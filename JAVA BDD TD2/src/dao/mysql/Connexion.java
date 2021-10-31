package dao.mysql;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Connexion {
	 private static Connexion instance;
	 public static Connexion getInstance() {
	 if (instance == null) {
	 instance = new Connexion();
	 }
	 return instance;
	 }
	 
	 private Connection maConnexion;
	
	
	 
	 
	 public Connection creeConnexion(){
	 Properties accesBdd = new Properties();
	 File fBdd = new File("properties");
	 try {
	 FileInputStream source = new FileInputStream(fBdd);
	 accesBdd.loadFromXML(source);
	 } catch (IOException ioe) {
	 ioe.printStackTrace();
	 }
	 
	 try {
		 if (maConnexion == null || maConnexion.isClosed()) {
		 maConnexion = DriverManager.getConnection(accesBdd.getProperty("url"),
				 accesBdd.getProperty("login"), accesBdd.getProperty("pass"));
		 }
		 } catch (SQLException sqle) {
		 System.out.println("Erreur connexion" +
		 sqle.getMessage());
		 }
		 return maConnexion;
		}
}

	