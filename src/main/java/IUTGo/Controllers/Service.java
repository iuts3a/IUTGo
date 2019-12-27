package IUTGo.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Service {
    public static void goTo(String path, Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HomePageConnectedController.class.getClassLoader().getResource(path));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 800, 550);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println("Erreur au chargement: " + ex);
        }
    }

    public static void populateListView(ListView<String> listView, String item) {
        listView.getItems().add(item);
    }

    public static void populateListView(ListView<String> listView, Set<String> items) {
        listView.getItems().addAll(items);
    }

    public static void populateListView(ListView<String> listView, ArrayList<String> items) {
        listView.getItems().addAll(items);
    }

    public static float getRandFloat(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min * 10, max * 10) / 10;
    }

    public static int getRandInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
