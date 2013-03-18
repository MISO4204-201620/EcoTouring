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
public class ConsultaDAO {
    
    private DataSource dao;
    private Connection con;
    
    public ConsultaDAO()
    {
     
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
 
                establecerConexion();
		
		PreparedStatement ps 
			= con.prepareStatement("select *  from RECURSOS_G14 r1, tipo_recursos_g14 r2 where r1.cod_tipo_recurso=r2.id_tipo_recurso");
			  
 
		//ejecutar la consulta
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
                        String desTipo=result.getString("DESCRIPCION_TIPO");
                        
                        
                        
                        rec.setTipoRecurso(tipoRec);
			rec.setDescripcionRecurso(descr);
                        rec.setEstado(estado);
                        rec.setIdRecurso(idRec);
                        rec.setCodUnidad(codUnidad);
                        rec.setDescTipo(desTipo);
			//rec.setHoraI(result.getString("HORARIO_RECURSO_HORAI"));
                        //rec.setHoraI(result.getString("HORARIO_RECURSO_HORAF"));
 
                        
                        
		
			list.add(rec);
		}
 
		return list;
	}
    
    
    public List<ReservasValue> darReservasUsuario(String id) throws SQLException{
 
                establecerConexion();
		
		PreparedStatement ps 
			= con.prepareStatement("Select id_reserva ,id_recurso, descripcion_recurso from recursos_g14 r1 ,reservas_g14 r2 where r1.id_recurso=r2.cod_id_recurso and r2.COD_CEDULA_RESPONSABLE='" + id +"'" );
			  
 
		//ejecutar la consulta
		ResultSet result =  ps.executeQuery();
 
		List<ReservasValue> list = new ArrayList<ReservasValue>();
 
		while(result.next()){
			ReservasValue res = new ReservasValue();
                         //aca arma el objeto value  
			res.setIdReserva(result.getInt("ID_RESERVA"));
                        res.setDescripcion_recurso(result.getString("DESCRIPCION_RECURSO"));
                        
                        
 
                        
                        
		
			list.add(res);
		}
 
		return list;
	}
    
    
    
    
    
    
}
