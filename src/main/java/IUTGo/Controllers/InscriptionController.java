package IUTGo.Controllers;

import IUTGo.Models.Coordinates;
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

public class InscriptionController
{
    public TextField txtEmail;
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtUserName;
    public TextField txtXpos;
    public TextField txtYpos;
    public TextField txtTown;
    
    public PasswordField txtPassword1;
    public PasswordField txtPassword2;
    
    public Button btnSubmit;
    public Button btnBack;
    
    public Label error_user;
    public Label error_email;
    public Label error_lastName;
    public Label error_firstName;
    public Label error_password1;
    public Label error_password2;
    public Label error_coordinates;
    
    @FXML
    void initialize ()
    {
        error_user.setText("");
        error_email.setText("");
        error_lastName.setText("");
        error_firstName.setText("");
        error_password1.setText("");
        error_password2.setText("");
        error_coordinates.setText("");
    }
    
    public void btnSubmit_onAction (ActionEvent actionEvent)
    {
        //region =============== TextField => String ===============
        String email = txtEmail.getText().trim();
        String firstName = txtFirstName.getText().trim();
        String lastName = txtLastName.getText().trim();
        String userName = txtUserName.getText().trim();
        String password1 = txtPassword1.getText().trim();
        String password2 = txtPassword2.getText().trim();
        String Xpos = txtXpos.getText().trim();
        String Ypos = txtYpos.getText().trim();
        String town = txtTown.getText().trim();
        //endregion
    
        //region =============== String.isEmpty() ? ===============
        //region firstName.isEmpty()
        if(firstName.isEmpty())
        {
            error_firstName.setText("Enter your First Name");
            return;
        }
        //endregion
        //region lastName.isEmpty()
        if(lastName.isEmpty())
        {
            error_lastName.setText("Enter your Last Name");
            return;
        }
        //endregion
        //region userName.isEmpty()
        if(userName.isEmpty())
        {
            error_user.setText("Enter your User Name");
            return;
        }
        //endregion
        //region email.isEmpty()
        if(email.isEmpty())
        {
            error_email.setText("Enter an Email");
            return;
        }
        //endregion
        //region password1.isEmpty()
        if(password1.isEmpty())
        {
            error_password1.setText("Enter an password");
            return;
        }
        //endregion
        //region password2.isEmpty()
        if(password2.isEmpty())
        {
            error_password2.setText("You must confirm your password");
            return;
        }
        //endregion
        //region Xpos.isEmpty()
        if(Xpos.isEmpty())
        {
            error_coordinates.setText("Enter an Xpos");
            return;
        }
        //endregion
        //region Ypos.isEmpty()
        if(Ypos.isEmpty())
        {
            error_coordinates.setText("Enter an Ypos");
            return;
        }
        //endregion
        //region town.isEmpty()
        if(town.isEmpty())
        {
            error_coordinates.setText("Enter a Town");
            return;
        }
        //endregion
        //endregion
    
        //region =============== Specific Validation ===============
        //region !firstName.matches("\\p{L}*")
        if(!firstName.matches("\\p{L}*"))
        {
            error_firstName.setText("Only letters allowed in First Name");
            return;
        }
        //endregion
        //region !lastName.matches("\\p{L}*")
        if(!lastName.matches("\\p{L}*"))
        {
            error_lastName.setText("Only letters allowed in Last Name");
            return;
        }
        //endregion
        //region userName.length() < 6
        if(userName.length() < 6)
        {
            error_user.setText("Must be minimum 6 characters");
            return;
        }
        //endregion
        //region !email.matches("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+")
        if(!email.matches("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+"))
        {
            error_email.setText("Enter a valid Email");
            return;
        }
        //endregion
        //region !password1.equals(password2)
        if(!password1.equals(password2))
        {
            error_password2.setText("The passwords must be the same");
            return;
        }
        //endregion
        //region !Xpos.matches("[a-zA-Z0-9]{1,2}.[a-zA-Z0-9]")
        if(!Xpos.matches("[a-zA-Z0-9]{1,2}.[a-zA-Z0-9]"))
        {
            error_coordinates.setText("Only digits allowed for Xpos");
            return;
        }
        //endregion
        //region !Ypos.matches("[a-zA-Z0-9]{1,2}.[a-zA-Z0-9]")
        if(!Ypos.matches("[a-zA-Z0-9]{1,2}.[a-zA-Z0-9]"))
        {
            error_coordinates.setText("Only digits allowed for Ypos");
            return;
        }
        //endregion
        //region !town.matches("\\p{L}*")
        if(!town.matches("\\p{L}*"))
        {
            error_coordinates.setText("Only letters allowed in Town");
            return;
        }
        //endregion
        //endregion
    
        try
        {
            //region Email already used
            if(User.read().containsKey(email))
            {
                error_email.setText("Email already used");
                return;
            }
            //endregion
            //region UserName already used
            for (User user : User.read().values())
            {
                if(user.getUserName().equals(userName))
                {
                    error_email.setText("UserName already used");
                    return;
                }
            }
            //endregion
        
            Coordinates coords = new Coordinates(Float.parseFloat(Xpos), Float.parseFloat(Ypos), town);
        
            User newUser = new User(lastName, firstName, userName, email, password1, coords);
        
            newUser.save();
        
            CurrentUser.Init(email);
        
            Service.goTo("HomePageConnected.fxml", (Stage) btnBack.getScene().getWindow());
        }
        //region catch
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        //endregion
    
        initialize();
    }
    
    public void btnBack_onAction (ActionEvent actionEvent)
    {
        Service.goTo("HomePage.fxml", (Stage) btnBack.getScene().getWindow());
    }
    
    public void homePage_onMouseClick (MouseEvent mouseEvent)
    {
        Service.goTo("HomePage.fxml", (Stage) btnBack.getScene().getWindow());
    }
}
