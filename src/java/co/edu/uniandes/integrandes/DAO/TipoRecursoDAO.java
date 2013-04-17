/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.integrandes.DAO;

import co.edu.uniandes.integrandes.fachada.UsuarioBean;
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
 * @author Gloria
 */
public class TipoRecursoDAO {
    
    private DataSource dao;
    private Connection con;
    
    public TipoRecursoDAO()
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
    
    
    public List<TipoRecursoValue> consultarCaracteristicas(int recurso) throws SQLException{
                establecerConexion();
		
		PreparedStatement ps = con.prepareStatement("select * from caracteristicas_recurso_g14 where cod_id_tipo="+ recurso);
		//ejecutar la consulta
		ResultSet result =  ps.executeQuery();
                System.out.println("ps");
 
		List<TipoRecursoValue> list = new ArrayList<TipoRecursoValue>();
 
		while(result.next()){
			TipoRecursoValue res = new TipoRecursoValue();
                         //aca arma el objeto value                          
                        int id_car=(int)result.getLong("ID_CARACTERISTICA");
                        String caracteristica=result.getString("CARACTERISTICA_TIPO");
                        
			res.setIdRecurso(id_car);
                        res.setDecripcion(caracteristica);
			list.add(res);                        
		}		
                return list;
	} 
    
    
    public List<TipoRecursoValue> consultarHorarios() throws SQLException{
                establecerConexion();
		
		PreparedStatement ps = con.prepareStatement("select distinct HORARIO_RECURSO_HORAI ||' - '|| HORARIO_RECURSO_HORAF as RANGO from horarios_recursos_g14 order by rango asc");
		//ejecutar la consulta
		ResultSet result =  ps.executeQuery();
                System.out.println("ps");
 
		List<TipoRecursoValue> list = new ArrayList<TipoRecursoValue>();
 
		while(result.next()){
			TipoRecursoValue res = new TipoRecursoValue();
                         //aca arma el objeto value                                                  
                        String caracteristica=result.getString("RANGO");                        
			res.setDecripcion(caracteristica);                        
			list.add(res);                        
		}		
                return list;
	}
    
    public List<TipoRecursoValue> buscarRecursoDisponible(String caracteristica, String horario,String fecha, String TipoRecurso) throws SQLException{
        List<TipoRecursoValue> list = new ArrayList<TipoRecursoValue>();
        try {
            establecerConexion();
            //Operación uno (1) de la transacción
		PreparedStatement ps = con.prepareStatement
                        ("select DISTINCT DESCRIPCION_RECURSO, ID_RECURSO, CARACTERISTICA_TIPO, hor.HORARIO_RECURSO_HORAI ||' - '|| hor.HORARIO_RECURSO_HORAF AS HORA\n" +
                        "from recursos_g14 rec, caracteristicas_recurso_g14 car, tipo_recursos_g14 ti, horarios_recursos_g14 hor\n" +
                        "where rec.cod_tipo_recurso=ti.id_tipo_recurso\n" +
                        "AND car.cod_id_tipo =ti.id_tipo_recurso\n" +
                        "AND hor.cod_id_recurso=ti.id_tipo_recurso\n" +
                        "AND car.cod_id_tipo=hor.cod_id_recurso\n" +
                        "AND car.id_caracteristica="+caracteristica+"\n" +
                        "AND ti.id_tipo_recurso= "+TipoRecurso+"\n" +
                        "AND hor.HORARIO_RECURSO_HORAI ||' - '|| hor.HORARIO_RECURSO_HORAF='"+horario+"'\n" +
                        "ORDER BY DESCRIPCION_RECURSO, CARACTERISTICA_TIPO, HORA");
		//ejecutar la consulta
		ResultSet result =  ps.executeQuery();                
                System.out.println(ps);                
		while(result.next()){
			TipoRecursoValue res = new TipoRecursoValue();
                         //aca arma el objeto value                                                  
                        String descripcion_recurso=result.getString("DESCRIPCION_RECURSO");
                        String caracteristica_recurso=result.getString("CARACTERISTICA_TIPO");
                        String hora=result.getString("HORA");
                        int id_recurso=result.getInt("ID_RECURSO");
                        
			res.setDecripcion(descripcion_recurso);
                        res.setCaracteristica(caracteristica_recurso);
                        res.setHorario(hora);
                        res.setIdRecurso(id_recurso);
                        
			list.add(res);                        
		}
                con.commit();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(TipoRecursoDAO.class.getName()).log(Level.SEVERE, null, ex);                    
                    con.rollback();
                    return null;
                }
                return list;
    }
    
    //REQUERIMIENTO 08 DAR DE BAJA UN RECURSO
    
    public List<TipoRecursoValue> dardeBajaRecurso(int id_Recurso,String Estado) throws SQLException{
                List<TipoRecursoValue> list = new ArrayList<TipoRecursoValue>();        
                try{
                establecerConexion();		
		//Primera Operación de la Transacción
                PreparedStatement ps = con.prepareStatement("UPDATE RECURSOS_G14 SET ESTADO_RECURSO='Dañado' WHERE ID_RECURSO=1");
                //Segunda Operación de la Transacción
                PreparedStatement ps1 = con.prepareStatement("UPDATE RESERVAS_G14 SET ESTADO_RESERVA='Cancelada' where COD _ID_RECURSO=1");
                //ejecutar la consulta
		ps.executeQuery();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
                    con.rollback();
                }
                return list;
	}
}
