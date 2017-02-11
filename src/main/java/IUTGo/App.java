package IUTGo;

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
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        try
        {
            URL fxml = getClass().getResource("../HomePage.fxml");

            Parent root = FXMLLoader.load(fxml);

            primaryStage.setTitle("Home");
            primaryStage.setScene(new Scene(root, 800, 800));
            primaryStage.show();
        }
        catch (NullPointerException npe)
        {
            npe.printStackTrace();
        }
    }
}
