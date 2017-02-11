package IUTGo.Controllers;

import IUTGo.Models.Coordinates;
import IUTGo.Models.Users.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.HashMap;

/**
 Created by xavier on 08/02/2017.
 */

public class InscriptionController
{
    
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
    private TextField numTel;
    
    @FXML
    private Button validate;
    
    @FXML
    void validate (ActionEvent event)
    {
        if(name.getText().trim().isEmpty()) return;
        if(firstName.getText().trim().isEmpty()) return;
        if(mail.getText().trim().isEmpty()) return;
        if(user.getText().trim().isEmpty()) return;
        if(user.getText().trim().length() < 6) return;
        if(password.getText().isEmpty()) return;
        if(!confirmPassword.getText().equals(password.getText())) return;
        
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
    
                System.out.println(newUser);
                System.out.println(listUsers);
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
        
    }
    
    @FXML
    void homepage (ActionEvent event)
    {
        
    }
}
