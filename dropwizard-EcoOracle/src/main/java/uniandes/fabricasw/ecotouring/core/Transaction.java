package uniandes.fabricasw.ecotouring.core;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "TRANSACTION", schema = "ADMIN")
@NamedQueries({
		@NamedQuery(name = "uniandes.fabricasw.ecotouring.core.Transaction.findAll", query = "SELECT t FROM Transaction t") })
public class Transaction implements java.io.Serializable {

	public Transaction(Person customer, Date dateTransaction, Long id, TransactionStatus status,
			Set<TransactionDetail> transacctionDetails, TransactionType type) {
		super();
		this.customer = customer;
		this.dateTransaction = dateTransaction;
		this.id = id;
		this.status = status;
		this.transacctionDetails = transacctionDetails;
		this.type = type;
	}

	private static final long serialVersionUID = 1L;

	private Person customer;
	private Date dateTransaction;
	@Id
	@GeneratedValue(generator = "TransactionSeq")
	@SequenceGenerator(name = "TransactionSeq", sequenceName = "TRANSACTION_SEQ", allocationSize = 5)
	private Long id;
	private TransactionStatus status;
	private Set<TransactionDetail> transacctionDetails = new HashSet<TransactionDetail>();
	private TransactionType type;

	public Transaction() {
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

	@Id

	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getId() {
		return this.id;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS", nullable = false)
	public TransactionStatus getStatus() {
		return this.status;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transaction")
	public Set<TransactionDetail> getTransacctionDetails() {
		return this.transacctionDetails;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE", nullable = false)
	public TransactionType getType() {
		return this.type;
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
