package uniandes.fabricasw.ecotouring.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.dropwizard.hibernate.UnitOfWork;
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
	public List<?> search(@PathParam("criteria") String criteria, @PathParam("searchKeyword") String searchKeyword) {
		switch (criteria) {
		case "ITEM_DESC":
			return itemDao.searchItemsByDescription("%"+searchKeyword+"%");
		case "PERSON_NAME":
			return personDAO.searchPeopleByName("%"+searchKeyword+"%");			
		default:
			return itemDao.searchItemsByDescription(searchKeyword);
		}
	}

}
