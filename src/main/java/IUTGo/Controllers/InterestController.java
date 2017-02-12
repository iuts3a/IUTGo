package IUTGo.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class InterestController
{
    @FXML
    private Button goBack;

    @FXML
    private Button modify;

    @FXML
    private Label label_lieu;

    @FXML
    private Label label_town;

    @FXML
    private Label label_horaires;

    @FXML
    private Label label_note;

    @FXML
    private Label label_type;

    @FXML
    private Label label_description;

    @FXML
    private Label label_prix;


    @FXML
    public void goBack(){
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
        Stage stage = (Stage) goBack.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void modify(){

    }
}
