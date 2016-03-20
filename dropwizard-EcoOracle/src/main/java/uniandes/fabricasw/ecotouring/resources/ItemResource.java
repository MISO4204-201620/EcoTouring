package uniandes.fabricasw.ecotouring.resources;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Optional;

import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import uniandes.fabricasw.ecotouring.core.Conversation;
import uniandes.fabricasw.ecotouring.core.Item;
import uniandes.fabricasw.ecotouring.core.ItemComment;
import uniandes.fabricasw.ecotouring.core.ItemContent;
import uniandes.fabricasw.ecotouring.core.Person;
import uniandes.fabricasw.ecotouring.db.ItemCommentDAO;
import uniandes.fabricasw.ecotouring.db.ItemContentDAO;
import uniandes.fabricasw.ecotouring.db.ItemConversationDAO;
import uniandes.fabricasw.ecotouring.db.ItemDAO;
import uniandes.fabricasw.ecotouring.db.PersonDAO;
import uniandes.fabricasw.ecotouring.views.PersonView;

@Path("/items/{itemId}")
@Produces(MediaType.APPLICATION_JSON)
public class ItemResource {

	private final ItemDAO itemDAO;
	private final ItemContentDAO itemContentDAO;
	private final ItemCommentDAO itemCommentDAO;
	private final ItemConversationDAO itemConversationDAO;

	public ItemResource(ItemDAO itemDAO, ItemContentDAO itemContentDAO, ItemCommentDAO itemCommentDAO, ItemConversationDAO itemConversationDAO) {
		this.itemDAO = itemDAO;
		this.itemContentDAO = itemContentDAO;
		this.itemCommentDAO = itemCommentDAO;
		this.itemConversationDAO = itemConversationDAO;
	}

	@GET
	@UnitOfWork
	public Item getItem(@PathParam("itemId") LongParam itemId) {
		return findSafely(itemId.get());
	}
	
	@GET
	@Path("/conversations")
	@UnitOfWork
	@Produces(MediaType.APPLICATION_JSON)
	public List<Conversation> listConversations(@PathParam("itemId") LongParam personId) {
		return itemConversationDAO.findConversationByItemId(personId.get());
	}
	
	@GET
	@Path("/scores")
	@UnitOfWork
	@Produces(MediaType.APPLICATION_JSON)
	public List<ItemComment> listScores(@PathParam("itemId") LongParam personId) {
		return itemCommentDAO.findItemCommentsByItemId(personId.get());
	}	
	
	@GET
	@Path("/content")
	@UnitOfWork
	@Produces(MediaType.APPLICATION_JSON)
	public List<ItemContent> listContent(@PathParam("itemId") LongParam personId) {
		return itemContentDAO.findItemContentByItemId(personId.get());
	}	
	
	@POST
	@UnitOfWork
	public Item createItem(Item item) {
		return itemDAO.create(item);
	}

	private Item findSafely(long itemId) {
		final Optional<Item> item = itemDAO.findById(itemId);
		if (!item.isPresent()) {
			throw new NotFoundException("No such item.");
		}
		return item.get();
	}
}
