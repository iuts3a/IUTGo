package IUTGo.Controllers;

import IUTGo.Models.PointInterest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
    void initialize(){
        ObservableList data = FXCollections.observableArrayList();
        try {
            HashMap<String, PointInterest> pointInterest = PointInterest.read();
            for(Map.Entry<String, PointInterest> entry : pointInterest.entrySet()) {
                if(!entry.getValue().isValidated()){
                    data.add(entry.getKey());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }




        tv_pending_approval.setItems(data);
    }

    @FXML
    public void accept(ActionEvent event) {
        if(tv_pending_approval.getSelectionModel().getSelectedItem() != null){
            try {
                PointInterest.read().get(tv_pending_approval.getSelectionModel().getSelectedItem()).setValidated(true);
                PointInterest.read().get(tv_pending_approval.getSelectionModel().getSelectedItem()).save();
                System.out.println(PointInterest.read().get(tv_pending_approval.getSelectionModel().getSelectedItem()).isValidated());
                ObservableList data = FXCollections.observableArrayList();

                    HashMap<String, PointInterest> pointInterest = PointInterest.read();
                    for(Map.Entry<String, PointInterest> entry : pointInterest.entrySet()) {
                        if(!entry.getValue().isValidated()){
                            data.add(entry.getKey());
                        }
                    }
                tv_pending_approval.setItems(data);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void refuse(ActionEvent event) {
        if(tv_pending_approval.getSelectionModel().getSelectedItem() != null){
            try {
                PointInterest.read().remove(tv_pending_approval.getSelectionModel().getSelectedItem() );
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void goBack(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(HomePageConnectedController.class.getClassLoader().getResource("HomePageConnected.fxml"));
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

    public void homepage(MouseEvent mouseEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HomePageConnectedController.class.getClassLoader().getResource("HomePageConnected.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) retour.getScene().getWindow();
            Scene scene = new Scene(root, 1000, 510);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println("Erreur au chargement: " + ex);
        }
    }
}
