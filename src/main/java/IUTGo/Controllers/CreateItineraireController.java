package IUTGo.Controllers;

import IUTGo.Models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

/**
 Created by chloe on 08/02/2017.
 */
public class CreateItineraireController
{
    @FXML
    private Label feedback_description;
    
    @FXML
    private TextField textfield_nom;
    
    @FXML
    private Label feedback_nom;
    
    @FXML
    private Label feedback_start;
    
    @FXML
    private Button btn_back;
    
    @FXML
    private ComboBox<?> combo_type;
    
    @FXML
    private TextField textfield_depart;
    
    @FXML
    private Button button_valider;
    
    @FXML
    private TextArea textarea_description;
    
    @FXML
    private Label feedback_type;
    
    @FXML
    public void initialize ()
    {
        feedback_nom.setVisible(false);
        feedback_description.setVisible(false);
        feedback_start.setVisible(false);
    }
    
    @FXML
    void toBack (ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(HomePageConnectedController.class.getClassLoader().getResource(
                    "HomePageConnected.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) button_valider.getScene().getWindow();
            Scene scene = new Scene(root, 1000, 510);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex)
        {
            System.err.println("Erreur au chargement: " + ex);
        }
    }
    
    
    @SuppressWarnings("ConstantConditions")
    @FXML
    void validateData (ActionEvent event)
    {
        feedback_nom.setVisible(false);
        feedback_description.setVisible(false);
        feedback_start.setVisible(false);
        if(textfield_nom.getText().trim().isEmpty())
        {
            feedback_nom.setVisible(true);
            return;
        }
        if(textarea_description.getText().trim().isEmpty())
        {
            feedback_description.setVisible(true);
            return;
        }
        if(textfield_depart.getText().trim().isEmpty())
        {
            feedback_start.setVisible(true);
            return;
        }
        try
        {
            if(!PointInterest.read().containsKey(textfield_depart.getText().trim()))
            {
                feedback_start.setVisible(true);
                return;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return;
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            return;
        }
    
        try
        {
            HashMap<String, RoadTrip> listRoadTrip = RoadTrip.read();
            HashMap<String, PointInterest> listPointInterest = PointInterest.read();
            if(!listRoadTrip.containsKey(textfield_nom.getText()) && listPointInterest.containsKey(textfield_depart.getText().trim()))
            {
                RoadTrip roadTrip = new RoadTrip(textfield_nom.getText(), CurrentUser.getInstance().getUser());
                roadTrip.addPointInterest(listPointInterest.get(textfield_depart.getText().trim()));
                roadTrip.save();
                
                CurrentUser.getInstance().getUser().addRoadTripToFavorite(textfield_nom.getText());
                CurrentUser.getInstance().getUser().save();
                
                FXMLLoader fxmlLoader = new FXMLLoader(UserInfoController.class.getClassLoader().getResource(
                        "UserInfo.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = (Stage) button_valider.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
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
    void homepage (MouseEvent event)
    {
        
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(HomePageConnectedController.class.getClassLoader().getResource(
                    "HomePageConnected.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) button_valider.getScene().getWindow();
            Scene scene = new Scene(root, 1000, 510);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex)
        {
            System.err.println("Erreur au chargement: " + ex);
        }
    }
    
}
