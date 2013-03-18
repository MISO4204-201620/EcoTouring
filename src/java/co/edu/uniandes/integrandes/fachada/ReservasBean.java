/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.integrandes.fachada;

import co.edu.uniandes.integrandes.DAO.IngresoDAO;
import co.edu.uniandes.integrandes.values.ReservasValue;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Coder
 */
@ManagedBean(name="reservasBean")
@SessionScoped
public class ReservasBean {
    
    IngresoDAO dao;

    /**
     * Creates a new instance of ReservasBean
     */
    public ReservasBean() {
        
        dao=new IngresoDAO();
    }
    
    //metodos RF3 RF4 y RF5
    
   
    
    
    
    public boolean RegistrarReserva()
     {
      
     return true;
     }
     
     public boolean RegistrarPrestamo()
     {
         return true;
     }
     
     public boolean RegistrarDevolucion()
     {
     
         return true;
     }
    
}
