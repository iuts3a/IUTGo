package IUTGo.Controllers;

import IUTGo.Models.CurrentUser;
import IUTGo.Models.Users.User;
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
import java.util.HashMap;

/**
 Created by xavier on 08/02/2017.
 */

public class ConnexionController
{
    
    @FXML
    private Button button_validation;
    
    @FXML
    private TextField password;
    
    @FXML
    private Button button_register;
    
    @FXML
    private TextField username;
    
    @FXML
    private Label connection_error;
    
    
    @FXML
    public void initialize ()
    {
        connection_error.setVisible(false);
    }
    
    @FXML
    void redirect_register_view (ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(InscriptionController.class.getClassLoader().getResource(
                    "Inscription.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) button_register.getScene().getWindow();
            Scene scene = new Scene(root, 860, 700);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex)
        {
            System.err.println("Erreur au chargement: " + ex);
        }
    }
    
    
    @FXML
    void validate_connexion (ActionEvent event)
    {
        connection_error.setVisible(false);
        if((username.getText().trim().length() > 0) && (username.getText() != null) && (password.getText() != null))
        {
            
            try
            {
                HashMap<String, User> user = User.read();
                if(user.containsKey(username.getText()))
                {
                    if(user.get(username.getText()).getPassword().equals(password.getText()))
                    {
                        CurrentUser.Init(username.getText());
                        
                        FXMLLoader fxmlLoader = new FXMLLoader(HomePageConnectedController.class.getClassLoader().getResource(
                                "HomePageConnected.fxml"));
                        Parent root = fxmlLoader.load();
                        Stage stage = (Stage) button_register.getScene().getWindow();
                        Scene scene = new Scene(root, 1000, 510);
                        stage.setScene(scene);
                        stage.show();
                    }
                }
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            
        }
        else
        {
            connection_error.setVisible(true);
            username.setText(null);
            password.setText(null);
        }
    }
    
    @FXML
    void homepage (MouseEvent event)
    {
        
        
    }
    
    @FXML
    void go_back (ActionEvent event)
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HomePageConnectedController.class.getClassLoader().getResource(
                "HomePage.fxml"));
        Parent root = null;
        try
        {
            root = fxmlLoader.load();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        Stage stage = (Stage) button_register.getScene().getWindow();
        assert root != null;
        Scene scene = new Scene(root, 830, 560);
        stage.setScene(scene);
        stage.show();
    }
    
}
