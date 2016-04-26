package uniandes.fabricasw.ecotouring.core;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PERSON", schema = "ADMIN")
@NamedQueries({
		@NamedQuery(name = "uniandes.fabricasw.ecotouring.core.Person.findAll", query = "SELECT p FROM Person p"),
		@NamedQuery(name = "uniandes.fabricasw.ecotouring.core.Person.findAllSuppliers", query = "SELECT p FROM Person p WHERE role = 'SUPPLIER'") })
public class Person implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String fullName;
	private String jobTitle;

	private Role role;
	private String username;
	private String password;
	private String address;
	private String email;

	private Person parent;
	private Set<Person> persons = new HashSet<Person>();
	private Set<Conversation> conversations = new HashSet<Conversation>();
	private Set<ItemComment> itemComments = new HashSet<ItemComment>();
	private Set<Item> items = new HashSet<Item>();
	private Set<Transaction> transactions = new HashSet<Transaction>();

	public Person() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PersonSeq")
	@SequenceGenerator(name = "PersonSeq", sequenceName = "PERSON_SEQ", allocationSize = 1)
	public Long getId() {
		return this.id;
	}

	@Column(name = "NAME", length = 20)
	public String getFullName() {
		return this.fullName;
	}

	@Column(name = "JOBTITLE", length = 20)
	public String getJobTitle() {
		return this.jobTitle;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "ROLE", nullable = false)
	public Role getRole() {
		return this.role;
	}

	@Column(name = "USERNAME", length = 20)
	public String getUsername() {
		return this.username;
	}

	@Column(name = "PASSWORD", length = 20)
	public String getPassword() {
		return this.password;
	}

	@Column(name = "ADDRESS", length = 20)
	public String getAddress() {
		return this.address;
	}

	@Column(name = "EMAIL", length = 20)
	public String getEmail() {
		return this.email;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
	public Set<Conversation> getConversations() {
		return this.conversations;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
	public Set<ItemComment> getItemComments() {
		return this.itemComments;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier")
	public Set<Item> getItems() {
		return this.items;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT")
	public Person getParent() {
		return this.parent;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
	public Set<Person> getPersons() {
		return this.persons;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setConversations(Set<Conversation> conversations) {
		this.conversations = conversations;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setItemComments(Set<ItemComment> itemComments) {
		this.itemComments = itemComments;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public void setParent(Person parent) {
		this.parent = parent;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
