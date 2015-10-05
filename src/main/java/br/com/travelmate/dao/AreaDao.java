package br.com.travelmate.dao;

import br.com.travelmate.connection.ConectionFactory;
import br.com.travelmate.model.Area;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class AreaDao {
    
    public Area salvar(Area area) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        //abrindo uma transação
        manager.getTransaction().begin();
        area = manager.merge(area);
        //fechando uma transação
        manager.getTransaction().commit();
        return area;
    }
    
    public List<Area> listar(String sql)throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        Query q = manager.createQuery(sql);
        List<Area> lista = q.getResultList();
        manager.getTransaction().commit();
        return  lista;
    }
    
}
