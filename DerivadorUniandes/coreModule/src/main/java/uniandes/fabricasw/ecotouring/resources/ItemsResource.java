package uniandes.fabricasw.ecotouring.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.dropwizard.hibernate.UnitOfWork;
import uniandes.fabricasw.ecotouring.core.Item;
import uniandes.fabricasw.ecotouring.db.ItemDAO;

@Path("/items")
@Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + "; charset=utf-8")
public class ItemsResource {

	private final ItemDAO itemDAO;

	public ItemsResource(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	@POST
	@UnitOfWork
	public Item createItem(Item item) {
		return itemDAO.create(item);
	}

	@GET
	@UnitOfWork
	public List<Item> listItems() {
		List<Item> l = itemDAO.findAll();
		if (l.isEmpty()) {
			throw new NotFoundException("No data found.");
		}
		return l;
	}

}
