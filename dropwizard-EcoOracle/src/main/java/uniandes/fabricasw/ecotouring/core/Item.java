package uniandes.fabricasw.ecotouring.core;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "item")
@NamedQueries({ @NamedQuery(name = "com.example.helloworld.core.Item.findAll", query = "SELECT i FROM Item i") })
public class Item {

	@Id
	@GeneratedValue(generator = "ItemSeq")
	@SequenceGenerator(name = "ItemSeq", sequenceName = "ITEM_SEQ", allocationSize = 5)
	public long id;

	@Column(name = "descripcion", nullable = false)
	public char descripcion;

	@Column(name = "estado", nullable = false)
	public long estado;

	@Column(name = "idCategoria", nullable = false)
	public long idCategoria;

	@Column(name = "idProveedor", nullable = false)
	public long idProveedor;

	@Column(name = "nombre", nullable = false)
	public char nombre;

	@Column(name = "precio", nullable = false)
	public long precio;

	@Column(name = "tipoOferta", nullable = false)
	public long tipoOferta;

	public Item() {
	}

	public Item(long id, char descripcion, long estado, long idCategoria, long idProveedor, char nombre, long precio,
			long tipoOferta) {
		this.id = id;
		this.descripcion = descripcion;
		this.estado = estado;
		this.idCategoria = idCategoria;
		this.idProveedor = idProveedor;
		this.nombre = nombre;
		this.precio = precio;
		this.tipoOferta = tipoOferta;
	}

	public char getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(char descripcion) {
		this.descripcion = descripcion;
	}

	public long getEstado() {
		return estado;
	}

	public void setEstado(long estado) {
		this.estado = estado;
	}

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(long idProveedor) {
		this.idProveedor = idProveedor;
	}

	public char getNombre() {
		return nombre;
	}

	public void setNombre(char nombre) {
		this.nombre = nombre;
	}

	public long getTipoOferta() {
		return tipoOferta;
	}

	public void setTipoOferta(long tipoOferta) {
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

		return Objects.equals(this.id, that.id) && Objects.equals(this.descripcion, that.descripcion)
				&& Objects.equals(this.estado, that.estado) && Objects.equals(this.idCategoria, that.idCategoria)
				&& Objects.equals(this.idProveedor, that.idProveedor) && Objects.equals(this.nombre, that.nombre)
				&& Objects.equals(this.precio, that.precio) && Objects.equals(this.tipoOferta, that.tipoOferta);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, descripcion, estado, idCategoria, idProveedor, nombre, precio, tipoOferta);
	}
}
