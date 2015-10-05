/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelmate.dao;


import br.com.travelmate.connection.ConectionFactory;
import br.com.travelmate.model.Unidadenegocio;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Wolverine
 */
public class UnidadeNegocioDao {
    
    private EntityManager manager;
    
    public Unidadenegocio salvar(Unidadenegocio unidadeNegocio) throws SQLException{
        manager = ConectionFactory.getConnection();
        //abrindo uma transação
        manager.getTransaction().begin();
        unidadeNegocio = manager.merge(unidadeNegocio);
        //fechando uma transação
        manager.getTransaction().commit();
        return unidadeNegocio;
    }
    
    public Unidadenegocio consultar(int idUnidadeNegocio) throws SQLException{
        manager = ConectionFactory.getConnection();
        //abrindo uma transação
        manager.getTransaction().begin();
        Unidadenegocio unidadeNegocio = manager.find(Unidadenegocio.class, idUnidadeNegocio);
        //fechando uma transação
        manager.getTransaction().commit();
        return unidadeNegocio;
    }
    
    public List<Unidadenegocio> listar() throws Exception{
        manager = ConectionFactory.getConnection();
         manager.getTransaction().begin();
        Query q = manager.createQuery("select u from Unidadenegocio u order by u.nomeFantasia");
        manager.getTransaction().commit();
        if (q.getResultList().size()>0){
            return q.getResultList();
        }
        return null;
    }
    
}
