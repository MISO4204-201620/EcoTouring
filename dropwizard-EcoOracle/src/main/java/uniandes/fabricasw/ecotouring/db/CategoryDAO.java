package uniandes.fabricasw.ecotouring.db;

import java.util.List;

import org.hibernate.SessionFactory;

import com.google.common.base.Optional;

import io.dropwizard.hibernate.AbstractDAO;
import uniandes.fabricasw.ecotouring.core.Category;

public class CategoryDAO extends AbstractDAO<Category> {
	
	public CategoryDAO(SessionFactory factory) {
		super(factory);
	}

	public Optional<Category> findById(Long id) {
		return Optional.fromNullable(get(id));
	}

	public Category create(Category category) {
		return persist(category);
	}

	public List<Category> findAllCategories() {
		return list(namedQuery("uniandes.fabricasw.ecotouring.core.Category.findAll"));
	}
}
