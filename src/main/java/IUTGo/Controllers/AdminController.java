package IUTGo.Controllers;

import IUTGo.Models.PointInterest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {

    @FXML
    private ListView<PointInterest> tv_pending_approval;

    @FXML
    private Button btn_accept;

    @FXML
    private Button btn_refuse;

    @FXML
    private Button retour;

    @FXML
    public void accept(ActionEvent event) {

    }

    @FXML
    public void refuse(ActionEvent event) {

    }

    @FXML
    public void goBack(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(HomePageConnectedController.class.getClassLoader().getResource("HomePage.fxml"));
        Parent root = null;
        try
        {
            root = fxmlLoader.load();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        Stage stage = (Stage) retour.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
