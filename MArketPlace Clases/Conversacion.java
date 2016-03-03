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
@Table(name = "conversacion")
@NamedQueries({
        @NamedQuery(
                name = "com.example.helloworld.core.Conversacion.findAll",
                query = "SELECT con FROM Conversacion con"
        )
})
public class Conversacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idConversacion;

    @Column(name = "autor", nullable = false)
    public int autor;

    @Column(name = "estado", nullable = false)
    public int estado;
    
    @Column(name = "fecha", nullable = false)
    public Date fecha;
    
    @Column(name = "id", nullable = false)
    public int id;
    
    @Column(name = "mensaje", nullable = false)
    public char mensaje;
    
    @Column(name = "tipo", nullable = false)
    public int tipo;
    
    public Conversacion() {
    }

    public Conversacion(int idConversacion, int estado, int autor, Date fecha, int id, char mensaje, int tipo) {
    	this.idConversacion = idConversacion;
    	this.autor = autor;
        this.estado = estado;
    	this.fecha = fecha;
        this.id = id;
    	this.mensaje = mensaje;
        this.tipo = tipo;
    }

    public int getIdConversacion() {
        return idConversacion;
    }

    public void setIdConversacion(int idConversacion) {
        this.idConversacion = idConversacion;
    }

    public int getAutor() {
        return autor;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }
    
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public char getMensaje() {
        return mensaje;
    }

    public void setMensaje(char mensaje) {
        this.id = mensaje;
    }
    
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
     
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Conversacion)) {
            return false;
        }

        final Conversacion that = (Conversacion) o;

        return Objects.equals(this.idConversacion, that.idConversacion) &&
                Objects.equals(this.autor, that.autor) &&
                Objects.equals(this.estado, that.estado) &&
                Objects.equals(this.fecha, that.fecha) &&
                Objects.equals(this.id, that.id) &&
                Objects.equals(this.mensaje, that.mensaje) &&
                Objects.equals(this.tipo, that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idConversacion, autor, estado, fecha, id, mensaje, tipo);
    }
}
