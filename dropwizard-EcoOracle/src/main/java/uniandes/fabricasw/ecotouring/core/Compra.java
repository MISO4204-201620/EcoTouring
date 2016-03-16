package uniandes.fabricasw.ecotouring.core;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "compra")
@NamedQueries({
		@NamedQuery(name = "uniandes.fabricasw.ecotouring.core.Compra.findAll", query = "SELECT com FROM Compra com") })
public class Compra {

	// TODO
	/**
	 * @Id
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) public long idCompra;
	 * 
	 * @Column(name = "formaPago", nullable = false) public long formaPago;
	 * 
	 * @Column(name = "total", nullable = false) public float total;
	 * 
	 * @Column(name = "idTransaccion", nullable = false) public long
	 *              idTransaccion;
	 * 
	 * @Column(name = "fecha", nullable = false) private Date fecha;
	 * 
	 *              public Compra() { }
	 * 
	 *              public Compra(long idCompra, long formaPago, float total,
	 *              long idTransaccion, Date fecha) { this.idCompra = idCompra;
	 *              this.formaPago = formaPago; this.total = total;
	 *              this.idTransaccion = idTransaccion; this.fecha = fecha; }
	 * 
	 *              public long getIdCompra() { return idCompra; }
	 * 
	 *              public void setIdCompra(long idCompra) { this.idCompra =
	 *              idCompra; }
	 * 
	 *              public long getFormaPago() { return formaPago; }
	 * 
	 *              public void setFormaPago(long formaPago) { this.formaPago =
	 *              formaPago; }
	 * 
	 *              public float getTotal() { return total; }
	 * 
	 *              public void setTotal(float total) { this.total = total; }
	 * 
	 *              public long getIdTransaccion() { return idTransaccion; }
	 * 
	 *              public void setIdTransaccion(long idTransaccion) {
	 *              this.idTransaccion = idTransaccion;
	 * 
	 *              public Date getFecha() { return fecha; }
	 * 
	 *              public void setFecha(Date fecha) { this.fecha = fecha; }
	 * 
	 * @Override public boolean equals(Object o) { if (this == o) { return true;
	 *           } if (!(o instanceof Compra)) { return false; }
	 * 
	 *           final Compra that = (Compra) o;
	 * 
	 *           return Objects.equals(this.idCompra, that.idCompra) &&
	 *           Objects.equals(this.formaPago, that.formaPago) &&
	 *           Objects.equals(this.total, that.total) &&
	 *           Objects.equals(this.idTransaccion, that.idTransaccion) &&
	 *           Objects.equals(this.fecha, that.fecha); }
	 * 
	 * @Override public int hashCode() { return Objects.hash(idCompra,
	 *           formaPago, total, idTransaccion, fecha); }
	 */
}
