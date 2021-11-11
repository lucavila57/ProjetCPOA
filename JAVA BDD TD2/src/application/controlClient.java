package application;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import modele.metier.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

public class controlClient implements Initializable {

	private boolean creer;
	private boolean maj;
	public static int idCl;

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
	private Label lbl_recap;
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
		TableColumn<Client, String> colPrenom = new TableColumn<>("Prenom");
		TableColumn<Client, String> colNoRue = new TableColumn<>("No de rue");
		TableColumn<Client, String> colVoie = new TableColumn<>("Voie");
		TableColumn<Client, String> colCdePostal = new TableColumn<>("Code Postal");
		TableColumn<Client, String> colVille = new TableColumn<>("Code Ville");
		TableColumn<Client, String> colPays = new TableColumn<>("Code Pays");

		colIdClient.setCellValueFactory(new PropertyValueFactory<Client, String>("idCl"));
		colNom.setCellValueFactory(new PropertyValueFactory<Client, String>("nom"));
		colPrenom.setCellValueFactory(new PropertyValueFactory<Client, String>("prenom"));
		colNoRue.setCellValueFactory(new PropertyValueFactory<Client, String>("noRue"));
		colVoie.setCellValueFactory(new PropertyValueFactory<Client, String>("voie"));
		colCdePostal.setCellValueFactory(new PropertyValueFactory<Client, String>("codePostal"));
		colVille.setCellValueFactory(new PropertyValueFactory<Client, String>("ville"));
		colPays.setCellValueFactory(new PropertyValueFactory<Client, String>("pays"));

		tblClient.getColumns().setAll(colIdClient, colNom, colPrenom, colNoRue, colVoie, colCdePostal, colVille,
				colPays);

		List<Client> clients = controlAccueil.daoClient.findAll();

		tblClient.getItems().addAll(clients);
		return tblClient;

	}

	@Override
	public String toString() {
		if (creer)
			return "Ajout de : " + txt_nom.getText().trim() + " " + txt_prenom.getText().trim();
		else if (maj)
			return "Modifiction de : " + txt_nom.getText().trim() + " " + txt_prenom.getText().trim();
		else
			return "";
	}

	public void initialize(URL location, ResourceBundle resources) {
		try {
			tblClient();
		} catch (Exception e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("Probleme a l'initialisation");
			alert.setHeaderText("Un probleme est survenue lors de l'initialisation de vos Clients");
			alert.setContentText(e.toString());
			alert.showAndWait();
		}
	}

	@FXML
	public void valider() throws Exception {
		if ((txt_nom.getText().trim().isEmpty()) || (txt_prenom.getText().trim().isEmpty())
				|| (txt_no_rue.getText().trim().isEmpty()) || (txt_voie.getText().trim().isEmpty())
				|| (txt_codePostal.getText().trim().isEmpty()) || (txt_ville.getText().trim().isEmpty())
				|| (txt_pays.getText().trim().isEmpty())) {
			lbl_recap.setText("Les champs ne sont pas tous valides");

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("Erreur lors de la saisie");
			alert.setHeaderText("Un ou plusieurs champs sont mal remplis.");
			alert.showAndWait();
		}

		else if (creer) {
			try {
				String nom = txt_nom.getText().trim();
				String prenom = txt_prenom.getText().trim();
				String noRue = txt_no_rue.getText().trim();
				String voie = txt_voie.getText().trim();
				String codePostal = txt_codePostal.getText().trim();
				String ville = txt_ville.getText().trim();
				String pays = txt_pays.getText().trim();

				controlAccueil.daoClient.create(new Client(nom, prenom, noRue, voie, codePostal, ville, pays));
				lbl_recap.setText(toString());

			} catch (Exception e) {
				lbl_recap.setText("");
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.initOwner(vue);
				alert.setTitle("La creation a echouee");
				alert.setHeaderText("Un probleme est survenue lors de la creation de votre Periode");
				alert.setContentText(e.toString());
				alert.showAndWait();
			}
		}

		else if (maj) {
			try {
				String nom = txt_nom.getText().trim();
				String prenom = txt_prenom.getText().trim();
				String noRue = txt_no_rue.getText().trim();
				String voie = txt_voie.getText().trim();
				String codePostal = txt_codePostal.getText().trim();
				String ville = txt_ville.getText().trim();
				String pays = txt_pays.getText().trim();
				lbl_recap.setText(toString());
				controlAccueil.daoClient.update(new Client(tblClient.getSelectionModel().getSelectedItem().getIdCl(),
						nom, prenom, noRue, voie, codePostal, ville, pays));

			} catch (Exception e) {
				lbl_recap.setText("");
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.initOwner(vue);
				alert.setTitle("La modification a echouee");
				alert.setHeaderText("Un probleme est survenue lors de la modification de votre Client");
				alert.setContentText(e.toString());
				alert.showAndWait();
			}
		}
		creer = false;
		maj = false;
		List<Client> client = controlAccueil.daoClient.findAll();
		tblClient.getItems().clear();
		tblClient.getItems().addAll(client);

		form.setDisable(true);
		btn_valider.setDisable(true);
	}

	@FXML
	public void create() throws Exception {
		form.setDisable(false);
		btn_valider.setDisable(false);

		txt_nom.setText("");
		txt_prenom.setText("");
		txt_no_rue.setText("");
		txt_voie.setText("");
		txt_codePostal.setText("");
		txt_ville.setText("");
		txt_pays.setText("");

		creer = true;
		maj = false;
	}

	@FXML
	public void delete() throws Exception {
		try {
			controlAccueil.daoClient.delete(tblClient.getSelectionModel().getSelectedItem());
			List<Client> clients = controlAccueil.daoClient.findAll();
			tblClient.getItems().clear();
			tblClient.getItems().addAll(clients);
		} catch (Exception e) {
			lbl_recap.setText("");
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("Un probleme est survenue lors de la suppression de votre client");
			alert.setHeaderText("Aucun Client selectionne");
			alert.setContentText(e.toString());
			alert.showAndWait();
		}
	}

	@FXML
	public void update() throws Exception {
		try {
			Client client = tblClient.getSelectionModel().getSelectedItem();

			txt_nom.setText(client.getNom().trim());
			txt_prenom.setText(client.getPrenom().trim());
			txt_no_rue.setText(client.getNoRue().trim());
			txt_voie.setText(client.getVoie().trim());
			txt_codePostal.setText(client.getCodePostal().trim());
			txt_ville.setText(client.getVille().trim());
			txt_pays.setText(client.getPays().trim());

			form.setDisable(false);
			btn_valider.setDisable(false);

			creer = false;
			maj = true;
		} catch (Exception e) {
			lbl_recap.setText("");
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("Un probleme est survenue lors de la modification de votre Client");
			alert.setHeaderText("Aucun Client selectionne");
			alert.setContentText(e.toString());
			alert.showAndWait();
		}
	}

	@FXML
	public void retour() throws IOException {
		controlAccueil.daoClient = null;
		controlAccueil.daoAbo = null;
		controlAccueil.daoRevue = null;

		Stage stage = (Stage) btn_retour.getScene().getWindow();
		stage.close();
		Stage stage1 = new Stage();

		URL fxmlURL = getClass().getResource("vue/fenetre.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
		Node root = fxmlLoader.load();
		Scene scene = new Scene((VBox) root, 498.0, 112.0);

		stage1.setScene(scene);
		stage1.setTitle("Accueil");
		stage1.show();
	}
}