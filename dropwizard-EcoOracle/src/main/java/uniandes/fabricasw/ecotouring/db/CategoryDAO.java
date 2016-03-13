package uniandes.fabricasw.ecotouring.db;

import java.util.List;

import org.hibernate.SessionFactory;

import com.google.common.base.Optional;

import io.dropwizard.hibernate.AbstractDAO;
import uniandes.fabricasw.ecotouring.core.Person;

public class CategoryDAO extends AbstractDAO<Person> {
	public CategoryDAO(SessionFactory factory) {
		super(factory);
	}

	public Optional<Person> findById(Long id) {
		return Optional.fromNullable(get(id));
	}

	public Person create(Person person) {
		return persist(person);
	}

	public List<Person> findAll() {
		return list(namedQuery("com.example.helloworld.core.Person.findAll"));
	}
}
