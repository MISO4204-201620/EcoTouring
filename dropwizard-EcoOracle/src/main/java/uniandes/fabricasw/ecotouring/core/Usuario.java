package uniandes.fabricasw.ecotouring.core;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@NamedQueries({ @NamedQuery(name = "com.example.helloworld.core.Usuario.findAll", query = "SELECT u FROM Usuario u") })
public class Usuario {

	// TODO
	/**
	 * @Id
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) public long id;
	 * 
	 * @Column(name = "facebook", nullable = false) public char facebook;
	 * 
	 * @Column(name = "nombre", nullable = false) public char nombre;
	 * 
	 * @Column(name = "password", nullable = false) public char password;
	 * 
	 * @Column(name = "tipo", nullable = false) public long tipo;
	 * 
	 * @Column(name = "twitter", nullable = false) public char twitter;
	 * 
	 * @Column(name = "username", nullable = false) public char username;
	 * 
	 *              public Usuario() { }
	 * 
	 *              public Usuario(long id, char facebook, char nombre, char
	 *              password, long tipo, char twitter, char username) { this.id
	 *              = id; this.facebook = facebook; this.nombre = nombre;
	 *              this.password = password; this.tipo = tipo; this.twitter =
	 *              twitter; this.username = username; }
	 * 
	 *              public long getId() { return id; }
	 * 
	 *              public void setId(long id) { this.id = id; }
	 * 
	 *              public char getFacebook() { return facebook; }
	 * 
	 *              public void setFacebook(char facebook) { this.facebook =
	 *              facebook; }
	 * 
	 *              public char getNombre() { return nombre; }
	 * 
	 *              public void setNombre(char nombre) { this.nombre = nombre; }
	 * 
	 *              public char getPassword() { return password; }
	 * 
	 *              public void setPassword(char password) { this.password =
	 *              password; }
	 * 
	 *              public long getTipo() { return tipo; }
	 * 
	 *              public void setTipo(long tipo) { this.tipo = tipo; }
	 * 
	 *              public char getTwitter() { return twitter; }
	 * 
	 *              public void setTwitter(char twitter) { this.twitter =
	 *              twitter; }
	 * 
	 *              public char getUsername() { return username; }
	 * 
	 *              public void setUsername(char username) { this.username =
	 *              username; }
	 * 
	 * @Override public boolean equals(Object o) { if (this == o) { return true;
	 *           } if (!(o instanceof Usuario)) { return false; }
	 * 
	 *           final Usuario that = (Usuario) o;
	 * 
	 *           return Objects.equals(this.id, that.id) &&
	 *           Objects.equals(this.facebook, that.facebook) &&
	 *           Objects.equals(this.nombre, that.nombre) &&
	 *           Objects.equals(this.password, that.password) &&
	 *           Objects.equals(this.tipo, that.tipo) &&
	 *           Objects.equals(this.twitter, that.twitter) &&
	 *           Objects.equals(this.username, that.username); }
	 * 
	 * @Override public int hashCode() { return Objects.hash(id, facebook,
	 *           nombre, password, tipo, twitter, username); }
	 */
}
