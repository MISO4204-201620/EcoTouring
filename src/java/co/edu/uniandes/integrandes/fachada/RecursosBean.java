/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.integrandes.fachada;

import co.edu.uniandes.integrandes.DAO.ConsultaDAO;
import co.edu.uniandes.integrandes.values.RecursosValue;
import co.edu.uniandes.integrandes.values.ReservasValue;
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
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author Coder
 */
@ManagedBean(name="recursosBean")
@RequestScoped
public class RecursosBean {

    private ConsultaDAO dao;
    
    private String ced;

    
   
    
   
    /**
     * Creates a new instance of RecursosBean
     */
    public RecursosBean() {
        
        dao=new ConsultaDAO();
    }
    
    //info mang
    public String getCed() {
        return ced;
    }

    public void setCed(String ced) {
        this.ced = ced;
    }
    
    
    //prueba de un metodo de llamado
    
    /**
     * REQUERIMIENTO 01 (Prueba)
     */
    
    public List<RecursosValue> darRecursos(){
        try {
            return dao.darListaRecursos();
        } catch (SQLException ex) {
            Logger.getLogger(RecursosBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
      
    }
    
    /**
     * REQUERIMIENTO 02 
     */
    
    public List<ReservasValue>consultarReserva()
   {
   
       try {
            return dao.darReservasUsuario(ced);
        } catch (SQLException ex) {
            Logger.getLogger(RecursosBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
       
   }
  
    
    
}
