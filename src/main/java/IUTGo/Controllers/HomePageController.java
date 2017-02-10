package IUTGo.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by chloe on 08/02/2017.
 */
public class HomePageController {
    @FXML
    private Hyperlink hl_inscription;

    @FXML
    private Button btn_search_pi;

    @FXML
    private Hyperlink hl_connect;

    @FXML
    private Button btn_see_rt;

    @FXML
    void see_rt(ActionEvent event) {

    }

    @FXML
    void search_pi(ActionEvent event) {

    }

    @FXML
    void connect(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ConnexionController.class.getClassLoader().getResource("connection.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) btn_see_rt.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println("Erreur au chargement: " + ex);
        }

    }

    @FXML
    void inscription(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(CreateItineraireController.class.getClassLoader().getResource("creation_itineraire.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) btn_see_rt.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println("Erreur au chargement: " + ex);
        }

    }
}

