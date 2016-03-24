package uniandes.fabricasw.ecotouring.db;

import java.util.List;

import org.hibernate.SessionFactory;

import io.dropwizard.hibernate.AbstractDAO;
import uniandes.fabricasw.ecotouring.core.Conversation;

public class ItemConversationDAO extends AbstractDAO<Conversation> {
	
	public ItemConversationDAO(SessionFactory factory) {
		super(factory);
	}

	public Conversation create(Conversation conversation) {
		return persist(conversation);
	}

	public List<Conversation> findConversationByItemId(Long id) {
		return list(namedQuery("uniandes.fabricasw.ecotouring.core.Conversation.findByItem").setParameter(0, id));
	}	
}
