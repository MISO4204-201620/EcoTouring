package uniandes.fabricasw.ecotouring.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.DiscriminatorType;
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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "ITEM", schema = "ADMIN")
@DiscriminatorColumn(name="CATEGORY", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("BASIC")
@NamedQueries({ @NamedQuery(name = "uniandes.fabricasw.ecotouring.core.Item.findAll", query = "SELECT i FROM Item i") })
public class Item implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long itemId;	
	private ItemType itemType;
	private ItemStatus status;
	private String name;
	private String description;
	private Long price;
	private Long score;
	private Category category;
	private Person supplier;	
	private String tags;
	private String urlImage;
	private ContentType contentType;
	private Item item;
	
	private List<Conversation> conversations = new ArrayList<Conversation>();
	private Set<ItemComment> itemComments = new HashSet<ItemComment>();
	private Set<ItemContent> itemContents = new HashSet<ItemContent>();
	private Set<TransactionDetail> transactionDetails = new HashSet<TransactionDetail>();	
	private Set<Item> items = new HashSet<Item>();
	
	public Item() {
	}

	@Id
	@Column(name = "ITEM_ID")
	@GeneratedValue(generator = "ItemSeq")
	@SequenceGenerator(name = "ItemSeq", sequenceName = "ITEM_SEQ", allocationSize = 25)	
	public Long getitemId() {
		return this.itemId;
	}		
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE", nullable = true)
	public ItemType getItemType() {
		return itemType;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS", nullable = true)
	public ItemStatus getStatus() {
		return this.status;
	}	

	@Column(name = "NAME", nullable = false)
	public String getName() {
		return this.name;
	}
	
	@Column(name = "DESCRIPTION", nullable = true)
	public String getDescription() {
		return this.description;
	}	

	@Column(name = "PRICE", nullable = false)
	public Long getPrice() {
		return this.price;
	}

	@Column(name = "SCORE", nullable = false)
	public Long getScore() {
		return this.score;
	}
	
	/*@Enumerated(EnumType.STRING)
	public Category getCategory() {
		return this.category;
	}*/
	
	@ManyToOne
	@JoinColumn(name = "SUPPLIER", nullable = true)
	public Person getSupplier() {
		return this.supplier;
	}	

	@Column(name = "TAGS", nullable = true)
	public String getTags() {
		return this.tags;
	}
	
	@Column(name = "URL_IMAGE", nullable = true)
	public String getUrlImage() {
		return this.urlImage;
	}	

	@Enumerated(EnumType.STRING)
	@Column(name = "CONTENT_TYPE", nullable = true)
	public ContentType getContentType() {
		return this.contentType;
	}
	
	@ManyToOne
	@JoinColumn(name = "PARENT", nullable = true)
	public Item getItem() {
		return this.item;
	}	

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	public List<Conversation> getConversations() {
		return this.conversations;
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
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")	
	public Set<TransactionDetail> getTransactionDetails() {
		return this.transactionDetails;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}

	public void setConversations(List<Conversation> conversations) {
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
