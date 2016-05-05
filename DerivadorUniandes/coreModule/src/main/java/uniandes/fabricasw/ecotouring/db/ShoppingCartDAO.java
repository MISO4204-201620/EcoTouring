package uniandes.fabricasw.ecotouring.db;

import java.util.List;

import org.hibernate.SessionFactory;

import com.google.common.base.Optional;

import io.dropwizard.hibernate.AbstractDAO;
import uniandes.fabricasw.ecotouring.core.Transaction;

public class ShoppingCartDAO extends AbstractDAO<Transaction> {

	public ShoppingCartDAO(SessionFactory factory) {
		super(factory);
	}

	public Optional<Transaction> findById(Long id) {
		return Optional.fromNullable(get(id));
	}

	public Transaction create(Transaction transaction) {
		return persist(transaction);
	}

	public List<Transaction> findAll() {
		return list(namedQuery("uniandes.fabricasw.ecotouring.core.Transaction.findAll"));
	}

	public Transaction update(Transaction transaction) {
		return persist(transaction);
	}
}
