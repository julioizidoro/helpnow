/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelmate.dao;
import br.com.travelmate.connection.ConectionFactory;
import br.com.travelmate.model.Usuario;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Wolverine
 */
public class UsuarioDao {
    
    private EntityManager manager;
    
    public Usuario salvar(Usuario usuario) throws SQLException{
        manager = ConectionFactory.getConnection();
        //abrindo uma transação
        manager.getTransaction().begin();
        usuario = manager.merge(usuario);
        //fechando uma transação
        manager.getTransaction().commit();
        return usuario;
    }
    
    public Usuario consultar(int idUsuario) throws SQLException{
        manager = ConectionFactory.getConnection();
        //abrindo uma transação
        manager.getTransaction().begin();
        Usuario usuario = manager.find(Usuario.class, idUsuario);
        //fechando uma transação
        manager.getTransaction().commit();
        return usuario;
    }
    
    public Usuario consultar(String login, String senha) throws SQLException{
        manager = ConectionFactory.getConnection();
         manager.getTransaction().begin();
        Query q = manager.createQuery("select u from Usuario u where u.login='" + login + "' and u.senha='" + senha + "'  order by u.nome");
        manager.getTransaction().commit();
        if (q.getResultList().size()>0){
            return (Usuario) q.getResultList().get(0);
        }
        return null;
    }
    
    public List<Usuario> listaUsuario() throws SQLException{
        manager = ConectionFactory.getConnection();
         manager.getTransaction().begin();
        Query q = manager.createQuery("select u from Usuario u order by u.nome");
        manager.getTransaction().commit();
        if (q.getResultList().size()>0){
            return q.getResultList();
        }
        return null;
    }
    
    public List<Usuario> listaUsuarioUnidade(int idUnidade) throws SQLException{
        manager = ConectionFactory.getConnection();
         manager.getTransaction().begin();
        Query q = manager.createQuery("select u from Usuario u where u.unidadenegocio.idunidadeNegocio=" + idUnidade + " order by u.nome");
       manager.getTransaction().commit();
        if (q.getResultList().size()>0){
            return q.getResultList();
        }
        return null;
    }
    
   
    
    public List<Usuario> listaUsuario(String nome) throws SQLException{
        manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        Query q = manager.createQuery("select u from Usuario u where u.nome like '%" + nome + "%' order by u.nome" );
        manager.getTransaction().commit();
        return q.getResultList();
    }
    
    public List<Usuario> consultar(String sql) throws SQLException{
        manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        Query q = manager.createQuery(sql);
        manager.getTransaction().commit();
        if (q.getResultList().size() > 0) {
            return  (List<Usuario>) q.getResultList();
        } else {
            return null;
        }
    }
    
}
