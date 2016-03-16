package uniandes.fabricasw.ecotouring.core;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "marketplace")
@NamedQueries({
		@NamedQuery(name = "uniandes.fabricasw.ecotouring.core.MarketPlace.findAll", query = "SELECT mp FROM MarketPlace mp") })
public class MarketPlace {

	// TODO
	/**
	 * @Id
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) public long id;
	 * 
	 * @Column(name = "configuracion", nullable = false) public long
	 *              configuracion;
	 * 
	 * @Column(name = "nombre", nullable = false) public char nombre;
	 * 
	 * @Column(name = "url", nullable = false) public char url;
	 * 
	 *              public MarketPlace() { }
	 * 
	 *              public MarketPlace(long id, long configuracion, char nombre,
	 *              char url) { this.id = id; this.configuracion =
	 *              configuracion; this.nombre = nombre; this.url = url; }
	 * 
	 *              public long getId() { return id; }
	 * 
	 *              public void setId(long id) { this.id = id; }
	 * 
	 *              public long getConfiguracion() { return configuracion; }
	 * 
	 *              public void setConfiguracion(long configuracion) {
	 *              this.configuracion = configuracion; }
	 * 
	 *              public char getNombre() { return nombre; }
	 * 
	 *              public void setNombre(char nombre) { this.nombre = nombre; }
	 * 
	 *              public char getUrl() { return url; }
	 * 
	 *              public void setUrl(char url) { this.url = url; }
	 * 
	 * @Override public boolean equals(Object o) { if (this == o) { return true;
	 *           } if (!(o instanceof MarketPlace)) { return false; }
	 * 
	 *           final MarketPlace that = (MarketPlace) o;
	 * 
	 *           return Objects.equals(this.id, that.id) &&
	 *           Objects.equals(this.configuracion, that.configuracion) &&
	 *           Objects.equals(this.nombre, that.nombre) &&
	 *           Objects.equals(this.url, that.url); }
	 * 
	 * @Override public int hashCode() { return Objects.hash(id, configuracion,
	 *           nombre, url); }
	 */
}
