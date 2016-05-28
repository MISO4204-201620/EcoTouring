package uniandes.fabricasw.ecotouring.resources;

import java.util.Date;
import java.util.Set;

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
import uniandes.fabricasw.ecotouring.core.Item;
import uniandes.fabricasw.ecotouring.core.Message;
import uniandes.fabricasw.ecotouring.core.MessageStatus;
import uniandes.fabricasw.ecotouring.core.Transaction;
import uniandes.fabricasw.ecotouring.core.TransactionDetail;
import uniandes.fabricasw.ecotouring.core.TransactionStatus;
import uniandes.fabricasw.ecotouring.db.ItemDAO;
import uniandes.fabricasw.ecotouring.db.MessageDAO;
import uniandes.fabricasw.ecotouring.db.ShoppingCartDAO;
import uniandes.fabricasw.ecotouring.db.ShoppingCartDetailDAO;

@Path("/shoppingCart/{shoppingCartId}")
@Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
public class ShoppongCartDetailResource {

	private final ItemDAO itemDAO;
	private final MessageDAO messageDAO;
	private final ShoppingCartDAO shoppingCartDAO;
	private final ShoppingCartDetailDAO shoppingCartDetailDAO;

	public ShoppongCartDetailResource(ItemDAO itemDAO, MessageDAO messageDAO, ShoppingCartDAO shoppingCartDAO,
			ShoppingCartDetailDAO shoppingCartDetailDAO) {
		this.itemDAO = itemDAO;
		this.messageDAO = messageDAO;
		this.shoppingCartDAO = shoppingCartDAO;
		this.shoppingCartDetailDAO = shoppingCartDetailDAO;
	}

	@GET
	@UnitOfWork
	public Transaction getTransaction(@PathParam("shoppingCartId") LongParam shoppingCartId) {
		return findSafely(shoppingCartId.get());
	}

	@POST
	@UnitOfWork
	public TransactionDetail addItem2Cart(TransactionDetail transactionDetail) {
		return shoppingCartDetailDAO.create(transactionDetail);
	}

	@GET
	@Path("/detail")
	@UnitOfWork
	public Set<TransactionDetail> getTransactionDetails(@PathParam("shoppingCartId") LongParam shoppingCartId) {
		return shoppingCartDAO.findById(shoppingCartId.get()).get().getTransacctionDetails();
	}

	@POST
	@Path("/detail")
	@UnitOfWork
	public TransactionDetail createAJTransactionDetail(TransactionDetail transactionDetail) {
		Optional<Item> i = itemDAO.findById(transactionDetail.getItem().getitemId());
		messageDAO.create(new Message("Notificacion Sistema",
				"Se realizo una operacion sobre el item" + i.get().getName(),
				i.get().getSupplier(), i.get().getSupplier(), new Date(),
				MessageStatus.UNREAD));
		return shoppingCartDetailDAO.create(transactionDetail);
	}

	@POST
	@Path("/changeStatusNew")
	@UnitOfWork
	public Transaction changeTransactionStatusNew(@PathParam("shoppingCartId") LongParam shoppingCartId) {
		Transaction transaction = shoppingCartDAO.findById(shoppingCartId.get()).get();
		transaction.setStatus(TransactionStatus.NEW);
		return shoppingCartDAO.update(transaction);
	}

	@POST
	@Path("/changeStatusPurshased")
	@UnitOfWork
	public Transaction changeTransactionStatusPurshased(@PathParam("shoppingCartId") LongParam shoppingCartId) {
		Transaction transaction = shoppingCartDAO.findById(shoppingCartId.get()).get();
		transaction.setStatus(TransactionStatus.PURSHASED);
		return shoppingCartDAO.update(transaction);
	}

	@POST
	@Path("/changeStatusRejected")
	@UnitOfWork
	public Transaction changeTransactionStatusRejected(@PathParam("shoppingCartId") LongParam shoppingCartId) {
		Transaction transaction = shoppingCartDAO.findById(shoppingCartId.get()).get();
		transaction.setStatus(TransactionStatus.REJECTED);
		return shoppingCartDAO.update(transaction);
	}

	@POST
	@Path("/changeStatusValidated")
	@UnitOfWork
	public Transaction changeTransactionStatusValidated(@PathParam("shoppingCartId") LongParam shoppingCartId) {
		Transaction transaction = shoppingCartDAO.findById(shoppingCartId.get()).get();
		transaction.setStatus(TransactionStatus.VALIDATED);
		return shoppingCartDAO.update(transaction);
	}

	private Transaction findSafely(Long shoppingCartId) {
		final Optional<Transaction> transaction = shoppingCartDAO.findById(shoppingCartId);
		if (!transaction.isPresent()) {
			throw new NotFoundException("No data found.");
		}
		return transaction.get();
	}
}
