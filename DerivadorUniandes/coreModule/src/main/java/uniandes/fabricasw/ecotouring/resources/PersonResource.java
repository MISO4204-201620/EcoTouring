package uniandes.fabricasw.ecotouring.resources;

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
import uniandes.fabricasw.ecotouring.core.Message;
import uniandes.fabricasw.ecotouring.core.Person;
import uniandes.fabricasw.ecotouring.db.PersonDAO;
import uniandes.fabricasw.ecotouring.views.PersonView;

@Path("/people/{personId}")
@Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + "; charset=utf-8")
public class PersonResource {

	private final PersonDAO peopleDAO;

	public PersonResource(PersonDAO peopleDAO) {
		this.peopleDAO = peopleDAO;
	}

	@GET
	@UnitOfWork
	public Person getPerson(@PathParam("personId") LongParam personId) {
		return findSafely(personId.get());
	}

	@POST
	@UnitOfWork
	public Person createPerson(Person person) {
		return peopleDAO.create(person);
	}

	@GET
	@Path("/view_freemarker")
	@UnitOfWork
	@Produces(MediaType.TEXT_HTML)
	public PersonView getPersonViewFreemarker(@PathParam("personId") LongParam personId) {
		return new PersonView(PersonView.Template.FREEMARKER, findSafely(personId.get()));
	}

	@GET
	@Path("/view_mustache")
	@UnitOfWork
	@Produces(MediaType.TEXT_HTML)
	public PersonView getPersonViewMustache(@PathParam("personId") LongParam personId) {
		return new PersonView(PersonView.Template.MUSTACHE, findSafely(personId.get()));
	}
	
	@GET
	@Path("/messages")
	@UnitOfWork
	public Set<Message> listMessages(@PathParam("personId") LongParam personId) {
		Set<Message> l = findSafely(personId.get()).getMessages();
		if (l.isEmpty()) {
			throw new NotFoundException("No data found.");
		}
		return l;
	}	

	private Person findSafely(Long personId) {
		final Optional<Person> person = peopleDAO.findById(personId);
		if (!person.isPresent()) {
			throw new NotFoundException("No data found.");
		}
		return person.get();
	}
}
