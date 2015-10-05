package br.com.travelmate.dao;

import br.com.travelmate.connection.ConectionFactory;
import br.com.travelmate.model.Chamado;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class ChamadoDao {
    
    public Chamado salvar(Chamado chamado) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        //abrindo uma transação
        manager.getTransaction().begin();
        chamado = manager.merge(chamado);
        //fechando uma transação
        manager.getTransaction().commit();
        return chamado;
    }
    
    public List<Chamado> listar(String nome)throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        Query q = manager.createQuery("select c from Chamado c order by c.dataabertura");
        List<Chamado> lista = q.getResultList();
        manager.getTransaction().commit();
        return  lista;
    }
    
}