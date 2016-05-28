package uniandes.fabricasw.ecotouring.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.dropwizard.hibernate.UnitOfWork;

import uniandes.fabricasw.ecotouring.auth.Authenticator;
import uniandes.fabricasw.ecotouring.auth.AuthenticatorFactory;
import uniandes.fabricasw.ecotouring.auth.IAuthenticatorStrategy;
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
	
	// Metodo de autenticar usuario
	@POST
	@UnitOfWork
	public Person authenticateUser(Person user) {
		

		// Se instancia la fabrica de estrategias de autenticacion
		AuthenticatorFactory authenticatorFactory = new AuthenticatorFactory();
		IAuthenticatorStrategy authenticatorStrategy;		
		String identifier;

		// Se determina por que tipo de red social opcional pide autenticacion sino se obliga a autenticar por la app
		if(!isNullOrEmpty(user.getFacebook())){


			authenticatorStrategy = authenticatorFactory.create("facebook");
			identifier = user.getFacebook();
		}
		else if(!isNullOrEmpty(user.getTwitter())){





			authenticatorStrategy = authenticatorFactory.create("twitter");
			identifier = user.getTwitter();
		}
		else {
			authenticatorStrategy = authenticatorFactory.create("ecotouring");
			identifier = user.getPassword();
		}
		
		// Se instancia el autenticador con el tipo de estrategia de autenticacion
		Authenticator authenticator = new Authenticator(authenticatorStrategy);
		Person authenticatedUser = authenticator.authenticate(userDAO, user.getUsername(), identifier);		
				
		if (authenticatedUser == null) {
			throw new NotFoundException("Usuario no autenticado");
		}
		
		return authenticatedUser;		
	}
}
