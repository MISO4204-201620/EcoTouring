package uniandes.fabricasw.ecotouring.db;

import java.util.List;
import org.hibernate.SessionFactory;
import com.google.common.base.Optional;
import io.dropwizard.hibernate.AbstractDAO;
import uniandes.fabricasw.ecotouring.core.Message;

public class MessageDAO extends AbstractDAO<Message> {

	public MessageDAO(SessionFactory factory) {
		super(factory);
	}

	public Optional<Message> findById(Long id) {
		return Optional.fromNullable(get(id));
	}

	public Message create(Message message) {
		return persist(message);
	}

	public List<Message> findAll() {
		return list(namedQuery("uniandes.fabricasw.ecotouring.core.Message.findAll"));
	}
}
