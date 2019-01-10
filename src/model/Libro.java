package model;

import java.io.Serializable;

public class Libro implements Serializable{
	
	  private String isbn;
	  private String titulo;
	  private String descripcion;
	  private String nombre_autor;
	  private String fecha_publicacion;
	  private String fecha_registro;
	  private int codigo_categoria;
	  private String nid_editorial;	
	  
public Libro() {
	this.isbn = "";
	this.titulo = "";
	this.descripcion = "";
	this.nombre_autor = "";
	this.fecha_publicacion = "";
	this.fecha_registro = "";
	this.codigo_categoria = 0;
	this.nid_editorial = "";	
}

public Libro(String isbn, String titulo, String descripcion, String nombre_autor, String fecha_publicacion,
			 String fecha_registro, int codigo_categoria, String nid_editorial) {
	this.isbn = isbn;
	this.titulo = titulo;
	this.descripcion = descripcion;
	this.nombre_autor = nombre_autor;
	this.fecha_publicacion = fecha_publicacion;
	this.fecha_registro = fecha_registro;
	this.codigo_categoria = codigo_categoria;
	this.nid_editorial = nid_editorial;
}

public String getIsbn() {
	return isbn;
}

public void setIsbn(String isbn) {
	this.isbn = isbn;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public String getNombre_autor() {
	return nombre_autor;
}

public void setNombre_autor(String nombre_autor) {
	this.nombre_autor = nombre_autor;
}

public String getFecha_publicacion() {
	return fecha_publicacion;
}

public void setFecha_publicacion(String fecha_publicacion) {
	this.fecha_publicacion = fecha_publicacion;
}

public String getFecha_registro() {
	return fecha_registro;
}

public void setFecha_registro(String fecha_registro) {
	this.fecha_registro = fecha_registro;
}

public int getCodigo_categoria() {
	return codigo_categoria;
}

public void setCodigo_categoria(int codigo_categoria) {
	this.codigo_categoria = codigo_categoria;
}

public String getNid_editorial() {
	return nid_editorial;
}

public void setNid_editorial(String nid_editorial) {
	this.nid_editorial = nid_editorial;
}	  

}
