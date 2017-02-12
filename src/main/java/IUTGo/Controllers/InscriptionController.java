package IUTGo.Controllers;

import IUTGo.Models.Coordinates;
import IUTGo.Models.CurrentUser;
import IUTGo.Models.Users.User;
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
 Created by xavier on 08/02/2017.
 */

@SuppressWarnings("unused")
public class InscriptionController
{
    
    public  Label     error_user;
    public  Label     error_email;
    public  Label     error_password;
    @FXML
    private TextField firstName;
    
    @FXML
    private PasswordField password;
    
    @FXML
    private TextField mail;
    
    @FXML
    private TextField name;
    
    @FXML
    private PasswordField confirmPassword;
    
    @FXML
    private Button back;
    
    @FXML
    private CheckBox conditions;
    
    @FXML
    private TextField user;
    
    @FXML
    private Button validate;
    
    @FXML
    void initialize ()
    {
        error_email.setVisible(false);
        error_user.setVisible(false);
        error_password.setVisible(false);
    }
    
    @FXML
    void validate (ActionEvent event)
    {
        error_email.setVisible(false);
        error_user.setVisible(false);
        error_password.setVisible(false);
        
        if(name.getText().trim().isEmpty()) return;
        if(firstName.getText().trim().isEmpty()) return;
        if(mail.getText().trim().isEmpty())
        {
            if(user.getText().trim().isEmpty())
            {
                error_user.setVisible(true);
                return;
            }
        }
        if(user.getText().trim().length() < 6)
        {
            error_user.setVisible(true);
            return;
        }
        if(password.getText().isEmpty()) return;
        if(!confirmPassword.getText().equals(password.getText()))
        {
            error_password.setVisible(true);
            return;
        }
        
        try
        {
            HashMap<String, User> listUsers = User.read();
            
            if(!listUsers.containsKey(mail.getText()))
            {
                User newUser = new User(name.getText(),
                                        firstName.getText(),
                                        user.getText(),
                                        mail.getText(),
                                        password.getText(),
                                        new Coordinates(1, 2, "Ville"));
                
                newUser.save();
                CurrentUser.Init(mail.getText());
                
                FXMLLoader fxmlLoader = new FXMLLoader(HomePageConnectedController.class.getClassLoader().getResource(
                        "HomePageConnected.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = (Stage) validate.getScene().getWindow();
                Scene scene = new Scene(root, 680, 700);
                stage.setScene(scene);
                stage.show();
            }
            else
            {
                error_email.setVisible(true);
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
    void back (ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(InscriptionController.class.getClassLoader().getResource(
                    "HomePage.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) validate.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    @FXML
    void homepage (MouseEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(InscriptionController.class.getClassLoader().getResource(
                    "HomePage.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) validate.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
