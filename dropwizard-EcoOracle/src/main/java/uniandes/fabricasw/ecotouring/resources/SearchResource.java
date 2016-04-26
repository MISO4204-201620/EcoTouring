package uniandes.fabricasw.ecotouring.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.dropwizard.hibernate.UnitOfWork;
import uniandes.fabricasw.ecotouring.core.ApiResponse;
import uniandes.fabricasw.ecotouring.core.Item;
import uniandes.fabricasw.ecotouring.core.Person;
import uniandes.fabricasw.ecotouring.db.ItemDAO;
import uniandes.fabricasw.ecotouring.db.PersonDAO;

@Path("/search/{criteria}/{searchKeyword}")
@Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + "; charset=utf-8")
public class SearchResource {

	private final PersonDAO personDAO;
	private final ItemDAO itemDao;

	public SearchResource(PersonDAO personDAO, ItemDAO itemDao) {
		this.personDAO = personDAO;
		this.itemDao = itemDao;
	}

	@GET
	@UnitOfWork
	public ApiResponse<?> search(@PathParam("criteria") String criteria,
			@PathParam("searchKeyword") String searchKeyword) {
		switch (criteria) {
		case "ITEM_DESC":
			ApiResponse<Item> ar = new ApiResponse<Item>();
			List<Item> l = itemDao.searchItemsByDescription(searchKeyword);
			if (l.isEmpty()) {
				throw new NotFoundException("No data found.");
			}
			ar.setData(l);
			return ar;
		case "PERSON_NAME":
			ApiResponse<Person> ar1 = new ApiResponse<Person>();
			List<Person> l1 = personDAO.searchPeopleByName(searchKeyword);
			if (l1.isEmpty()) {
				throw new NotFoundException("No data found.");
			}
			ar1.setData(l1);
			return ar1;
		default:
			ApiResponse<Item> ar2 = new ApiResponse<Item>();
			List<Item> l2 = itemDao.searchItemsByDescription(searchKeyword);
			if (l2.isEmpty()) {
				throw new NotFoundException("No data found.");
			}
			ar2.setData(l2);
			return ar2;
		}
	}
}