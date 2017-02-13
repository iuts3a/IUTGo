package IUTGo.Controllers;

import IUTGo.Models.PointInterest;
import IUTGo.Models.PointInterestType;
import IUTGo.Models.RoadTrip;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vmonsch on 08/02/2017.
 */

public class FilterInterestController {

    @FXML
    private Button button_reset;

    @FXML
    private ComboBox<String> combo_box_type;

    @FXML
    private ListView<String> list_PI;

    @FXML
    private Button button_valider;

    @FXML
    private Button button_back;

    @FXML
    private ComboBox<Integer> combo_box_note;

    @FXML
    private Button button_filtrer;

    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        ObservableList a = FXCollections.observableArrayList();
        ObservableList b = FXCollections.observableArrayList();
        for (PointInterestType t : PointInterestType.values()) {
            a.add(t.toString());
        }
        for (int i=1 ; i<6 ; i++) {
            b.add(i);
        }
        combo_box_note.setItems(b);
        combo_box_type.setItems(a);
        ObservableList data = FXCollections.observableArrayList();
        HashMap<String, PointInterest> h = PointInterest.read();
        for(Object s : h.keySet()){
            //if (h.get(s).isValidated())
                data.add(h.get(s).getName());
        }
        list_PI.setItems(data);

    }

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
    void resetFiltres(ActionEvent event) throws IOException, ClassNotFoundException {
        combo_box_type.getSelectionModel().clearSelection();
        combo_box_note.getSelectionModel().clearSelection();
        initialize();
    }
    @FXML
    void goBack(ActionEvent event) {
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
    void goTrier(ActionEvent event) throws IOException, ClassNotFoundException {
        ObservableList data = FXCollections.observableArrayList();
        HashMap<String, PointInterest> h = PointInterest.read();
        for(Object s : h.keySet()){
            if (h.get(s).getType().toString().equals(combo_box_type.getSelectionModel().getSelectedItem()))
            {
                if (h.get(s).getGrade() > (combo_box_note.getSelectionModel().getSelectedIndex())+1) {
                    //if (h.get(s).isValidated())
                    data.add(h.get(s).getName());
                }

            }

        }
        list_PI.setItems(data);
    }


    @FXML
    void openPI(ActionEvent event)
    {
        if(list_PI.getSelectionModel().getSelectedItem() != null) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(RoadTripController.class.getClassLoader().getResource("PointInterest.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = (Stage) button_valider.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                ((InterestController) fxmlLoader.getController()).pipeline(list_PI.getSelectionModel().getSelectedItem());
                stage.show();
            } catch (IOException ex) {
                System.err.println("test " + ex);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void back (ActionEvent actionEvent) {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(InscriptionController.class.getClassLoader().getResource(
                    "HomePageConnected.fxml"));
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
}
