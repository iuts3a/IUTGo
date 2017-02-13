package IUTGo.Controllers;

import IUTGo.Models.Coordinates;
import IUTGo.Models.CurrentUser;
import IUTGo.Models.PointInterest;
import IUTGo.Models.PointInterestType;
import IUTGo.Models.Users.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CreationPointInterestController
{
    public TextField name;
    public TextField comment;
    public TextField type;
    public TextField price;
    public TextField coords1;
    public TextField coords2;
    public TextField ville;
    public Label     error_name;
    public Label     error_type;
    public Label     error_price;
    public Label     error_coords;
    
    @FXML
    private Button btn_back;
    
    @FXML
    private Button button_valider;
    
    {
        User currentUser = CurrentUser.getInstance().getUser();
        
        String x = coords1.getText().trim();
        String y = coords2.getText().trim();
        try
        {
            Coordinates coordinates = new Coordinates(Float.parseFloat(x), Float.parseFloat(y), ville.getText().trim());
            
            PointInterest newPointInterest = new PointInterest(name.getText(),
                                                               comment.getText().trim(),
                                                               PointInterestType.valueOf(type.getText().trim()),
                                                               Float.parseFloat(price.getText().trim()),
                                                               coordinates,
                                                               currentUser);
            newPointInterest.save();
            System.out.println(newPointInterest.getName());
            
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    
    @FXML
    void initialize ()
    {
        error_name.setVisible(false);
        error_price.setVisible(false);
        error_type.setVisible(false);
        error_coords.setVisible(false);
    }
    
    @SuppressWarnings("ConstantConditions")
    @FXML
    void validateData (ActionEvent event)
    {
        error_name.setVisible(false);
        error_price.setVisible(false);
        error_type.setVisible(false);
        error_coords.setVisible(false);
        
        boolean typeOk = false;
        
        if(name.getText().trim().isEmpty())
        {
            error_name.setVisible(true);
        }
        if(price.getText().trim().isEmpty())
        {
            try
            {
                Float.parseFloat(price.getText().trim());
            }
            catch (NumberFormatException e)
            {
                error_price.setVisible(true);
            }
        }
        if(coords1.getText().trim().isEmpty())
        {
            try
            {
                Float.parseFloat(coords1.getText().trim());
            }
            catch (NumberFormatException e)
            {
                error_coords.setVisible(true);
            }
        }
        if(coords2.getText().trim().isEmpty())
        {
            try
            {
                Float.parseFloat(coords2.getText().trim());
            }
            catch (NumberFormatException e)
            {
                error_coords.setVisible(true);
            }
        }
        if(ville.getText().trim().isEmpty())
        {
            error_coords.setVisible(true);
        }
        for (PointInterestType t : PointInterestType.values())
        {
            if(t.toString().equalsIgnoreCase(type.getText()))
            {
                typeOk = true;
            }
        }
        if(!typeOk)
        {
            error_type.setVisible(true);
        }
        
        if(comment.getText().trim().isEmpty())
        {
            User currentUser = CurrentUser.getInstance().getUser();
            
            String x = coords1.getText().trim();
            String y = coords2.getText().trim();
            try
            {
                Coordinates coordinates = new Coordinates(Float.parseFloat(x),
                                                          Float.parseFloat(y),
                                                          ville.getText().trim());
                
                currentUser.suggestPointInteret(name.getText(),
                                                PointInterestType.valueOf(type.getText().trim().toUpperCase()),
                                                Float.parseFloat(price.getText().trim()),
                                                coordinates);
                
                System.out.println(name.getText().trim());
                
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            User currentUser = CurrentUser.getInstance().getUser();
            
            String x = coords1.getText().trim();
            String y = coords2.getText().trim();
            try
            {
                Coordinates coordinates = new Coordinates(Float.parseFloat(x),
                                                          Float.parseFloat(y),
                                                          ville.getText().trim());
                
                currentUser.suggestPointInteret(name.getText(),
                                                comment.getText().trim(),
                                                PointInterestType.valueOf(type.getText().trim().toUpperCase()),
                                                Float.parseFloat(price.getText().trim()),
                                                coordinates);
                
                System.out.println(name.getText().trim());
                
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    
    @FXML
    void homepage (MouseEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(HomePageConnectedController.class.getClassLoader().getResource(
                    "HomePageConnected.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) button_valider.getScene().getWindow();
            Scene scene = new Scene(root, 1000, 510);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex)
        {
            System.err.println("Erreur au chargement: " + ex);
        }
        
    }
    
    @FXML
    void toBack (ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(HomePageConnectedController.class.getClassLoader().getResource(
                    "HomePageConnected.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) button_valider.getScene().getWindow();
            Scene scene = new Scene(root, 1000, 510);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex)
        {
            System.err.println("Erreur au chargement: " + ex);
        }
    }
    
}
