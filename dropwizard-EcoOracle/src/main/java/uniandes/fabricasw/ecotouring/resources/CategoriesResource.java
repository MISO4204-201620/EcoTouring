package uniandes.fabricasw.ecotouring.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.dropwizard.hibernate.UnitOfWork;
import uniandes.fabricasw.ecotouring.core.Categories;
import uniandes.fabricasw.ecotouring.db.AccommodationDAO;
import uniandes.fabricasw.ecotouring.db.AlimentationDAO;
import uniandes.fabricasw.ecotouring.db.EcoTourDAO;
import uniandes.fabricasw.ecotouring.db.TransportDAO;

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
public class CategoriesResource {

	private final AlimentationDAO alimentationDAO;
	private final AccommodationDAO accommodationDAO;
	private final EcoTourDAO ecoTourDAO;
	private final TransportDAO transportDAO;

	public CategoriesResource(AccommodationDAO accommodationDAO,AlimentationDAO alimentationDAO, EcoTourDAO ecoTourDAO,
			TransportDAO transportDAO) {
		this.alimentationDAO = alimentationDAO;
		this.accommodationDAO = accommodationDAO;
		this.ecoTourDAO = ecoTourDAO;
		this.transportDAO = transportDAO;
	}

	@GET
	@UnitOfWork
	public List<Categories> listCategories() {
		List<Categories> categories = new ArrayList<Categories>();
		List<?> cat1 = alimentationDAO.findAll();
		List<?> cat2 = accommodationDAO.findAll();
		List<?> cat3 = ecoTourDAO.findAll();
		List<?> cat4 = transportDAO.findAll();
		categories.add(new Categories("Accommodation",cat1.size()));
		categories.add(new Categories("Alimentation", cat2.size()));
		categories.add(new Categories("EcoTour", cat3.size()));
		categories.add(new Categories("Transport", cat4.size()));
		return categories;
	}

}