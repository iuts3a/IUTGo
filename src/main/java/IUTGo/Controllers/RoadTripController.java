package IUTGo.Controllers;
import IUTGo.Models.CurrentUser;
import IUTGo.Models.RoadTrip;
import IUTGo.Models.Users.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * Created by xavier on 08/02/2017.
 */

public class RoadTripController {

    @FXML
    private Label prix_roadtrip;

    @FXML
    private TextField Lieu;

    @FXML
    private ListView<?> table_PI;

    @FXML
    private Text roadtrip_name;

    String roadTripSelected;

    public void pipeline(String r){
        roadTripSelected = r;
    }

    @FXML
    void initialize()
    {
        roadtrip_name.setText(roadTripSelected);
        try {
            RoadTrip roadTrip = RoadTrip.read().get(roadTripSelected);
            prix_roadtrip.setText(roadTrip.getName());
            ObservableList data = FXCollections.observableArrayList();

            for(int i= 0; i<roadTrip.getPointInterests().size(); i++){

                data.add(roadTrip.getPointInterests().get(i).getName());
            }
            table_PI.setItems(data);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

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
