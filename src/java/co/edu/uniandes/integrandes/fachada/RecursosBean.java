/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.integrandes.fachada;

import co.edu.uniandes.integrandes.DAO.ConsultaDAO;
import co.edu.uniandes.integrandes.values.RecursosValue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Coder
 */
@ManagedBean(name="recursosBean")
@RequestScoped
public class RecursosBean {

    private ConsultaDAO dao;
    
    /**
     * Creates a new instance of RecursosBean
     */
    public RecursosBean() {
        
        dao=new ConsultaDAO();
    }
    
    //prueba de un metodo de llamado
    
    public List<RecursosValue> darRecursos(){
        try {
            return dao.darListaRecursos();
        } catch (SQLException ex) {
            Logger.getLogger(RecursosBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    }
    
}
