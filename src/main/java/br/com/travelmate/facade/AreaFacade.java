package br.com.travelmate.facade;

import br.com.travelmate.dao.AreaDao;
import br.com.travelmate.model.Area;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AreaFacade {
    
    AreaDao areaDao;
    
    public Area salvar(Area area) {
        areaDao = new AreaDao();
        try {
            return areaDao.salvar(area);
        } catch (SQLException ex) {
            Logger.getLogger(AreaFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    public List<Area> listar(String sql) {
        areaDao = new AreaDao();
        try {
            return areaDao.listar(sql);
        } catch (SQLException ex) {
            Logger.getLogger(AreaFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
