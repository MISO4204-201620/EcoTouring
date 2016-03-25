package uniandes.fabricasw.ecotouring.core;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ARTICLE", schema = "ADMIN")
@NamedQueries({
		@NamedQuery(name = "uniandes.fabricasw.ecotouring.core.Article.findAll", query = "SELECT a FROM Article a") })
public class Article implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String title;
	private String text;
	private Person author;
	private Date date;	
	private String slug;
	private Set<Tag> tags = new HashSet<Tag>();	

	public Article() {
	}

	@Id
	@GeneratedValue(generator = "ArticleSeq")
	@SequenceGenerator(name = "ArticleSeq", sequenceName = "ARTICLE_SEQ", allocationSize = 5)	
	public Long getId() {
		return id;
	}
	
	@Column(name = "TITLE", nullable = false)
	public String getTitle() {
		return title;
	}
    
	@Column(name = "TEXT", nullable = false)
	public String getText() {
		return text;
	}
	
	@ManyToOne
	@JoinColumn(name = "AUTHOR", nullable = false)
	public Person getAuthor() {
		return author;
	}

	@Temporal(TemporalType.DATE)	
	@Column(name = "DATE_CREATED", nullable = false)
	public Date getDate() {
		return date;
	}	

	@Column(name = "SLUG", nullable = false)
	public String getSlug() {
		return slug;
	}
	
    @JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
	public Set<Tag> getTags() {
		return tags;
	}

	public void setAuthor(Person author) {
		this.author = author;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}