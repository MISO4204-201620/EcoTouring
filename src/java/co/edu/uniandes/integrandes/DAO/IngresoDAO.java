/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.integrandes.DAO;




import co.edu.uniandes.integrandes.fachada.UsuarioBean;
import co.edu.uniandes.integrandes.values.RecursosValue;
import co.edu.uniandes.integrandes.values.ReservasValue;
import co.edu.uniandes.integrandes.values.TipoRecursoValue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 *
 * @author Coder
 */
public class IngresoDAO {
    
      private DataSource dao;
     private Connection con;
     
     public IngresoDAO(){
      
    inicializar();
      
    }
    
     public void  establecerConexion() throws SQLException
    {
       
        
        if(dao==null)
		throw new SQLException("No se puede obtener el DAO");
 
		//conexion DB
	 con = dao.getConnection();
 
	if(con==null){
		throw new SQLException("No se Pudo establecer una COnexion con la DB");
               
        }
 
    }
     
     public void inicializar(){
        try {
			Context ct = new InitialContext();
			dao = (DataSource)ct.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
    }
     //Metodos de Gestion de Recursos y Reservas
     
     
    
     
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
     
     
     //Taller 3
     
     //RF7
     
     public boolean actualizarRecurso(String caracteristica, int idTipoRecurso) throws SQLException
     {
               List<RecursosValue> list = new ArrayList<RecursosValue>();        
                try{
                establecerConexion();		
		//Primera Operación de la Transacción Actualizar el Recurso
                PreparedStatement ps = con.prepareStatement("update caracteristicas_recurso_g14 set caracteristica_tipo='"+caracteristica+"' where id_caracteristica="+idTipoRecurso);
                
                //Segunda Operación Cambiar el estado de las resercas asociadas al recurso
                PreparedStatement ps1 = con.prepareStatement("UPDATE RESERVAS_G14 RE TI SET ESTADO_RESERVA='Cancelada' WHERE COD_ID_RECURSO="+idTipoRecurso);
                //ejecutar la consulta
		ps.executeQuery();
                con.commit();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
                    con.rollback();
                    return false;
                }
                return true;
	}        
}
