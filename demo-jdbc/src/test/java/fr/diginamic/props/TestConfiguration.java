package fr.diginamic.props;

import java.util.ResourceBundle;
import java.util.Set;

public class TestConfiguration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResourceBundle cle1 = ResourceBundle.getBundle("Pierre");
		String driverName = cle1.getString("Pierre.driver");
		
		System.out.println("drivername");
		
		ResourceBundle http = ResourceBundle.getBundle("Pierre");
		String adresse = http.getString("Pierre.url");
		
		System.out.println("adresse");
		
		Set<String> valeurs= cle1.keySet();
		for (String val: valeurs) {
			
			driverName = cle1.getString(val);
			
			System.out.println(driverName);
		}
	}
	

}
