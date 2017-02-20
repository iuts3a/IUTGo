package IUTGo.Controllers;

import IUTGo.Models.RoadTrip;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class RoadTripSearchController
{
    public Button           btnFilter;
    public TextField        txtRTName;
    public Button           btnReset;
    public Button           btnShowRT;
    public Button           btnBack;
    public ListView<String> listViewRT;
    
    @FXML
    void initialize ()
    {
        try
        {
            txtRTName.setText("");
            listViewRT.getItems().clear();
            Service.populateListView(listViewRT, RoadTrip.read().keySet());
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
    
    public void btnReset_onAction (ActionEvent actionEvent)
    {
        txtRTName.setText("");
        initialize();
    }
    
    public void btnFilter_onAction (ActionEvent actionEvent)
    {
        String name = txtRTName.getText().trim();
        
        if(name.isEmpty())
        {
            return;
        }
        
        try
        {
            listViewRT.getItems().clear();
            
            for (String RTName : RoadTrip.read().keySet())
            {
                if(RTName.contains(name)) Service.populateListView(listViewRT, RTName);
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
    
    public void btnShowRTonAction (ActionEvent event)
    {
        if(listViewRT.getSelectionModel().getSelectedItem() != null)
        {
            FXMLLoader fxmlLoader = new FXMLLoader(RoadTripController.class.getClassLoader().getResource("Roadtrip.fxml"));
            
            String selectedItem = listViewRT.getSelectionModel().getSelectedItem();
            
            ((RoadTripController) fxmlLoader.getController()).pipeline(selectedItem, "RoadTripSerach.fxml");
            
            Service.goTo("RoadTrip.fxml", (Stage) btnBack.getScene().getWindow());
        }
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
