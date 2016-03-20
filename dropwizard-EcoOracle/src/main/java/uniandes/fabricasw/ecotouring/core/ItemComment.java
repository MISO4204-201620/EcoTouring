package uniandes.fabricasw.ecotouring.core;
// Generated Mar 20, 2016 12:10:37 PM by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ItemComment generated by hbm2java
 */
@Entity
@Table(name = "ITEM_COMMENT", schema = "ADMIN")
public class ItemComment {

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

	@Id

	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AUTHOR", nullable = false)
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEM", nullable = false)
	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Column(name = "SCORE", nullable = false, precision = 22, scale = 0)
	public BigDecimal getScore() {
		return this.score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	@Column(name = "TEXT", length = 20)
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_ENTRY", length = 7)
	public Date getDateEntry() {
		return this.dateEntry;
	}

	public void setDateEntry(Date dateEntry) {
		this.dateEntry = dateEntry;
	}

}
