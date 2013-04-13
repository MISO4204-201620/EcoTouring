/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.integrandes.values;

/**
 *
 * @author Gloria
 */
public class PrestamosValue {
    private int numprestamo;
    private int cod_reserva;
    private String hora_prestamo;
    private String prestatario;

    /**
     * @return the numprestamo
     */
    public int getNumprestamo() {
        return numprestamo;
    }

    /**
     * @param numprestamo the numprestamo to set
     */
    public void setNumprestamo(int numprestamo) {
        this.numprestamo = numprestamo;
    }

    /**
     * @return the cod_reserva
     */
    public int getCod_reserva() {
        return cod_reserva;
    }

    /**
     * @param cod_reserva the cod_reserva to set
     */
    public void setCod_reserva(int cod_reserva) {
        this.cod_reserva = cod_reserva;
    }

    /**
     * @return the hora_prestamo
     */
    public String getHora_prestamo() {
        return hora_prestamo;
    }

    /**
     * @param hora_prestamo the hora_prestamo to set
     */
    public void setHora_prestamo(String hora_prestamo) {
        this.hora_prestamo = hora_prestamo;
    }

    /**
     * @return the prestatario
     */
    public String getPrestatario() {
        return prestatario;
    }

    /**
     * @param prestatario the prestatario to set
     */
    public void setPrestatario(String prestatario) {
        this.prestatario = prestatario;
    }   
}
