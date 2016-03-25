package uniandes.fabricasw.ecotouring.core;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TRANSPORT")
public class Transport extends Item implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private TransportType type;
	private String origin;
	private String destination;
	private String initialHour;	
	private String finalHour;	

	@Column(name = "TRANSPORT_TYPE", nullable = false)
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

	@Column(name = "INITIAL_HOUR", nullable = false)
	public String getInitialHour() {
		return initialHour;
	}	
	
	@Column(name = "FINAL_HOUR", nullable = false)
	public String getFinalHour() {
		return finalHour;
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