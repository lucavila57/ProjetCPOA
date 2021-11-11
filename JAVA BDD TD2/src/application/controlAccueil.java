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

	public static ClientDAO daoClient;
	public static PeriodiciteDAO daoPerio;
	public static RevueDAO daoRevue;
	public static AbonnementDAO daoAbo;

	@FXML
	private RadioButton mysql;
	@FXML
	private RadioButton listeMemoire;
	@FXML
	private Button btn_client;
	@FXML
	private Button btn_abonnement;
	@FXML
	private Button btn_periodicite;
	@FXML
	private Button btn_revue;
	@FXML
	private Window vue;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	public void Periodicite() throws IOException {
		if (mysql.isSelected()) {
			daoPerio = DAOFactory.getDAOFactory(Persistance.MYSQL).getPeriodiciteDAO();
		} else if (listeMemoire.isSelected()) {
			daoPerio = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE).getPeriodiciteDAO();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("Erreur lors de l'acces a Periode");
			alert.setHeaderText("Aucune persistance selectionnee");
			alert.showAndWait();
		}

		if (daoPerio != null) {
			Stage stage = (Stage) btn_periodicite.getScene().getWindow();
			stage.close();
			Stage stage1 = new Stage();

			URL fxmlURL = getClass().getResource("vue/vuePeriodicite.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Node root = fxmlLoader.load();
			Scene scene = new Scene((VBox) root, 625.0, 322.0);

			stage1.setScene(scene);
			stage1.setTitle("Gestion des Periodicite");
			stage1.show();
		}
	}

	@FXML
	public void Client() throws IOException {
		if (mysql.isSelected()) {
			daoClient = DAOFactory.getDAOFactory(Persistance.MYSQL).getClientDAO();
			daoAbo = DAOFactory.getDAOFactory(Persistance.MYSQL).getAbonnementDAO();
			daoRevue = DAOFactory.getDAOFactory(Persistance.MYSQL).getRevueDAO();
		} else if (listeMemoire.isSelected()) {
			daoClient = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE).getClientDAO();
			daoAbo = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE).getAbonnementDAO();
			daoRevue = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE).getRevueDAO();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("Erreur lors de l'acces a Client");
			alert.setHeaderText("Aucune persistance selectionnee");
			alert.showAndWait();
		}

		if (daoClient != null) {
			Stage stage = (Stage) btn_client.getScene().getWindow();
			stage.close();
			Stage stage1 = new Stage();

			URL fxmlURL = getClass().getResource("vue/vueClient.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Node root = fxmlLoader.load();
			Scene scene = new Scene((VBox) root, 758.0, 636.0);

			stage1.setScene(scene);
			stage1.setTitle("Gestion des Clients");
			stage1.show();
		}
	}

	@FXML
	public void Abonnement() throws IOException {
		if (mysql.isSelected()) {
			daoAbo = DAOFactory.getDAOFactory(Persistance.MYSQL).getAbonnementDAO();
			daoClient = DAOFactory.getDAOFactory(Persistance.MYSQL).getClientDAO();
			daoRevue = DAOFactory.getDAOFactory(Persistance.MYSQL).getRevueDAO();
		} else if (listeMemoire.isSelected()) {
			daoAbo = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE).getAbonnementDAO();
			daoClient = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE).getClientDAO();
			daoRevue = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE).getRevueDAO();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("Erreur lors de l'acces a Abonnement");
			alert.setHeaderText("Aucune persistance selectionnee");
			alert.showAndWait();
		}

		if (daoAbo != null) {
			Stage stage = (Stage) btn_abonnement.getScene().getWindow();
			stage.close();
			Stage stage1 = new Stage();

			URL fxmlURL = getClass().getResource("vue/vueAbonnement.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Node root = fxmlLoader.load();
			Scene scene = new Scene((VBox) root, 705.0, 600.0);

			stage1.setScene(scene);
			stage1.setTitle("Gestion des Abonnements");
			stage1.show();
		}
	}

	@FXML
	public void Revue() throws IOException {
		if (mysql.isSelected()) {
			daoRevue = DAOFactory.getDAOFactory(Persistance.MYSQL).getRevueDAO();
			daoPerio = DAOFactory.getDAOFactory(Persistance.MYSQL).getPeriodiciteDAO();
			daoAbo = DAOFactory.getDAOFactory(Persistance.MYSQL).getAbonnementDAO();
		} else if (listeMemoire.isSelected()) {
			daoRevue = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE).getRevueDAO();
			daoPerio = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE).getPeriodiciteDAO();
			daoAbo = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE).getAbonnementDAO();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("Erreur lors de l'acces a Revue");
			alert.setHeaderText("Aucune persistance selectionnee");
			alert.showAndWait();
		}

		if (daoRevue != null) {
			Stage stage = (Stage) btn_revue.getScene().getWindow();
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
