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
@Table(name = "compraitem")
@NamedQueries({
        @NamedQuery(
                name = "com.example.helloworld.core.CompraItem.findAll",
                query = "SELECT comit FROM CompraItem comit"
        )
})
public class CompraItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idCompraItem;

    @Column(name = "cantidad", nullable = false)
    public int cantidad;

    @Column(name = "idCompra", nullable = false)
    public int idCompra;
    
    @Column(name = "idProveedor", nullable = false)
    public int idProveedor;
    
    @Column(name = "idItem", nullable = false)
    private int idItem;
    
    @Column(name = "precio", nullable = false)
    private float precio;
    
    public CompraItem() {
    }

    public CompraItem(int idCompraItem, int cantidad, int idCompra, int idProveedor, int idItem, float precio) {
    	this.idCompraItem = idCompraItem;
    	this.cantidad = cantidad;
        this.idCompra = idCompra;
        this.idProveedor = idProveedor;
        this.idItem = idItem;
        this.precio = precio;
    }

    public int getIdCompraItem() {
        return idCompraItem;
    }

    public void setIdCompraItem(int idCompraItem) {
        this.idCompraItem = idCompraItem;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }
    
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
        
     public int getIdItem() {
         return idItem;
     }

     public void setIdItem(int idItem) {
         this.idItem = idItem;
     }
     
     public float getPrecio() {
         return precio;
     }

     public void setPrecio(float precio) {
         this.precio = precio;
     }
     
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CompraItem)) {
            return false;
        }

        final CompraItem that = (CompraItem) o;

        return Objects.equals(this.idCompraItem, that.idCompraItem) &&
                Objects.equals(this.cantidad, that.cantidad) &&
                Objects.equals(this.idCompra, that.idCompra) &&
                Objects.equals(this.idProveedor, that.idProveedor) &&
                Objects.equals(this.idItem, that.idItem) &&
                Objects.equals(this.precio, that.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCompraItem, cantidad, idCompra, idProveedor, idItem, precio);
    }
}
