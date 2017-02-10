package IUTGo.Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * Created by xavier on 08/02/2017.
 */

public class RoadTripController {

    @FXML
    private TableColumn<?, ?> colonne_lieux;

    @FXML
    private TableColumn<?, ?> colonne_date;

    @FXML
    private TextField nom3;

    @FXML
    private TextField nom2;

    @FXML
    private TextField nom1;

    @FXML
    private Label prix_roadtrip;

    @FXML
    private TableView<?> Tableau;

    @FXML
    private TextField Lieux;

    @FXML
    private TextField prenom2;

    @FXML
    private Label nombre_places;

    @FXML
    private TextField prenom1;

    @FXML
    private TextField prenom3;

    @FXML
    void homepage(ActionEvent event) {

    }

    @FXML
    void valider(ActionEvent event) {

    }

    @FXML
    void retour(ActionEvent event) {

    }

}
