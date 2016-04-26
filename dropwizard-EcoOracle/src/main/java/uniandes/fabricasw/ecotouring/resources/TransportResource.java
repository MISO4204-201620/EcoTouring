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
import uniandes.fabricasw.ecotouring.core.Transport;
import uniandes.fabricasw.ecotouring.db.TransportDAO;

@Path("/transport")
@Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
public class TransportResource {

	private final TransportDAO transportDAO;

	public TransportResource(TransportDAO transportDAO) {
		this.transportDAO = transportDAO;
	}

	@GET
	@UnitOfWork
	public List<Transport> listTransport() {
		List<Transport> l = transportDAO.findAll();
		if (l.isEmpty()) {
			throw new NotFoundException("No data found.");
		}
		return l;
	}

	@POST
	@UnitOfWork
	public Transport create(Transport Transport) {
		return transportDAO.create(Transport);
	}

	private Transport findSafely(LongParam itemId) {
		final Optional<Transport> item = transportDAO.findById(itemId.get());
		if (!item.isPresent()) {
			throw new NotFoundException("No data found.");
		}
		return item.get();
	}
}
