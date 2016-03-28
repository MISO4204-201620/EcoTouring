package uniandes.fabricasw.ecotouring.db;

import java.util.List;

import org.hibernate.SessionFactory;

import io.dropwizard.hibernate.AbstractDAO;
import uniandes.fabricasw.ecotouring.core.Conversation;

public class ConversationDAO extends AbstractDAO<Conversation> {

	public ConversationDAO(SessionFactory factory) {
		super(factory);
	}

	public Conversation create(Conversation conversation) {
		return persist(conversation);
	}

	public List<Conversation> findItemCommentsByItemId(Long id) {
		return list(namedQuery("uniandes.fabricasw.ecotouring.core.Conversation.findByItem"));
	}

}