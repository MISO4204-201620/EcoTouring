package uniandes.fabricasw.ecotouring.db;

import java.util.List;

import org.hibernate.SessionFactory;

import com.google.common.base.Optional;

import io.dropwizard.hibernate.AbstractDAO;
import uniandes.fabricasw.ecotouring.core.Type;

public class CategoryDAO extends AbstractDAO<Type> {
	public CategoryDAO(SessionFactory factory) {
		super(factory);
	}

	public Optional<Type> findById(Long id) {
		return Optional.fromNullable(get(id));
	}

	public Type create(Type type) {
		return persist(type);
	}

	public List<Type> findAllCategories() {
		return list(namedQuery("uniandes.fabricasw.ecotouring.core.Type.findAllCategories"));
	}
}
