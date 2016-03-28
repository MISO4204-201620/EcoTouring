package uniandes.fabricasw.ecotouring.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Optional;

import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import uniandes.fabricasw.ecotouring.core.*;
import uniandes.fabricasw.ecotouring.db.ShoppingCartDAO;
import uniandes.fabricasw.ecotouring.db.ShoppingCartDetailDAO;

@Path("/shoppingCart/{shoppingCartId}")
@Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
public class ShoppongCartDetailResource {

	private final ShoppingCartDAO shoppingCartDAO;
	private final ShoppingCartDetailDAO shoppingCartDetailDao;
	

	public ShoppongCartDetailResource(ShoppingCartDAO shoppingCartDAO, ShoppingCartDetailDAO shoppingCartDetailDao) {
		this.shoppingCartDAO = shoppingCartDAO;
		this.shoppingCartDetailDao = shoppingCartDetailDao;
	}
	
	@GET
	@UnitOfWork
	public Transaction getTransaction(@PathParam("shoppingCartId") LongParam shoppingCartId) {
		return findSafely(shoppingCartId.get());
	}
	
	@POST
	@UnitOfWork
	public TransactionDetail createPerson(TransactionDetail transactionDetail) {
		return shoppingCartDetailDao.create(transactionDetail);
	}	
	
	@GET
	@Path("/detail")
	@UnitOfWork
	public List<TransactionDetail> getTransactionDetails(@PathParam("shoppingCartId") LongParam shoppingCartId) {
		return new ArrayList<TransactionDetail>(shoppingCartDAO.findById(shoppingCartId.get()).get().getTransacctionDetails());
	}
	
	@POST
	@Path("/detail")
	@UnitOfWork
	public TransactionDetail createTransactionDetail(TransactionDetail transactionDetail) {
		return shoppingCartDetailDao.create(transactionDetail);
	}

	private Transaction findSafely(Long shoppingCartId) {
		final Optional<Transaction> transaction = shoppingCartDAO.findById(shoppingCartId);
		if (!transaction.isPresent()) {
			throw new NotFoundException("No data found.");
		}
		return transaction.get();
	}
}
