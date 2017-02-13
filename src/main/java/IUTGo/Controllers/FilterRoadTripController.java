package IUTGo.Controllers;

import IUTGo.Models.CurrentUser;
import IUTGo.Models.RoadTrip;
import IUTGo.Models.Users.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.HashMap;

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
    private ListView<String> list_RoadTrip;

    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        ObservableList data = FXCollections.observableArrayList();
        HashMap<String, RoadTrip> h = RoadTrip.read();
        for(Object s : h.keySet()){
            data.add(h.get(s).getName());
        }
        list_RoadTrip.setItems(data);

    }

    @FXML
    void homepage (javafx.scene.input.MouseEvent event) {
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
    void back(ActionEvent event) {
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
    void resetFiltres(ActionEvent event) throws IOException, ClassNotFoundException {
        textfield_nom.setText("");
        initialize();
    }

    @FXML
    void goTrier(ActionEvent event) throws IOException, ClassNotFoundException {
        ObservableList data = FXCollections.observableArrayList();
        HashMap<String, RoadTrip> h = RoadTrip.read();
        for(Object s : h.keySet()){
            data.add(h.get(s).getName());
        }
        list_RoadTrip.setItems(data);
    }

    @FXML
    void openRT(ActionEvent event) {
        if(list_RoadTrip.getSelectionModel().getSelectedItem() != null) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(RoadTripController.class.getClassLoader().getResource("Roadtrip.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = (Stage) button_valider.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                ((RoadTripController) fxmlLoader.getController()).pipeline(list_RoadTrip.getSelectionModel().getSelectedItem());
                stage.show();
            } catch (IOException ex) {
                System.err.println("test " + ex);
            }
        }

    }
}
