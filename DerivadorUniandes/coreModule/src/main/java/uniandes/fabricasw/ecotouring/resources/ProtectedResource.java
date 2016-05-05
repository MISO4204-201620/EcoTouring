package uniandes.fabricasw.ecotouring.resources;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.dropwizard.auth.Auth;
import uniandes.fabricasw.ecotouring.core.User;

@Path("/protected")
@Produces(MediaType.TEXT_PLAIN)
public class ProtectedResource {

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
