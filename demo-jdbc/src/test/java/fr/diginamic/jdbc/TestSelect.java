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
import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;

public class TestSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FournisseurDaoJdbc fdao = new FournisseurDaoJdbc();
		List<Fournisseur> values = fdao.extraire();
		
		for (List<Fournisseur> val : values ) {
			System.out.println(val);
		}
	}
}