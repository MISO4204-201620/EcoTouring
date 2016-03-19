package uniandes.fabricasw.ecotouring.core;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import uniandes.fabricasw.ecotouring.core.Item;
import uniandes.fabricasw.ecotouring.core.Person;
import uniandes.fabricasw.ecotouring.core.Type;

@Entity
@Table(name = "ITEM")
@NamedQueries({ @NamedQuery(name = "Item.findAll",
                                    query = "SELECT i FROM Item i") })
public class Item {

	@Column(name = "ID", nullable = false)
	private BigDecimal id;

	@Column(name = "NAME", nullable = false)
	private String name;	

	@Column(name = "DESCRIPTION", nullable = true)
	private String description;	
	
	@Column(name = "SUPPLIER", nullable = true)
	private Person person;

	@Column(name = "PRICE", nullable = true)
	private BigDecimal price;
	
	@Column(name = "CATEGORY", nullable = true)
	private Type type;

	@Column(name = "URL_IMAGE", nullable = true)
	private String urlImage;	

	@Column(name = "CONTENT_TYPE", nullable = true)
	private String contentType;	

	@Column(name = "STATUS", nullable = true)
	private Character status;	

	@Column(name = "TAGS", nullable = true)
	private String tags;	

	@Column(name = "SCORE", nullable = true)
	private BigDecimal score;	
	
	@Column(name = "PARENT", nullable = true)
	private Item item;	
	
	private Set itemComments = new HashSet(0);
	private Set transacctionDetails = new HashSet(0);
	private Set items = new HashSet(0);
	private Set itemContents = new HashSet(0);
	private Set conversations = new HashSet(0);

	public Item() {
	}

	public Item(BigDecimal id, Person person, String name, String description, BigDecimal price) {
		this.id = id;
		this.person = person;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Item(BigDecimal id, Person person, Type type, Item item, String name, String description, BigDecimal price,
			String urlImage, String contentType, Character status, String tags, BigDecimal score, Set itemComments,
			Set transacctionDetails, Set items, Set itemContents, Set conversations) {
		this.id = id;
		this.person = person;
		this.type = type;
		this.item = item;
		this.name = name;
		this.description = description;
		this.price = price;
		this.urlImage = urlImage;
		this.contentType = contentType;
		this.status = status;
		this.tags = tags;
		this.score = score;
		this.itemComments = itemComments;
		this.transacctionDetails = transacctionDetails;
		this.items = items;
		this.itemContents = itemContents;
		this.conversations = conversations;
	}

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getUrlImage() {
		return this.urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public String getContentType() {
		return this.contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Character getStatus() {
		return this.status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public BigDecimal getScore() {
		return this.score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public Set getItemComments() {
		return this.itemComments;
	}

	public void setItemComments(Set itemComments) {
		this.itemComments = itemComments;
	}

	public Set getTransacctionDetails() {
		return this.transacctionDetails;
	}

	public void setTransacctionDetails(Set transacctionDetails) {
		this.transacctionDetails = transacctionDetails;
	}

	public Set getItems() {
		return this.items;
	}

	public void setItems(Set items) {
		this.items = items;
	}

	public Set getItemContents() {
		return this.itemContents;
	}

	public void setItemContents(Set itemContents) {
		this.itemContents = itemContents;
	}

	public Set getConversations() {
		return this.conversations;
	}

	public void setConversations(Set conversations) {
		this.conversations = conversations;
	}

}
