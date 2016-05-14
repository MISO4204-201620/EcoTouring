package uniandes.fabricasw.ecotouring.core;

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

@Entity
@Table(name = "TAG", schema = "ADMIN")
@NamedQueries({ @NamedQuery(name = "uniandes.fabricasw.ecotouring.core.Tag.findAll", query = "SELECT t FROM Tag t") 
})
public class Tag implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Article article;
	public Long count;
	public String href;
	public String word;

	public Tag() {
	}

	public Tag(String word, Long count) {
		this.word = word;
		this.count = count;
		href = "/tags/" + word;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TagSeq")
	@SequenceGenerator(name = "TagSeq", sequenceName = "TAG_SEQ", allocationSize = 1)
	public Long getId() {
		return id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ARTICLE", nullable = false)
	public Article getArticle() {
		return article;
	}

	@Column(name = "COUNT", nullable = false, precision = 22, scale = 0)
	public Long getCount() {
		return count;
	}

	@Column(name = "HREF", nullable = false, length = 100)
	public String getHref() {
		return href;
	}

	@Column(name = "WORD", nullable = false, length = 100)
	public String getWord() {
		return word;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setWord(String word) {
		this.word = word;
	}
}