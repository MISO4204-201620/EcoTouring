/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.integrandes.DAO;




import co.edu.uniandes.integrandes.values.RecursosValue;
import co.edu.uniandes.integrandes.values.ReservasValue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
     
     
     
     
}
