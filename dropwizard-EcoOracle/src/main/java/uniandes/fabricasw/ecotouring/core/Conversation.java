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
@Table(name = "CONVERSATION", schema = "ADMIN")
@NamedQueries({
		@NamedQuery(name = "uniandes.fabricasw.ecotouring.core.Conversation.findByItem", query = "SELECT i FROM Conversation i WHERE item = :itemId") })
public class Conversation implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Conversation conversation;
	private Set<Conversation> conversations = new HashSet<Conversation>();
	private ConversationType conversationtype;
	private Date dateEntry;
	private String entry;
	@Id
	@GeneratedValue(generator = "ConversationSeq")
	@SequenceGenerator(name = "ConversationSeq", sequenceName = "CONVERSATION_SEQ", allocationSize = 5)
	private Long id;
	private Item item;
	private Person person;

	@ManyToOne
	@JoinColumn(name = "PARENT")
	public Conversation getConversation() {
		return this.conversation;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conversation")
	public Set<Conversation> getConversations() {
		return this.conversations;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE", nullable = false)
	public ConversationType getConversationtype() {
		return conversationtype;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_ENTRY", nullable = false, length = 7)
	public Date getDateEntry() {
		return this.dateEntry;
	}

	@Column(name = "ENTRY", nullable = false, length = 4000)
	public String getEntry() {
		return this.entry;
	}

	@Id

	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getId() {
		return this.id;
	}

	@ManyToOne
	@JoinColumn(name = "ITEM", nullable = false)
	public Item getItem() {
		return this.item;
	}

	@ManyToOne
	@JoinColumn(name = "AUTHOR", nullable = false)
	public Person getPerson() {
		return this.person;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

	public void setConversations(Set<Conversation> conversations) {
		this.conversations = conversations;
	}

	public void setConversationtype(ConversationType conversationtype) {
		this.conversationtype = conversationtype;
	}

	public void setDateEntry(Date dateEntry) {
		this.dateEntry = dateEntry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
