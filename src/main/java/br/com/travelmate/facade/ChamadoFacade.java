package br.com.travelmate.facade;

import br.com.travelmate.dao.ChamadoDao;
import br.com.travelmate.model.Chamado;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ChamadoFacade {
    
    ChamadoDao chamadoDao;
    
    public Chamado salvar(Chamado chamado) {
        chamadoDao = new ChamadoDao();
        try {
            return chamadoDao.salvar(chamado);
        } catch (SQLException ex) {
            Logger.getLogger(ChamadoFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    public List<Chamado> listar(String nome) {
        chamadoDao = new ChamadoDao();
        try {
            return chamadoDao.listar(nome);
        } catch (SQLException ex) {
            Logger.getLogger(ChamadoFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
