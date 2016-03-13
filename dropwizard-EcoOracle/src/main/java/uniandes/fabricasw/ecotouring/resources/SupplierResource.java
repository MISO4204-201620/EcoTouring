package uniandes.fabricasw.ecotouring.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.dropwizard.hibernate.UnitOfWork;
import uniandes.fabricasw.ecotouring.core.Person;
import uniandes.fabricasw.ecotouring.db.PersonDAO;

@Path("/suppliers")
@Produces(MediaType.APPLICATION_JSON)
public class SupplierResource {
	private final PersonDAO peopleDAO;

	public SupplierResource(PersonDAO peopleDAO) {
		this.peopleDAO = peopleDAO;
	}

	@POST
	@UnitOfWork
	public Person createPerson(Person person) {
		return peopleDAO.create(person);
	}

	@GET
	@UnitOfWork
	public List<Person> listPeople() {
		return peopleDAO.findAll();
	}

}
