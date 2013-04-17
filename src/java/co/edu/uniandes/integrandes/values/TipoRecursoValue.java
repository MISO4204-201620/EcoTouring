/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.integrandes.values;

import java.util.ArrayList;

/**
 *
 * @author Gloria
 */
public class TipoRecursoValue {
    private String decripcion;
    private int idRecurso;
    private String horario;
    private String caracteristica;
    
    
    private ArrayList<String> CaracteristicasRecurso;

    /**
     * @return the decripcion
     */
    public String getDecripcion() {
        return decripcion;
    }

    /**
     * @param decripcion the decripcion to set
     */
    public void setDecripcion(String decripcion) {
        this.decripcion = decripcion;
    }

    /**
     * @return the CaracteristicasRecurso
     */
    public ArrayList<String> getCaracteristicasRecurso() {
        return CaracteristicasRecurso;
    }

    /**
     * @param CaracteristicasRecurso the CaracteristicasRecurso to set
     */
    public void setCaracteristicasRecurso(ArrayList<String> CaracteristicasRecurso) {
        this.CaracteristicasRecurso = CaracteristicasRecurso;
    }

    /**
     * @return the idRecurso
     */
    public int getIdRecurso() {
        return idRecurso;
    }

    /**
     * @param idRecurso the idRecurso to set
     */
    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }    

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * @return the caracteristica
     */
    public String getCaracteristica() {
        return caracteristica;
    }

    /**
     * @param caracteristica the caracteristica to set
     */
    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }
    
}
