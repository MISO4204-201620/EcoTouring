/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.integrandes.DAO;

import co.edu.uniandes.integrandes.values.RecursosValue;
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
public class ConsultaDAO {
    
    private DataSource dao;
    
    public ConsultaDAO()
    {
     
        inicializar();
    
    }
    
    //metodo init
    public void inicializar(){
        try {
			Context ct = new InitialContext();
			dao = (DataSource)ct.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
    }
    
    //Aca van los metodos de las consultas
    
    public List<RecursosValue> darListaRecursos() throws SQLException{
 
		if(dao==null)
			throw new SQLException("No se puede obtener el DAO");
 
		//get database connection
		Connection con = dao.getConnection();
 
		if(con==null)
			throw new SQLException("No se Pudo establecer una COnexion con la DB");
 
		PreparedStatement ps 
			= con.prepareStatement(
			   "select *  from RECURSOS_G14"); 
 
		//get customer data from database
		ResultSet result =  ps.executeQuery();
 
		List<RecursosValue> list = new ArrayList<RecursosValue>();
 
		while(result.next()){
			RecursosValue rec = new RecursosValue();
                         //aca arma el objeto value  
			int tipoRec=(int)result.getLong("COD_TIPO_RECURSO");
                        String descr=result.getString("DESCRIPCION_RECURSO");
                        int estado = result.getInt("ESTADO_RECURSO");
                        int idRec = result.getInt("ID_RECURSO");
                        int codUnidad=result.getInt("COD_UNIDAD");
                        
                        rec.setTipoRecurso(tipoRec);
			rec.setDescripcionRecurso(descr);
                        rec.setEstado(estado);
                        rec.setIdRecurso(2);
                        rec.setCodUnidad(codUnidad);
                        
			//cust.setAddress(result.getString("nada"));
			//cust.setCreated_date(result.getDate("nada"));
 
			//store all data into a List
			list.add(rec);
		}
 
		return list;
	}
    
}
