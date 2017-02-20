package IUTGo.Controllers;

import IUTGo.Models.CurrentUser;
import IUTGo.Models.PointInterest;
import IUTGo.Models.RoadTrip;
import IUTGo.Models.Users.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class RoadTripController
{
    private final User currentUser = CurrentUser.getInstance().getUser();
    public  Label            lblName;
    public  Label            txtPrice;
    public  Label            txtGrade;
    public  Button           btnBack;
    public  Button           btnSubmit;
    public  CheckBox         chkbxInscription;
    public  ComboBox<String> ddlSuggestPI;
    public  ListView<String> listViewUsers;
    public  ListView<String> listViewPI;
    public  Button           btnShowPI;
    public  Button           btnShowUser;
    private RoadTrip         RT;
    private String           originURL;
    
    public void pipeline (String roadTripName, String originURL)
    {
        try
        {
            this.RT = RoadTrip.read().get(roadTripName);
            this.originURL = originURL;
            this.lblName.setText(roadTripName);
            init();
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
    
    private void init ()
    {
        chkbxInscription.setVisible(false);
        listViewPI.getItems().clear();
        listViewUsers.getItems().clear();
        ddlSuggestPI.getItems().clear();
        try
        {
            txtPrice.setText(String.valueOf(RT.getPrice()));
            txtGrade.setText(String.valueOf(RT.getGrade()));
            
            for (String piName : RoadTrip.read().get(RT.getName()).getPointInterests().keySet())
            {
                listViewPI.getItems().add(piName);
            }
            
            for (String userName : RT.getParticipants().keySet())
            {
                listViewUsers.getItems().add(userName);
            }
            
            for (PointInterest PI : RT.getPointInterests().values())
            {
                ddlSuggestPI.getItems().add(PI.getName());
            }
            
            if(!RT.getParticipants().containsKey(currentUser.getEmail()))
            {
                chkbxInscription.setVisible(true);
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
        try
        {
            User user = CurrentUser.getInstance().getUser();
            
            if(chkbxInscription.isSelected()) user.signIn(RT.getName());
            
            if(ddlSuggestPI.getSelectionModel().getSelectedItem() != null)
            {
                PointInterest pi = PointInterest.read().get(ddlSuggestPI.getSelectionModel().getSelectedItem());
                RT.addPointInterest(pi);
                RT.save();
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
        
        init();
    }
    
    public void btnShowPI_onAction (ActionEvent actionEvent)
    {
        if(listViewPI.getSelectionModel().getSelectedItem() != null)
        {
            FXMLLoader fxmlLoader = new FXMLLoader(RoadTripController.class.getClassLoader().getResource(
                    "PointInterest.fxml"));
    
            String selectedItem = listViewPI.getSelectionModel().getSelectedItem();
    
            ((PointInterestController) fxmlLoader.getController()).pipeline(selectedItem, "RoadTrip.fxml");
    
            Service.goTo("PointInterest.fxml", (Stage) btnBack.getScene().getWindow());
        }
    }
    
    public void btnShowUser_onAction (ActionEvent actionEvent)
    {
        if(listViewUsers.getSelectionModel().getSelectedItem() != null)
        {
            FXMLLoader fxmlLoader = new FXMLLoader(RoadTripController.class.getClassLoader().getResource(
                    "OtherUserInfo.fxml"));
    
            String selectedItem = listViewUsers.getSelectionModel().getSelectedItem();
    
            ((OtherUserInfoController) fxmlLoader.getController()).pipeline(selectedItem, "RoadTrip.fxml");
    
            Service.goTo("OtherUserInfo.fxml", (Stage) btnBack.getScene().getWindow());
        }
    }
    
    public void btnBack_onAction (ActionEvent event)
    {
        Service.goTo(originURL, (Stage) btnBack.getScene().getWindow());
    }
    
    public void homePage_onMouseClick (MouseEvent mouseEvent)
    {
        Service.goTo("HomePageConnected.fxml", (Stage) btnBack.getScene().getWindow());
    }
}
