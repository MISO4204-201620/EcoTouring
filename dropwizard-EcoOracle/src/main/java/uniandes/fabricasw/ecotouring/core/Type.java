package uniandes.fabricasw.ecotouring.core;
// Generated Mar 13, 2016 7:36:42 PM by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Type generated by hbm2java
 */
public class Type implements java.io.Serializable {

	private BigDecimal id;
	private Type type;
	private String name;
	private Set types = new HashSet(0);
	private Set transactions = new HashSet(0);
	private Set personsForRole = new HashSet(0);
	private Set items = new HashSet(0);
	private Set conversations = new HashSet(0);
	private Set personsForCategory = new HashSet(0);

	public Type() {
	}

	public Type(BigDecimal id, Type type, String name) {
		this.id = id;
		this.type = type;
		this.name = name;
	}

	public Type(BigDecimal id, Type type, String name, Set types, Set transactions, Set personsForRole, Set items,
			Set conversations, Set personsForCategory) {
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

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getTypes() {
		return this.types;
	}

	public void setTypes(Set types) {
		this.types = types;
	}

	public Set getTransactions() {
		return this.transactions;
	}

	public void setTransactions(Set transactions) {
		this.transactions = transactions;
	}

	public Set getPersonsForRole() {
		return this.personsForRole;
	}

	public void setPersonsForRole(Set personsForRole) {
		this.personsForRole = personsForRole;
	}

	public Set getItems() {
		return this.items;
	}

	public void setItems(Set items) {
		this.items = items;
	}

	public Set getConversations() {
		return this.conversations;
	}

	public void setConversations(Set conversations) {
		this.conversations = conversations;
	}

	public Set getPersonsForCategory() {
		return this.personsForCategory;
	}

	public void setPersonsForCategory(Set personsForCategory) {
		this.personsForCategory = personsForCategory;
	}

}
