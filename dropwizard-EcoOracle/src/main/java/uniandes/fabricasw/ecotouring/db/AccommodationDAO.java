package uniandes.fabricasw.ecotouring.db;

import java.util.List;

import org.hibernate.SessionFactory;

import com.google.common.base.Optional;

import io.dropwizard.hibernate.AbstractDAO;
import uniandes.fabricasw.ecotouring.core.*;

public class AccommodationDAO extends AbstractDAO<Accommodation> {
	
	public AccommodationDAO(SessionFactory factory) {
		super(factory);
	}

	public Optional<Accommodation> findById(Long id) {
		return Optional.fromNullable(get(id));
	}

	public Accommodation create(Accommodation accommodation) {
		return persist(accommodation);
	}

	public List<Accommodation> findAll() {
		return list(namedQuery("uniandes.fabricasw.ecotouring.core.Item.findAccommodation"));
	}
	
}
