package IUTGo.Controllers;

import IUTGo.Models.CurrentUser;
import IUTGo.Models.PointInterest;
import IUTGo.Models.RoadTrip;
import IUTGo.Models.Users.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Set;

/**
 Created by chloe on 08/02/2017.
 */
@SuppressWarnings("ConstantConditions")
public class RoadTripCreationController
{
    private final User currentUser = CurrentUser.getInstance().getUser();
    public Label            error_PointInterest;
    public Label            error_name;
    public Button           btnSubmit;
    public Button           btnBack;
    public TextField        txtName;
    public ComboBox<String> ddlPI;
    
    @FXML
    public void initialize ()
    {
        error_name.setText("");
        error_PointInterest.setText("");
    
        ddlPI.getItems().clear();
    
        try
        {
            for (PointInterest PI : PointInterest.read().values())
            {
                if(PI.isValidated()) ddlPI.getItems().add(PI.getName());
            }
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
    }
    
    public void btnSubmit_onAction (ActionEvent actionEvent)
    {
        String name = txtName.getText().trim();
        
        //region name.isEmpty()
        if(name.isEmpty())
        {
            error_name.setText("Enter a RoadTrip Name");
            return;
        }
        //endregion
        //region ddlPI.getSelectionModel().getSelectedItem() == null
        if(ddlPI.getSelectionModel().getSelectedItem() == null)
        {
            error_PointInterest.setText("Select a Start point");
            return;
        }
        //endregion
        
        String PIName = ddlPI.getSelectionModel().getSelectedItem();
        
        try
        {
            Set<String> listRTNames = RoadTrip.read().keySet();
            
            //region listRTNames.contains(name)
            if(listRTNames.contains(name))
            {
                error_name.setText("Name already used");
                return;
            }
            //endregion
            
            currentUser.createRoadTrip(name, PIName);
            currentUser.save();
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