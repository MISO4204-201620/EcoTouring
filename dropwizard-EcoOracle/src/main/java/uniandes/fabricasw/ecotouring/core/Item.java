package uniandes.fabricasw.ecotouring.core;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "ITEM", schema = "ADMIN")
@NamedQueries({ @NamedQuery(name = "uniandes.fabricasw.ecotouring.core.Item.findAll", query = "SELECT i FROM Item i") })
public class Item implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long itemId;	
	private Category category;
	private ContentType contentType;
	private Set<Conversation> conversations = new HashSet<Conversation>();
	private String description;	
	private Item item;
	private Set<ItemComment> itemComments = new HashSet<ItemComment>();
	private Set<ItemContent> itemContents = new HashSet<ItemContent>();
	private Set<Item> items = new HashSet<Item>();
	private ItemType itemType;
	private String name;
	private Long price;
	private Long score;
	private ItemStatus status;
	private Person supplier;
	private String tags;
	private Set<TransactionDetail> transactionDetails = new HashSet<TransactionDetail>();
	private String urlImage;

	public Item() {
	}

	@ManyToOne
	@JoinColumn(name = "CATEGORY", referencedColumnName = "ID", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "CONTENT_TYPE", nullable = true)
	public ContentType getContentType() {
		return this.contentType;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	public Set<Conversation> getConversations() {
		return this.conversations;
	}

	@Column(name = "DESCRIPTION", nullable = true)
	public String getDescription() {
		return this.description;
	}

	@Id
	@Column(name = "ITEM_ID")
	@GeneratedValue(generator = "ItemSeq")
	@SequenceGenerator(name = "ItemSeq", sequenceName = "ITEM_SEQ", allocationSize = 5)	
	public Long getitemId() {
		return this.itemId;
	}

	@ManyToOne
	@JoinColumn(name = "PARENT", nullable = true)
	public Item getItem() {
		return this.item;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	public Set<ItemComment> getItemComments() {
		return this.itemComments;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	public Set<ItemContent> getItemContents() {
		return this.itemContents;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	public Set<Item> getItems() {
		return this.items;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE", nullable = true)
	public ItemType getItemType() {
		return itemType;
	}

	@Column(name = "NAME", nullable = false)
	public String getName() {
		return this.name;
	}

	@Column(name = "PRICE", nullable = false)
	public Long getPrice() {
		return this.price;
	}

	@Column(name = "SCORE", nullable = false)
	public Long getScore() {
		return this.score;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS", nullable = true)
	public ItemStatus getStatus() {
		return this.status;
	}

	@ManyToOne
	@JoinColumn(name = "SUPPLIER", nullable = true)
	public Person getSupplier() {
		return this.supplier;
	}

	@Column(name = "TAGS", nullable = true)
	public String getTags() {
		return this.tags;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")	
	public Set<TransactionDetail> getTransactionDetails() {
		return this.transactionDetails;
	}

	@Column(name = "URL_IMAGE", nullable = true)
	public String getUrlImage() {
		return this.urlImage;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}

	public void setConversations(Set<Conversation> conversations) {
		this.conversations = conversations;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setItemComments(Set<ItemComment> itemComments) {
		this.itemComments = itemComments;
	}

	public void setItemContents(Set<ItemContent> itemContents) {
		this.itemContents = itemContents;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public void setStatus(ItemStatus status) {
		this.status = status;
	}

	public void setSupplier(Person person) {
		this.supplier = person;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public void setTransactionDetails(Set<TransactionDetail> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

}
