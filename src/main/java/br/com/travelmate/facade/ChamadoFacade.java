package br.com.travelmate.facade;

import br.com.travelmate.dao.ChamadoDao;
import br.com.travelmate.model.Chamado;
import br.com.travelmate.model.Usuario;
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
    
    
    public List<Chamado> listar(String sql) {
        chamadoDao = new ChamadoDao();
        try {
            return chamadoDao.listar(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ChamadoFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    public List<Usuario> listarUsuario(String sql) {
        chamadoDao = new ChamadoDao();
        try {
            return chamadoDao.listarUsuario(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ChamadoFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public void excluir(int idChamado) {
        chamadoDao = new ChamadoDao();
        try {
            chamadoDao.excluir(idChamado);
        } catch (SQLException ex) {
            Logger.getLogger(ChamadoFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
