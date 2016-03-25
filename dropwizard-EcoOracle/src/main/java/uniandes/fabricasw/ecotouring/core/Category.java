package uniandes.fabricasw.ecotouring.core;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CATEGORY", schema = "ADMIN")
@NamedQueries({
		@NamedQuery(name = "uniandes.fabricasw.ecotouring.core.Category.findAll", query = "SELECT c FROM Category c WHERE type = 4") })
public class Category implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


	private Long id;	
	private String name;
	private Long type;
	private Set<Item> items = new HashSet<Item>();

	public Category() {
		this.type = 4L;
	}

	@Id
	@GeneratedValue(generator = "CategorySeq")
	@SequenceGenerator(name = "CategorySeq", sequenceName = "CATEGORY_SEQ", allocationSize = 5)
	public Long getId() {
		return this.id;
	}
	
	@Column(name = "NAME", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}	

	@JsonIgnore	
	@Column(name = "TYPE", nullable = false)
	public Long getType() {
		return this.type;
	}	
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Item> getItems() {
		return this.items;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(Long type) {
		this.type = type;
	}
}
