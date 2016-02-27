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
@Table(name = "contenido")
@NamedQueries({
        @NamedQuery(
                name = "com.example.helloworld.core.Contenido.findAll",
                query = "SELECT ca FROM Contenido ca"
        )
})
public class Contenido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idCalificacion;

    @Column(name = "idItem", nullable = false)
    public int idItem;

    @Column(name = "idTransaccion", nullable = false)
    public int idTransaccion;
    
    @column(name = "calificacion", nullable = false)
    public int calificacion;
    
    @column(name = "comentario", nullable = false)
    public String comentario;
    
    public Contenido() {
    }

    public Contenido(int idCalificacion, int idItem, int idTransaccion, int calificacion, String comentario) {
        this.idCalificacion = idCalificacion;
        this.idItem = idItem;
        this.idTransaccion = idTransaccion;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    public int getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }
    
    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    
    public int getComentario() {
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
        if (!(o instanceof Contenido)) {
            return false;
        }

        final Contenido that = (Contenido) o;
        
        return Objects.equals(this.idCalificacion, that.idCalificacion) &&
                Objects.equals(this.idItem, that.idItem) &&
                Objects.equals(this.idTransaccion, that.idTransaccion) &&
                Objects.equals(this.calificacion, that.calificacion) &&
                Objects.equals(this.comentario, that.comentario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCalificacion, idItem, idTransaccion, calificacion, comentario);
    }
}
