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
@Table(name = "consulta")
@NamedQueries({
        @NamedQuery(
                name = "com.example.helloworld.core.Consulta.findAll",
                query = "SELECT co FROM Consulta co"
        )
})
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idConsulta;

    @Column(name = "idBusqueda", nullable = false)
    public int idBusqueda;

    @Column(name = "idTransaccion", nullable = false)
    public int idTransaccion;
    
    public Consulta() {
    }

    public Consulta(int idConsulta, int idBusqueda, int idTransaccion) {
        this.idConsulta = idConsulta;
        this.idBusqueda = idBusqueda;
        this.idTransaccion = idTransaccion;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getIdBusqueda() {
        return idBusqueda;
    }

    public void setIdBusqueda(int idBusqueda) {
        this.idBusqueda = idBusqueda;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
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
    }
}
