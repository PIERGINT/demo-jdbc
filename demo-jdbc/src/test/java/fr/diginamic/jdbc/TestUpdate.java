package fr.diginamic.jdbc;

import java.sql.DriverManager;
import org.mariadb.jdbc.Driver;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import java.sql.Statement;
import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

public class TestUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FournisseurDaoJdbc fdao = new FournisseurDaoJdbc();
		
		fdao.update("Bricoleurs du Sud","Bricoleurs du Languedoc");
}
}
	
