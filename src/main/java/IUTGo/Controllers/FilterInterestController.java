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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 Created by vmonsch on 08/02/2017.
 */

public class FilterInterestController
{
    
    public ListView list_RoadTrip;
    @FXML
    private TextField textfield_ville;
    
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
    private ListView<String> list_PI;
    
    @FXML
    private TextField textfield_nom1;
    
    @FXML
    void homepage (MouseEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(HomePageConnectedController.class.getClassLoader().getResource(
                    "HomePageConnected.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) button_back.getScene().getWindow();
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
    void initialize ()
    {
        ObservableList data = FXCollections.observableArrayList();
        
        try
        {
            for (PointInterest p : PointInterest.read().values())
            {
                if(p.isValidated()) data.add(p.getName());
            }
            
            list_PI.setItems(data);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    
    @FXML
    void resetFiltres (ActionEvent event)
    {
        textfield_nom.setText(null);
        textfield_ville.setText(null);
    }
    
    @FXML
    void goBack (ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(HomePageConnectedController.class.getClassLoader().getResource(
                    "HomePageConnected.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) button_back.getScene().getWindow();
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
    void goTrier (ActionEvent event)
    {
        ObservableList data = FXCollections.observableArrayList();
        HashMap<String, PointInterest> pointInterest = null;
        try
        {
            pointInterest = PointInterest.read();
            for (Map.Entry<String, PointInterest> entry : pointInterest.entrySet())
            {
                if(!textfield_ville.getText().trim().isEmpty())
                {
                    if(pointInterest.get(entry.getKey()).getCoordinates().getCity().equals(textfield_ville.getText()))
                    {
                        data.add(entry.getKey());
                    }
                }
                if(!textfield_nom.getText().trim().isEmpty())
                {
                    if(pointInterest.get(entry.getKey()).getName().equals(textfield_nom.getText()))
                    {
                        data.add(entry.getKey());
                    }
                }
                
            }
            list_PI.setItems(data);
            list_PI.refresh();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    
    
    @FXML
    void openPI (ActionEvent event)
    {
        if(list_PI.getSelectionModel().getSelectedItem() != null){
            try
            {
                FXMLLoader fxmlLoader = new FXMLLoader(RoadTripController.class.getClassLoader().getResource("PointInterest.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = (Stage) button_back.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                ((InterestController)fxmlLoader.getController()).pipeline((String)list_PI.getSelectionModel().getSelectedItem());
                stage.show();
            }
            catch (IOException ex)
            {
                System.err.println("test " + ex);
            }
        }
    }
    
    public void back (ActionEvent actionEvent)
    {
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
