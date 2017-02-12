package IUTGo.Controllers;

import IUTGo.Models.PointInterestType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CreationPointInterestController
{
    public TextField name;
    public TextField comment;
    public TextField type;
    public TextField price;
    public TextField coords1;
    public TextField coords2;
    public TextField ville;
    public Label     error_name;
    public Label     error_type;
    public Label     error_price;
    public Label     error_coords;
    
    @FXML
    private Button btn_back;
    
    @FXML
    private Button button_valider;
    
    @FXML
    void initialize ()
    {
        error_name.setVisible(false);
        error_price.setVisible(false);
        error_type.setVisible(false);
        error_coords.setVisible(false);
    }
    
    @FXML
    void validateData (ActionEvent event)
    {
        error_name.setVisible(false);
        error_price.setVisible(false);
        error_type.setVisible(false);
        error_coords.setVisible(false);
        
        boolean typeOk = false;
        
        if(name.getText().trim().isEmpty())
        {
            error_name.setVisible(true);
        }
        if(price.getText().trim().isEmpty())
        {
            try
            {
                Double.parseDouble(price.getText().trim());
            }
            catch (NumberFormatException e)
            {
                error_price.setVisible(true);
            }
        }
        for(PointInterestType t : PointInterestType.values())
        {
            if(t.toString().equalsIgnoreCase(type.getText()))
            {
                typeOk = true;
            }
        }
        if(!typeOk)
        {
            
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
    
    @FXML
    void toBack (ActionEvent event)
    {
        
    }
    
}
