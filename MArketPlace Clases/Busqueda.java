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
@Table(name = "busqueda")
@NamedQueries({
        @NamedQuery(
                name = "com.example.helloworld.core.Busqueda.findAll",
                query = "SELECT bu FROM Busqueda bu"
        )
})
public class Busqueda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idBusqueda;

    @Column(name = "idCategoriaItem", nullable = false)
    public int idCategoriaItem;

    @Column(name = "idProveedor", nullable = false)
    public int idProveedor;
    
    @Column(name = "idTransaccion", nullable = false)
    public int idTransaccion;
    
    @Column(name = "descripcion", nullable = false)
    public String descripcion;
    
    public Busqueda() {
    }

    public Busqueda(int idBusqueda, int idCategoriaItem, int idProveedor, int idTransaccion, String descripcion) {
    	this.idBusqueda = idBusqueda;
    	this.idCategoriaItem = idCategoriaItem;
        this.idProveedor = idProveedor;
        this.idTransaccion = idTransaccion;
        this.descripcion = descripcion;
    }

    public int getIdBusqueda() {
        return idBusqueda;
    }

    public void setIdBusqueda(int idBusqueda) {
        this.idBusqueda = idBusqueda;
    }

    public int getIdCategoriaItem() {
        return idCategoriaItem;
    }

    public void setIdCategoriaItem(int idCategoriaItem) {
        this.idCategoriaItem = idCategoriaItem;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
        
     public String getDescripcion() {
         return descripcion;
     }

     public void setDescripcion(String descripcion) {
         this.descripcion = descripcion;
     }
     
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Busqueda)) {
            return false;
        }

        final Busqueda that = (Busqueda) o;

        return Objects.equals(this.idBusqueda, that.idBusqueda) &&
                Objects.equals(this.idCategoriaItem, that.idCategoriaItem) &&
                Objects.equals(this.idProveedor, that.idProveedor) &&
                Objects.equals(this.idTransaccion, that.idTransaccion) &&
                Objects.equals(this.descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBusqueda, idCategoriaItem, idProveedor, idTransaccion, descripcion);
    }
}
