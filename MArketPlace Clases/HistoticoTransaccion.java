package com.example.helloworld.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "historicotransaccion")
@NamedQueries({
        @NamedQuery(
                name = "com.example.helloworld.core.HistoricoTransaccion.findAll",
                query = "SELECT ht FROM HistoricoTransaccion ht"
        )
})
public class HistoricoTransaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idHistoricoTransaccion;

    @Column(name = "estado", nullable = false)
    public int estado;

    @Column(name = "idTransaccion", nullable = false)
    public int idTransaccion;
    
    @column(name = "fecha", nullable = false)
    public Date fecha;
    
    public HistoricoTransaccion() {
    }

    public HistoricoTransaccion(int idHistoricoTransaccion, int estado, int idTransaccion, int fecha) {
        this.idHistoricoTransaccion = idHistoricoTransaccion;
        this.estado = estado;
        this.idTransaccion = idTransaccion;
        this.fecha = fecha;
    }

    public int getIdHistoricoTransaccion() {
        return idHistoricoTransaccion;
    }

    public void setIdHistoricoTransaccion(int idHistoricoTransaccion) {
        this.idHistoricoTransaccion = idHistoricoTransaccion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HistoricoTransaccion)) {
            return false;
        }

        final HistoricoTransaccion that = (HistoricoTransaccion) o;
        
        return Objects.equals(this.idHistoricoTransaccion, that.idHistoricoTransaccion) &&
                Objects.equals(this.estado, that.estado) &&
                Objects.equals(this.idTransaccion, that.idTransaccion) &&
                Objects.equals(this.fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHistoricoTransaccion, estado, idTransaccion, fecha);
    }
}
