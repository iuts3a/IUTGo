package IUTGo.Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by xavier on 08/02/2017.
 */

public class ConnexionController {

    @FXML
    private Button button_validation;

    @FXML
    private TextField password;

    @FXML
    private Button button_register;

    @FXML
    private TextField username;

    @FXML
    private Label connection_error;

    @FXML
    public void  initialize() {
        connection_error.setVisible(false);
    }

    @FXML
    void redirect_register_view(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(InscriptionController.class.getClassLoader().getResource("inscription.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) button_register.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println("Erreur au chargement: " + ex);
        }
    }



    @FXML
    void validate_connexion(ActionEvent event) {
        connection_error.setVisible(false);
        if((username.getText().trim().length()>0)&&(username.getText()!=null)&&(password.getText()!=null)){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HomePageConnectedController.class.getClassLoader().getResource("home_page_connected.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = (Stage) button_register.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                System.err.println("Erreur au chargement: " + ex);
            }
        }
        else{
            connection_error.setVisible(true);
            username.setText(null);
            password.setText(null);
        }


    }

    @FXML
    void homepage(ActionEvent event) {
        connection_error.setVisible(true);

    }

}
