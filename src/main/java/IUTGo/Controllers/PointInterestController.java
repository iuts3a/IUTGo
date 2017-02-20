package IUTGo.Controllers;

import IUTGo.Models.CurrentUser;
import IUTGo.Models.PointInterest;
import IUTGo.Models.Users.Admin;
import IUTGo.Models.Users.User;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

@SuppressWarnings("ConstantConditions")
public class PointInterestController
{
    public TextField txtType;
    public TextField txtDescription;
    public TextField txtTown;
    public TextField txtGrade;
    public TextField txtPrice;
    
    public Label lblName;
    public Label error_price;
    public Label error_comment;
    public Label error_grade;
    
    public Button btnSubmit;
    public Button btnUpdate;
    public Button btnBack;
    
    public ListView listViewComments;
    public TextArea txtNewComment;
    
    public ComboBox<Integer> ddlGrade;
    
    private PointInterest PI;
    private String        originURL;
    
    public void pipeline (String PIName, String originURL)
    {
        try
        {
            this.PI = PointInterest.read().get(PIName);
            this.originURL = originURL;
            init();
        }
        //region catch
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        //endregion
    }
    
    private void init ()
    {
        error_price.setText("");
        error_comment.setText("");
        error_grade.setText("");
        
        lblName.setText(PI.getName());
        txtTown.setText(PI.getCoordinates().getTown());
        txtGrade.setText(String.valueOf(PI.getGrade()));
        txtType.setText(String.valueOf(PI.getType()));
        txtPrice.setText(String.valueOf(PI.getPrice()));
        txtDescription.setText(PI.getDescription());
        
        if(CurrentUser.getInstance().getUser().getAdmin()) txtPrice.setEditable(true);
        
        ddlGrade.getItems().clear();
        ddlGrade.getItems().addAll(1, 2, 3, 4, 5);
    }
    
    public void btnUpdate_onAction (ActionEvent actionEvent)
    {
        String newPrice = txtPrice.getText().trim();
        
        //region newPrice.isEmpty()
        if(newPrice.isEmpty())
        {
            error_price.setText("Enter a Price");
            return;
        }
        //endregion
        //region !newPrice.matches("[a-zA-Z0-9]{1,2}.[a-zA-Z0-9]")
        if(!newPrice.matches("[a-zA-Z0-9]{1,2}.[a-zA-Z0-9]"))
        {
            error_price.setText("Only digits allowed");
        }
        //endregion
        
        User user = CurrentUser.getInstance().getUser();
        
        if(user.getAdmin())
        {
            ((Admin) user).changePricePointInterest(PI.getName(), Float.parseFloat(newPrice));
        }
        
        init();
    }
    
    public void btnSubmit_onAction (ActionEvent actionEvent)
    {
        //region ddlGrade.selected == null
        if(ddlGrade.getSelectionModel().getSelectedItem() == null)
        {
            error_grade.setText("Select a grade");
        }
        //endregion
        //region ddlGrade.selected == null
        if(txtNewComment.getText().trim().isEmpty())
        {
            error_grade.setText("Enter a comment");
        }
        //endregion
        
        String newComment = txtNewComment.getText().trim();
        Integer newGrade = ddlGrade.getSelectionModel().getSelectedItem();
        
        User currentUser = CurrentUser.getInstance().getUser();
        currentUser.commentPointInteret(PI.getName(), newComment, newGrade);
        
        init();
    }
    
    public void btnBack_onAction (ActionEvent actionEvent)
    {
        Service.goTo(originURL, (Stage) btnBack.getScene().getWindow());
    }
    
    public void homePage_onMouseClick (MouseEvent mouseEvent)
    {
        Service.goTo("HomePageConnected.fxml", (Stage) btnBack.getScene().getWindow());
    }
}
