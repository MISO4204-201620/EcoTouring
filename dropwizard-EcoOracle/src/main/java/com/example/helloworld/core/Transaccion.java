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
@Table(name = "transaccion")
@NamedQueries({
        @NamedQuery(
                name = "com.example.helloworld.core.Transaccion.findAll",
                query = "SELECT tr FROM Transaccion tr"
        )
})
public class Transaccion {
	
	//TODO
	/**
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idTransaccion;

    @Column(name = "idUsuario", nullable = false)
    public long idUsuario;

    @Column(name = "tipo", nullable = false)
    public long tipo;
    
    public Transaccion() {
    }

    public Transaccion(long idTransaccion, long idUsuario, long tipo) {
        this.idTransaccion = idTransaccion;
        this.idUsuario = idUsuario;
        this.tipo = tipo;
    }

    public long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getTipo() {
        return tipo;
    }

    public void setTipo(long tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Transaccion)) {
            return false;
        }

        final Transaccion that = (Transaccion) o;
        
        return Objects.equals(this.idTransaccion, that.idTransaccion) &&
                Objects.equals(this.idUsuario, that.idUsuario) &&
                Objects.equals(this.tipo, that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTransaccion, idUsuario, tipo);
    }*/
}
