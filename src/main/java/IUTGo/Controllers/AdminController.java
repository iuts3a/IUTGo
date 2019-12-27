package IUTGo.Controllers;

import IUTGo.Models.PointInterest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {
    public Button btnRejecet;
    public Button btnAccept;
    public Button btnBack;
    public ListView<String> listViewPendingAprouval;

    @FXML
    void initialize() {
        try {
            listViewPendingAprouval.getItems().clear();
            for (PointInterest pi : PointInterest.read().values()) {
                if (!pi.isValidated()) {
                    Service.populateListView(listViewPendingAprouval, pi.getName());
                }
            }
        }
        //region catch
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //endregion
    }

    public void btnAccept_onAction(ActionEvent event) {
        try {
            if (listViewPendingAprouval.getSelectionModel().getSelectedItem() != null) {
                String selectedPIName = listViewPendingAprouval.getSelectionModel().getSelectedItem();
                PointInterest selectedPI = PointInterest.read().get(selectedPIName);

                selectedPI.setValidated(true);
                selectedPI.save();

                initialize();
            }
        }
        //region catch
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //endregion
    }

    public void btnRejecet_onAction(ActionEvent actionEvent) {
        if (listViewPendingAprouval.getSelectionModel().getSelectedItem() != null) {
            try {
                String selectedPointInterest = listViewPendingAprouval.getSelectionModel().getSelectedItem();
                PointInterest.read().remove(selectedPointInterest);
                initialize();
            }
            //region catch
            catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            //endregion
        }
    }

    public void btnBack_onAction(ActionEvent event) {
        Service.goTo("HomePageConnected.fxml", (Stage) btnBack.getScene().getWindow());
    }

    public void homePage_onMouseClicks(MouseEvent mouseEvent) {
        Service.goTo("HomePageConnected.fxml", (Stage) btnBack.getScene().getWindow());
    }
}
