package IUTGo.Controllers;

import IUTGo.Models.RoadTrip;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.awt.event.MouseEvent;

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
    void goTrier(ActionEvent event) {

    }

    @FXML
    void homepage(MouseEvent event) {

    }

    @FXML
    void openPI(ActionEvent event) {

    }

    @FXML
    void resetFiltres(ActionEvent event) {

    }
}
