package application;

import java.awt.Label;
import java.awt.TextField;
import java.io.IOException;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import modele.metier.Client;


public class controlClient implements Initializable{

	private boolean b_create;
	private boolean b_update;
	public static int id_cli;
	
	@FXML
	private TextField txt_nom;
	@FXML
	private TextField txt_prenom;
	@FXML
	private TextField txt_no_rue;
	@FXML
	private TextField txt_voie;
	@FXML
	private TextField txt_codePostal;
	@FXML
	private TextField txt_ville;
	@FXML
	private TextField txt_pays;
	@FXML
	private Label affichage;
	@FXML
	private Button btn_creer;
	@FXML
	private Button btn_modifier;
	@FXML
	private Button btn_supprimer;
	@FXML
	private Button btn_valider;
	@FXML
	private Button btn_retour;
	@FXML
	private GridPane form;
	@FXML
	private TableView<Client> tblClient;
	@FXML
	private Window vue;
	
	@SuppressWarnings("unchecked")
	public TableView<Client> tblClient() throws Exception {

		TableColumn<Client, String> colIdClient = new TableColumn<>("id_Client");
		TableColumn<Client, String> colNom = new TableColumn<>("Nom");
		TableColumn<Client, String> colPrenom = new TableColumn<>("Prénom");
		TableColumn<Client, String> colNoRue = new TableColumn<>("No de rue");
		TableColumn<Client, String> colVoie = new TableColumn<>("Voie");
		TableColumn<Client, String> colCdePostal = new TableColumn<>("Code Postal");
		TableColumn<Client, String> colVille = new TableColumn<>("Code Ville");
		TableColumn<Client, String> colPays = new TableColumn<>("Code Pays");

		colIdClient.setCellValueFactory(new PropertyValueFactory<Client, String>("id_client"));
		colNom.setCellValueFactory(new PropertyValueFactory<Client, String>("nom"));
		colPrenom.setCellValueFactory(new PropertyValueFactory<Client, String>("prenom"));
		colNoRue.setCellValueFactory(new PropertyValueFactory<Client, String>("no_rue"));
		colVoie.setCellValueFactory(new PropertyValueFactory<Client, String>("voie"));
		colCdePostal.setCellValueFactory(new PropertyValueFactory<Client, String>("code_postal"));
		colVille.setCellValueFactory(new PropertyValueFactory<Client, String>("ville"));
		colPays.setCellValueFactory(new PropertyValueFactory<Client, String>("pays"));

		tblClient.getColumns().setAll(colIdClient, colNom, colPrenom, colNoRue, colVoie, colCdePostal, colVille, colPays );

		List<Client> clients = controlAccueil.daocli.findAll();
		
		tblClient.getItems().addAll(clients);
		return tblClient;

	}
	
	@Override
	public String toString() {
		if(b_create) return "Ajout de : " + txt_nom.getText().trim() +" "+ txt_prenom.getText().trim();
		else if(b_update) return "Modifiction de : "+ txt_nom.getText().trim() +" "+ txt_prenom.getText().trim();
		else return "";
	}	

	public void initialize(URL location, ResourceBundle resources) {
		try {
			tblClient();
		} 
		catch (Exception e) {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("Probleme a l'initialisation");
			alert.setHeaderText("Un probleme est survenue lors de l'initialisation de vos Clients");
			alert.setContentText(e.toString());
			alert.showAndWait();
		}
	}
	
