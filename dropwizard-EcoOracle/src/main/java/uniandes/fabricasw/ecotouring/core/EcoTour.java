package uniandes.fabricasw.ecotouring.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ECOTOUR", schema = "ADMIN")
//@DiscriminatorValue("VCUST")
@PrimaryKeyJoinColumn(name="ITEM_ID")
@NamedQueries({
		@NamedQuery(name = "uniandes.fabricasw.ecotouring.core.EcoTour.findAll", query = "SELECT e FROM EcoTour e") })
public class EcoTour extends Item implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private EcoTourType EcoTourType;
	private String itinerary;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE", nullable = false)
	public EcoTourType getEcoTourType() {
		return EcoTourType;
	}

	@Column(name = "ITINERARY", nullable = false)
	public String getItinerary() {
		return itinerary;
	}

	public void setEcoTourType(EcoTourType ecoTourType) {
		EcoTourType = ecoTourType;
	}

	public void setItinerary(String itinerary) {
		this.itinerary = itinerary;
	}
}
