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
@PrimaryKeyJoinColumn(name="ITEM_ID")
@Table(name = "ALIMENTATION", schema = "ADMIN")
@NamedQueries({
		@NamedQuery(name = "uniandes.fabricasw.ecotouring.core.Alimentation.findAll", query = "SELECT a FROM Alimentation a") })
public class Alimentation extends Item implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private AlimentationType alimentationType;
	private Long calories;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE", nullable = false)
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
