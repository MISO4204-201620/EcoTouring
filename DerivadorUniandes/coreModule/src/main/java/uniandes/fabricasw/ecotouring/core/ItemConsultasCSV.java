package uniandes.fabricasw.ecotouring.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Lo mas consultado por proveedor

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemConsultasCSV implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long itemId;
	private String name;
	private String description;
	private int queryCounter;

	public ItemConsultasCSV(Item item) {
		this.itemId = item.getitemId();
		this.name = item.getName();
		this.description = item.getDescription();
		this.queryCounter = item.getQueryCounter();
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQueryCounter() {
		return queryCounter;
	}

	public void setQueryCounter(int queryCounter) {
		this.queryCounter = queryCounter;
	}

}
