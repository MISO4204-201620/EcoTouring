package uniandes.fabricasw.ecotouring.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import uniandes.fabricasw.ecotouring.core.Item;
import uniandes.fabricasw.ecotouring.core.Person;
import uniandes.fabricasw.ecotouring.db.PersonDAO;

@Path("/suppliers/{personId}")
@Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + "; charset=utf-8")
public class SupplierResource {

	private final PersonDAO personDAO;

	public SupplierResource(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@GET
	@UnitOfWork
	public Person getPerson(@PathParam("personId") LongParam personId) {
		return findSafely(personId);
	}

	@GET
	@Path("/items")
	@UnitOfWork
	public List<Item> listItems(@PathParam("personId") LongParam personId) {
		return new ArrayList<Item>(personDAO.findById(personId.get()).get().getItems());
	}

	/*@POST
	@Path("/conversations")
	@UnitOfWork
	public Conversation createConversation(Conversation conversation) {
		return conversationDAO.create(conversation);
	}
	
	@POST
	@Path("/publishItem")
	@UnitOfWork
	public Item changeItemStatusPublish(@PathParam("itemId") LongParam itemId) {
		Item item = itemDAO.findById(itemId.get()).get();
		item.setStatus(ItemStatus.PUBLISHED);
		return itemDAO.update(item);
	}*/

	private Person findSafely(LongParam itemId) {
		final Optional<Person> item = personDAO.findById(itemId.get());
		if (!item.isPresent()) {
			throw new NotFoundException("No data found.");
		}
		return item.get();
	}
}
