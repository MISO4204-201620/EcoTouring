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
@Table(name = "consultaitem")
@NamedQueries({
        @NamedQuery(
                name = "com.example.helloworld.core.ConsultaItem.findAll",
                query = "SELECT c FROM ConsultaItem c"
        )
})
public class ConsultaItem {
	
	
	//TODO
	/**
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idConsultaItem;

    @Column(name = "idConsulta", nullable = false)
    public long idConsulta;

    @Column(name = "idItem", nullable = false)
    public long idItem;
 
    public ConsultaItem() {
    }

    public ConsultaItem(long idConsultaItem, long idConsulta, long idItem) {
        this.idConsultaItem = idConsultaItem;
        this.idConsulta = idConsulta;
        this.idItem = idItem;
    }

    public long getIdConsultaItem() {
        return idConsultaItem;
    }

    public void setIdConsultaItem(long idConsultaItem) {
        this.idConsultaItem = idConsultaItem;
    }

    public long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public long getIdItem() {
        return idItem;
    }

    public void setIdItem(long idItem) {
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
    }*/
}
