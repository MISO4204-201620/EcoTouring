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
import uniandes.fabricasw.ecotouring.core.EcoTour;
import uniandes.fabricasw.ecotouring.db.EcoTourDAO;

@Path("/ecotour")
@Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
public class EcoTourResource {

	private final EcoTourDAO ecoTourDAO;

	public EcoTourResource(EcoTourDAO ecoTourDAO) {
		this.ecoTourDAO = ecoTourDAO;
	}

	@GET
	@UnitOfWork
	public List<EcoTour> listecoTour() {
		List<EcoTour> l = ecoTourDAO.findAll();
		if (l.isEmpty()) {
			throw new NotFoundException("No data found.");
		}
		return l;
	}

	@POST
	@UnitOfWork
	public EcoTour createConversation(EcoTour ecoTour) {
		return ecoTourDAO.create(ecoTour);
	}

	private EcoTour findSafely(LongParam itemId) {
		final Optional<EcoTour> item = ecoTourDAO.findById(itemId.get());
		if (!item.isPresent()) {
			throw new NotFoundException("No data found.");
		}
		return item.get();
	}
}
