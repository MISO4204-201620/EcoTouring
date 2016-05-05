package uniandes.fabricasw.ecotouring.core;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

	private Long id;
	private String text;
	private Long score;
	private Date dateEntry;
	private Item item;
	private Person author;

	public ItemComment() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ItemCommentSeq")
	@SequenceGenerator(name = "ItemCommentSeq", sequenceName = "ITEM_COMMENT_SEQ", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getId() {
		return this.id;
	}

	@Column(name = "TEXT", length = 20)
	public String getText() {
		return this.text;
	}

	@Column(name = "SCORE", nullable = false, precision = 22, scale = 0)
	public Long getScore() {
		return this.score;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_ENTRY", length = 7)
	public Date getDateEntry() {
		return this.dateEntry;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEM", nullable = false)
	public Item getItem() {
		return this.item;
	}

	@ManyToOne
	@JoinColumn(name = "AUTHOR", nullable = false)
	public Person getAuthor() {
		return this.author;
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
