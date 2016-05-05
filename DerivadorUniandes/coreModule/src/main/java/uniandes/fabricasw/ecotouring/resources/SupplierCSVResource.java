package uniandes.fabricasw.ecotouring.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.google.common.base.Optional;

import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import uniandes.fabricasw.ecotouring.core.Item;
import uniandes.fabricasw.ecotouring.core.ItemCSV;
import uniandes.fabricasw.ecotouring.core.Person;
import uniandes.fabricasw.ecotouring.db.PersonDAO;

@Path("/supplierCSV/{personId}")
public class SupplierCSVResource {

	private final PersonDAO personDAO;

	public SupplierCSVResource(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	public String toCSV(List<ItemCSV> listOfPojos) {
		CsvMapper mapper = new CsvMapper();
		CsvSchema schema = mapper.schemaFor(ItemCSV.class).withHeader();
		try {
			return mapper.writer(schema).writeValueAsString(listOfPojos);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@GET
	@Path("/items")
	@UnitOfWork
	public Response listItems(@PathParam("personId") LongParam personId) {
		ArrayList<Item> items = new ArrayList<Item>(personDAO.findById(personId.get()).get().getItems());
		if (items.isEmpty()) {
			throw new NotFoundException("No data found.");
		}
		
		ArrayList<ItemCSV> itemsCSV = new ArrayList<ItemCSV>();
		for (Item item : items) {
			ItemCSV i = new ItemCSV();
			i.setItemId(item.getitemId());
			i.setName(item.getName());
			itemsCSV.add(i);
		}		
		Object myCsvText = toCSV(itemsCSV);
		String fileName = "items.csv";
		return Response.ok(myCsvText).header("Content-Disposition", "attachment; filename=" + fileName).build();
	}

	// crear 3 métodos, uno por cada reporte

	// Reporte 1 Items del proveedor descargables en CSV
	@GET
	@Path("/itemsCSV")
	@UnitOfWork
	public List<Item> listItemsCSV(@PathParam("personId") LongParam personId) {
		ArrayList<Item> l = new ArrayList<Item>(personDAO.findById(personId.get()).get().getItems());
		if (l.isEmpty()) {
			throw new NotFoundException("No data found.");
		}
		return l;
	}

	// Reporte 2 Items del proveedor más consultados descargables en CSV
	@GET
	@Path("/itemsQueriesCSV")
	@UnitOfWork
	public List<Item> listItemsQueriesCSV(@PathParam("personId") LongParam personId) {
		ArrayList<Item> l = new ArrayList<Item>(personDAO.findById(personId.get()).get().getItems());
		if (l.isEmpty()) {
			throw new NotFoundException("No data found.");
		}
		return l;
	}

	// Reporte 3 Items del proveedor más vendidos descargables en CSV
	@GET
	@Path("/itemsTransactionsCSV")
	@UnitOfWork
	public List<Item> listItemsTransactionsCSV(@PathParam("personId") LongParam personId) {
		ArrayList<Item> l = new ArrayList<Item>(personDAO.findById(personId.get()).get().getItems());
		if (l.isEmpty()) {
			throw new NotFoundException("No data found.");
		}
		return l;
	}

	private Person findSafely(LongParam itemId) {
		final Optional<Person> item = personDAO.findById(itemId.get());
		if (!item.isPresent()) {
			throw new NotFoundException("No data found.");
		}
		return item.get();
	}
}
