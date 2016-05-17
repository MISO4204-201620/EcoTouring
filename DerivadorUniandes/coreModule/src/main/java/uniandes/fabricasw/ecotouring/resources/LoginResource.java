package uniandes.fabricasw.ecotouring.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.dropwizard.hibernate.UnitOfWork;

import uniandes.fabricasw.ecotouring.auth.Authenticator;
import uniandes.fabricasw.ecotouring.auth.EcoTouringAuthenticator;
import uniandes.fabricasw.ecotouring.auth.FacebookAuthenticator;
import uniandes.fabricasw.ecotouring.auth.TwitterAuthenticator;
import uniandes.fabricasw.ecotouring.core.Person;
import uniandes.fabricasw.ecotouring.db.PersonDAO;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + "; charset=utf-8")
public class LoginResource {

	private final PersonDAO userDAO;

	public LoginResource(PersonDAO userDAO) {
		this.userDAO = userDAO;
	}

	// Verifica si un string es nulo o vacio
	public static boolean isNullOrEmpty(String param) {
		return param == null || param.trim().length() == 0;
	}

	@POST
	@UnitOfWork
	public Person authenticateUser(Person user) {

		Person authenticatedUser = null;

		if (!isNullOrEmpty(user.getFacebook())) {
			Authenticator facebookAuthenticator = new Authenticator(new FacebookAuthenticator());
			authenticatedUser = facebookAuthenticator.authenticate(userDAO, user.getUsername(), user.getFacebook());
		} else if (!isNullOrEmpty(user.getTwitter())) {
			Authenticator twitterAuthenticator = new Authenticator(new TwitterAuthenticator());
			authenticatedUser = twitterAuthenticator.authenticate(userDAO, user.getUsername(), user.getTwitter());
		} else if (!isNullOrEmpty(user.getPassword())) {
			Authenticator ecoTouringAuthenticator = new Authenticator(new EcoTouringAuthenticator());
			authenticatedUser = ecoTouringAuthenticator.authenticate(userDAO, user.getUsername(), user.getPassword());
		}

		if (authenticatedUser == null) {
			throw new NotFoundException("Usuario no autenticado");
		}

		return authenticatedUser;
	}
}
