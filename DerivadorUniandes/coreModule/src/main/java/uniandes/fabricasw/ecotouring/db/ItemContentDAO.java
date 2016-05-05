package uniandes.fabricasw.ecotouring.db;

import java.util.List;

import org.hibernate.SessionFactory;

import io.dropwizard.hibernate.AbstractDAO;
import uniandes.fabricasw.ecotouring.core.ItemContent;

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
