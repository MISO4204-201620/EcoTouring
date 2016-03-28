package uniandes.fabricasw.ecotouring.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Optional;

import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import uniandes.fabricasw.ecotouring.core.Accommodation;
import uniandes.fabricasw.ecotouring.db.AccommodationDAO;

@Path("/accommodation")
@Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
public class AccommodationResource {

	private final AccommodationDAO accommodationDAO;

	public AccommodationResource(AccommodationDAO accommodationDAO) {
		this.accommodationDAO = accommodationDAO;
	}

	@GET
	@UnitOfWork
	public List<Accommodation> listAccommodation() {
		return accommodationDAO.findAll();
	}
	/*
	 * public Accommodation getAccommodation(@PathParam("itemId") LongParam
	 * itemId) { return findSafely(itemId); }
	 */

	@POST
	@UnitOfWork
	public Accommodation create(Accommodation accommodation) {
		return accommodationDAO.create(accommodation);
	}

	private Accommodation findSafely(LongParam itemId) {
		final Optional<Accommodation> item = accommodationDAO.findById(itemId.get());
		if (!item.isPresent()) {
			throw new NotFoundException("No data found.");
		}
		return item.get();
	}
}
