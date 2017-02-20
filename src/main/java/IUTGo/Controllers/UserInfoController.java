package IUTGo.Controllers;

import IUTGo.Models.CurrentUser;
import IUTGo.Models.RoadTrip;
import IUTGo.Models.Users.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class UserInfoController
{
    public Button           btnBack;
    public Button           btnShowRT;
    public Label            lblEmail;
    public Label            lblFullName;
    public ListView<String> listViewRT;
    public Label            lblUserName;
    public Button           btnRemoveRT;
    
    @FXML
    void initialize ()
    {
        User user = CurrentUser.getInstance().getUser();
    
        lblEmail.setText(user.getEmail());
        lblFullName.setText(user.getUserName());
        lblFullName.setText(user.getLastName() + " " + user.getFirstName());
    
        listViewRT.getItems().clear();
        Service.populateListView(listViewRT, user.getFavoriteRoadTrips().keySet());
    }
    
    public void btnShowRT (ActionEvent actionEvent)
    {
        if(listViewRT.getSelectionModel().getSelectedItem() != null)
        {
            FXMLLoader fxmlLoader = new FXMLLoader(RoadTripController.class.getClassLoader().getResource("Roadtrip.fxml"));
    
            String selectedItem = listViewRT.getSelectionModel().getSelectedItem();
    
            ((RoadTripController) fxmlLoader.getController()).pipeline(selectedItem, "UserInfo.fxml");
    
            Service.goTo("RoadTrip.fxml", (Stage) btnBack.getScene().getWindow());
        }
    
        initialize();
    }
    
    public void btnRemoveRT (ActionEvent actionEvent)
    {
        if(listViewRT.getSelectionModel().getSelectedItem() != null)
        {
            try
            {
                User currentUser = CurrentUser.getInstance().getUser();
                String selectedRoadTrip = listViewRT.getSelectionModel().getSelectedItem();
                RoadTrip roadTrip = RoadTrip.read().get(selectedRoadTrip);
            
                roadTrip.deleteParticipants(currentUser.getUserName());
            
                currentUser.getFavoriteRoadTrips().remove(selectedRoadTrip);
            
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
    
        initialize();
    }
    
    public void btnBack_onAction (ActionEvent actionEvent)
    {
        Service.goTo("HomePageConnected.fxml", (Stage) btnBack.getScene().getWindow());
    }
    
    public void homePage_onMouseClick (MouseEvent mouseEvent)
    {
        Service.goTo("HomePageConnected.fxml", (Stage) btnBack.getScene().getWindow());
    }
}