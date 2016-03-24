package uniandes.fabricasw.ecotouring;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;

import com.google.common.base.Optional;

import io.dropwizard.testing.ConfigOverride;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import uniandes.fabricasw.ecotouring.EcoTouringApplication;
import uniandes.fabricasw.ecotouring.EcoTouringConfiguration;
import uniandes.fabricasw.ecotouring.api.Saying;

public class IntegrationTest {

	private static final String TMP_FILE = createTempFile();
	private static final String CONFIG_PATH = ResourceHelpers.resourceFilePath("test-example.yml");

	@ClassRule
	public static final DropwizardAppRule<EcoTouringConfiguration> RULE = new DropwizardAppRule<>(
			EcoTouringApplication.class, CONFIG_PATH,
			ConfigOverride.config("database.url", "jdbc:oracle:thin:admin/fabricasw@//54.174.139.165:1521/XE"));

	private Client client;

	@BeforeClass
	public static void migrateDb() throws Exception {
		RULE.getApplication().run("db", "migrate", CONFIG_PATH);
	}

	@Before
	public void setUp() throws Exception {
		client = ClientBuilder.newClient();
	}

	@After
	public void tearDown() throws Exception {
		client.close();
	}

	private static String createTempFile() {
		try {
			return File.createTempFile("test-example", null).getAbsolutePath();
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	@Test
	public void testHelloWorld() throws Exception {
		final Optional<String> name = Optional.fromNullable("DrIntegrationTest");
		final Saying saying = client.target("http://localhost:" + RULE.getLocalPort() + "/hello-world")
				.queryParam("name", name.get()).request().get(Saying.class);
		assertThat(saying.getContent()).isEqualTo(RULE.getConfiguration().buildTemplate().render(name));
	}

	/*@Test
	public void testPostPerson() throws Exception {
		final Person person = new Person("DrIntegrationTest", "ChiefWizard");
		final Person newPerson = client.target("http://localhost:" + RULE.getLocalPort() + "/people").request()
				.post(Entity.entity(person, MediaType.APPLICATION_JSON_TYPE)).readEntity(Person.class);
		assertThat(newPerson.getId()).isNotNull();
		assertThat(newPerson.getFullName()).isEqualTo(person.getFullName());
		assertThat(newPerson.getJobTitle()).isEqualTo(person.getJobTitle());
	}*/
}
