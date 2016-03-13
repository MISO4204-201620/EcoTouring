package uniandes.fabricasw.ecotouring.core;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "busqueda")
@NamedQueries({
		@NamedQuery(name = "com.example.helloworld.core.Busqueda.findAll", query = "SELECT bu FROM Busqueda bu") })
public class Busqueda {

	// TODO
	/**
	 * @Id
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) public long
	 *                          idBusqueda;
	 * 
	 * @Column(name = "idCategoriaItem", nullable = false) public long
	 *              idCategoriaItem;
	 * 
	 * @Column(name = "idProveedor", nullable = false) public long idProveedor;
	 * 
	 * @Column(name = "idTransaccion", nullable = false) public long
	 *              idTransaccion;
	 * 
	 * @Column(name = "descripcion", nullable = false) public String
	 *              descripcion;
	 * 
	 *              public Busqueda() { }
	 * 
	 *              public Busqueda(long idBusqueda, long idCategoriaItem, long
	 *              idProveedor, long idTransaccion, String descripcion) {
	 *              this.idBusqueda = idBusqueda; this.idCategoriaItem =
	 *              idCategoriaItem; this.idProveedor = idProveedor;
	 *              this.idTransaccion = idTransaccion; this.descripcion =
	 *              descripcion; }
	 * 
	 *              public long getIdBusqueda() { return idBusqueda; }
	 * 
	 *              public void setIdBusqueda(long idBusqueda) { this.idBusqueda
	 *              = idBusqueda; }
	 * 
	 *              public long getIdCategoriaItem() { return idCategoriaItem; }
	 * 
	 *              public void setIdCategoriaItem(long idCategoriaItem) {
	 *              this.idCategoriaItem = idCategoriaItem; }
	 * 
	 *              public long getIdProveedor() { return idProveedor; }
	 * 
	 *              public void setIdProveedor(long idProveedor) {
	 *              this.idProveedor = idProveedor; }
	 * 
	 *              public long getIdTransaccion() { return idTransaccion; }
	 * 
	 *              public void setIdTransaccion(long idTransaccion) {
	 *              this.idTransaccion = idTransaccion; }
	 * 
	 *              public String getDescripcion() { return descripcion; }
	 * 
	 *              public void setDescripcion(String descripcion) {
	 *              this.descripcion = descripcion; }
	 * 
	 * @Override public boolean equals(Object o) { if (this == o) { return true;
	 *           } if (!(o instanceof Busqueda)) { return false; }
	 * 
	 *           final Busqueda that = (Busqueda) o;
	 * 
	 *           return Objects.equals(this.idBusqueda, that.idBusqueda) &&
	 *           Objects.equals(this.idCategoriaItem, that.idCategoriaItem) &&
	 *           Objects.equals(this.idProveedor, that.idProveedor) &&
	 *           Objects.equals(this.idTransaccion, that.idTransaccion) &&
	 *           Objects.equals(this.descripcion, that.descripcion); }
	 * 
	 * @Override public int hashCode() { return Objects.hash(idBusqueda,
	 *           idCategoriaItem, idProveedor, idTransaccion, descripcion); }
	 */
}
