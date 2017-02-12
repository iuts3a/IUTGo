package IUTGo.Controllers;

import IUTGo.Models.RoadTrip;
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
import java.util.ArrayList;
import java.util.Collection;

public class OtherUserInfoController
{
    
    private ObservableList data = FXCollections.observableArrayList();
    @FXML
    private Button btn_show_roadtrip;
    
    @FXML
    private Label lb_email;
    
    @FXML
    private ListView<RoadTrip> tv_roadtrip;
    
    @FXML
    private Button retour;
    
    @FXML
    private Label lb_lastname;
    
    @FXML
    private Label lb_telephone;
    
    @FXML
    private Label lb_name;
    
    @FXML
    void show_roadtrip (ActionEvent event)
    {
        ArrayList<RoadTrip> listRoadTrip = new ArrayList<RoadTrip>((Collection<? extends RoadTrip>) tv_roadtrip);
        for (RoadTrip roadTrip : listRoadTrip)
        {
            data.add(roadTrip);
        }
        tv_roadtrip.setItems(data);
        
    }
    
    @FXML
    void retour (ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(InscriptionController.class.getClassLoader().getResource(
                    "HomePageConnected.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) retour.getScene().getWindow();
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