package uniandes.fabricasw.ecotouring.db;

import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.google.common.base.Optional;

import io.dropwizard.hibernate.AbstractDAO;
import uniandes.fabricasw.ecotouring.core.Conversation;
import uniandes.fabricasw.ecotouring.core.Item;
import uniandes.fabricasw.ecotouring.core.ItemComment;
import uniandes.fabricasw.ecotouring.core.ItemContent;

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
		return list(namedQuery("uniandes.fabricasw.ecotouring.core.Item.findAll"));
	}

	public List<Conversation> findConversationsByItem(Long id) {
		return findById(id).get().getConversations();
	}

	public Set<ItemComment> findItemCommentsByItem(Long id) {
		return (Set<ItemComment>) findById(id).get().getItemComments();
	}

	public Set<ItemContent> findItemContentsByItem(Long id) {
		return (Set<ItemContent>) findById(id).get().getItemContents();
	}

	public Item update(Item item) {
		return persist(item);
	}

	@SuppressWarnings("unchecked")
	public List<Item> searchItemsByDescription(String searchKeyword) {
		return (List<Item>) this.criteria().add(Restrictions.like("description", "searchKeyword")).list();
	}

}
