package application;



import java.io.IOException;

import java.net.URL;




import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;

import javafx.scene.layout.VBox;


public class Main extends Application  {
    @Override
    public void start(Stage primaryStage)throws IOException {
        try {
            URL fxmlURL=getClass().getResource("vue/fenetre.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
            Node root = fxmlLoader.load();
            Scene scene = new Scene((VBox) root,640,400);
            primaryStage.setScene(scene);
            primaryStage.setTitle("RevuesOnLine");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

