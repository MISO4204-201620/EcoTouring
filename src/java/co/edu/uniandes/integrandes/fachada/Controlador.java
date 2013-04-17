/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.integrandes.fachada;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Coder
 */
@ManagedBean(name="controlador")
@RequestScoped
public class Controlador {

    /**
     * Creates a new instance of Controlador
     */
    public String consultarRecursos()
        {
            return "ir";
        }
        public String consultarReservas()
        {
             return "ir";
        }
        public String ingresarReserva()
        {
             return "ir";
        }
        public String ingresarPrestamo()
        {
             return "ir";
        }
         public String registrarDevolucion()
        {
             return "ir";
        }
        
         //Taller 3
         
          public String actualizarRecurso()
        {
            return "ir";             
        }
         //Llamadas
         
}
