package IUTGo.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by vmonsch on 08/02/2017.
 */

public class FilterInterestController {

    @FXML
    private TableColumn<?, ?> column_ville;

    @FXML
    private Button button_reset;

    @FXML
    private TextField textfield_nom;

    @FXML
    private TableColumn<?, ?> column_nom;

    @FXML
    private TableColumn<?, ?> column_note;

    @FXML
    private TableView<?> tableview_PI;

    @FXML
    private ChoiceBox<?> choice_type;

    @FXML
    private TableColumn<?, ?> column_type;

    @FXML
    private Button button_valider;

    @FXML
    private Button button_back;

    @FXML
    private Button button_filtrer;

    @FXML
    private TextField textfield_ville;

    @FXML
    void homepage(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HomePageConnectedController.class.getClassLoader().getResource("home_page_connected.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) button_back.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println("Erreur au chargement: " + ex);
        }
    }

    @FXML
    void resetFiltres(ActionEvent event) {

    }

    @FXML
    void goTrier(ActionEvent event) {

    }

    @FXML
    void openPI(ActionEvent event) {

    }

}
