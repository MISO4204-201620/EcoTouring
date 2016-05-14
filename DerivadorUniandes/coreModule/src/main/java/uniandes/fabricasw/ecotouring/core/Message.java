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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "MESSAGE", schema = "ADMIN")
@NamedQueries({ 
	    @NamedQuery(name = "uniandes.fabricasw.ecotouring.core.Message.findAll", query = "SELECT m FROM Message m"),
		@NamedQuery(name = "uniandes.fabricasw.ecotouring.core.Message.findByReceiver", query = "SELECT m FROM Message m WHERE receiver = :receiver") 
	    })
public class Message implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String subject;
	private String body;
	private Person sender;
	private Person receiver;
	private Date dateEntry;
	private MessageStatus status;
	private Message parent;
	
	private Set<Message> messages = new HashSet<Message>();

	public Message() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MessageSeq")
	@SequenceGenerator(name = "MessageSeq", sequenceName = "MESSAGE_SEQ", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getId() {
		return this.id;
	}
	
	@Column(name = "SUBJECT", nullable = false, length = 200)	
	public String getSubject() {
		return subject;
	}

	@Column(name = "BODY", nullable = false, length = 4000)
	public String getBody() {
		return body;
	}

	@ManyToOne
	@JoinColumn(name = "SENDER", nullable = false)	
	public Person getSender() {
		return sender;
	}
	
	@ManyToOne
	@JoinColumn(name = "RECEIVER", nullable = false)	
	public Person getReceiver() {
		return receiver;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_ENTRY", nullable = false, length = 7)	
	public Date getDateEntry() {
		return dateEntry;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS", nullable = false)
	public MessageStatus getStatus() {
		return status;
	}	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "PARENT")	
	public Message getParent() {
		return parent;
	}	

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")	
	public Set<Message> getMessages() {
		return messages;
	}
	
	public void setId(Long id) {
		this.id = id;
	}	

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void setBody(String body) {
		this.body = body;
	}

	public void setSender(Person sender) {
		this.sender = sender;
	}	
	
	public void setReceiver(Person receiver) {
		this.receiver = receiver;
	}	

	public void setDateEntry(Date dateEntry) {
		this.dateEntry = dateEntry;
	}

	public void setStatus(MessageStatus status) {
		this.status = status;
	}
	
	public void setParent(Message parent) {
		this.parent = parent;
	}	

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}
}
