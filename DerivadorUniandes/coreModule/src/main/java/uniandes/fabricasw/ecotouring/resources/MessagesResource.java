package uniandes.fabricasw.ecotouring.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.dropwizard.hibernate.UnitOfWork;
import uniandes.fabricasw.ecotouring.core.Message;
import uniandes.fabricasw.ecotouring.db.MessageDAO;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + "; charset=utf-8")

public class MessagesResource {

	private final MessageDAO messageDAO;

	public MessagesResource(MessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}

	@POST
	@UnitOfWork
	public Message createMessage(Message message) {
		return messageDAO.create(message);
	}

	@GET
	@UnitOfWork
	public List<Message> listMessages() {
		List<Message> l = messageDAO.findAll();
		if (l.isEmpty()) {
			throw new NotFoundException("No data found.");
		}
		return l;
	}

}
