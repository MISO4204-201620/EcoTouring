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
@Table(name = "ITEM")
@NamedQueries({ @NamedQuery(name = "uniandes.fabricasw.ecotouring.core.Item.findAll", query = "SELECT i FROM Item i") })
public class Item {

	public Item(long id, long idCategory, long idSupplier, long idTipo, char name, long price, long score,
			char description, long estatus) {
		super();
		this.id = id;
		this.idCategory = idCategory;
		this.idSupplier = idSupplier;
		this.idTipo = idTipo;
		this.name = name;
		this.price = price;
		this.score = score;
		this.description = description;
		this.estatus = estatus;
	}

	@Id
	@GeneratedValue(generator = "ItemSeq")
	@SequenceGenerator(name = "ItemSeq", sequenceName = "ITEM_SEQ", allocationSize = 5)
	public long id;

	@Column(name = "idCategoria", nullable = false)
	public long idCategory;

	@Column(name = "idProveedor", nullable = false)
	public long idSupplier;

	@Column(name = "tipoOferta", nullable = false)
	public long idTipo;

	@Column(name = "nombre", nullable = false)
	public char name;

	@Column(name = "precio", nullable = false)
	public long price;
	
	@Column(name = "calificacion", nullable = false)
	public long score;
	
	@Column(name = "descripcion", nullable = false)
	public char description;

	@Column(name = "estado", nullable = false)
	public long estatus;	

	public Item() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(long idCategory) {
		this.idCategory = idCategory;
	}

	public long getIdSupplier() {
		return idSupplier;
	}

	public void setIdSupplier(long idSupplier) {
		this.idSupplier = idSupplier;
	}

	public long getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(long idTipo) {
		this.idTipo = idTipo;
	}

	public char getName() {
		return name;
	}

	public void setName(char name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	public char getDescription() {
		return description;
	}

	public void setDescription(char description) {
		this.description = description;
	}

	public long getEstatus() {
		return estatus;
	}

	public void setEstatus(long estatus) {
		this.estatus = estatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + description;
		result = prime * result + (int) (estatus ^ (estatus >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (idCategory ^ (idCategory >>> 32));
		result = prime * result + (int) (idSupplier ^ (idSupplier >>> 32));
		result = prime * result + (int) (idTipo ^ (idTipo >>> 32));
		result = prime * result + name;
		result = prime * result + (int) (price ^ (price >>> 32));
		result = prime * result + (int) (score ^ (score >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (description != other.description)
			return false;
		if (estatus != other.estatus)
			return false;
		if (id != other.id)
			return false;
		if (idCategory != other.idCategory)
			return false;
		if (idSupplier != other.idSupplier)
			return false;
		if (idTipo != other.idTipo)
			return false;
		if (name != other.name)
			return false;
		if (price != other.price)
			return false;
		if (score != other.score)
			return false;
		return true;
	}

}
