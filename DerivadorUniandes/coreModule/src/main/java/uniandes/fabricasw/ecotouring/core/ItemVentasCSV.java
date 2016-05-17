package uniandes.fabricasw.ecotouring.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Lo mas vendido por proveedor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemVentasCSV implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long itemId;
	private String name;
	private String description;
	private int transactionCount;

	public ItemVentasCSV(Item item) {
		this.itemId = item.getitemId();
		this.name = item.getName();
		this.transactionCount = 1;// item.getTransactionCount();
		this.description = item.getDescription();
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

	public int getTransactionCount() {
		return transactionCount;
	}

	public void setTransactionCount(int transactionCount) {
		this.transactionCount = transactionCount;
	}

}
