package IUTGo.Controllers;

import IUTGo.Models.CurrentUser;
import IUTGo.Models.Users.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.io.IOException;

/**
 Created by chloe on 08/02/2017.
 */
public class HomePageConnectedController
{
    public  Hyperlink hl_admin;
    @FXML
    private Button    btn_create_PI;
    
    @FXML
    private Button btn_create_rt;
    
    @FXML
    private Button btn_search_pi;
    
    @FXML
    private Button btn_see_rt;
    
    @FXML
    private Hyperlink hl_deco;
    
    @FXML
    private Hyperlink hl_info;
    
    @FXML
    void initialize ()
    {
        if(!(CurrentUser.getInstance().getUser() instanceof Admin)) hl_admin.setVisible(false);
    }
    
    @FXML
    void create_rt (ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(CreateItineraireController.class.getClassLoader().getResource(
                    "RoadTripCreation.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) btn_create_rt.getScene().getWindow();
            Scene scene = new Scene(root, 800, 550);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex)
        {
            System.err.println("Erreur au chargement: " + ex);
        }
    }
    
    @FXML
    void see_rt (ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(CreateItineraireController.class.getClassLoader().getResource("FilterRoadTrip.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) btn_see_rt.getScene().getWindow();
            Scene scene = new Scene(root, 1000, 800);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex)
        {
            System.err.println("Erreur au chargement: " + ex);
        }
    }
    
    @FXML
    void search_pi (ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(CreateItineraireController.class.getClassLoader().getResource("FilterPoinInterest.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) btn_create_rt.getScene().getWindow();
            Scene scene = new Scene(root,1000, 800);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex)
        {
            System.err.println("Erreur au chargement: " + ex);
        }
    }
    
    @FXML
    void create_PI(ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(CreateItineraireController.class.getClassLoader().getResource("FilterPoinInterest.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) btn_create_PI.getScene().getWindow();
            Scene scene = new Scene(root,1000, 800);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex)
        {
            System.err.println("Erreur au chargement: " + ex);
        }
    }
    
    @FXML
    void deco (ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(HomePageController.class.getClassLoader().getResource("HomePage.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) btn_create_rt.getScene().getWindow();
            Scene scene = new Scene(root, 830, 560);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex)
        {
            System.err.println("Erreur au chargement: " + ex);
        }
    }
    
    @FXML
    void informations (ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(UserInfoController.class.getClassLoader().getResource("UserInfo.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) btn_create_rt.getScene().getWindow();
            Scene scene = new Scene(root, 780, 700);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex)
        {
            System.err.println("Erreur au chargement: " + ex);
        }
    }
}
