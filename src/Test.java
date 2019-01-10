import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.CategoriaDAO;
import dao.ConexionDB;
import model.Categoria;
public class Test {
	public static void main(String args[]) throws IOException, ClassNotFoundException{
		try {
			
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://25.82.80.3:5432/ebiblioteca","postgres","x"); /* 192.168.1.66 */
						
			
		//String SQL = "SELECT codigo, nombre FROM categorias;";
		
		//Connection con = ConexionDB.conectar();
		
		//PreparedStatement st = con.prepareStatement(SQL);
		Statement st = con.createStatement();
		
		ResultSet rt = st.executeQuery("SELECT * FROM categorias;");
		//st.setString(1, cat.getNombre());
		
		//ResultSet rt = st.executeQuery(SQL);
		
		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		
		Categoria cat;
		
		while (rt.next()) {
			
		cat = new Categoria ();
		cat.setCodigo(rt.getInt("codigo"));
		cat.setNombre(rt.getString("nombre"));
		
		lista.add(cat);
		System.out.println(lista.add(cat));
		
		}
		
		
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
	}
	
}
