package application;

import java.io.IOException;


import java.net.URL;
import java.util.ResourceBundle;

import dao.AbonnementDAO;
import dao.ClientDAO;
import dao.DAOFactory;
import dao.PeriodiciteDAO;
import dao.Persistance;
import dao.RevueDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

public class controlAccueil implements Initializable {
	
	public static ClientDAO daocli;
	public static PeriodiciteDAO daoper;
	public static RevueDAO daorev;
	public static AbonnementDAO daoabo;
	
	@FXML
	private RadioButton mysql;
	@FXML
	private RadioButton list;
	@FXML
	private Button Client;
	@FXML
	private Button Abonnement;
	@FXML
	private Button Periodicite;
	@FXML
	private Button Revue;
	@FXML
	private Window vue;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	@FXML
	public void Periodicite() throws IOException {
		if (mysql.isSelected()) {
			daoper = DAOFactory.getDAOFactory(Persistance.MYSQL).getPeriodiciteDAO();
		} 
		else if (list.isSelected()) {
			daoper = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE).getPeriodiciteDAO();
		}
		else {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("Erreur lors de l'acces a Periode");
			alert.setHeaderText("Aucune persistance selectionnee");
			alert.showAndWait();
		}		
		
		if (daoper!=null) {
			Stage stage =(Stage) Periodicite.getScene().getWindow();
			stage.close();
			Stage stage1 = new Stage();
			
			URL fxmlURL = getClass().getResource("fenetres/fenetre_ajout_periodicite.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Node root = fxmlLoader.load();
			Scene scene = new Scene((VBox) root, 625.0, 322.0);
			
			
			stage1.setScene(scene);
			stage1.setTitle("Gestion des Periodicite");
			stage1.show();
		}
	}
	
	@FXML
	public void Abonnement() throws IOException {
		if (mysql.isSelected()) {
			daoabo = DAOFactory.getDAOFactory(Persistance.MYSQL).getAbonnementDAO();
			daocli = DAOFactory.getDAOFactory(Persistance.MYSQL).getClientDAO();
			daorev = DAOFactory.getDAOFactory(Persistance.MYSQL).getRevueDAO();
		} 
		else if (list.isSelected()) {
			daoabo = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE).getAbonnementDAO();
			daocli = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE).getClientDAO();
			daorev = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE).getRevueDAO();
		}
		else {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("Erreur lors de l'acces a Abonnement");
			alert.setHeaderText("Aucune persistance selectionnee");
			alert.showAndWait();
		}		
		
		if (daoabo!=null) {
			Stage stage =(Stage) Abonnement.getScene().getWindow();
			stage.close();
			Stage stage1 = new Stage();
			
			URL fxmlURL = getClass().getResource("fenetres/fenetre_ajout_abonnement.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Node root = fxmlLoader.load();
			Scene scene = new Scene((VBox) root, 705.0, 600.0);
			
			
			stage1.setScene(scene);
			stage1.setTitle("Gestion des Abonnements");
			stage1.show();
		}
	}

	@FXML
	public void Client() throws IOException {
		if (mysql.isSelected()) {
			daocli = DAOFactory.getDAOFactory(Persistance.MYSQL).getClientDAO();
			daoabo = DAOFactory.getDAOFactory(Persistance.MYSQL).getAbonnementDAO();
			daorev = DAOFactory.getDAOFactory(Persistance.MYSQL).getRevueDAO();
		} 
		else if (list.isSelected()) {
			daocli = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE).getClientDAO();
			daoabo = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE).getAbonnementDAO();
			daorev = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE).getRevueDAO();
		}
		else {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("Erreur lors de l'acces a Client");
			alert.setHeaderText("Aucune persistance selectionnee");
			alert.showAndWait();
		}	
		
		if (daocli!=null) {
			Stage stage =(Stage) Client.getScene().getWindow();
			stage.close();
			Stage stage1 = new Stage();
			
			URL fxmlURL = getClass().getResource("fenetres/fenetre_ajout_client.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Node root = fxmlLoader.load();
			Scene scene = new Scene((VBox) root, 758.0, 636.0);
		
			
			stage1.setScene(scene);
			stage1.setTitle("Gestion des Clients");
			stage1.show();
		}
	}
	
	@FXML
	public void Revue() throws IOException {
		if (mysql.isSelected()) {
			daorev = DAOFactory.getDAOFactory(Persistance.MYSQL).getRevueDAO();
			daoper = DAOFactory.getDAOFactory(Persistance.MYSQL).getPeriodiciteDAO();
			daoabo = DAOFactory.getDAOFactory(Persistance.MYSQL).getAbonnementDAO();
		} 
		else if (list.isSelected()) {
			daorev = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE).getRevueDAO();
			daoper = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE).getPeriodiciteDAO();
			daoabo = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE).getAbonnementDAO();
		}
		else {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("Erreur lors de l'acces a Revue");
			alert.setHeaderText("Aucune persistance selectionnee");
			alert.showAndWait();
		}		
		
		if (daorev!=null) {
			Stage stage =(Stage) Revue.getScene().getWindow();
			stage.close();
			Stage stage1 = new Stage();
			
			URL fxmlURL = getClass().getResource("vue/Main3.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Node root = fxmlLoader.load();
			Scene scene = new Scene((VBox) root, 900.0, 623.0);
			
			
			stage1.setScene(scene);
			stage1.setTitle("Gestion des revues");
			stage1.show();
			
		}					
	}
}
