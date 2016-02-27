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
@Table(name = "transaccion")
@NamedQueries({
        @NamedQuery(
                name = "com.example.helloworld.core.Transaccion.findAll",
                query = "SELECT tr FROM Transaccion tr"
        )
})
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idTransaccion;

    @Column(name = "idUsuario", nullable = false)
    public int idUsuario;

    @Column(name = "tipo", nullable = false)
    public int tipo;
    
    public Transaccion() {
    }

    public Transaccion(int idTransaccion, int idUsuario, int tipo) {
        this.idTransaccion = idTransaccion;
        this.idUsuario = idUsuario;
        this.tipo = tipo;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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
    }
}
