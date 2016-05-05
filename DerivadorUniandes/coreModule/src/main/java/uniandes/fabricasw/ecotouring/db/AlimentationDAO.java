package uniandes.fabricasw.ecotouring.db;

import java.util.List;

import org.hibernate.SessionFactory;

import com.google.common.base.Optional;

import io.dropwizard.hibernate.AbstractDAO;
import uniandes.fabricasw.ecotouring.core.Alimentation;

public class AlimentationDAO extends AbstractDAO<Alimentation> {

	public AlimentationDAO(SessionFactory factory) {
		super(factory);
	}

	public Optional<Alimentation> findById(Long id) {
		return Optional.fromNullable(get(id));
	}

	public Alimentation create(Alimentation alimentation) {
		return persist(alimentation);
	}

	public List<Alimentation> findAll() {
		return list(namedQuery("uniandes.fabricasw.ecotouring.core.Item.findAlimentation"));
	}

}
