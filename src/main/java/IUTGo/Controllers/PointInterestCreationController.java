package IUTGo.Controllers;

import IUTGo.Models.Coordinates;
import IUTGo.Models.CurrentUser;
import IUTGo.Models.PointInterestType;
import IUTGo.Models.Users.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

@SuppressWarnings({"ConstantConditions"})
public class PointInterestCreationController
{
    public Label error_name;
    public Label error_type;
    public Label error_price;
    public Label error_coords;
    
    public TextField txtName;
    public TextField txtDescription;
    public TextField txtPrice;
    public TextField txtXpos;
    public TextField txtYpos;
    public TextField txtTown;
    
    public Button btnSubmit;
    public Button btnBack;
    
    public ComboBox<String> ddlType;
    
    @FXML
    void initialize ()
    {
        txtName.setText("");
        txtDescription.setText("");
        txtPrice.setText("");
        txtXpos.setText("");
        txtYpos.setText("");
        txtTown.setText("");
        
        ddlType.getItems().clear();
        
        for (PointInterestType PIT : PointInterestType.values())
        {
            ddlType.getItems().add(PIT.toString());
        }
    }
    
    public void btnSubmit_onAction (ActionEvent actionEvent)
    {
        error_coords.setText("");
        error_coords.setTextFill(Color.web("RED"));
        
        //region =============== TextField => String ===============
        String name = txtName.getText().trim();
        String description = txtDescription.getText().trim();
        String type = ddlType.getSelectionModel().getSelectedItem().toUpperCase();
        String price = txtPrice.getText().trim();
        String xpos = txtXpos.getText().trim();
        String ypos = txtYpos.getText().trim();
        String town = txtTown.getText().trim();
        //endregion
        
        //region =============== String.isEmpty() ? ===============
        //region name.isEmpty()
        if(name.isEmpty())
        {
            error_name.setText("Enter a Name");
            return;
        }
        //endregion
        //region price.isEmpty()
        if(price.isEmpty())
        {
            error_price.setText("Enter a Price");
            return;
        }
        //endregion
        //region xpos.isEmpty()
        if(xpos.isEmpty())
        {
            error_coords.setText("Enter a Xpos");
            return;
        }
        //endregion
        //region ypos.isEmpty()
        if(ypos.isEmpty())
        {
            error_coords.setText("Enter a Ypos");
            return;
        }
        //endregion
        //region town.isEmpty()
        if(town.isEmpty())
        {
            error_coords.setText("Enter a Town");
            return;
        }
        //endregion
        //endregion
        
        //region =============== Specific Validation ===============
        //region !price.matches("[0-9]{1,2}(.[0-9]){0,2}")
        if(!price.matches("[0-9]{1,2}(.[0-9]){0,2}"))
        {
            error_price.setText("Only digits allowed for Price");
            return;
        }
        //endregion
        //region !xpos.matches("[0-9]{1,2}(.[0-9]){0,2}")
        if(!xpos.matches("[0-9]{1,2}(.[0-9]){0,2}"))
        {
            error_coords.setText("Only digits allowed for Xpos");
            return;
        }
        //endregion
        //region !ypos.matches("[0-9]{1,2}(.[0-9]){0,2}")
        if(!ypos.matches("[0-9]{1,2}(.[0-9]){0,2}"))
        {
            error_coords.setText("Only digits allowed for Ypos");
            return;
        }
        //endregion
        //region !town.matches("\\p{L}*")
        if(!town.matches("\\p{L}*"))
        {
            error_coords.setText("Only letters allowed in Town");
            return;
        }
        //endregion
        //endregion
        
        User currentUser = CurrentUser.getInstance().getUser();
        
        Float Xpos = Float.valueOf(xpos);
        Float Ypos = Float.valueOf(ypos);
        
        Coordinates coordinates = new Coordinates(Xpos, Ypos, town);
        
        if(description.isEmpty())
        {
            currentUser.suggestPointInteret(name, PointInterestType.valueOf(type), Float.parseFloat(price), coordinates);
        }
        else
        {
            currentUser.suggestPointInteret(name,
                                            description,
                                            PointInterestType.valueOf(type),
                                            Float.parseFloat(price),
                                            coordinates);
        }
        
        error_coords.setText("Point Interest Created.");
        error_coords.setTextFill(Color.web("Green"));
        initialize();
    }
    
    public void btnBack_onAction (ActionEvent event)
    {
        Service.goTo("HomePageConnected.fxml", (Stage) btnBack.getScene().getWindow());
    }
    
    public void homePage_onMouseClick (MouseEvent mouseEvent)
    {
        Service.goTo("HomePageConnected.fxml", (Stage) btnBack.getScene().getWindow());
    }
}