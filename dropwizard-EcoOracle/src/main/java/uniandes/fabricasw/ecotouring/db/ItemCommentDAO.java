package uniandes.fabricasw.ecotouring.db;

import java.util.List;

import org.hibernate.SessionFactory;

import com.google.common.base.Optional;

import io.dropwizard.hibernate.AbstractDAO;
import uniandes.fabricasw.ecotouring.core.Conversation;
import uniandes.fabricasw.ecotouring.core.Item;
import uniandes.fabricasw.ecotouring.core.ItemComment;
import uniandes.fabricasw.ecotouring.core.ItemContent;
import uniandes.fabricasw.ecotouring.core.Person;

public class ItemCommentDAO extends AbstractDAO<ItemComment> {
	public ItemCommentDAO(SessionFactory factory) {
		super(factory);
	}

	public ItemComment create(ItemComment itemComment) {
		return persist(itemComment);
	}

	public List<ItemComment> findItemCommentsByItemId(Long id) {
		return null;
		//return Optional.fromNullable(get(id));
	}
	
}
