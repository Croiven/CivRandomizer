package civRandom;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


/**
 * @author Joonas
 * @version 3.3.2018
 * Pääohjelma ohjelmalle joka arpoo 1-8 pelaajalle kaksi kansaa Sid Meier's Civilization VI peliin.
 */
public class CivRandomMain extends Application {
	
	/**
	 * Käynnistys
	 */
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("CivRandomView.fxml"));
            final Pane root = ldr.load();
            //final CivRandomController civrandomCtrl = (CivRandomController) ldr.getController();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("civrandom.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("civRandom");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args Ei käytössä
     */
    public static void main(String[] args) {
        launch(args);
    }
}