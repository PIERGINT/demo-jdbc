package fr.diginamic.jdbc.entites;

public class Fournisseur {
	int id;
	String nom;
	
	public Fournisseur(int id, String nom) {
		this.id= id;
		this.nom= nom;
	}
	public String toString(){
		return " ID :"+id + " NOM :"+ nom ;
}
}
