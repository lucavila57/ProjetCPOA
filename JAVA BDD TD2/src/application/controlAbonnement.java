package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

import modele.metier.Abonnement;
import modele.metier.Client;
import modele.metier.Revue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

public class controlAbonnement implements Initializable {

	private boolean creer = false;
	private boolean maj = false;
	// initialisation des boutons

	@FXML
	private ComboBox<Client> cbx_idClient;
	@FXML
	private ComboBox<Revue> cbx_idRevue;
	@FXML
	private DatePicker date_deb;
	@FXML
	private DatePicker date_fin;
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
	private TableView<Abonnement> tblAbonnement;
	@FXML
	private Window vue;

	// fin initialisation des boutons

	// tableView
	@SuppressWarnings("unchecked")
	public TableView<Abonnement> tblAbonnement() throws Exception {
		TableColumn<Abonnement, String> colDate_Deb = new TableColumn<>("date_debut");
		TableColumn<Abonnement, String> colDate_Fin = new TableColumn<>("date_fin");
		TableColumn<Abonnement, String> colIdClient = new TableColumn<>("id_client");
		TableColumn<Abonnement, String> colIdRevue = new TableColumn<>("id_revue");

		colDate_Deb.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("dateDeb"));
		colDate_Fin.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("dateFin"));
		colIdClient.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("idCl"));
		colIdRevue.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("id_revue"));
		tblAbonnement.getColumns().setAll(colIdClient, colIdRevue, colDate_Deb, colDate_Fin);

		List<Abonnement> abonnements = controlAccueil.daoAbo.findAll();

		tblAbonnement.getItems().addAll(abonnements);
		return tblAbonnement;
	}

	// fin tableView
	@Override
	public String toString() {
		if (creer)
			return "Ajout de : " + cbx_idClient.getSelectionModel().getSelectedItem().getNom().trim() + " "
					+ cbx_idRevue.getSelectionModel().getSelectedItem().getTitre().trim();
		else if (maj)
			return "Modifiction de : " + cbx_idClient.getSelectionModel().getSelectedItem().getNom().trim() + " "
					+ cbx_idRevue.getSelectionModel().getSelectedItem().getTitre().trim();
		else
			return "";
	}

	// initialisation
	public void initialize(URL location, ResourceBundle resources) {
		try {
			cbx_idRevue.setItems(FXCollections.observableArrayList(controlAccueil.daoRevue.findAll()));
			cbx_idClient.setItems(FXCollections.observableArrayList(controlAccueil.daoClient.findAll()));

			tblAbonnement();
		} catch (Exception e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("Probleme a l'initialisation");
			alert.setHeaderText("Un probleme est survenue lors de l'initialisation de vos Abonnements");
			alert.setContentText(e.toString());
			alert.showAndWait();
		}
	}

	// bouton valider
	@FXML
	public void valider() throws Exception {
		Client idCl = cbx_idClient.getValue();
		Revue idRevue = cbx_idRevue.getValue();

		if ((idCl == null) || (idRevue == null) || (date_deb.getChronology() == null)
				|| (date_fin.getChronology() == null)) {
			lbl_recap.setText("Les champs ne sont pas tous valides");

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("Erreur lors de la saisie");
			alert.setHeaderText("Un ou plusieurs champs sont mal remplis.");
			alert.showAndWait();
		} else if (creer) {

			try {

				LocalDate txt_date_deb = date_deb.getValue();
				LocalDate txt_date_fin = date_fin.getValue();

				controlAccueil.daoAbo
						.create(new Abonnement(txt_date_deb, txt_date_fin, idCl.getIdCl(), idRevue.getId_revue()));
				lbl_recap.setText(toString());
			} catch (Exception e) {
				lbl_recap.setText("");
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.initOwner(vue);
				alert.setTitle("La creation a echouee");
				alert.setHeaderText("Un probleme est survenue lors de la creation de votre Abonnement");
				alert.setContentText(e.toString());
				alert.showAndWait();
			}
		}

		else if (maj) {
			try {
				LocalDate txt_date_deb = date_deb.getValue();
				LocalDate txt_date_fin = date_fin.getValue();

				controlAccueil.daoAbo
						.update(new Abonnement(txt_date_deb, txt_date_fin, idCl.getIdCl(), idRevue.getId_revue()));
				lbl_recap.setText(toString());

			} catch (Exception e) {
				lbl_recap.setText("");
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.initOwner(vue);
				alert.setTitle("La modification a echouee");
				alert.setHeaderText("Un probleme est survenue lors de la modification de votre Abonnement");
				alert.setContentText(e.toString());
				alert.showAndWait();
			}
		}
		creer = false;
		maj = false;
		List<Abonnement> abonnement = controlAccueil.daoAbo.findAll();
		tblAbonnement.getItems().clear();
		tblAbonnement.getItems().addAll(abonnement);

		form.setDisable(true);
		btn_valider.setDisable(true);
	}

	// bouton mise a jour
	@FXML
	public void update() {
		try {
			Abonnement abonnement = tblAbonnement.getSelectionModel().getSelectedItem();

			DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			LocalDate date_d = LocalDate.parse(abonnement.getDateDeb().toString(), formatage);
			LocalDate date_f = LocalDate.parse(abonnement.getDateFin().toString(), formatage);

			cbx_idClient.setValue(controlAccueil.daoClient.getById(abonnement.getIdCl()));
			cbx_idRevue.setValue(controlAccueil.daoRevue.getById(abonnement.getId_revue()));
			date_deb.setValue(date_d);
			date_fin.setValue(date_f);

			cbx_idRevue.setDisable(true);
			cbx_idClient.setDisable(true);
			form.setDisable(false);
			btn_valider.setDisable(false);

			creer = false;
			maj = true;
		} catch (Exception e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("Un probleme est survenue lors de la modification de votre Abonnement");
			alert.setHeaderText("Aucun Abonnement selectionne");
			alert.setContentText(e.toString());
			alert.showAndWait();
		}
	}

	// bouton supprimer
	@FXML
	public void delete() throws Exception {
		try {
			controlAccueil.daoAbo.delete(tblAbonnement.getSelectionModel().getSelectedItem());
			List<Abonnement> abos = controlAccueil.daoAbo.findAll();
			tblAbonnement.getItems().clear();
			tblAbonnement.getItems().addAll(abos);

		} catch (Exception e) {
			lbl_recap.setText("");
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("Un probleme est survenue lors de la suppression de votre Abonnement");
			alert.setHeaderText("Aucun Abonnement selectionne");
			alert.setContentText(e.toString());
			alert.showAndWait();
		}
	}

	// bouton creer
	@FXML
	public void create() throws Exception {
		cbx_idRevue.setDisable(false);
		cbx_idClient.setDisable(false);
		form.setDisable(false);
		btn_valider.setDisable(false);

		cbx_idClient.setValue(null);
		cbx_idRevue.setValue(null);
		date_deb.setValue(null);
		;
		date_fin.setValue(null);

		creer = true;
		maj = false;
	}

	// bouton retour
	@FXML
	public void retour() throws IOException {
		controlAccueil.daoAbo = null;
		controlAccueil.daoClient = null;
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
