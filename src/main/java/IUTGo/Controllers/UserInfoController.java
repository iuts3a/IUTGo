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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 Created by vmonsch on 08/02/2017.
 */

public class UserInfoController
{
    public ListView tv_roadtrip;
    public Button btn_show_roadtrip;
    public Button btn_delete_rt;
    public Button retour;
    public Button btn_create_rt;
    public Label name;
    public Label firstName;
    public Label email;
    
    @FXML
    void initialize()
    {
        User user = CurrentUser.getInstance().getUser();
        
        name.setText(user.getLastName());
        firstName.setText(user.getFirstName());
        email.setText(user.getEmail());

        ObservableList data = FXCollections.observableArrayList();

        for(int i= 0; i<user.getFavoriteRoadTrips().size(); i++){
            data.add(user.getFavoriteRoadTrips().get(i).getName());
        }
        tv_roadtrip.setItems(data);

    }
    
    @FXML
    void create_rt (ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(CreateItineraireController.class.getClassLoader().getResource(
                    "RoadTripCreation.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) btn_create_rt.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex)
        {
            System.err.println("Erreur au chargement: " + ex);
        }
        
    }
    
    @FXML
    void show_roadtrip (ActionEvent event)
    {
        if(tv_roadtrip.getSelectionModel().getSelectedItem() != null){
            try
            {
                FXMLLoader fxmlLoader = new FXMLLoader(RoadTripController.class.getClassLoader().getResource("Roadtrip.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = (Stage) btn_create_rt.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                ((RoadTripController)fxmlLoader.getController()).pipeline((String)tv_roadtrip.getSelectionModel().getSelectedItem());
                stage.show();
            }
            catch (IOException ex)
            {
                System.err.println("test " + ex);
            }
        }

        
    }
    
    @FXML
    void delete_rt (ActionEvent event)
    {
        if(tv_roadtrip.getSelectionModel().getSelectedItem() != null){
            try {
                RoadTrip.read().get(tv_roadtrip.getSelectionModel().getSelectedItem()).deleteParticipants(CurrentUser.getInstance().getUser().getEmail());
                System.out.println(CurrentUser.getInstance().getUser().getFavoriteRoadTrips().remove(RoadTrip.read().get(tv_roadtrip.getSelectionModel().getSelectedItem())));

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            //initialize();
        }
    }
    
    @FXML
    void retour (ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(HomePageConnectedController.class.getClassLoader().getResource(
                    "HomePageConnected.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) btn_create_rt.getScene().getWindow();
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
    void accept_notif (ActionEvent event)
    {
        
    }
    
    @FXML
    void refuse_modif (ActionEvent event)
    {
        
    }
    
}
