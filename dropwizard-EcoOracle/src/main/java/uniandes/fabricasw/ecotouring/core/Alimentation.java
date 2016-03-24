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
@Table(name = "ALIMENTATION", schema = "ADMIN")
@PrimaryKeyJoinColumn(name="ITEM_ID")
@NamedQueries({
		@NamedQuery(name = "uniandes.fabricasw.ecotouring.core.Alimentation.findAll", query = "SELECT a FROM Alimentation a") })
public class Alimentation extends Item implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private AlimentationType alimentationType;
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE", nullable = false)
	public AlimentationType getAlimentationType() {
		return alimentationType;
	}

	@Override
	@Column(name = "RESTAURANT_NAME", nullable = false)
	public String getName() {
		return name;
	}

	public void setAlimentationType(AlimentationType alimentationType) {
		this.alimentationType = alimentationType;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}
