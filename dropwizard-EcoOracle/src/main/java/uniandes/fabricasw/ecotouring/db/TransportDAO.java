package uniandes.fabricasw.ecotouring.db;

import java.util.List;

import org.hibernate.SessionFactory;

import com.google.common.base.Optional;

import io.dropwizard.hibernate.AbstractDAO;
import uniandes.fabricasw.ecotouring.core.Transport;

public class TransportDAO extends AbstractDAO<Transport> {

	public TransportDAO(SessionFactory factory) {
		super(factory);
	}

	public Optional<Transport> findById(Long id) {
		return Optional.fromNullable(get(id));
	}

	public Transport create(Transport transport) {
		return persist(transport);
	}

	public List<Transport> findAll() {
		return list(namedQuery("uniandes.fabricasw.ecotouring.core.Item.findTransport"));
	}

}
