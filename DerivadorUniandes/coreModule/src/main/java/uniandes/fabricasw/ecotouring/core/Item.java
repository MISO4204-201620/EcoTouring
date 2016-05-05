package uniandes.fabricasw.ecotouring.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "ITEM", schema = "ADMIN")
@DiscriminatorColumn(name = "CATEGORY", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("BASIC")
@NamedQueries({ @NamedQuery(name = "uniandes.fabricasw.ecotouring.core.Item.findAll", query = "SELECT i FROM Item i"),
		@NamedQuery(name = "uniandes.fabricasw.ecotouring.core.Item.findAccommodation", query = "SELECT i FROM Item i WHERE category = 'ACCOMMODATION'"),
		@NamedQuery(name = "uniandes.fabricasw.ecotouring.core.Item.findAlimentation", query = "SELECT i FROM Item i WHERE category = 'ALIMENTATION'"),
		@NamedQuery(name = "uniandes.fabricasw.ecotouring.core.Item.findEcoTour", query = "SELECT i FROM Item i WHERE category = 'ECOTOUR'"),
		@NamedQuery(name = "uniandes.fabricasw.ecotouring.core.Item.findTransport", query = "SELECT i FROM Item i WHERE category = 'TRANSPORT'") })
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long itemId;
	private ItemType itemType;
	private ItemStatus status;
	private String name;
	private String description;
	private Long price;
	private Long score;
	private String category;
	private Person supplier;
	private String tags;
	private String urlImage;
	private ContentType contentType;
	private Item parent;
	private int queryCounter;

	private List<Conversation> conversations = new ArrayList<Conversation>();
	private Set<ItemComment> itemComments = new HashSet<ItemComment>();
	private Set<ItemContent> itemContents = new HashSet<ItemContent>();
	private Set<TransactionDetail> transactionDetails = new HashSet<TransactionDetail>();
	private Set<Item> packageDetails = new HashSet<Item>(0);

	public Item() {
		this.queryCounter = 0;
	}

	@Id
	@Column(name = "ITEM_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_SEQ")
	@SequenceGenerator(name = "ITEM_SEQ", sequenceName = "ITEM_SEQ", allocationSize = 1)
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

	// @Enumerated(EnumType.STRING)
	@Column(name = "CATEGORY", insertable = false, updatable = false)
	public String getCategory() {
		return this.category;
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

	@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@itemId")
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "PARENT", nullable = true)
	public Item getParent() {
		return this.parent;
	}

	// @JsonManagedReference
	@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@itemId")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
	public Set<Item> getPackageDetails() {
		return this.packageDetails;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	public List<Conversation> getConversations() {
		return this.conversations;
	}
	
	@Column(name = "QUERY_COUNTER", nullable = true)
	public int getQueryCounter() {
		return queryCounter;
	}

	public void setQueryCounter(int queryCounter) {
		this.queryCounter = queryCounter;
	}

	public void addQueryCounter() {
		this.queryCounter++;
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
	public Set<TransactionDetail> getTransactionDetails() {
		return this.transactionDetails;
	}

	public void setCategory(String category) {
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

	public void setItemComments(Set<ItemComment> itemComments) {
		this.itemComments = itemComments;
	}

	public void setItemContents(Set<ItemContent> itemContents) {
		this.itemContents = itemContents;
	}

	public void setParent(Item parent) {
		this.parent = parent;
	}

	public void setPackageDetails(Set<Item> packageDetails) {
		this.packageDetails = packageDetails;
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