	@FXML
	public void valider() throws Exception{
		if ((txt_nom.getText().trim().isEmpty()) || (txt_prenom.getText().trim().isEmpty())
				|| (txt_no_rue.getText().trim().isEmpty()) || (txt_voie.getText().trim().isEmpty()) || (txt_codePostal.getText().trim().isEmpty()) || 
				(txt_ville.getText().trim().isEmpty()) || (txt_pays.getText().trim().isEmpty())) {			
			affichage.setText("Les champs ne sont pas tous valides");

			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("Erreur lors de la saisie");
			alert.setHeaderText("Un ou plusieurs champs sont mal remplis.");
			alert.showAndWait();
		}
		
		else if(b_create) {
			try {
				String nom = txt_nom.getText().trim();
				String prenom = txt_prenom.getText().trim();
				String no_rue = txt_no_rue.getText().trim();
				String voie = txt_voie.getText().trim();
				String codePostal = txt_codePostal.getText().trim();
				String ville = txt_ville.getText().trim();
				String pays = txt_pays.getText().trim();

			    controlAccueil.daocli.create(new Client(nom, prenom, no_rue, voie, codePostal, ville, pays ));
				affichage.setText(toString());

			} 
			catch (Exception e) {
				affichage.setText("");
				Alert alert=new Alert(Alert.AlertType.ERROR);
				alert.initOwner(vue);
				alert.setTitle("La creation a echouee");
				alert.setHeaderText("Un probleme est survenue lors de la creation de votre Periode");
				alert.setContentText(e.toString());
				alert.showAndWait();
			}			
		}
		
		else if(b_update) {
			try {
				String nom = txt_nom.getText().trim();
				String prenom = txt_prenom.getText().trim();
				String no_rue = txt_no_rue.getText().trim();
				String voie = txt_voie.getText().trim();
				String codePostal = txt_codePostal.getText().trim();
				String ville = txt_ville.getText().trim();
				String pays = txt_pays.getText().trim();

				controlAccueil.daocli.update(new Client(tblClient.getSelectionModel().getSelectedItem().getIdCl(),nom, prenom, no_rue, voie, codePostal,ville,pays ));
				affichage.setText(toString());
			} 
			catch (Exception e) {
				affichage.setText("");
				Alert alert=new Alert(Alert.AlertType.ERROR);
				alert.initOwner(vue);
				alert.setTitle("La modification a echouee");
				alert.setHeaderText("Un probleme est survenue lors de la modification de votre Client");
				alert.setContentText(e.toString());
				alert.showAndWait();
			}
		}
		b_create=false;
		b_update=false;
		List<Client> client = controlAccueil.daocli.findAll();
		tblClient.getItems().clear();
		tblClient.getItems().addAll(client); 
		
		form.setDisable(true);
		btn_valider.setDisable(true);		
	}
	
	@FXML
	public void create() throws Exception{
		form.setDisable(false);
		btn_valider.setDisable(false);
		
		txt_nom.setText("");
		txt_prenom.setText("");
		txt_no_rue.setText("");
		txt_voie.setText("");
		txt_codePostal.setText("");
		txt_ville.setText("");
		txt_pays.setText("");
		
		b_create=true;
		b_update=false;
	}
	
	@FXML
	public void delete() throws Exception{
		try {
			controlAccueil.daocli.delete(tblClient.getSelectionModel().getSelectedItem()); 
			List<Client> clients = controlAccueil.daocli.findAll();
	        tblClient.getItems().clear();
	        tblClient.getItems().addAll(clients);
		} 
		catch (Exception e) {
			affichage.setText("");
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("Un probleme est survenue lors de la suppression de votre client");
			alert.setHeaderText("Aucun Client selectionne");
			alert.setContentText(e.toString());
			alert.showAndWait();
		}		
	}
	
	@FXML
	public void update() throws Exception{
		try {			
			Client client=tblClient.getSelectionModel().getSelectedItem();
						
			txt_nom.setText(client.getNom().trim());
			txt_prenom.setText(client.getPrenom().trim());
			txt_no_rue.setText(client.getNoRue().trim());
			txt_voie.setText(client.getVoie().trim());
			txt_codePostal.setText(client.getCodePostal().trim());
			txt_ville.setText(client.getVille().trim());
			txt_pays.setText(client.getPays().trim());
			
			form.setDisable(false);
			btn_valider.setDisable(false);
			
			b_create=false;
			b_update=true;
		}
		catch (Exception e) {
			affichage.setText("");
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("Un probleme est survenue lors de la modification de votre Client");
			alert.setHeaderText("Aucun Client selectionne");
			alert.setContentText(e.toString());
			alert.showAndWait();
		}
	}
	
	
	@FXML
	public void retour() throws IOException{
		controlAccueil.daocli=null;
		controlAccueil.daoabo=null;
		controlAccueil.daorev=null;
		
		Stage stage =(Stage) btn_retour.getScene().getWindow();
		stage.close();
		Stage stage1 = new Stage();
		
		URL fxmlURL = getClass().getResource("fenetres/fenetre.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
		Node root = fxmlLoader.load();
		Scene scene = new Scene((VBox) root, 498.0, 112.0);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		stage1.setScene(scene);
		stage1.setTitle("Accueil");
		stage1.show();
	}	
}