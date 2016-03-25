package uniandes.fabricasw.ecotouring.core;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM", schema = "ADMIN")
@DiscriminatorValue("ECOTOUR")
public class EcoTour extends Item implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private EcoTourType ecoTourType;
	private String itinerary;

	@Enumerated(EnumType.STRING)
	@Column(name = "ECOTOUR_TYPE", nullable = true)
	public EcoTourType getEcoTourType() {
		return ecoTourType;
	}

	@Column(name = "ITINERARY", nullable = true)
	public String getItinerary() {
		return itinerary;
	}

	public void setEcoTourType(EcoTourType ecoTourType) {
		this.ecoTourType = ecoTourType;
	}

	public void setItinerary(String itinerary) {
		this.itinerary = itinerary;
	}
}
