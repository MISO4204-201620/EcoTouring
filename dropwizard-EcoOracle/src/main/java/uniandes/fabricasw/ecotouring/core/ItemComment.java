package uniandes.fabricasw.ecotouring.core;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ITEM_COMMENT", schema = "ADMIN")
@NamedQueries({
		@NamedQuery(name = "uniandes.fabricasw.ecotouring.core.ItemComment.findByItem", query = "SELECT i FROM ItemComment i WHERE item = 1") })
public class ItemComment implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Person author;
	private Date dateEntry;
	@Id
	@GeneratedValue(generator = "ItemCommentSeq")
	@SequenceGenerator(name = "ItemCommentSeq", sequenceName = "ITEM_COMMENT_SEQ", allocationSize = 5)
	private Long id;
	private Item item;
	private Long score;
	private String text;

	public ItemComment() {
	}

	public ItemComment(Long id, Person person, Item item, Long score) {
		this.id = id;
		this.author = person;
		this.item = item;
		this.score = score;
	}

	public ItemComment(Long id, Person person, Item item, Long score, String text, Date dateEntry) {
		this.id = id;
		this.author = person;
		this.item = item;
		this.score = score;
		this.text = text;
		this.dateEntry = dateEntry;
	}

	public Person getAuthor() {
		return author;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_ENTRY", length = 7)
	public Date getDateEntry() {
		return this.dateEntry;
	}

	@Id

	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getId() {
		return this.id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEM", nullable = false)
	public Item getItem() {
		return this.item;
	}

	@ManyToOne
	@JoinColumn(name = "AUTHOR", nullable = false)
	public Person getPerson() {
		return this.author;
	}

	@Column(name = "SCORE", nullable = false, precision = 22, scale = 0)
	public Long getScore() {
		return this.score;
	}

	@Column(name = "TEXT", length = 20)
	public String getText() {
		return this.text;
	}

	public void setAuthor(Person author) {
		this.author = author;
	}

	public void setDateEntry(Date dateEntry) {
		this.dateEntry = dateEntry;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setPerson(Person author) {
		this.author = author;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public void setText(String text) {
		this.text = text;
	}

}
