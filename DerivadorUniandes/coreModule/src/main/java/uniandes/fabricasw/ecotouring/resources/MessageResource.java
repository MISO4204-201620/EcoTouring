package uniandes.fabricasw.ecotouring.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Optional;

import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import uniandes.fabricasw.ecotouring.core.Message;
import uniandes.fabricasw.ecotouring.db.MessageDAO;

@Path("/message/{messageId}")
@Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + "; charset=utf-8")
public class MessageResource {

	private final MessageDAO messageDAO;

	public MessageResource(MessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}

	@GET
	@UnitOfWork
	public Message getMessage(@PathParam("messageId") LongParam messageId) {
		return findSafely(messageId);
	}

	private Message findSafely(LongParam messageId) {
		final Optional<Message> message = messageDAO.findById(messageId.get());
		if (!message.isPresent()) {
			throw new NotFoundException("No data found.");
		}
		return message.get();
	}
}
