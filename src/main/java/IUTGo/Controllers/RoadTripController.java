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
        roadtrip_name.setText(roadTripSelected);
        next();
    }

    @FXML
    void next()
    {
        check.setVisible(false);
        try {
            RoadTrip roadTrip = RoadTrip.read().get(roadTripSelected);
            prix_roadtrip.setText(String.valueOf(roadTrip.getPrice()));
            ObservableList data = FXCollections.observableArrayList();
            for(String s : RoadTrip.read().get(roadTripSelected).getPointInterests().keySet()) {
                    data.add(s);
            }
            table_PI.setItems(data);

            if(!RoadTrip.read().get(roadTripSelected).getParticipants().containsKey(CurrentUser.getInstance().getUser().getEmail())){
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
        User user = CurrentUser.getInstance().getUser();
        if(check.isSelected()){
            user.signIn(roadTripSelected);
        }
        if(!Lieu.getText().equals(""))
        {
            if (PointInterest.read().containsKey(Lieu.getText()))
            {
                RoadTrip r = RoadTrip.read().get(roadTripSelected);
                PointInterest pi = PointInterest.read().get(Lieu.getText());
                r.addPointInterest(pi);
                r.save();
                next();
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
