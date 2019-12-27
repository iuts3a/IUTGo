package IUTGo.Controllers;

import IUTGo.Models.PointInterest;
import IUTGo.Models.PointInterestType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by vmonsch on 08/02/2017.
 */

public class PointInterestSearchController {
    public Button btnReset;
    public Button btnSearch;
    public Button btnShowPI;
    public Button btnBack;

    public ListView<String> listViewPI;

    public ComboBox<String> ddlType;
    public ComboBox<Integer> ddlGrade;

    @FXML
    void initialize() {
        ddlGrade.getItems().clear();
        ddlType.getItems().clear();
        listViewPI.getItems().clear();

        ddlGrade.getItems().addAll(1, 2, 3, 4, 5);

        for (PointInterestType type : PointInterestType.values()) {
            ddlType.getItems().add(type.toString());
        }

        try {
            for (PointInterest PI : PointInterest.read().values()) {
                if (PI.isValidated()) Service.populateListView(listViewPI, PI.getName());
            }
        }
        //region catch
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //endregion
    }

    public void btnReset_onAction(ActionEvent actionEvent) {
        ddlType.getSelectionModel().clearSelection();
        ddlGrade.getSelectionModel().clearSelection();
        initialize();
    }

    public void btnSearch_onAction(ActionEvent actionEvent) {
        Integer selectedGrade = 0;
        String selectedType = "";
        Boolean gradeChecked = false;
        Boolean typeChecked = false;

        if (ddlGrade.getSelectionModel().getSelectedItem() != null) {
            selectedGrade = ddlGrade.getSelectionModel().getSelectedItem();
            gradeChecked = true;
        }
        if (ddlType.getSelectionModel().getSelectedItem() != null) {
            selectedType = ddlType.getSelectionModel().getSelectedItem().toUpperCase();
            typeChecked = true;
        }

        try {
            HashMap<String, PointInterest> listPi = PointInterest.read();

            for (PointInterest pi : listPi.values()) {
                if (!gradeChecked && !typeChecked) listViewPI.getItems().addAll(listPi.keySet());

                if (gradeChecked && !typeChecked && pi.getGrade() >= selectedGrade) {
                    if (pi.isValidated()) listViewPI.getItems().add(pi.getName());
                }

                if (!gradeChecked && typeChecked && pi.getType().equals(PointInterestType.valueOf(selectedType))) {
                    if (pi.isValidated()) listViewPI.getItems().add(pi.getName());
                }

                if (gradeChecked && typeChecked && pi.getGrade() >= selectedGrade && pi.getType().equals(
                        PointInterestType.valueOf(selectedType))) {
                    if (pi.isValidated()) listViewPI.getItems().add(pi.getName());
                }
            }
        }
        //region catch
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //endregion

        initialize();
    }

    public void btnShowPI_onAction(ActionEvent actionEvent) {
        if (listViewPI.getSelectionModel().getSelectedItem() != null) {
            FXMLLoader fxmlLoader = new FXMLLoader(RoadTripController.class.getClassLoader().getResource(
                    "PointInterest.fxml"));

            String selectedItem = listViewPI.getSelectionModel().getSelectedItem();

            ((PointInterestController) fxmlLoader.getController()).pipeline(selectedItem, "PointInterest.fxml");

            Service.goTo("PointInterest.fxml", (Stage) btnBack.getScene().getWindow());
        }
    }

    public void btnBack_onAction(ActionEvent event) {
        Service.goTo("HomePageConnected.fxml", (Stage) btnBack.getScene().getWindow());
    }

    public void homePage_onMouseClick(MouseEvent mouseEvent) {
        Service.goTo("HomePageConnected.fxml", (Stage) btnBack.getScene().getWindow());
    }

}
