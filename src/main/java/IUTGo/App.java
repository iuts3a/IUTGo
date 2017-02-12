package IUTGo;

import IUTGo.Models.Coordinates;
import IUTGo.Models.RoadTrip;
import IUTGo.Models.Users.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class App extends Application
{
    public static void main( String[] args ) throws Exception
    {
        launch(args);
       /* User u = new User("coupigny-Warot", "chloe", "chloee", "chloe.coupwarot@orange.fr","Chloe01234", new Coordinates(1, 2, "Ville") );
        User.createSaveFile();
        u.save();*/
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        try
        {
            URL fxml = getClass().getResource("../HomePage.fxml");

            Parent root = FXMLLoader.load(fxml);

            primaryStage.setTitle("Home");
            primaryStage.setScene(new Scene(root, 830, 560));
            primaryStage.show();
        }
        catch (NullPointerException npe)
        {
            npe.printStackTrace();
        }
    }
}
