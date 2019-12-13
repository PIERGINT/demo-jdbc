package fr.diginamic.props;

import java.sql.DriverManager;

import org.mariadb.jdbc.Driver;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ResourceBundle;
import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;

public class TestConnexionJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				
				System.out.println("Driver chargé");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				System.out.println("Unloaded");
			}
			
			ResourceBundle cle1 = ResourceBundle.getBundle("Pierredatafiles");
			String urlName = cle1.getString("Pierredatafiles.url");
		
			ResourceBundle cle2 = ResourceBundle.getBundle("Pierredatafiles");
			String userName = cle2.getString("Pierredatafiles.user");
			
			ResourceBundle cle3 = ResourceBundle.getBundle("Pierredatafiles");
			String password = cle3.getString("Pierredatafiles.password");
			
			try {
			Connection connect = DriverManager.getConnection(urlName,userName,password);
			
			System.out.println("Connected");
			
			connect.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println("Connection failed");
			
			
		}
	}
}
