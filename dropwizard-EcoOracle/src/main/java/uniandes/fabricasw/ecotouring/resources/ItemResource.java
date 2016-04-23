package uniandes.fabricasw.ecotouring.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
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
import uniandes.fabricasw.ecotouring.core.ItemStatus;
import uniandes.fabricasw.ecotouring.db.ConversationDAO;
import uniandes.fabricasw.ecotouring.db.ItemCommentDAO;
import uniandes.fabricasw.ecotouring.db.ItemContentDAO;
import uniandes.fabricasw.ecotouring.db.ItemDAO;

@Path("/items/{itemId}")
@Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + "; charset=utf-8")
public class ItemResource {

	private final ItemDAO itemDAO;
	private final ConversationDAO conversationDAO;
	private final ItemCommentDAO itemCommentDAO;
	private final ItemContentDAO itemContentDAO;

	public ItemResource(ItemDAO itemDAO, ConversationDAO conversationDAO, ItemCommentDAO itemCommentDAO,
			ItemContentDAO itemContentDAO) {
		this.itemDAO = itemDAO;
		this.conversationDAO = conversationDAO;
		this.itemCommentDAO = itemCommentDAO;
		this.itemContentDAO = itemContentDAO;
	}

	@GET
	@UnitOfWork
	public Item getItem(@PathParam("itemId") LongParam itemId) {
		return findSafely(itemId);
	}

	@GET
	@Path("/conversations")
	@UnitOfWork
	public List<Conversation> listConversations(@PathParam("itemId") LongParam itemId) {
		ArrayList<Conversation> l = new ArrayList<Conversation>(itemDAO.findConversationsByItem(itemId.get()));
		if (l.isEmpty()) {
			throw new NotFoundException("No data found.");
		}
		return l;		
	}

	@POST
	@Path("/conversations")
	@UnitOfWork
	public Conversation createConversation(Conversation conversation) {
		return conversationDAO.create(conversation);
	}	
	
	@GET
	@Path("/packageDetail")
	@UnitOfWork
	public List<Item> findPackageDetailByItem(@PathParam("itemId") LongParam itemId) {
		ArrayList<Item> l = new ArrayList<Item>(itemDAO.findPackageDetailByItem(itemId.get()));
		if (l.isEmpty()) {
			throw new NotFoundException("No data found.");
		}
		return l;		
	}

	//Asociar un item a un paquete
	@POST
	@Path("/packageDetail/{childId}")
	@UnitOfWork
	public Item addItem(@PathParam("itemId") LongParam parenId, @PathParam("childId") LongParam childId) {		
		Item parent = itemDAO.findById(parenId.get()).get(); 
		Item child = itemDAO.findById(childId.get()).get();
		return itemDAO.setChild(parent, child);
	}	
	
	@GET
	@Path("/scores")
	@UnitOfWork
	public List<ItemComment> listScores(@PathParam("itemId") LongParam itemId) {
		List<ItemComment> l = new ArrayList<ItemComment>(itemDAO.findItemCommentsByItem(itemId.get()));
		if (l.isEmpty()) {
			throw new NotFoundException("No data found.");
		}
		return l;		
	}

	@POST
	@Path("/scores")
	@UnitOfWork
	public ItemComment createScore(ItemComment itemComment) {
		return itemCommentDAO.create(itemComment);
	}

	@GET
	@Path("/content")
	@UnitOfWork
	public List<ItemContent> listContents(@PathParam("itemId") LongParam itemId) {
		List<ItemContent> l = new ArrayList<ItemContent>(itemDAO.findItemContentsByItem(itemId.get()));
		if (l.isEmpty()) {
			throw new NotFoundException("No data found.");
		}
		return l;
	}

	@POST
	@Path("/content")
	@UnitOfWork
	public ItemContent createContent(ItemContent itemContent) {
		return itemContentDAO.create(itemContent);
	}

	@POST
	@Path("/hiddeItem")
	@UnitOfWork
	public Item changeItemStatusHidde(@PathParam("itemId") LongParam itemId) {
		Item item = itemDAO.findById(itemId.get()).get();
		item.setStatus(ItemStatus.HIDDEN);
		return itemDAO.update(item);
	}

	@POST
	@Path("/publishItem")
	@UnitOfWork
	public Item changeItemStatusPublish(@PathParam("itemId") LongParam itemId) {
		Item item = itemDAO.findById(itemId.get()).get();
		item.setStatus(ItemStatus.PUBLISHED);
		return itemDAO.update(item);
	}

	private Item findSafely(LongParam itemId) {
		final Optional<Item> item = itemDAO.findById(itemId.get());
		if (!item.isPresent()) {
			throw new NotFoundException("No data found.");
		}
		return item.get();
	}	
}
