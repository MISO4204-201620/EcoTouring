package uniandes.fabricasw.ecotouring.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.dropwizard.hibernate.UnitOfWork;
import uniandes.fabricasw.ecotouring.core.Category;
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
	public Category createType(Category category) {
		return categoryDAO.create(category);
	}

	@GET
	@UnitOfWork
	public List<Category> listCategories() {
		return categoryDAO.findAllCategories();
	}

}
