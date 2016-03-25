package uniandes.fabricasw.ecotouring.core;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("ACCOMMODATION")
public class Accommodation extends Item implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private AccommodationType accommodationType;
	private City city;
	private Country country;
	private String hotelName;
	private Long numberOfRooms;

	@Enumerated(EnumType.STRING)
	@Column(name = "ACCOMMODATION_TYPE", nullable = false)
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
