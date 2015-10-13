/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelmate.facade;

import br.com.travelmate.dao.ExecutorDao;
import br.com.travelmate.model.Executor;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wolverine
 */
public class ExecutorFacade {
    
    ExecutorDao executorDao;
    
    public Executor salvar(Executor executor) {
        executorDao = new ExecutorDao();
        try {
            return executorDao.salvar(executor);
        } catch (SQLException ex) {
            Logger.getLogger(ExecutorFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
