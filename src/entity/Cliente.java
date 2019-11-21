package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigoCliente;
	private String apellido;
	private String dirrecion;
	private String dui;
	private String email;
	private String genero;
	private String nombre;
	private String telefono;

	public Cliente() {
	}


//	public Cliente(String apellido, String dirrecion, String dui, String email, String genero,
//			String nombre, String telefono) {
//		super();
//		this.apellido = apellido;
//		this.dirrecion = dirrecion;
//		this.dui = dui;
//		this.email = email;
//		this.genero = genero;
//		this.nombre = nombre;
//		this.telefono = telefono;
//	}
	
	

	public Cliente( String nombre,String apellido, String telefono,String dui,String email,String dirrecion,String genero) {
		super();
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.dui = dui;
		this.email = email;
		this.dirrecion = dirrecion;
		this.genero = genero;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_cliente")
	public int getCodigoCliente() {
		return this.codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}


	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDirrecion() {
		return this.dirrecion;
	}

	public void setDirrecion(String dirrecion) {
		this.dirrecion = dirrecion;
	}


	public String getDui() {
		return this.dui;
	}

	public void setDui(String dui) {
		this.dui = dui;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}