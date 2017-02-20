package IUTGo.Controllers;

import IUTGo.Models.CurrentUser;
import IUTGo.Models.Users.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ConnexionController
{
    public Button        btnConnexion;
    public TextField     txtEmail;
    public PasswordField txtPassword;
    public Button        btnBack;
    public Label         error_login;
    
    @FXML
    public void initialize ()
    {
        error_login.setText("");
    }
    
    public void btnConnexion_onAction (ActionEvent actionEvent)
    {
        String email = txtEmail.getText().trim();
        String password = txtPassword.getText().trim();
        
        try
        {
            if(!User.read().containsKey(email) || !User.read().get(email).getPassword().equals(password))
            {
                error_login.setText("Email or Password is invalid");
                return;
            }
    
            CurrentUser.Init(email);
    
            Service.goTo("HomePageConnected.fxml", (Stage) btnBack.getScene().getWindow());
        }
        //region catch
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //endregion
    }
    
    public void btnBack_onAction (ActionEvent event)
    {
        Service.goTo("HomePage.fxml", (Stage) btnBack.getScene().getWindow());
    }
    
    public void homePage_onMouseClick (MouseEvent mouseEvent)
    {
        Service.goTo("HomePage.fxml", (Stage) btnBack.getScene().getWindow());
    }
}
