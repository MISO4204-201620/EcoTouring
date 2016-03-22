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

public class ItemContentDAO extends AbstractDAO<ItemContent> {
	public ItemContentDAO(SessionFactory factory) {
		super(factory);
	}

	public ItemContent create(ItemContent itemContent) {
		return persist(itemContent);
	}

	public List<ItemContent> findItemContentByItemId(Long id) {
		return list(namedQuery("uniandes.fabricasw.ecotouring.core.ItemContent.findByItem"));
	}	
}
