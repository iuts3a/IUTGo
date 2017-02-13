package IUTGo;

import IUTGo.Models.Coordinates;
import IUTGo.Models.PointInterest;
import IUTGo.Models.Users.Admin;
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
        /*RoadTrip.createSaveFile();
        User.createSaveFile();
        PointInterest.createSaveFile();*/
    
        for (PointInterest p : PointInterest.read().values())
        {
            System.out.println(p);
        }
        Admin admin = new Admin("Ad", "min", "administrateur", "aa@gmail.com", "a", new Coordinates(1, 2, "Ville"));
        admin.save();

        User alex = new User("bolot", "alexandre","Numinex222",  "bolotalex06@gmail.com", "@lexandr1", new Coordinates(1, 2, "Ville"));
        alex.save();
    
        User chloe = new User("coupigny-Warot", "chloe", "chloee", "chloe.coupwarot@orange.fr","Chloe01234", new Coordinates(1, 2, "Ville") );
        chloe.save();
        
        launch(args);
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
