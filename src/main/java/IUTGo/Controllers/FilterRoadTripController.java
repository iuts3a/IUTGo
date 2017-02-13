package IUTGo.Controllers;

import IUTGo.Models.RoadTrip;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class FilterRoadTripController {

    @FXML
    private TextField textfield_nom;

    @FXML
    private Button button_reset;

    @FXML
    private Button button_filtrer;

    @FXML
    private Button button_valider;

    @FXML
    private Button button_back;

    @FXML
    private ListView<RoadTrip> list_RoadTrip;

    @FXML
    void goBack(ActionEvent event) {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(InscriptionController.class.getClassLoader().getResource("HomePageConnected.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) button_back.getScene().getWindow();
            Scene scene = new Scene(root, 1000, 510);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    void openPI(ActionEvent event) {

    }

    @FXML
    void resetFiltres(ActionEvent event) {

    }
}
