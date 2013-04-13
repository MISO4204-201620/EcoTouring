/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.integrandes.DAO;

import co.edu.uniandes.integrandes.values.RecursosValue;
import co.edu.uniandes.integrandes.values.ReservasValue;
import co.edu.uniandes.integrandes.values.PrestamosValue;
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
    
    public List<ReservasValue> darReservasUsuario() throws SQLException{
 
                establecerConexion();
		
		PreparedStatement ps = con.prepareStatement("select re.id_reserva as ID_RESERVA ,rec.descripcion_recurso AS RECURSO, re.horario_reserva as horario, us.usuario_nombre || ' ' || us.usuario_apellido as NOMBRE\n" +
                "from reservas_g14 re, usuarios_g14 us, recursos_g14 rec\n" +"where re.cod_cedula_responsable=us.cedula AND rec.id_recurso=re.cod_id_recurso ORDER BY NOMBRE");
 
		//ejecutar la consulta
		ResultSet result =  ps.executeQuery();
                System.out.println("ps");
 
		List<ReservasValue> list = new ArrayList<ReservasValue>();
 
		while(result.next()){
			ReservasValue res = new ReservasValue();
                         //aca arma el objeto value                          
                        int tipoRes=(int)result.getLong("ID_RESERVA");
                        String nombre_recurso=result.getString("RECURSO");
                        String hora = result.getString("HORARIO");
                        String nombre = result.getString("NOMBRE");                        
                        
                        res.setNumeroReserva(tipoRes);
			res.setNombreRecurso(nombre_recurso);
                        res.setHoraReserva(hora);
                        res.setNombreResponsable(nombre);                     
                        
			list.add(res);
		}
		return list;
	}     
    
        public List<ReservasValue> darReservasUsuario(String cedula) throws SQLException{
 
                establecerConexion();
		
		PreparedStatement ps = con.prepareStatement("select re.id_reserva as ID_RESERVA ,rec.descripcion_recurso AS RECURSO, re.horario_reserva as horario, us.usuario_nombre || ' ' || us.usuario_apellido as NOMBRE\n" +
                "from reservas_g14 re, usuarios_g14 us, recursos_g14 rec\n" +"where re.cod_cedula_responsable=us.cedula AND rec.id_recurso=re.cod_id_recurso AND re.cod_cedula_responsable='"+cedula+"' ORDER BY NOMBRE");
 
		//ejecutar la consulta
		ResultSet result =  ps.executeQuery();
                System.out.println("ps");
 
		List<ReservasValue> list = new ArrayList<ReservasValue>();
 
		while(result.next()){
			ReservasValue res = new ReservasValue();
                         //aca arma el objeto value                          
                        int tipoRes=(int)result.getLong("ID_RESERVA");
                        String nombre_recurso=result.getString("RECURSO");
                        String hora = result.getString("HORARIO");
                        String nombre = result.getString("NOMBRE");                        
                        
                        res.setNumeroReserva(tipoRes);
			res.setNombreRecurso(nombre_recurso);
                        res.setHoraReserva(hora);
                        res.setNombreResponsable(nombre);                     
                        
			list.add(res);
		}
		return list;
	}
        
        public boolean insertarReserva(String cedula, int recurso) throws SQLException{
                boolean  inserto=true; 
                try {
                System.out.println("Los datos que llegan son: Cedula "+cedula+"Recursos: "+recurso);
                establecerConexion();
		
		PreparedStatement ps = con.prepareStatement("insert into reservas_g14 (cod_cedula_responsable,horario_reserva,cod_id_recurso) values('"+cedula+"',to_date(current_date, 'DD-MM-YYYY HH:MI:SS'),"+recurso+" )");
 
		//ejecutar la consulta
		ps.executeQuery();
                System.out.println(ps);
 
		
                } catch (SQLException e) {
                        System.out.println(e);
                        inserto=false;
		}		
		return inserto;
	}          
        
        public List<RecursosValue> consultarTipoRecurso() throws SQLException{                                
                establecerConexion();
		
		PreparedStatement ps = con.prepareStatement("select * from tipo_recursos_g14");
 
		//ejecutar la consulta
		ResultSet result =  ps.executeQuery();
                System.out.println("ps");
 
		List<RecursosValue> list = new ArrayList<RecursosValue>();
 
		while(result.next()){
			RecursosValue res = new RecursosValue();
                         //aca arma el objeto value                          
                        int tipoRes=(int)result.getLong("ID_TIPO_RECURSO");
                        String des_tipo_recurso=result.getString("DESCRIPCION_TIPO");
                        
                        res.setTipoRecurso(tipoRes);
			res.setDesctipoRecurso(des_tipo_recurso);                        
			list.add(res);
		}
		return list;
	}
    
        public List<PrestamosValue> consultarPrestamos(String cedula) throws SQLException{                                
                establecerConexion();
		
		PreparedStatement ps = con.prepareStatement("select ID_PRESTAMO, COD_ID_RESERVA, HORA_PRESTAMO from prestamos_g14 p, reservas_g14 r where r.id_reserva=p.cod_id_reserva AND r.cod_cedula_responsable='"+cedula+"'");
 
		//ejecutar la consulta
		ResultSet result =  ps.executeQuery();
                System.out.println("ps");
 
		List<PrestamosValue> list = new ArrayList<PrestamosValue>();
 
		while(result.next()){
			PrestamosValue res = new PrestamosValue();
                         //aca arma el objeto value                          
                        int tipoRes=(int)result.getLong("ID_PRESTAMO");
                        int id_reserva=result.getInt("COD_ID_RESERVA");
                        String hora_prestamo=result.getString("HORA_PRESTAMO");
                        
                        res.setNumprestamo(tipoRes);
			res.setCod_reserva(id_reserva);                        
                        res.setHora_prestamo(hora_prestamo);
			list.add(res);
		}
		return list;
	}        
        
        public List<PrestamosValue> consultarTodosPrestamos() throws SQLException{                                
                establecerConexion();
		
		PreparedStatement ps = con.prepareStatement("select ID_PRESTAMO, COD_ID_RESERVA, to_date(HORA_PRESTAMO, 'DD-MM-YYYY HH:MI:SS') as HORAPRESTAMO from prestamos_g14 p ORDER BY horaprestamo");
 
		//ejecutar la consulta
		ResultSet result =  ps.executeQuery();
                System.out.println("ps");
 
		List<PrestamosValue> list = new ArrayList<PrestamosValue>();
 
		while(result.next()){
			PrestamosValue res = new PrestamosValue();
                         //aca arma el objeto value                          
                        int tipoRes=(int)result.getLong("ID_PRESTAMO");
                        int id_reserva=result.getInt("COD_ID_RESERVA");
                        String hora_prestamo=result.getString("HORAPRESTAMO");
                        
                        res.setNumprestamo(tipoRes);
			res.setCod_reserva(id_reserva);                        
                        res.setHora_prestamo(hora_prestamo);
			list.add(res);
		}
		return list;
	} 
}
