package uniandes.fabricasw.ecotouring.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.dropwizard.hibernate.UnitOfWork;
import uniandes.fabricasw.ecotouring.core.Item;
import uniandes.fabricasw.ecotouring.db.ItemDAO;

@Path("/items")
@Produces(MediaType.APPLICATION_JSON)
public class ItemResource {

	private final ItemDAO itemDAO;

	public ItemResource(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	@POST
	@UnitOfWork
	public Item createPerson(Item item) {
		return itemDAO.create(item);
	}

	@GET
	@UnitOfWork
	public List<Item> listItems() {
		return itemDAO.findAll();
	}

}
