package uniandes.fabricasw.ecotouring.resources;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.runners.MockitoJUnitRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.ImmutableList;

import io.dropwizard.testing.junit.ResourceTestRule;
import uniandes.fabricasw.ecotouring.core.Person;
import uniandes.fabricasw.ecotouring.db.PersonDAO;

/**
 * Unit tests for {@link PeopleResource}.
 */
@RunWith(MockitoJUnitRunner.class)
public class PeopleResourceTest {
	private static final PersonDAO dao = mock(PersonDAO.class);
	@ClassRule
	public static final ResourceTestRule resources = ResourceTestRule.builder().addResource(new PeopleResource(dao))
			.build();
	@Captor
	private ArgumentCaptor<Person> personCaptor;
	private Person person;

	@Before
	public void setUp() {
		person = new Person();
		person.setFullName("Full Name");
		person.setJobTitle("Job Title");
	}

	@After
	public void tearDown() {
		reset(dao);
	}

	@Test
	public void createPerson() throws JsonProcessingException {
		when(dao.create(any(Person.class))).thenReturn(person);
		final Response response = resources.client().target("/people").request(MediaType.APPLICATION_JSON_TYPE)
				.post(Entity.entity(person, MediaType.APPLICATION_JSON_TYPE));

		assertThat(response.getStatusInfo()).isEqualTo(Response.Status.OK);
		verify(dao).create(personCaptor.capture());
		assertThat(personCaptor.getValue()).isEqualTo(person);
	}

	@Test
	public void listPeople() throws Exception {
		final ImmutableList<Person> people = ImmutableList.of(person);
		when(dao.findAll()).thenReturn(people);

		final List<Person> response = resources.client().target("/people").request()
				.get(new GenericType<List<Person>>() {
				});

		verify(dao).findAll();
		assertThat(response).containsAll(people);
	}
}
