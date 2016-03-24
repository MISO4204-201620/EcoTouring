package uniandes.fabricasw.ecotouring.db;

import java.util.List;

import org.hibernate.SessionFactory;

import io.dropwizard.hibernate.AbstractDAO;
import uniandes.fabricasw.ecotouring.core.ItemComment;

public class ItemCommentDAO extends AbstractDAO<ItemComment> {
	
	public ItemCommentDAO(SessionFactory factory) {
		super(factory);
	}

	public ItemComment create(ItemComment itemComment) {
		return persist(itemComment);
	}

	public List<ItemComment> findItemCommentsByItemId(Long id) {
		return list(namedQuery("uniandes.fabricasw.ecotouring.core.ItemComment.findByItem"));
	}
	
}
