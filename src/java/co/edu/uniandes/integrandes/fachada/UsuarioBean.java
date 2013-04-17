/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.integrandes.fachada;

import co.edu.uniandes.integrandes.DAO.ConsultaDAO;
import co.edu.uniandes.integrandes.values.RecursosValue;
import co.edu.uniandes.integrandes.values.ReservasValue;
import java.io.Serializable;
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
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author Coder
 */
@ManagedBean(name="usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable{

    private ConsultaDAO dao;
    private String ced;
    
    //copiados de reservas bean
    private String tipoRecurso;
    private String idRecurso;
   

    //Taller 3
 
   
    
   
    /**
     * Creates a new instance of UsuarioBean
     */
    
      
      
     public UsuarioBean() {
        
        dao=new ConsultaDAO();
    }
    
     
     
    //info mang
    public String getCed() {
        return ced;
    }

    public void setCed(String ced) {
        this.ced = ced;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public String getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(String idRecurso) {
        this.idRecurso = idRecurso;
    }
    
    
    
    
    
    
    //prueba de un metodo de llamado
    
    /**
     * REQUERIMIENTO 01 (Se esta usando en boton "Consultar Recursos")
     * Lo utiliza los usuarios como los empleados
     */
    
    public List<RecursosValue> darRecursos(){
        try {
            return dao.darListaRecursos();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
      
    }
    
    /**
     * REQUERIMIENTO 02 (Se esta usando en boton "Consultar Reservas")
     * Lo utiliza los usuarios como los empleados
     * este metodo copiado de reservas bean
     */
    
    public List<ReservasValue> consultarReserva(){
       System.out.println("Cedula ingresada ---->" +ced);
        try {
            return dao.darReservasUsuario(ced);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
       
   } 
  
     /**
     * REQUERIMIENTO 03 (Se esta usando en boton "Registrar Reservas")
     * Lo utiliza los usuarios como los empleados
     * copiado de reservasbean
     */
    
     public String RegistrarReservas()
     {
     String mensaje="Iniciando ....";
      System.out.println("Tipo de Recurso---->" +tipoRecurso+ "Id del recurso a reservar"+ idRecurso);      
        try {
            int recurso=Integer.parseInt(tipoRecurso);
            dao.insertarReserva(ced, recurso);
            mensaje="Todo Terminó bien Registro Reserva";
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
            mensaje="Algo salió mal que vaina" + ex;
        }     
        return mensaje;
     }
    
    /**
     * REQUERIMIENTO 07 
     */
   
     public boolean  actualizarRecurso()
     {
     
         return true;
     }
    
    
     
     
   //Metodos
   public List<RecursosValue> darTipoRecurso(){
        try {
            return dao.consultarTipoRecurso();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
      
    }
    
   
   
   
   
//   public void testrf7()
//   {
//       System.out.println("dato: "+ tipoRecurso);
//   }
   
   //mis metodos
   
}
