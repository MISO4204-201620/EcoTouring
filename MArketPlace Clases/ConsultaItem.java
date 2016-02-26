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
@Table(name = "consultaitem")
@NamedQueries({
        @NamedQuery(
                name = "com.example.helloworld.core.ConsultaItem.findAll",
                query = "SELECT c FROM ConsultaItem c"
        )
})
public class ConsultaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idConsultaItem;

    @Column(name = "idConsulta", nullable = false)
    public int idConsulta;

    @Column(name = "idItem", nullable = false)
    public int idItem;
 
    public ConsultaItem() {
    }

    public ConsultaItem(int idConsultaItem, int idConsulta, int idItem) {
        this.idConsultaItem = idConsultaItem;
        this.idConsulta = idConsulta;
        this.idItem = idItem;
    }

    public int getIdConsultaItem() {
        return idConsultaItem;
    }

    public void setIdConsultaItem(int idConsultaItem) {
        this.idConsultaItem = idConsultaItem;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ConsultaItem)) {
            return false;
        }

        final ConsultaItem that = (ConsultaItem) o;

        return Objects.equals(this.idConsultaItem, that.idConsultaItem) &&
                Objects.equals(this.idConsulta, that.idConsulta) &&
                Objects.equals(this.idItem, that.idItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idConsultaItem, idConsulta, idItem);
    }
}
