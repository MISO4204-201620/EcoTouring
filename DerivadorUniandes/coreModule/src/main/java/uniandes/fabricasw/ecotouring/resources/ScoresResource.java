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
import uniandes.fabricasw.ecotouring.core.Person;
import uniandes.fabricasw.ecotouring.db.PersonDAO;

@Path("/scores")
@Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + "; charset=utf-8")
public class ScoresResource {

	private final PersonDAO peopleDAO;

	public ScoresResource(PersonDAO peopleDAO) {
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
		List<Person> l = peopleDAO.findAll();
		if (l.isEmpty()) {
			throw new NotFoundException("No data found.");
		}
		return l;
	}

}
