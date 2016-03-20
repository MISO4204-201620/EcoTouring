package uniandes.fabricasw.ecotouring.core;
// Generated Mar 20, 2016 12:10:37 PM by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Type generated by hbm2java
 */
@Entity
@Table(name = "TYPE", schema = "ADMIN")

@NamedQueries({ @NamedQuery(name = "uniandes.fabricasw.ecotouring.core.Type.findAllCategories",
query = "SELECT t FROM Type t WHERE type = 4") })
public class Type {

	private BigDecimal id;
	private Type type;
	private String name;
	private Set<Type> types = new HashSet<Type>(0);
	private Set<Transaction> transactions = new HashSet<Transaction>(0);
	private Set<Person> personsForRole = new HashSet<Person>(0);
	private Set<Item> items = new HashSet<Item>(0);
	private Set<Conversation> conversations = new HashSet<Conversation>(0);
	private Set<Person> personsForCategory = new HashSet<Person>(0);

	public Type() {
	}

	public Type(BigDecimal id, Type type, String name) {
		this.id = id;
		this.type = type;
		this.name = name;
	}

	public Type(BigDecimal id, Type type, String name, Set<Type> types, Set<Transaction> transactions,
			Set<Person> personsForRole, Set<Item> items, Set<Conversation> conversations,
			Set<Person> personsForCategory) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.types = types;
		this.transactions = transactions;
		this.personsForRole = personsForRole;
		this.items = items;
		this.conversations = conversations;
		this.personsForCategory = personsForCategory;
	}

	@Id
	@GeneratedValue(generator = "InvSeq")
	@SequenceGenerator(name = "InvSeq", sequenceName = "TYPE_SEQ", allocationSize = 5)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TYPE", nullable = false)
	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Column(name = "NAME", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
	public Set<Type> getTypes() {
		return this.types;
	}

	public void setTypes(Set<Type> types) {
		this.types = types;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
	public Set<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "typeByRole")
	public Set<Person> getPersonsForRole() {
		return this.personsForRole;
	}

	public void setPersonsForRole(Set<Person> personsForRole) {
		this.personsForRole = personsForRole;
	}

	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
	public Set<Item> getItems() {
		return this.items;
	}*/

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
	public Set<Conversation> getConversations() {
		return this.conversations;
	}

	public void setConversations(Set<Conversation> conversations) {
		this.conversations = conversations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "typeByCategory")
	public Set<Person> getPersonsForCategory() {
		return this.personsForCategory;
	}

	public void setPersonsForCategory(Set<Person> personsForCategory) {
		this.personsForCategory = personsForCategory;
	}

}
