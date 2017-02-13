package IUTGo.Controllers;

import IUTGo.Models.Comment;
import IUTGo.Models.CurrentUser;
import IUTGo.Models.PointInterest;
import IUTGo.Models.Users.Admin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

@SuppressWarnings("unchecked")
public class InterestController
{
    @FXML
    private Button modifier;
    
    @FXML
    private TextField label_nom;
    
    @FXML
    private ListView<String> list_comment;
    
    @FXML
    private TextField nouvelle_note;
    
    @FXML
    private TextArea nouveau_comment;
    
    @FXML
    private Button retour;
        
    @FXML
    private TextField label_lieu;
    
    @FXML
    private TextField label_town;
    
    @FXML
    private TextField label_horaires;
    
    @FXML
    private TextField label_note;
    
    @FXML
    private TextField label_type;
    
    @FXML
    private TextField label_description;
    
    @FXML
    private TextField label_prix;
    
    private String pointInterestSelected;
    
    public void pipeline (String p)
    {
        pointInterestSelected = p;
        next();
    }
    
    @FXML
    void next ()
    {
        label_nom.setText(pointInterestSelected);
        try
        {
            PointInterest pointInterest = PointInterest.read().get(pointInterestSelected);
            
            label_lieu.setText(pointInterest.getCoordinates().getLatitude() + "-" + pointInterest.getCoordinates().getLongitude());
            label_town.setText(pointInterest.getCoordinates().getCity());
            label_note.setText(String.valueOf(pointInterest.getGrade()));
            label_type.setText(String.valueOf(pointInterest.getType()));
            label_description.setText(pointInterest.getDescription());
            label_prix.setText(String.valueOf(pointInterest.getPrice()));
            
            ObservableList data = FXCollections.observableArrayList();
            
            for (Comment comment : pointInterest.getComments())
            {
                data.add(comment.getGrade() + ": " + comment.getMessage());
            }
            
            list_comment.setItems(data);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        
        if(CurrentUser.getInstance().getUser() instanceof Admin)
        {
            label_prix.setEditable(true);
        }
        else
        {
            modifier.setVisible(false);
        }
    }
    
    @FXML
    public void goBack ()
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(InscriptionController.class.getClassLoader().getResource(
                    "HomePageConnected.fxml"));
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
    public void modify ()
    {
        if(!label_prix.getText().trim().isEmpty())
        {
            try
            {
                float newPrix = Float.parseFloat(label_prix.getText().trim());
                
                Admin admin = (Admin) CurrentUser.getInstance().getUser();
                admin.changePricePointInterest(label_nom.getText().trim(), newPrix);
                
                next();
            }
            catch (NumberFormatException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public void commenter (ActionEvent actionEvent)
    {
        if(!nouveau_comment.getText().trim().isEmpty() && !nouvelle_note.getText().trim().isEmpty())
        {
            try
            {
                Integer newNote = Integer.parseInt(nouvelle_note.getText().trim());
                
                CurrentUser.getInstance().getUser().commentPointInteret(label_nom.getText().trim(),
                                                                        nouveau_comment.getText().trim(),
                                                                        newNote);
                
                next();
            }
            catch (NumberFormatException e)
            {
                e.printStackTrace();
            }
        }
    }
}
