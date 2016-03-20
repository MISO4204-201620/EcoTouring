package uniandes.fabricasw.ecotouring.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.dropwizard.hibernate.UnitOfWork;
import uniandes.fabricasw.ecotouring.core.Type;
import uniandes.fabricasw.ecotouring.db.CategoryDAO;

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
public class CategoriesResource {

	private final CategoryDAO categoryDAO;

	public CategoriesResource(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	@POST
	@UnitOfWork
	public Type createType(Type type) {
		return categoryDAO.create(type);
	}

	@GET
	@UnitOfWork
	public List<Type> listCategories() {
		return categoryDAO.findAllCategories();
	}

}
