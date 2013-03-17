/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.integrandes.values;

import java.util.ArrayList;

/**
 *
 * @author Coder
 */
public class RecursosValue {
    
    public int idRecurso;


   
    public String descripcionRecurso;
    public int estado;
    public ArrayList HorarioDispoRecurso;
    public String nombreRecurso;
    public int numeroRecurso;
    public int tipoRecurso;

    
    public int codUnidad;
    
    
    
    public int getCodUnidad() {
        return codUnidad;
    }

    public void setCodUnidad(int codUnidad) {
        this.codUnidad = codUnidad;
    }
    
    public int getIdRecurso() {
       
        return idRecurso;
    }
    
     public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }
     
    public String getDescripcionRecurso() {
        return descripcionRecurso;
    }

    public void setDescripcionRecurso(String descripcionRecurso) {
        this.descripcionRecurso = descripcionRecurso;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public ArrayList getHorarioDispoRecurso() {
        return HorarioDispoRecurso;
    }

    public void setHorarioDispoRecurso(ArrayList HorarioDispoRecurso) {
        this.HorarioDispoRecurso = HorarioDispoRecurso;
    }

    public String getNombreRecurso() {
        return nombreRecurso;
    }

    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

    public int getNumeroRecurso() {
        return numeroRecurso;
    }

    public void setNumeroRecurso(int numeroRecurso) {
        this.numeroRecurso = numeroRecurso;
    }

    public int getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(int tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }
    
}
