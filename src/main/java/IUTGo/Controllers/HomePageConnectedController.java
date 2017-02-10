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
public class HomePageConnectedController {
    @FXML
    private Button btn_modify_rt;

    @FXML
    private Button btn_create_rt;

    @FXML
    private Button btn_search_pi;

    @FXML
    private Button btn_see_rt;

    @FXML
    private Hyperlink hl_deco;

    @FXML
    private Hyperlink hl_info;



    @FXML
    void create_rt(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(CreateItineraireController.class.getClassLoader().getResource("creation_itineraire.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) btn_create_rt.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println("Erreur au chargement: " + ex);
        }
    }

    @FXML
    void see_rt(ActionEvent event) {

    }

    @FXML
    void search_pi(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(CreateItineraireController.class.getClassLoader().getResource("creation_itineraire.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) btn_create_rt.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println("Erreur au chargement: " + ex);
        }
    }

    @FXML
    void modify_rt(ActionEvent event) {

    }

    @FXML
    void deco(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HomePageController.class.getClassLoader().getResource("home-page.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) btn_create_rt.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println("Erreur au chargement: " + ex);
        }
    }

    @FXML
    void informations(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(UserInfoController.class.getClassLoader().getResource("information_user.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) btn_create_rt.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println("Erreur au chargement: " + ex);
        }
    }

}
