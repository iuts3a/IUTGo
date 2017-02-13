package IUTGo.Controllers;
import IUTGo.Models.CurrentUser;
import IUTGo.Models.PointInterest;
import IUTGo.Models.RoadTrip;
import IUTGo.Models.Users.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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

    @FXML
    private CheckBox check ;

    String roadTripSelected ;

    public void pipeline(String r){
        roadTripSelected = r;
        next();
    }

    @FXML
    void next()
    {
        roadtrip_name.setText(roadTripSelected);
        check.setVisible(false);
        try {
            RoadTrip roadTrip = RoadTrip.read().get(roadTripSelected);
            prix_roadtrip.setText(String.valueOf(roadTrip.getPrice()));
            ObservableList data = FXCollections.observableArrayList();
            for(Map.Entry<String, PointInterest> entry : roadTrip.getPointInterests().entrySet()) {
                if(entry.getValue().isValidated()){
                    data.add(entry.getKey());
                }
            }
            table_PI.setItems(data);

            if(!CurrentUser.getInstance().getUser().getFavoriteRoadTrips().contains(roadTripSelected)){
                check.setVisible(true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void homepage(MouseEvent event) {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(HomePageConnectedController.class.getClassLoader().getResource(
                    "HomePageConnected.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) prix_roadtrip.getScene().getWindow();
            Scene scene = new Scene(root, 1000, 510);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex)
        {
            System.err.println("Erreur au chargement: " + ex);
        }

    }

    @FXML
    void valider(ActionEvent event) throws IOException, ClassNotFoundException {
        RoadTrip roadTrip = RoadTrip.read().get(roadTripSelected);
        if(check.isSelected()){
            roadTrip.addParticipants(CurrentUser.getInstance().getUser());
        }
        if(!Lieu.getText().equals(""))
        {
            PointInterest pi = PointInterest.read().get(Lieu.getText());
            try {

                if(CurrentUser.getInstance().getUser().getFavoriteRoadTrips().contains(roadTripSelected) || check.isSelected()){
                    if(pi != null){
                        RoadTrip.read().get(roadTripSelected).addPointInterest(pi);
                        CurrentUser.getInstance().getUser().getFavoriteRoadTrips().add(RoadTrip.read().get(roadTripSelected));
                    }

                }
                next();


            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void retour(ActionEvent event) {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(HomePageConnectedController.class.getClassLoader().getResource(
                    "HomePageConnected.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) prix_roadtrip.getScene().getWindow();
            Scene scene = new Scene(root, 830, 560);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex)
        {
            System.err.println("Erreur au chargement: " + ex);

        }
    }

    public void supprimerPi(ActionEvent actionEvent) {
    }
}
