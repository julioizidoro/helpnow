package br.com.travelmate.dao;

import br.com.travelmate.connection.ConectionFactory;
import br.com.travelmate.model.Interacao;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class InteracaoDao {
    
    public Interacao salvar(Interacao interacao) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        //abrindo uma transação
        manager.getTransaction().begin();
        interacao = manager.merge(interacao);
        //fechando uma transação
        manager.getTransaction().commit();
        return interacao;
    }
    
    public List<Interacao> listar(String sql)throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        Query q = manager.createQuery(sql);
        List<Interacao> lista = q.getResultList();
        manager.getTransaction().commit();
        return  lista;
    }
    
}
