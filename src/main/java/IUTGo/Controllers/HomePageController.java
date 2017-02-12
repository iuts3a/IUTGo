package IUTGo.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.io.IOException;

/**
 Created by chloe on 08/02/2017.
 */
public class HomePageController
{
    @FXML
    private Hyperlink hl_inscription;
    
    @FXML
    private Hyperlink hl_connect;
    
    @FXML
    void see_rt (ActionEvent event)
    {
        
    }
    
    @FXML
    void search_pi (ActionEvent event)
    {
        
    }
    
    @FXML
    void connect (ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(ConnexionController.class.getClassLoader().getResource(
                    "Connection.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) hl_connect.getScene().getWindow();
            Scene scene = new Scene(root, 700, 570);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex)
        {
            System.err.println("Erreur au chargement: " + ex);
        }
        
    }
    
    @FXML
    void inscription (ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(InscriptionController.class.getClassLoader().getResource(
                    "Inscription.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) hl_connect.getScene().getWindow();
            Scene scene = new Scene(root, 680, 700);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex)
        {
            System.err.println("Erreur au chargement: " + ex);
        }
    }
}

