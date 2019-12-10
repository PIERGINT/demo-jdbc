package fr.diginamic.props;

import java.sql.DriverManager;
import org.mariadb.jdbc.Driver;
import java.sql.SQLException;
import java.sql.Connection;

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
			
			
		
		try {
			Connection connect = DriverManager.getConnection(
					"jdbc:mariadb://bhxqckbmk7uf6rhmvkob-mysql.services.clever-cloud.com:3306/bhxqckbmk7uf6rhmvkob",
					"ujwzpdfm288mqwtu", "o6wWk1KaV5OZ7lLalP9W");
			
			System.out.println("Connect");
			
			connect.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println();
			
			
		}
	}
}
