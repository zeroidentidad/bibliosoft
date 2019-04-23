package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.IOException;
import dao.ConexionDB;

import model.Categoria;

public class CategoriaDAO {
		
	
	public static boolean registrar(Categoria cat) throws IOException {
					
		try {
		
		String SQL = "INSERT INTO categorias(nombre) VALUES (?);";
		
		Connection con =ConexionDB.conectar();
		
		PreparedStatement st;
		
		st = con.prepareStatement(SQL);
		
		st.setString(1, cat.getNombre());
		
		if(st.executeUpdate()>0) {
			return true;
		} else {return false;}
		
		} catch (SQLException e) {
			return false;
		}
		
	}
	
	public static ArrayList<Categoria> listar() throws IOException {
					
		try {
		
		//String SQL = "SELECT codigo, nombre FROM categorias;";
		Connection con = ConexionDB.conectar();
		//PreparedStatement st = con.prepareStatement(SQL);
		//st.setString(1, cat.getNombre());
		//ResultSet rt = st.executeQuery(SQL);
		
		Statement st = con.createStatement();
		ResultSet rt = st.executeQuery("SELECT * FROM categorias;");
		
		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		
		Categoria cat;
		
		while (rt.next()) {
			
		cat = new Categoria ();
		cat.setCodigo(rt.getInt("codigo"));
		cat.setNombre(rt.getString("nombre"));
		
		lista.add(cat);
		
		}
		
		return lista;
		
		} catch (SQLException e) {
			return null;
		}
		
	}
	
	public static String getCategoria(int codigo) throws IOException {
		
		try {
		
		String SQL = "SELECT nombre FROM categorias WHERE codigo=?";
		Connection con = ConexionDB.conectar();
		PreparedStatement st = con.prepareStatement(SQL);
		st.setInt(1, codigo);
		ResultSet rt = st.executeQuery();
		
		/*Statement st = con.createStatement();
		ResultSet rt = st.executeQuery("SELECT nombre FROM categorias WHERE codigo=?");*/
		
		if (rt.next()) {
			return rt.getString("nombre");
		}
		
		return "- Sin editorial -";
		
		} catch (SQLException e) {
			return "- SQLException -";
		}
		
	}	

}
