package uniandes.fabricasw.ecotouring.core;

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

@Entity
@Table(name = "TRANSACCTION_DETAIL", schema = "ADMIN")
@NamedQueries({
		@NamedQuery(name = "uniandes.fabricasw.ecotouring.core.TransactionDetail.findAll", query = "SELECT t FROM TransactionDetail t") })
public class TransactionDetail implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Transaction transaction;
	private Item item;
	private Long price;
	private Long quantity;

	public TransactionDetail() {
	}

	@Id
	@GeneratedValue(generator = "TransactionDetailSeq")
	@SequenceGenerator(name = "TransactionDetailSeq", sequenceName = "TRANSACTION_DETAIL_SEQ", allocationSize = 5)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getId() {
		return this.id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRANSACTION", nullable = false)
	public Transaction getTransaction() {
		return this.transaction;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEM", nullable = false)
	public Item getItem() {
		return this.item;
	}

	@Column(name = "PRICE", nullable = false)
	public Long getPrice() {
		return this.price;
	}

	@Column(name = "QUANTITY", nullable = false)
	public Long getQuantity() {
		return this.quantity;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

}
