package uniandes.fabricasw.ecotouring.db;

import java.util.List;

import org.hibernate.SessionFactory;

import com.google.common.base.Optional;

import io.dropwizard.hibernate.AbstractDAO;
import uniandes.fabricasw.ecotouring.core.TransactionDetail;

public class ShoppingCartDetailDAO extends AbstractDAO<TransactionDetail> {

	public ShoppingCartDetailDAO(SessionFactory factory) {
		super(factory);
	}

	public Optional<TransactionDetail> findById(Long id) {
		return Optional.fromNullable(get(id));
	}

	public TransactionDetail create(TransactionDetail transactionDetail) {
		return persist(transactionDetail);
	}

	public List<TransactionDetail> findAll() {
		return list(namedQuery("uniandes.fabricasw.ecotouring.core.TransactionDetail.findAll"));
	}
}
