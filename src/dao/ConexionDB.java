package dao;

import java.sql.DriverManager;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionDB {
	
	public static Connection conectar() throws IOException{
		
		//FileInputStream fis=new FileInputStream("db.properties");
		InputStream fis = ConexionDB.class.getResourceAsStream("db.properties");		
		Properties p=new Properties ();
		p.load (fis);
		
        String usuario= (String) p.get ("usuario"); 
        String contrasena= (String) p.get ("contrasena"); 
        String iphost= (String) p.get ("iphost");
        String puerto= (String) p.get ("puerto");
        String namedb= (String) p.get ("namedb");
		
			try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://"+iphost+":"+puerto+"/"+namedb+"",usuario,contrasena); 
			} catch (ClassNotFoundException e) {
			return null;			
			} catch (SQLException e) {
			return null;
			}	
		
		
	}
       
}