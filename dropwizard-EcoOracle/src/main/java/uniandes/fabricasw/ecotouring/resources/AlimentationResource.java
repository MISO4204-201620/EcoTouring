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
import uniandes.fabricasw.ecotouring.core.Alimentation;
import uniandes.fabricasw.ecotouring.db.AlimentationDAO;

@Path("/alimentation")
@Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
public class AlimentationResource {

	private final AlimentationDAO alimentationDAO;

	public AlimentationResource(AlimentationDAO alimentationDAO) {
		this.alimentationDAO = alimentationDAO;
	}

	@GET
	@UnitOfWork
	public List<Alimentation> listAlimentation() {
		return alimentationDAO.findAll();
	}
	/*
	 * public Alimentation getAlimentation(@PathParam("itemId") LongParam
	 * itemId) { return findSafely(itemId); }
	 */

	@POST
	@UnitOfWork
	public Alimentation create(Alimentation alimentation) {
		return alimentationDAO.create(alimentation);
	}

	private Alimentation findSafely(LongParam itemId) {
		final Optional<Alimentation> item = alimentationDAO.findById(itemId.get());
		if (!item.isPresent()) {
			throw new NotFoundException("No data found.");
		}
		return item.get();
	}
}
