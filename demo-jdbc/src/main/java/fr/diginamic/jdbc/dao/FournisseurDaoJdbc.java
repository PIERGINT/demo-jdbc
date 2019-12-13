package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public class FournisseurDaoJdbc implements FournisseurDao {

	ResourceBundle fichier = ResourceBundle.getBundle("Pierredatafiles");
	String urlName = fichier.getString("Pierredatafiles.url");
	String userName = fichier.getString("Pierredatafiles.user");
	String password = fichier.getString("Pierredatafiles.password");

	Connection connect = null;
	Statement perState = null;
	ResultSet curseur = null;
	Fournisseur fournisseur = null;

	Integer id;
	String nom;

	public FournisseurDaoJdbc() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");

			System.out.println("Driver chargé");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			System.out.println("Unloaded");
		}
	};

	public void insertConnect() {
		try {
			if (connect == null || connect.isClosed()) {

				connect = DriverManager.getConnection(urlName, userName, password);
				System.out.println("Connected");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("La connexion a échoué");

		}
		

	}

	@SuppressWarnings("finally")
	@Override
	public List<Fournisseur> extraire() {

		insertConnect();
		ArrayList<Fournisseur> fournisseur = new ArrayList<>();
		try {
			perState = connect.createStatement();
			curseur = perState.executeQuery("SELECT ID, NOM FROM FOURNISSEUR");

			

			while (curseur.next()) {
				id = curseur.getInt("ID");
				nom = curseur.getString("NOM");
				Fournisseur fournisseurCourant = new Fournisseur(id, nom);
				fournisseur.add(fournisseurCourant);
				
			}
		}

		finally {
			try {
				if (connect != null) {

					connect.close();
				}
			} catch (SQLException e0) {
				// TODO Auto-generated catch block

				System.out.println("Problème Fermeture Connexion");

				try {
					if (perState != null) {

						perState.close();
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block

					System.out.println("Problème Fermeture Statement");

				}
				try {
					if (curseur != null) {

						curseur.close();
					}

				} catch (SQLException e2) {
					// TODO Auto-generated catch block

					System.out.println("Problème Curseur");

				}
			}
			return fournisseur;
		}

	}

	@Override
	public void insert(Fournisseur fournisseur) {

		insertConnect();

		int nb;
		try {
			perState = connect.createStatement();
			nb = perState.executeUpdate("INSERT INTO FOURNISSEUR (ID,NOM) VALUES (" + fournisseur.getId() + ",'"
					+fournisseur.getNom() + "'");

			System.out.println(nb);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Aucune ligne n'a pu être insérée");
		} finally {

			try {
				if (perState != null) {

					perState.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block

				System.out.println("Problème Statement");

			}

			try {
				if (connect != null) {

					connect.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Connection failed");

			}

		}

	}

	@SuppressWarnings("finally")
	@Override
	public int update(String ancienNom, String nouveauNom) {
		insertConnect();

		int nb = 0;
		try {
			perState = connect.createStatement();
			nb = perState.executeUpdate("UPDATE FOURNISSEUR SET NOM ='"+ nouveauNom+"' WHERE NOM = '"+ancienNom+"'");
			System.out.println("Nombre de lignes mises à jour" + nb);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			System.out.println("Mise à jour impossible");
		}

		finally {
			try {
				if (perState != null) {

					perState.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block

				System.out.println("Problème Statement");

			}
			try {
				if (connect != null) {

					connect.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block

				System.out.println("Connection failed");

			}

			return nb;
		}
	}

	@Override
	public boolean delete(Fournisseur fournisseur) {
		insertConnect();
		
		int nb = 0;
		try {
			perState = connect.createStatement();
			nb = perState.executeUpdate("DELETE FROM FOURNISSEUR WHERE NOM ='"+ fournisseur.getNom()+"'");
			System.out.println("Nombre de lignes mises à jour" + nb);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			System.out.println("Suppression impossible");
		}

		finally {
			try {
				if (perState != null) {

					perState.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block

				System.out.println("Problème Statement");

			}
			try {
				if (connect != null) {

					connect.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block

				System.out.println("Connection failed");

			}

		
		
	}

		return true;

}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
