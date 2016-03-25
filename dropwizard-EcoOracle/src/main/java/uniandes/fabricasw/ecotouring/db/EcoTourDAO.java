package uniandes.fabricasw.ecotouring.db;

import java.util.List;

import org.hibernate.SessionFactory;

import com.google.common.base.Optional;

import io.dropwizard.hibernate.AbstractDAO;
import uniandes.fabricasw.ecotouring.core.*;

public class EcoTourDAO extends AbstractDAO<EcoTour> {
	
	public EcoTourDAO(SessionFactory factory) {
		super(factory);
	}

	public Optional<EcoTour> findById(Long id) {
		return Optional.fromNullable(get(id));
	}

	public EcoTour create(EcoTour ecoTour) {
		return persist(ecoTour);
	}

	public List<EcoTour> findAll() {
		return list(namedQuery("uniandes.fabricasw.ecotouring.core.Item.findEcotours"));
	}
	
}
