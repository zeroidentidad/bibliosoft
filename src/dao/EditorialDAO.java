package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Editorial;

public class EditorialDAO {

	public static boolean registrar(Editorial edi) throws IOException {
		
		try {
		
		String SQL = "INSERT INTO editoriales (nid,nombre,telefono,direccion,email,sitioweb) VALUES (?,?,?,?,?,?);";
		
		Connection con =ConexionDB.conectar();
		
		PreparedStatement st;
		
		st = con.prepareStatement(SQL);
		
		st.setString(1, edi.getNid());
		st.setString(2, edi.getNombre());
		st.setString(3, edi.getTelefono());
		st.setString(4, edi.getDireccion());
		st.setString(5, edi.getEmail());
		st.setString(6, edi.getSitioweb());
		
		if(st.executeUpdate()>0) {
			return true;
		} else {return false;}
		
		} catch (SQLException e) {
			return false;
		}
		
	}
	
	public static ArrayList<Editorial> listar() throws IOException {
					
		try {
		
		//String SQL = "SELECT * FROM editoriales;";
		Connection con = ConexionDB.conectar();
		//PreparedStatement st = con.prepareStatement(SQL);
		//st.setString(1, edi.getNombre());
		//ResultSet rt = st.executeQuery(SQL);
		
		Statement st = con.createStatement();
		ResultSet rt = st.executeQuery("SELECT * FROM editoriales;");		
		
		ArrayList<Editorial> lista = new ArrayList<Editorial>();
		
		Editorial edi;
		
		while (rt.next()) {
			
		edi = new Editorial ();
		edi.setNid(rt.getString("nid"));
		edi.setNombre(rt.getString("nombre"));
		edi.setTelefono(rt.getString("telefono"));
		edi.setDireccion(rt.getString("direccion"));
		edi.setEmail(rt.getString("email"));
		edi.setSitioweb(rt.getString("sitioweb"));
		
		lista.add(edi);
		
		}
		
		return lista;
		
		} catch (SQLException e) {
			return null;
		}
		
	}	
	
	public static String getEditorial(String nid) throws IOException {
		
		try {
		
		String SQL = "SELECT nombre FROM editoriales WHERE nid=?";
		Connection con = ConexionDB.conectar();
		PreparedStatement st = con.prepareStatement(SQL);
		st.setString(1, nid);
		ResultSet rt = st.executeQuery();
		
		/*Statement st = con.createStatement();
		ResultSet rt = st.executeQuery("SELECT nombre FROM editoriales WHERE nid=?");*/
		
		if (rt.next()) {
			return rt.getString("nombre");
		}
		
		return "- Sin editorial -";
		
		} catch (SQLException e) {
			return "- SQLException -";
		}
		
	}	
		
}
