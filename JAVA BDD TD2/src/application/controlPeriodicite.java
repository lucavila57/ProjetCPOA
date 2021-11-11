package application;

import java.io.IOException;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import modele.metier.Periodicite;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;

public class controlPeriodicite implements Initializable{
	
	private boolean creer;
	private boolean maj;

	@FXML
	private TextField txt_libelle;
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
	private TableView<Periodicite> tblPeriodicite;
	@FXML
	private Window vue;
	
	@SuppressWarnings("unchecked")
	public TableView<Periodicite> tblPeriodicite() throws Exception {
		
		TableColumn<Periodicite, String> colIdPeriodicite = new TableColumn<>("id_periodicite");
		TableColumn<Periodicite, String> colLibelle = new TableColumn<>("libelle");
		
		colIdPeriodicite.setCellValueFactory(new PropertyValueFactory<Periodicite, String>("id_perio"));
		colLibelle.setCellValueFactory(new PropertyValueFactory<Periodicite, String>("libelle"));
		
		tblPeriodicite.getColumns().setAll(colIdPeriodicite, colLibelle);
		
		List<Periodicite> periodes = controlAccueil.daoPerio.findAll();	
		
		tblPeriodicite.getItems().addAll(periodes);
		return tblPeriodicite;
	}
	
	@Override
	public String toString() {
		if(creer) return "Ajout de : " + txt_libelle.getText().trim();
		else if(maj) return "Modifiction de : " + txt_libelle.getText().trim();
		else return "";
	}

	public void initialize(URL location, ResourceBundle resources) {
		try {
			tblPeriodicite();
		} catch (Exception e) {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("Probleme a l'initialisation");
			alert.setHeaderText("Un probleme est survenue lors de l'initialisation de vos Periodes");
			alert.setContentText(e.toString());
			alert.showAndWait();
		}
	}
	
	@FXML
	public void valider() throws Exception{
		if (txt_libelle.getText().trim().isEmpty()) {			
			lbl_recap.setText("Les champs ne sont pas tous valides");

			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("Erreur lors de la saisie");
			alert.setHeaderText("Un ou plusieurs champs sont mal remplis.");
			alert.showAndWait();
		}
		
		else if(creer) {
			try {
				String libelle = txt_libelle.getText().trim();
				lbl_recap.setText(toString());

				controlAccueil.daoPerio.create(new Periodicite(libelle));
			} catch (Exception e) {
				lbl_recap.setText("");
				Alert alert=new Alert(Alert.AlertType.ERROR);
				alert.initOwner(vue);
				alert.setTitle("La creation a echouee");
				alert.setHeaderText("Un probleme est survenue lors de la creation de votre Periode");
				alert.setContentText(e.toString());
				alert.showAndWait();
			}			
		}
		
		else if(maj) {
			try {
				String libelle = txt_libelle.getText().trim();
				lbl_recap.setText(toString());

				controlAccueil.daoPerio.update(new Periodicite(tblPeriodicite.getSelectionModel().getSelectedItem().getId_perio(), libelle));
			} catch (Exception e) {
				lbl_recap.setText("");
				Alert alert=new Alert(Alert.AlertType.ERROR);
				alert.initOwner(vue);
				alert.setTitle("La modification a echouee");
				alert.setHeaderText("Un probleme est survenue lors de la modification de votre Periode");
				alert.setContentText(e.toString());
				alert.showAndWait();
			}
		}
		creer=false;
		maj=false;
		
		List<Periodicite> period = controlAccueil.daoPerio.findAll();
		tblPeriodicite.getItems().clear();
		tblPeriodicite.getItems().addAll(period); 
		
		form.setDisable(true);
		btn_valider.setDisable(true);		
	}
	
	@FXML
	public void create()throws Exception {
		form.setDisable(false);
		btn_valider.setDisable(false);
		
		txt_libelle.setText("");
		
		creer=true;
		maj=false;
	}
	
	@FXML
	public void delete()throws Exception{
		try {
			controlAccueil.daoPerio.delete(tblPeriodicite.getSelectionModel().getSelectedItem());  
	        List<Periodicite> period = controlAccueil.daoPerio.findAll();
	        tblPeriodicite.getItems().clear();
	        tblPeriodicite.getItems().addAll(period);			
		}
		catch (Exception e) {
			lbl_recap.setText("");
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("Un probleme est survenue lors de la suppression de votre Periode");
			alert.setHeaderText("Aucune Periode selectionnee");
			alert.setContentText(e.toString());
			alert.showAndWait();
		}
		
	}
	
	@FXML
	public void update()throws Exception{
		try {
			Periodicite period = tblPeriodicite.getSelectionModel().getSelectedItem();
			
			txt_libelle.setText(period.getLibelle().trim());
			
			form.setDisable(false);
			btn_valider.setDisable(false);
			
			creer=false;
			maj=true;
			
		}
		catch (Exception e) {
			lbl_recap.setText("");
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("Un probleme est survenue lors de la modification de votre Periode");
			alert.setHeaderText("Aucune Periode selectionnee");
			alert.setContentText(e.toString());
			alert.showAndWait();
		}
		
	}
	
	@FXML
	public void retour() throws IOException{
		controlAccueil.daoPerio=null;
		
		Stage stage =(Stage) btn_retour.getScene().getWindow();
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
