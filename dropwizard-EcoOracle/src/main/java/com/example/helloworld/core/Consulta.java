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
@Table(name = "consulta")
@NamedQueries({
        @NamedQuery(
                name = "com.example.helloworld.core.Consulta.findAll",
                query = "SELECT co FROM Consulta co"
        )
})
public class Consulta {
	
	
	//TODO
	/**
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idConsulta;

    @Column(name = "idBusqueda", nullable = false)
    public long idBusqueda;

    @Column(name = "idTransaccion", nullable = false)
    public long idTransaccion;
    
    public Consulta() {
    }

    public Consulta(long idConsulta, long idBusqueda, long idTransaccion) {
        this.idConsulta = idConsulta;
        this.idBusqueda = idBusqueda;
        this.idTransaccion = idTransaccion;
    }

    public long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public long getIdBusqueda() {
        return idBusqueda;
    }

    public void setIdBusqueda(long idBusqueda) {
        this.idBusqueda = idBusqueda;
    }

    public long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Consulta)) {
            return false;
        }

        final Consulta that = (Consulta) o;
        
        return Objects.equals(this.idConsulta, that.idConsulta) &&
                Objects.equals(this.idBusqueda, that.idBusqueda) &&
                Objects.equals(this.idTransaccion, that.idTransaccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idConsulta, idBusqueda, idTransaccion);
    }*/
}
