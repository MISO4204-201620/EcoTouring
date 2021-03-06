package uniandes.fabricasw.ecotouring.core;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

@Entity
@Table(name = "TRANSACTION", schema = "ADMIN")
@NamedQueries({
		@NamedQuery(name = "uniandes.fabricasw.ecotouring.core.Transaction.findAll", query = "SELECT t FROM Transaction t") })
public class Transaction implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private TransactionType type;
	private TransactionStatus status;
	private Person customer;
	private Date dateTransaction;
	private Set<TransactionDetail> transacctionDetails = new HashSet<TransactionDetail>();

	public Transaction() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TransactionSeq")
	@SequenceGenerator(name = "TransactionSeq", sequenceName = "TRANSACTION_SEQ", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getId() {
		return this.id;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE", nullable = false)
	public TransactionType getType() {
		return this.type;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS", nullable = false)
	public TransactionStatus getStatus() {
		return this.status;
	}

	@ManyToOne
	@JoinColumn(name = "CUSTOMER", nullable = false)
	public Person getCustomer() {
		return customer;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_TRANSACTION", nullable = false, length = 7)
	public Date getDateTransaction() {
		return this.dateTransaction;
	}

	@OneToMany(mappedBy = "transaction")
	public Set<TransactionDetail> getTransacctionDetails() {
		return this.transacctionDetails;
	}

	public void setCustomer(Person customer) {
		this.customer = customer;
	}

	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	public void setTransacctionDetails(Set<TransactionDetail> transacctionDetails) {
		this.transacctionDetails = transacctionDetails;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

}
