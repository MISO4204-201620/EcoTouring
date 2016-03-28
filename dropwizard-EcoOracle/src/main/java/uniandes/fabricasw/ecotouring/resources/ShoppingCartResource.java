package uniandes.fabricasw.ecotouring.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.dropwizard.hibernate.UnitOfWork;
import uniandes.fabricasw.ecotouring.core.Transaction;
import uniandes.fabricasw.ecotouring.db.ShoppingCartDAO;

@Path("/shoppingCart")
@Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + "; charset=utf-8")
public class ShoppingCartResource {

	private final ShoppingCartDAO shoppingCartDAO;

	public ShoppingCartResource(ShoppingCartDAO shoppingCartDAO) {
		this.shoppingCartDAO = shoppingCartDAO;
	}
	
	@GET
	@UnitOfWork
	public List<Transaction> listShoppingCart() {
		return shoppingCartDAO.findAll();
	}	

	@POST
	@UnitOfWork
	public Transaction createPerson(Transaction transaction) {
		return shoppingCartDAO.create(transaction);
	}

}
