package IUTGo.Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Created by chloe on 08/02/2017.
 */
public class CreateItineraireController {
    @FXML
    private TextField textfield_nom;

    @FXML
    private ComboBox<?> combo_type;

    @FXML
    private TextField textfield_depart;

    @FXML
    private TextArea textarea_description;

    @FXML
    private Button button_valider;

    @FXML
    void validateData(ActionEvent event) {

    }

    @FXML
    void homepage(ActionEvent event) {

    }

}
