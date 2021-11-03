package application;

import dao.DAOFactory;
import dao.Persistance;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import modele.metier.Periodicite;
import modele.metier.Revue;

import java.net.URL;
import java.util.ResourceBundle;

public class controller implements Initializable {

    @FXML
    private TextField txt_titre;
    @FXML
    private TextField txt_tarif;
    @FXML
    private ComboBox<Periodicite> txt_periodicite;
    @FXML
    private TextArea txt_description;
    @FXML
    private Button btn_creer;
    @FXML
    private Label lbl_recap;
    @FXML
    private RadioButton mysql;
    @FXML
    private RadioButton list;


    @Override
    public String toString() {
        return "Ajout de : " + txt_titre.getText() + " (" + txt_tarif.getText() + ")";
    }

    public void initialize(URL location, ResourceBundle resources) {

        DAOFactory dao = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);


        this.txt_periodicite.setItems(FXCollections.observableArrayList(dao.getPeriodiciteDAO().findAll()));

    }


    @FXML
    public void create() {

        Periodicite period = txt_periodicite.getValue();

        if ((txt_titre.getText().isEmpty()) || (txt_description.getText().isEmpty()) || (txt_tarif.getText().isEmpty())
                || (period == null) || ((mysql == null) && (list == null))) {
            lbl_recap.setTextFill(Color.web("red"));
            this.lbl_recap.setText("Les champs ne sont pas tous valides");
        } else {
            DAOFactory daos = null;
            if (mysql.isSelected()) {
                daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
            } else if (list.isSelected()) {
                daos = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
            }
            try {
                double tarif = Double.parseDouble(txt_tarif.getText());
                lbl_recap.setTextFill(Color.web("black"));
                lbl_recap.setText(toString());
                String titre = txt_titre.getText();
                String description = txt_description.getText();


                daos.getRevueDAO().create(new Revue(titre, description, tarif, null, period.getIdPerio()));
            } catch (Exception e) {
                lbl_recap.setTextFill(Color.web("red"));
                this.lbl_recap.setText("Erreur lors de la creation");
            }
        }
    }

}