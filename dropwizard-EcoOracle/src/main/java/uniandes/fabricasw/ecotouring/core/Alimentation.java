package uniandes.fabricasw.ecotouring.core;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("ALIMENTATION")
public class Alimentation extends Item implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private AlimentationType alimentationType;
	private Long calories;

	@Enumerated(EnumType.STRING)
	@Column(name = "ALIMENTATION_TYPE", nullable = false)
	public AlimentationType getAlimentationType() {
		return alimentationType;
	}

	@Column(name = "CALORIES", nullable = false)
	public Long getCalories() {
		return calories;
	}

	public void setAlimentationType(AlimentationType alimentationType) {
		this.alimentationType = alimentationType;
	}

	public void setCalories(Long calories) {
		this.calories = calories;
	}
}
