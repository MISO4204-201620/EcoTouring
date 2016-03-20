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

public class ItemDAO extends AbstractDAO<Item> {
	public ItemDAO(SessionFactory factory) {
		super(factory);
	}

	public Optional<Item> findById(Long id) {
		return Optional.fromNullable(get(id));
	}

	public Item create(Item item) {
		return persist(item);
	}

	public List<Item> findAll() {
		return list(namedQuery("Item.findAll"));
	}	
}
