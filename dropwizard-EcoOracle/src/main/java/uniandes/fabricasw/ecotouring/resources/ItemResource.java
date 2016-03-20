package uniandes.fabricasw.ecotouring.resources;

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
import uniandes.fabricasw.ecotouring.db.ItemDAO;
import uniandes.fabricasw.ecotouring.db.PersonDAO;
import uniandes.fabricasw.ecotouring.views.PersonView;

@Path("/item/{itemId}")
@Produces(MediaType.APPLICATION_JSON)
public class ItemResource {

	private final ItemDAO itemDAO;

	public ItemResource(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	@GET
	@UnitOfWork
	public Item getItem(@PathParam("itemId") LongParam itemId) {
		return findSafely(itemId.get());
	}
	
	@POST
	@UnitOfWork
	public Item createItem(Item item) {
		return itemDAO.create(item);
	}

	private Item findSafely(long itemId) {
		final Optional<Item> item = itemDAO.findById(itemId);
		if (!item.isPresent()) {
			throw new NotFoundException("No such user.");
		}
		return item.get();
	}
}
