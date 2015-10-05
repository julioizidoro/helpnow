package br.com.travelmate.facade;

import br.com.travelmate.dao.ChamadoDao;
import br.com.travelmate.dao.InteracaoDao;
import br.com.travelmate.model.Chamado;
import br.com.travelmate.model.Interacao;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InteracaoFacade {
    
    InteracaoDao interacaoDao;
    
    public Interacao salvar(Interacao interacao) {
        interacaoDao = new InteracaoDao();
        try {
            return interacaoDao.salvar(interacao);
        } catch (SQLException ex) {
            Logger.getLogger(InteracaoFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    public List<Interacao> listar(String sql) {
        interacaoDao = new InteracaoDao();
        try {
            return interacaoDao.listar(sql);
        } catch (SQLException ex) {
            Logger.getLogger(InteracaoFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
