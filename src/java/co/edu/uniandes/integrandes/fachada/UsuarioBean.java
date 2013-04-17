/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.integrandes.fachada;

import co.edu.uniandes.integrandes.DAO.ConsultaDAO;
import co.edu.uniandes.integrandes.DAO.TipoRecursoDAO;
import co.edu.uniandes.integrandes.values.RecursosValue;
import co.edu.uniandes.integrandes.values.ReservasValue;
import co.edu.uniandes.integrandes.values.TipoRecursoValue;
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
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author Coder
 */
@ManagedBean(name="usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable{

    private ConsultaDAO dao;
    private TipoRecursoDAO tipodao;
    private String ced;
    
    //copiados de reservas bean
    private String tipoRecurso;
    private String idRecurso;
    private String fecha;
    private String horario;
    private String caracteristica;
    private HtmlDataTable tabla;
    private TipoRecursoValue tipoRecursoValue;
    
    
   

    //Taller 3
 
    /**
     * Creates a new instance of UsuarioBean
     */
    
      
      
     public UsuarioBean() {
        
        dao=new ConsultaDAO();
        tipodao = new TipoRecursoDAO();
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
    
    /**
     * @return the dao
     */
    public ConsultaDAO getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(ConsultaDAO dao) {
        this.dao = dao;
    }

    /**
     * @return the tipodao
     */
    public TipoRecursoDAO getTipodao() {
        return tipodao;
    }

    /**
     * @param tipodao the tipodao to set
     */
    public void setTipodao(TipoRecursoDAO tipodao) {
        this.tipodao = tipodao;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * @return the caracteristica
     */
    public String getCaracteristica() {
        return caracteristica;
    }

    /**
     * @param caracteristica the caracteristica to set
     */
    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    /**
     * @return the tabla
     */
    public HtmlDataTable getTabla() {
        return tabla;
    }

    /**
     * @param tabla the tabla to set
     */
    public void setTabla(HtmlDataTable tabla) {
        this.tabla = tabla;
    }

    /**
     * @return the tipoRecursoValue
     */
    public TipoRecursoValue getTipoRecursoValue() {
        return tipoRecursoValue;
    }

    /**
     * @param tipoRecursoValue the tipoRecursoValue to set
     */
    public void setTipoRecursoValue(TipoRecursoValue tipoRecursoValue) {
        this.tipoRecursoValue = tipoRecursoValue;
    }
    
    
    
    
    //prueba de un metodo de llamado
    
    /**
     * REQUERIMIENTO 01 (Se esta usando en boton "Consultar Recursos")
     * Lo utiliza los usuarios como los empleados
     */
    
    public List<RecursosValue> darRecursos(){
        try {
            return getDao().darListaRecursos();
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
       System.out.println("Cedula ingresada ---->" +getCed());
        try {
            return getDao().darReservasUsuario(getCed());
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
      System.out.println("Tipo de Recurso---->" +getTipoRecurso()+ "Id del recurso a reservar"+ getIdRecurso());      
        try {
            int recurso=Integer.parseInt(getTipoRecurso());
            getDao().insertarReserva(getCed(), recurso);
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
            return getDao().consultarTipoRecurso();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
      
    }
    
   
   
   
   
   public void testrf7()
   {
       System.out.println("dato: "+ getTipoRecurso());
   }
   
   //REQUERIMIENTO 06
   
       // Consultar características Tipo Recurso
    public List<TipoRecursoValue> consultarCaracteristica() {
        try {
            System.out.println("El valo del tipo de recurso que selecciono es: " + getTipoRecurso());
            int recurso = Integer.parseInt(getTipoRecurso());
            return getTipodao().consultarCaracteristicas(recurso);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    //CONSULTAR LOS HORARIOS
    public List<TipoRecursoValue> consultarHorarios() {
        try {
            System.out.println("El valo del tipo de recurso que selecciono es: " + getTipoRecurso());
            //int recurso=Integer.parseInt(tipoRecurso);
            return getTipodao().consultarHorarios();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    //RESULTADOS FILTRO
    public List<TipoRecursoValue> resultadoFiltro() {

        System.out.println("El valo del tipo de CAR que selecciono es: " + getCaracteristica());
        System.out.println("El valo del tipo de HOR que selecciono es: " + getHorario());
        System.out.println("El valo del tipo de FE que selecciono es: " + getFecha());
        System.out.println("El valo del tipo de RECURSO que selecciono es: " + getTipoRecurso());
        //int recurso=Integer.parseInt(tipoRecurso);
        return getTipodao().buscarRecursoDisponible(getCaracteristica(), getHorario(), getFecha(), getTipoRecurso());
    }

    public String RegistrarReservasT3() {
        
//        FacesContext context = FacesContext.getCurrentInstance();  
//        Map requestMap = context.getExternalContext().getRequestParameterMap();  
//        String value = (String)requestMap.get("paramName");
        
        String mensaje = "Iniciando ....";
        System.out.println("Tipo de Recurso---->" + getTipoRecurso() + "Id del recurso a reservar" + getIdRecurso());
        try {
            int recurso = Integer.parseInt(getIdRecurso());
            getDao().insertarReserva("1022342164", recurso);
            mensaje = "Todo Terminó bien";
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
            mensaje = "Algo salió mal " + ex;
        }
        return mensaje;
    }
}
