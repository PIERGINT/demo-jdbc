package fr.diginamic.jdbc;

import java.sql.DriverManager;
import org.mariadb.jdbc.Driver;

import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import java.sql.Statement;

public class TestInsertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FournisseurDaoJdbc fdao = new FournisseurDaoJdbc();
		
		fdao.insert(new Fournisseur (5, "Ma petite entreprise"));
		
		
	}

}
