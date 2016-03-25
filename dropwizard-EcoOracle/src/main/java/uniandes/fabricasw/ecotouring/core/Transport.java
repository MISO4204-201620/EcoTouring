package uniandes.fabricasw.ecotouring.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="ITEM_ID")
@Table(name = "TRANSPORT", schema = "ADMIN")
@NamedQueries({
		@NamedQuery(name = "uniandes.fabricasw.ecotouring.core.Transport.findAll", query = "SELECT t FROM Transport t") })
public class Transport extends Item implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private TransportType type;
	private String origin;
	private String destination;
	private String finalHour;
	private String initialHour;	

	@Column(name = "TYPE", nullable = false)
	public TransportType getType() {
		return type;
	}	
	
	@Column(name = "ORIGIN", nullable = false)
	public String getOrigin() {
		return origin;
	}	
	
	@Column(name = "DESTINATION", nullable = false)
	public String getDestination() {
		return destination;
	}

	@Column(name = "FINAL_HOUR", nullable = false)
	public String getFinalHour() {
		return finalHour;
	}

	@Column(name = "INITIAL_HOUR", nullable = false)
	public String getInitialHour() {
		return initialHour;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setFinalHour(String finalHour) {
		this.finalHour = finalHour;
	}

	public void setInitialHour(String initialHour) {
		this.initialHour = initialHour;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void setType(TransportType type) {
		this.type = type;
	}
}