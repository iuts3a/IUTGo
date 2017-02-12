package IUTGo.Controllers;

import IUTGo.Models.PointInterest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
    void homepage (MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HomePageConnectedController.class.getClassLoader().getResource("HomePageConnected.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) button_back.getScene().getWindow();
            Scene scene = new Scene(root, 1000, 510);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println("Erreur au chargement: " + ex);
        }
    }

    @FXML
    void resetFiltres(ActionEvent event) {
        textfield_nom.setText(null);
        textfield_ville.setText(null);
    }

    @FXML
    void goTrier(ActionEvent event) {
        ObservableList data = FXCollections.observableArrayList();
        HashMap<String, PointInterest> pointInterest = null;
        try {
            pointInterest = PointInterest.read();
            for(Map.Entry<String, PointInterest> entry : pointInterest.entrySet()) {
                if(!textfield_ville.getText().trim().isEmpty()){
                    if(pointInterest.get(entry.getKey()).getCoordinates().getCity().equals(textfield_ville.getText())){
                        data.add(entry.getKey());
                    }
                }
                if(!textfield_nom.getText().trim().isEmpty()){
                    if(pointInterest.get(entry.getKey()).getName().equals(textfield_nom.getText())){
                        data.add(entry.getKey());
                    }
                }

            }
            list_PI.setItems(data);




        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }

    @FXML
    void openPI(ActionEvent event) {

    }

}
