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
         //REQUERIMIENTO 07
          public String actualizarRecurso()
        {
            System.out.println("Un cambio más");
            System.out.println("La 21 es la vencida");
            return "ir";
        }
        //REQUERIMIENTO 06
          public String hacerReserva()
        {
             return "ir";
        }
          
         //REQUERIMIENTO 08
        public String dardeBaja()
        {
             return "ir";
        }
}
