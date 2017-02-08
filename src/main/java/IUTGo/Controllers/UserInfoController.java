package IUTGo.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by vmonsch on 08/02/2017.
 */

public class UserInfoController {

    @FXML
    private Button btn_show_roadtrip;

    @FXML
    private ListView<?> tv_notifications;

    @FXML
    private Button btn_create_rt;

    @FXML
    private ListView<?> tv_roadtrip;

    @FXML
    private Button retour;

    @FXML
    private Button btn_accept_notif;

    @FXML
    private Button btn_delete_rt;

    @FXML
    private Button btn_refuse_modif;

    @FXML
    void create_rt(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(CreateItineraireController.class.getClassLoader().getResource("creation_itineraire.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) btn_accept_notif.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println("Erreur au chargement: " + ex);
        }

    }

    @FXML
    void show_roadtrip(ActionEvent event) {

    }

    @FXML
    void delete_rt(ActionEvent event) {

    }

    @FXML
    void retour(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HomePageConnectedController.class.getClassLoader().getResource("home_page_connected.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) btn_accept_notif.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println("Erreur au chargement: " + ex);
        }

    }

    @FXML
    void accept_notif(ActionEvent event) {

    }

    @FXML
    void refuse_modif(ActionEvent event) {

    }

}
