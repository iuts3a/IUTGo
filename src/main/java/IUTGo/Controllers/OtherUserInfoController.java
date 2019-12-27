package IUTGo.Controllers;

import IUTGo.Models.RoadTrip;
import IUTGo.Models.Users.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class OtherUserInfoController {
    public Label lblEmail;
    public Label lblFullName;
    public Label lblUserName;

    public ListView<String> listViewRT;

    public Button btnShowRT;
    public Button btnBack;

    private User observedUser;
    private String originURL;

    public void pipeline(String userName, String originURL) {
        try {
            this.observedUser = User.read().get(userName);
            this.originURL = originURL;
            init();
        }
        //region catch
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //endregion
    }

    private void init() {
        lblEmail.setText(observedUser.getEmail());
        lblUserName.setText(observedUser.getUserName());
        lblFullName.setText(observedUser.getLastName() + " " + observedUser.getFirstName());

        try {
            listViewRT.getItems().clear();
            Service.populateListView(listViewRT, RoadTrip.read().keySet());
        }
        //region catch
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //endregion
    }

    public void btnShowRT_onAction(ActionEvent actionEvent) {
        if (listViewRT.getSelectionModel().getSelectedItem() != null) {
            FXMLLoader fxmlLoader = new FXMLLoader(RoadTripController.class.getClassLoader().getResource("RoadTrip.fxml"));

            String selectedItem = listViewRT.getSelectionModel().getSelectedItem();

            ((RoadTripController) fxmlLoader.getController()).pipeline(selectedItem, "OtherUserInfo.fxml");

            Service.goTo("RoadTrip.fxml", (Stage) btnBack.getScene().getWindow());
        }
    }

    public void btnBack_onAction(ActionEvent event) {
        Service.goTo(originURL, (Stage) btnBack.getScene().getWindow());
    }

    public void homePage_onMouseClick(MouseEvent mouseEvent) {
        Service.goTo("HomePageConnected.fxml", (Stage) btnBack.getScene().getWindow());
    }

    public void btnShowRT(ActionEvent actionEvent) {
    }

    public void btnRemoveRT(ActionEvent actionEvent) {
    }
}