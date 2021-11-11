package application;

import java.io.IOException;




import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import modele.metier.Periodicite;
import modele.metier.Revue;
import javafx.collections.FXCollections;
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


public class controlRevue implements Initializable {
	
	private boolean creer=false;
	private boolean maj=false;

	@FXML
	private TextField txt_titre;
	@FXML
	private TextField txt_tarif;
	@FXML
	private TextField txt_visuel;
	@FXML
	private ComboBox<Periodicite> cbx_periodicite;
	@FXML
	private TextArea txt_description;		
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
	private TableView<Revue> tblRevue;
	@FXML
	private Window vue1;
	
	@SuppressWarnings("unchecked")
	public TableView<Revue> tblRevue() throws Exception {

		TableColumn<Revue, String> colIdRevue = new TableColumn<>("id_revue");
		TableColumn<Revue, String> colTitre = new TableColumn<>("Titre");
		TableColumn<Revue, String> colDescription = new TableColumn<>("Description");
		TableColumn<Revue, String> colTarif = new TableColumn<>("Tarif");
		TableColumn<Revue, String> colPeriodicite = new TableColumn<>("Periodicite");
		TableColumn<Revue, String> colVisuel = new TableColumn<>("Visuel");
		
		colIdRevue.setCellValueFactory(new PropertyValueFactory<Revue, String>("id_revue"));
		colTitre.setCellValueFactory(new PropertyValueFactory<Revue, String>("titre"));
		colDescription.setCellValueFactory(new PropertyValueFactory<Revue, String>("description"));
		colTarif.setCellValueFactory(new PropertyValueFactory<Revue, String>("tarifNumero"));
		colPeriodicite.setCellValueFactory(new PropertyValueFactory<Revue, String>("id_perio"));
		colVisuel.setCellValueFactory(new PropertyValueFactory<Revue, String>("visuel"));

		tblRevue.getColumns().setAll(colIdRevue, colTitre, colDescription, colTarif, colPeriodicite, colVisuel);

		List<Revue> revues = controlAccueil.daoRevue.findAll();
		
		tblRevue.getItems().addAll(revues);
		return tblRevue;

	}

	@Override
	public String toString() {
		if(creer) return "Ajout de : " + txt_titre.getText().trim() + " (" + txt_tarif.getText().trim() + "�)";
		else if(maj) return "Modifiction de : " + txt_titre.getText().trim();
		else return "";
	}

	public void initialize(URL location, ResourceBundle resources) {
 	
		try {
			cbx_periodicite.setItems(FXCollections.observableArrayList(controlAccueil.daoPerio.findAll()));
			
			tblRevue();
		} 
		catch (Exception e) {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue1);
			alert.setTitle("Probleme a l'initialisation");
			alert.setHeaderText("Un probleme est survenue lors de l'initialisation de vos Revues");
			alert.setContentText(e.toString());
			alert.showAndWait();
		}
	}

	@FXML
	public void valider() throws Exception {

		Periodicite period = cbx_periodicite.getValue();

		if ((txt_titre.getText().trim().isEmpty()) || (txt_description.getText().trim().isEmpty()) || (txt_tarif.getText().trim().isEmpty())
				|| (txt_visuel.getText().trim().isEmpty()) || (period == null)) {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue1);
			alert.setTitle("Erreur lors de la saisie");
			alert.setHeaderText("Un ou plusieurs champs sont mal remplis.");
			alert.showAndWait();
		}

		else if(creer){
			try {
				double tarif = Double.parseDouble(txt_tarif.getText().trim());
				String titre = txt_titre.getText().trim();
				String description = txt_description.getText().trim();
				String visuel = txt_visuel.getText().trim();
				lbl_recap.setText(toString());

				controlAccueil.daoRevue.create(
						new Revue(titre, description, tarif, visuel, period.getId_perio()));
			} catch (Exception e) {
				Alert alert=new Alert(Alert.AlertType.ERROR);
				alert.initOwner(vue1);
				alert.setTitle("La creation a echouee");
				alert.setHeaderText("Un probleme est survenue lors de la creation de votre Revue");
				alert.setContentText(e.toString());
				alert.showAndWait();
			}
		}
		else if(maj) {
			try {
				double tarif = Double.parseDouble(txt_tarif.getText().trim());
				String titre = txt_titre.getText().trim();
				String description = txt_description.getText().trim();
				String visuel = txt_visuel.getText().trim();
				lbl_recap.setText(toString());

				controlAccueil.daoRevue.update(
						new Revue(tblRevue.getSelectionModel().getSelectedItem().getId_revue(), titre, description, tarif, visuel, period.getId_perio()));				
			}
			catch (Exception e) {
				Alert alert=new Alert(Alert.AlertType.ERROR);
				alert.initOwner(vue1);
				alert.setTitle("La modification a echouee");
				alert.setHeaderText("Un probleme est survenue lors de la modification de votre Revue");
				alert.setContentText(e.toString());
				alert.showAndWait();
			}
			
		}
		creer=false;
		maj=false;
		
		List<Revue> revues = controlAccueil.daoRevue.findAll();
		tblRevue.getItems().clear();
		tblRevue.getItems().addAll(revues); 
		
		form.setDisable(true);
		btn_valider.setDisable(true);
	}
	
	@FXML
	public void create() throws Exception{
		form.setDisable(false);
		btn_valider.setDisable(false);
		
		txt_titre.setText("");
		txt_description.setText("");
		txt_tarif.setText("");
		cbx_periodicite.setValue(null);
		txt_visuel.setText("");
		
		creer=true;
		maj=false;
	}	
	
	@FXML
	public void delete() throws Exception{
		try {
			controlAccueil.daoRevue.delete(tblRevue.getSelectionModel().getSelectedItem()); 
	        List<Revue> revues = controlAccueil.daoRevue.findAll();
			tblRevue.getItems().clear();
			tblRevue.getItems().addAll(revues);
		} 
		catch (Exception e) {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue1);
			alert.setTitle("Un probleme est survenue lors de la suppression de votre Revue");
			alert.setHeaderText("Aucune Revue selectionnee");
			alert.setContentText(e.toString());
			alert.showAndWait();
		}		
	}
	
	@FXML
	public void update() throws Exception {
		try {			
			Revue revue=tblRevue.getSelectionModel().getSelectedItem();
						
			txt_titre.setText(revue.getTitre().trim());
			txt_description.setText(revue.getDescription().trim());
			txt_tarif.setText(String.valueOf(revue.getTarifNumero()).trim());
			cbx_periodicite.setValue(controlAccueil.daoPerio.getById(revue.getId_perio()));
			txt_visuel.setText(revue.getVisuel().trim());
			
			form.setDisable(false);
			btn_valider.setDisable(false);
			
			creer=false;
			maj=true;
		}
		catch (Exception e) {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue1);
			alert.setTitle("Un probleme est survenue lors de la modification de votre Revue");
			alert.setHeaderText("Aucune Revue selectionnee");
			alert.setContentText(e.toString());
			alert.showAndWait();
		}
	}
	
	
		
	@FXML
	public void retour() throws IOException{
		controlAccueil.daoRevue=null;
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