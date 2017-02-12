package IUTGo.Controllers;
import IUTGo.Models.CurrentUser;
import IUTGo.Models.PointInterest;
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
import java.util.Map;

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
    private Text roadtrip_name ;

    String roadTripSelected ;

    public void pipeline(String r){
        roadTripSelected = r;
        next();
    }

    @FXML
    void next()
    {
        roadtrip_name.setText(roadTripSelected);
        try {
            RoadTrip roadTrip = RoadTrip.read().get(roadTripSelected);
            prix_roadtrip.setText(String.valueOf(roadTrip.getPrice()));
            ObservableList data = FXCollections.observableArrayList();

            for(Map.Entry<String, PointInterest> entry : roadTrip.getPointInterests().entrySet()) {
                data.add(entry.getKey());
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
        if(!Lieu.getText().trim().isEmpty())
        {
            try {
                if(PointInterest.read().get(Lieu.getText()) != null){
                    RoadTrip.read().get(roadTripSelected).addPointInterest(PointInterest.read().get(Lieu.getText()));
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void retour(ActionEvent event) {

    }

}
