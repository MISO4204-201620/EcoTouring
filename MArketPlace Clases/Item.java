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
@Table(name = "item")
@NamedQueries({
        @NamedQuery(
                name = "com.example.helloworld.core.Item.findAll",
                query = "SELECT i FROM Item i"
        )
})
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idItem;

    @Column(name = "descripcion", nullable = false)
    public char descripcion;

    @Column(name = "estado", nullable = false)
    public int estado;
    
    @Column(name = "idCategoria", nullable = false)
    public int idCategoria;
    
    @Column(name = "id", nullable = false)
    public int id;
    
    @Column(name = "idProveedor", nullable = false)
    public int idProveedor;
    
    @Column(name = "nombre", nullable = false)
    public char nombre;
    
    @Column(name = "precio", nullable = false)
    public int precio;

    @Column(name = "tipoOferta", nullable = false)
    public int tipoOferta;

    public Item() {
    }

    public Item(int idItem, char descripcion, int estado, int idCategoria, int id, int idProveedor, char nombre, int precio, int tipoOferta) {
        this.idItem = idItem;
    	this.descripcion = descripcion;
        this.estado = estado;
        this.idCategoria = idCategoria;
        this.id = id;
        this.idProveedor = idProveedor;
        this.nombre = nombre; 
        this.precio = precio;
        this.tipoOferta = tipoOferta;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.id = idItem;
    }

    public char getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(char descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    public char getNombre() {
        return nombre;
    }

    public void setNombre(char nombre) {
        this.nombre = nombre;
    }
    
    public int getTipoOferta() {
        return tipoOferta;
    }

    public void setTipoOferta(int tipoOferta) {
        this.tipoOferta = tipoOferta;
    }
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Item)) {
            return false;
        }

        final Item that = (Item) o;

        return Objects.equals(this.idItem, that.idItem) &&
                Objects.equals(this.descripcion, that.descripcion) &&
                Objects.equals(this.estado, that.estado) &&
                Objects.equals(this.idCategoria, that.idCategoria) &&
                Objects.equals(this.id, that.id) &&
                Objects.equals(this.idProveedor, that.idProveedor) &&
                Objects.equals(this.nombre, that.nombre) &&
                Objects.equals(this.precio, that.precio) &&
                Objects.equals(this.tipoOferta, that.tipoOferta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idItem, descripcion, estado, idCategoria, id, idProveedor, nombre, precio, tipoOferta);
    }
}
