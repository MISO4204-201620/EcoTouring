package uniandes.fabricasw.ecotouring.auth;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
import uniandes.fabricasw.ecotouring.core.User;

public class ExampleAuthenticator implements Authenticator<BasicCredentials, User> {
	/**
	 * Valid users with mapping user -> roles
	 */
	private static final Map<String, Set<String>> VALID_USERS = ImmutableMap.of("guest", ImmutableSet.of(), "good-guy",
			ImmutableSet.of("BASIC_GUY"), "chief-wizard", ImmutableSet.of("ADMIN", "BASIC_GUY"));

	/*
	 * private final PersonDAO peopleDAO;
	 * 
	 * public ExampleAuthenticator(PersonDAO peopleDAO) { this.peopleDAO =
	 * peopleDAO; }
	 * 
	 * @UnitOfWork private List<Person> VALID_USERS() { return
	 * peopleDAO.findAll(); }
	 */

	@Override
	public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
		if (VALID_USERS.containsKey(credentials.getUsername()) && "secret".equals(credentials.getPassword())) {
			return Optional.of(new User(credentials.getUsername(), VALID_USERS.get(credentials.getUsername())));
		}
		return Optional.empty();
	}
}
