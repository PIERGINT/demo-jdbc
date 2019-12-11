package fr.diginamic.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import fr.diginamic.jdbc.entites.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TestSelect {

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
		
		Statement perState = connect.createStatement();
		ResultSet curseur = perState.executeQuery("SELECT ID, NOM FROM FOURNISSEUR");
		
		ArrayList<Fournisseur> fournisseur = new ArrayList<>();
		
		while (curseur.next()) {
			Integer id = curseur.getInt("ID");
			String nom = curseur.getString("NOM");			
			Fournisseur fournisseurCourant = new Fournisseur(id, nom);
			fournisseur.add(fournisseurCourant);
			
			System.out.println(fournisseurCourant.toString());
			}
		
		curseur.close();
		connect.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		System.out.println("Connection failed");
		
		
	}
}
}