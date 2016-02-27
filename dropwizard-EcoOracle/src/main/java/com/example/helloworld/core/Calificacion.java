package com.example.helloworld.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import java.util.Objects;

@Entity
@Table(name = "calificacion")
@NamedQueries({
        @NamedQuery(
                name = "com.example.helloworld.core.Calificacion.findAll",
                query = "SELECT ca FROM Calificacion ca"
        )
})
public class Calificacion {
	
	//TODO
	/**
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idCalificacion;

    @Column(name = "idItem", nullable = false)
    public long idItem;

    @Column(name = "idTransaccion", nullable = false)
    public long idTransaccion;
    
    @column(name = "calificacion", nullable = false)
    public long calificacion;
    
    @column(name = "comentario", nullable = false)
    public String comentario;
    
    public Calificacion() {
    }

    public Calificacion(long idCalificacion, long idItem, long idTransaccion, long calificacion, String comentario) {
        this.idCalificacion = idCalificacion;
        this.idItem = idItem;
        this.idTransaccion = idTransaccion;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    public long getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(long idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public long getIdItem() {
        return idItem;
    }

    public void setIdItem(long idItem) {
        this.idItem = idItem;
    }

    public long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }
    
    public long getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(long calificacion) {
        this.calificacion = calificacion;
    }
    
    public long getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Calificacion)) {
            return false;
        }

        final Calificacion that = (Calificacion) o;
        
        return Objects.equals(this.idCalificacion, that.idCalificacion) &&
                Objects.equals(this.idItem, that.idItem) &&
                Objects.equals(this.idTransaccion, that.idTransaccion) &&
                Objects.equals(this.calificacion, that.calificacion) &&
                Objects.equals(this.comentario, that.comentario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCalificacion, idItem, idTransaccion, calificacion, comentario);
    }*/
}
