package model;

import java.io.Serializable;

public class Editorial implements Serializable{

	  private String nid;
	  private String nombre;
	  private String telefono;
	  private String direccion;
	  private String email;
	  private String sitioweb;
	  
	public Editorial() {
		this.nid = "";
		this.nombre = "";
		this.telefono = "";
		this.direccion = "";
		this.email = "";
		this.sitioweb = "";
	}	  
	  
	public Editorial(String nid, String nombre, String telefono, String direccion, String email, String sitioweb) {
		this.nid = nid;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
		this.sitioweb = sitioweb;
	}
	
	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSitioweb() {
		return sitioweb;
	}

	public void setSitioweb(String sitioweb) {
		this.sitioweb = sitioweb;
	}	

}
