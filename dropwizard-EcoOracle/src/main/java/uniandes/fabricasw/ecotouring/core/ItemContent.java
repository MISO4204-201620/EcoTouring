package uniandes.fabricasw.ecotouring.core;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM_CONTENT", schema = "ADMIN")
@NamedQueries({
		@NamedQuery(name = "uniandes.fabricasw.ecotouring.core.ItemContent.findByItem", query = "SELECT i FROM ItemContent i WHERE item = 1") })
public class ItemContent implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String url;
	private ContentType contentType;
	private Item item;

	public ItemContent() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ItemContentSeq")
	@SequenceGenerator(name = "ItemContentSeq", sequenceName = "ITEM_CONTENT_SEQ", allocationSize=1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getId() {
		return this.id;
	}

	@Column(name = "NAME", nullable = false, length = 200)
	public String getName() {
		return this.name;
	}

	@Column(name = "URL", nullable = false, length = 200)
	public String getUrl() {
		return this.url;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "CONTENT_TYPE", nullable = false, length = 20)
	public ContentType getContentType() {
		return this.contentType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEM", nullable = false)
	public Item getItem() {
		return this.item;
	}

	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
