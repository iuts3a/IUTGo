package IUTGo.Controllers;

import IUTGo.Models.CurrentUser;
import IUTGo.Models.Users.Admin;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 Created by chloe on 08/02/2017.
 */
public class HomePageConnectedController
{
    public MenuButton menubtn;
    
    @FXML
    void initialize ()
    {
        //region menubtn.get(UserInfo).setOnAction
        menubtn.getItems().get(0).setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle (ActionEvent event)
            {
                Service.goTo("UserInfo.fxml", (Stage) menubtn.getScene().getWindow());
            }
        });
        //endregion
        //region menubtn.get(LogOut).setOnAction
        menubtn.getItems().get(1).setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle (ActionEvent event)
            {
                Service.goTo("HomePage.fxml", (Stage) menubtn.getScene().getWindow());
                CurrentUser.Init("");
            }
        });
        //endregion
    
        if(!(CurrentUser.getInstance().getUser() instanceof Admin))
        {
            menubtn.getItems().add(new MenuItem("Admin Section"));
            //region menubtn.get(Admin Section).setOnAction
            menubtn.getItems().get(2).setOnAction(new EventHandler<ActionEvent>()
            {
                public void handle (ActionEvent event)
                {
                    Service.goTo("AdminPage.fxml", (Stage) menubtn.getScene().getWindow());
                }
            });
            //endregion
        }
    }
    
    public void imgAddRT_onMouseClick (MouseEvent mouseEvent)
    {
        Service.goTo("RoadTripCreation.fxml", (Stage) menubtn.getScene().getWindow());
    }
    
    public void imgSearchRT_onMouseClick (MouseEvent mouseEvent)
    {
        Service.goTo("RoadTripSearch.fxml", (Stage) menubtn.getScene().getWindow());
    }
    
    public void imgSearchPI_onMouseClick (MouseEvent mouseEvent)
    {
        Service.goTo("PointInterestSearch.fxml", (Stage) menubtn.getScene().getWindow());
    }
    
    public void imgAddPI_onMouseClick (MouseEvent mouseEvent)
    {
        Service.goTo("PointInterestCreation.fxml", (Stage) menubtn.getScene().getWindow());
    }
}
