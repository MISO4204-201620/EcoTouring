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
   
    // cada string sera Dia, Horai, Horaf
    public ArrayList<String> HorarioDispoRecurso;
    public String nombreRecurso;
    public int numeroRecurso;
    public int tipoRecurso;
    public int codUnidad;
    
    public String horaI;
    public String horaF;

    public String getHoraI() {
        return horaI;
    }

    public void setHoraI(String horaI) {
        this.horaI = horaI;
    }

    public String getHoraF() {
        return horaF;
    }

    public void setHoraF(String horaF) {
        this.horaF = horaF;
    }

    
    
    
     public String getDescTipo() {
        return descTipo;
    }

    public void setDescTipo(String descTipo) {
        this.descTipo = descTipo;
    }
    public String descTipo;
    
    
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
