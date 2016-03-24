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
@Table(name = "ACCOMMODATION", schema = "ADMIN")
@PrimaryKeyJoinColumn(name="ITEM_ID")
@NamedQueries({
		@NamedQuery(name = "uniandes.fabricasw.ecotouring.core.Accommodation.findAll", query = "SELECT a FROM Accommodation a") })
public class Accommodation extends Item implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private AccommodationType accommodationType;
	private City city;
	private Country country;
	private String hotelName;
	private Long numberOfRooms;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE", nullable = false)
	public AccommodationType getAccommodationType() {
		return accommodationType;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "CITY", nullable = false)
	public City getCity() {
		return city;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "COUNTRY", nullable = false)
	public Country getCountry() {
		return country;
	}

	@Column(name = "HOTEL_NAME", nullable = false)
	public String getHotelName() {
		return hotelName;
	}

	@Column(name = "NUMBER_OF_ROOMS", nullable = false)
	public Long getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setAccommodationType(AccommodationType accommodationType) {
		this.accommodationType = accommodationType;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public void setNumberOfRooms(Long numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

}
