package uniandes.fabricasw.ecotouring.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import uniandes.fabricasw.ecotouring.filter.DateRequired;

@Path("/filtered")
public class FilteredResource {

	@GET
	@DateRequired
	@Path("hello")
	public String sayHello() {
		return "hello";
	}
}
