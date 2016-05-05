package uniandes.fabricasw.ecotouring.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import io.dropwizard.auth.Auth;
import io.dropwizard.auth.AuthenticationException;
import uniandes.fabricasw.ecotouring.core.User;

@Consumes(MediaType.APPLICATION_JSON)
public class LoginResource {

	@GET
	@Path("/valid")
	public String valid(@Auth User user) throws AuthenticationException {
		return "OK";
	}

	/*
	 * @POST
	 * 
	 * @Path("/login")
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON) public UserAuthResponse login(User
	 * user) throws AuthenticationException { Optional<User> res =
	 * DropwizardApplication.getCachedAuthenticator()
	 * .authenticate(user.toCredentials()); if ( res.isPresent() ) { return new
	 * UserAuthResponse(res.get()); } else { throw new MessageWrappedException(
	 * "Unable to log in with those credentials!"); } }
	 */

}
