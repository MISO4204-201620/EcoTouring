package uniandes.fabricasw.ecotouring.core;
// Generated Mar 13, 2016 7:36:42 PM by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.util.Date;

/**
 * ItemComment generated by hbm2java
 */
public class ItemComment implements java.io.Serializable {

	private BigDecimal id;
	private Person person;
	private Item item;
	private BigDecimal score;
	private String text;
	private Date dateEntry;

	public ItemComment() {
	}

	public ItemComment(BigDecimal id, Person person, Item item, BigDecimal score) {
		this.id = id;
		this.person = person;
		this.item = item;
		this.score = score;
	}

	public ItemComment(BigDecimal id, Person person, Item item, BigDecimal score, String text, Date dateEntry) {
		this.id = id;
		this.person = person;
		this.item = item;
		this.score = score;
		this.text = text;
		this.dateEntry = dateEntry;
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

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public BigDecimal getScore() {
		return this.score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDateEntry() {
		return this.dateEntry;
	}

	public void setDateEntry(Date dateEntry) {
		this.dateEntry = dateEntry;
	}

}
