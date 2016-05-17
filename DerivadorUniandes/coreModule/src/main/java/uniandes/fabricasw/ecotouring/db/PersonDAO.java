package uniandes.fabricasw.ecotouring.db;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.google.common.base.Optional;

import io.dropwizard.hibernate.AbstractDAO;
import uniandes.fabricasw.ecotouring.core.Person;

public class PersonDAO extends AbstractDAO<Person> {

	public PersonDAO(SessionFactory factory) {
		super(factory);
	}

	public Optional<Person> findById(Long id) {
		return Optional.fromNullable(get(id));
	}

	public Person create(Person person) {
		return persist(person);
	}

	public List<Person> findAll() {
		return list(namedQuery("uniandes.fabricasw.ecotouring.core.Person.findAll"));
	}

	public List<Person> findAllSuppliers() {
		return list(namedQuery("uniandes.fabricasw.ecotouring.core.Person.findAllSuppliers"));
	}

	@SuppressWarnings("unchecked")
	public List<Person> searchPeopleByName(String searchKeyword) {
		return (List<Person>) this.criteria().add(Restrictions.ilike("fullName", searchKeyword, MatchMode.ANYWHERE))
				.list();
	}

	// Verifica el login por la app EcoTouring
	public Person authenticateUserByEcoTouring(String userName, String password) {

		String queryString = "from Person p where p.username = :userName and p.password = :password";
		Query query = currentSession().createQuery(queryString);
		query.setParameter("userName", userName);
		query.setParameter("password", password);

		return (Person) query.uniqueResult();
	}

	// Verifica el login por Facebook
	public Person authenticateUserByFacebook(String userName, String identifierFacebook) {

		String queryString = "from Person p where p.username = :userName and p.facebook = :identifierFacebook";
		Query query = currentSession().createQuery(queryString);
		query.setParameter("userName", userName);
		query.setParameter("identifierFacebook", identifierFacebook);

		return (Person) query.uniqueResult();
	}

	// Verifica el login por Twitter
	public Person authenticateUserByTwitter(String userName, String identifierTwitter) {

		String queryString = "from Person p where p.username = :userName and p.twitter = :identifierTwitter";
		Query query = currentSession().createQuery(queryString);
		query.setParameter("userName", userName);
		query.setParameter("identifierTwitter", identifierTwitter);

		return (Person) query.uniqueResult();
	}
}
