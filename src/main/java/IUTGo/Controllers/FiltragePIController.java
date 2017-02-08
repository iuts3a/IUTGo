package IUTGo.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FiltragePIController {

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
