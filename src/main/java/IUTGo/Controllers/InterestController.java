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
    private Button retour;

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
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(InscriptionController.class.getClassLoader().getResource("HomePageConnected.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) retour.getScene().getWindow();
            Scene scene = new Scene(root, 1000, 510);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void modify(){

    }
}
