package IUTGo.Controllers;

import IUTGo.Models.PointInterest;
import IUTGo.Models.RoadTrip;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

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
    private Label label_note;

    @FXML
    private Label label_type;

    @FXML
    private Label label_description;

    @FXML
    private Label label_nom;

    @FXML
    private Label label_prix;

    String pi = null;

    public void pipeline(String r) throws IOException, ClassNotFoundException {
        pi = PointInterest.read().get(r).getName();
        next();
    }

    @FXML
    void next() throws IOException, ClassNotFoundException {
        label_nom.setText(pi);
        PointInterest p = PointInterest.read().get(pi);
        label_description.setText(p.getDescription());
        label_note.setText(String.valueOf(p.getGrade()));
        label_prix.setText(String.valueOf(p.getPrice()));
        label_town.setText(p.getCoordinates().getCity());
        label_type.setText(p.getType().toString());
    }

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
