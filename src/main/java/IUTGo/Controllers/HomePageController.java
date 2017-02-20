package IUTGo.Controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomePageController
{
    public Button btnInscription;
    public Button btnConnexion;
    
    public void btnConnexion_onAction (ActionEvent actionEvent)
    {
        Service.goTo("Inscription.fxml", (Stage) btnConnexion.getScene().getWindow());
    }
    
    public void btnInscription_onAction (ActionEvent actionEvent)
    {
        Service.goTo("Connexion.fxml", (Stage) btnConnexion.getScene().getWindow());
    }
}

