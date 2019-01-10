package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Libro;

public class LibroDAO {

	public static boolean registrar(Libro lib) throws IOException {
		
		try {
		
		String SQL = "INSERT INTO libros (isbn, titulo, descripcion, nombre_autor, fecha_publicacion, codigo_categoria, nid_editorial) VALUES (?,?,?,?,?,?,?);";
		
		Connection con =ConexionDB.conectar();
		
		PreparedStatement st;
		
		st = con.prepareStatement(SQL);
		
		st.setString(1,lib.getIsbn());
		st.setString(2,lib.getTitulo());
		st.setString(3,lib.getDescripcion());
		st.setString(4,lib.getNombre_autor());
		st.setString(5,lib.getFecha_publicacion());
		st.setInt(6,lib.getCodigo_categoria());
		st.setString(7,lib.getNid_editorial());
		
		if(st.executeUpdate()>0) {
			return true;
		} else {return false;}
		
		} catch (SQLException e) {
			return false;
		}
		
	}
	
	public static boolean actualizar(Libro lib) throws IOException {
		
		try {
		
		String SQL = "UPDATE libros set titulo=?, descripcion=?, nombre_autor=?, fecha_publicacion=?, codigo_categoria=?, nid_editorial=? where isbn=?;";
		
		Connection con =ConexionDB.conectar();
		
		PreparedStatement st;
		
		st = con.prepareStatement(SQL);
		
		st.setString(1,lib.getTitulo());
		st.setString(2,lib.getDescripcion());
		st.setString(3,lib.getNombre_autor());
		st.setString(4,lib.getFecha_publicacion());
		st.setInt(5,lib.getCodigo_categoria());
		st.setString(6,lib.getNid_editorial());
		st.setString(7,lib.getIsbn());
		
		if(st.executeUpdate()>0) {
			return true;
		} else {return false;}
		
		} catch (SQLException e) {
			return false;
		}
		
	}	
	
	public static boolean eliminar(Libro lib) throws IOException {
		
		try {
		
		String SQL = "DELETE FROM libros where isbn=?;";
		
		Connection con =ConexionDB.conectar();
		
		PreparedStatement st;
		
		st = con.prepareStatement(SQL);
		
		st.setString(1,lib.getIsbn());
		
		if(st.executeUpdate()>0) {
			return true;
		} else {return false;}
		
		} catch (SQLException e) {
			return false;
		}
		
	}	
	
	public static ArrayList<Libro> listar() throws IOException {
					
		try {
		
		//String SQL = "SELECT * FROM libros;";
		Connection con = ConexionDB.conectar();
		//PreparedStatement st = con.prepareStatement(SQL);
		//st.setString(1, edi.getNombre());
		//ResultSet rt = st.executeQuery(SQL);
		
		Statement st = con.createStatement();
		ResultSet rt = st.executeQuery("SELECT * FROM libros;");		
		
		ArrayList<Libro> lista = new ArrayList<Libro>();
		
		Libro lib;
		
		while (rt.next()) {
			
			lib = new Libro ();
			lib.setIsbn(rt.getString("isbn"));
			lib.setTitulo(rt.getString("titulo"));
			lib.setDescripcion(rt.getString("descripcion"));
			lib.setNombre_autor(rt.getString("nombre_autor"));
			lib.setFecha_publicacion(rt.getString("fecha_publicacion"));
			lib.setFecha_registro(rt.getString("fecha_registro"));
			lib.setCodigo_categoria(rt.getInt("codigo_categoria"));
			lib.setNid_editorial(rt.getString("nid_editorial"));
		
		lista.add(lib);
		
		}
		
		return lista;
		
		} catch (SQLException e) {
			return null;
		}
		
	}		
	
}
