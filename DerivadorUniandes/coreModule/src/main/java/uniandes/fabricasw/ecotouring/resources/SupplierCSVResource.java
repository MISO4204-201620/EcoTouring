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
import uniandes.fabricasw.ecotouring.core.ItemComentariosCSV;
import uniandes.fabricasw.ecotouring.core.ItemConsultasCSV;
import uniandes.fabricasw.ecotouring.core.ItemVentasCSV;
import uniandes.fabricasw.ecotouring.core.Person;
import uniandes.fabricasw.ecotouring.db.PersonDAO;

@Path("/supplierCSV/{personId}")
public class SupplierCSVResource {

	private final PersonDAO personDAO;

	public SupplierCSVResource(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	// Reporte 1 Items del proveedor vendidos descargables en CSV
	public String toVentasCSV(List<ItemVentasCSV> listOfPojos) {
		CsvMapper mapper = new CsvMapper();
		CsvSchema schema = mapper.schemaFor(ItemVentasCSV.class).withHeader();
		try {
			return mapper.writer(schema).writeValueAsString(listOfPojos);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}	
	
	@GET
	@Path("/ventasCSV")
	@UnitOfWork
	public Response listVentasCSV(@PathParam("personId") LongParam personId) {
			ArrayList<Item> items = new ArrayList<Item>(personDAO.findById(personId.get()).get().getItems());
			if (items.isEmpty()) {
				throw new NotFoundException("No data found.");
			}
			
			ArrayList<ItemVentasCSV> itemsCSV = new ArrayList<ItemVentasCSV>();
			for (Item item : items) {
				ItemVentasCSV i = new ItemVentasCSV(item);
				i.setItemId(item.getitemId());
				i.setName(item.getName());
				itemsCSV.add(i);
			}		
			Object myCsvText = toVentasCSV(itemsCSV);
			String fileName = "ventas.csv";
			return Response.ok(myCsvText).header("Content-Disposition", "attachment; filename=" + fileName).build();
	}

	// Reporte 2 Items del proveedor más consultados descargable en CSV
	public String toConsultasCSV(List<ItemConsultasCSV> listOfPojos) {
		CsvMapper mapper = new CsvMapper();
		CsvSchema schema = mapper.schemaFor(ItemConsultasCSV.class).withHeader();
		try {
			return mapper.writer(schema).writeValueAsString(listOfPojos);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}	
	
	@GET
	@Path("/consultasCSV")
	@UnitOfWork
		public Response listConsultasCSV(@PathParam("personId") LongParam personId) {
			ArrayList<Item> items = new ArrayList<Item>(personDAO.findById(personId.get()).get().getItems());
			if (items.isEmpty()) {
				throw new NotFoundException("No data found.");
			}
			
			ArrayList<ItemConsultasCSV> itemsCSV = new ArrayList<ItemConsultasCSV>();
			for (Item item : items) {
				ItemConsultasCSV i = new ItemConsultasCSV(item);
				i.setItemId(item.getitemId());
				i.setName(item.getName());
				itemsCSV.add(i);
			}		
			Object myCsvText = toConsultasCSV(itemsCSV);
			String fileName = "consultas.csv";
			return Response.ok(myCsvText).header("Content-Disposition", "attachment; filename=" + fileName).build();
	}

	// Reporte 3 Items del proveedor más comentados descargables en CSV
	public String toComentadosCSV(List<ItemComentariosCSV> listOfPojos) {
		CsvMapper mapper = new CsvMapper();
		CsvSchema schema = mapper.schemaFor(ItemComentariosCSV.class).withHeader();
		try {
			return mapper.writer(schema).writeValueAsString(listOfPojos);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("/comentariosCSV")
	@UnitOfWork
	public Response listComentariosCSV(@PathParam("personId") LongParam personId) {
			ArrayList<Item> items = new ArrayList<Item>(personDAO.findById(personId.get()).get().getItems());
			if (items.isEmpty()) {
				throw new NotFoundException("No data found.");
			}
			
			ArrayList<ItemComentariosCSV> itemsCSV = new ArrayList<ItemComentariosCSV>();
			for (Item item : items) {
				ItemComentariosCSV i = new ItemComentariosCSV(item);
				i.setItemId(item.getitemId());
				i.setName(item.getName());
				itemsCSV.add(i);
			}		
			Object myCsvText = toComentadosCSV(itemsCSV);
			String fileName = "comentarios.csv";
			return Response.ok(myCsvText).header("Content-Disposition", "attachment; filename=" + fileName).build();
	}

	private Person findSafely(LongParam itemId) {
		final Optional<Person> item = personDAO.findById(itemId.get());
		if (!item.isPresent()) {
			throw new NotFoundException("No data found.");
		}
		return item.get();
	}
}
