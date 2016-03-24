package uniandes.fabricasw.ecotouring.resources;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.dropwizard.auth.Auth;
import io.dropwizard.auth.AuthenticationException;
import uniandes.fabricasw.ecotouring.core.User;

@Path("/protected")
@Produces(MediaType.TEXT_PLAIN)
public class ProtectedResource {
	
	/*@GET
	@Path("/valid")
	public String valid(@Auth User user) throws AuthenticationException {
	   return SUCCESS_JSON;
	}
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public UserAuthResponse login(User user) throws AuthenticationException {
	   Optional<User> res = DropwizardApplication.getCachedAuthenticator()
	                        .authenticate(user.toCredentials());
	   if ( res.isPresent() ) {
	       return new UserAuthResponse(res.get());
	   } else {
	      throw new MessageWrappedException("Unable to log in with those credentials!");
	   }
	}*/

	@PermitAll
	@GET
	public String showSecret(@Auth User user) {
		return String.format("Hey there, %s. You know the secret! %d", user.getName(), user.getId());
	}

	@RolesAllowed("ADMIN")
	@GET
	@Path("admin")
	public String showAdminSecret(@Auth User user) {
		return String.format("Hey there, %s. It looks like you are an admin. %d", user.getName(), user.getId());
	}
}
