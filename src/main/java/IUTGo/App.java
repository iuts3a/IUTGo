package IUTGo;

import IUTGo.Models.Coordinates;
import IUTGo.Models.Users.Admin;
import IUTGo.Models.Users.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    public static void main(String[] args) {
        try {
            //region uncomment to reCreate the save files
            //RoadTrip.createSaveFile();
            //User.createSaveFile();
            //PointInterest.createSaveFile();
            //endregion

            //region uncomment to show all objects
        /*
        CurrentUser.Init("");
        
        for (PointInterest p : PointInterest.read().values())
        {
            System.out.println(p);
        }
        
        System.out.println("\n=================\n");
        
        for (RoadTrip r : RoadTrip.read().values())
        {
            System.out.println(r);
        }
        
        System.out.println("\n=================\n");
        
        for (User u : User.read().values())
        {
            if(!u.getAdmin()) System.out.println(u);
        }
        
        System.out.println("\n=================\n");
        
        for (User a : User.read().values())
        {
            if(a.getAdmin()) System.out.println(a);
        }*/
            //endregion

            //region User alex = new User(...); alex.save();
            User alex = new User("bolot", "alexandre", "Numinex222", "bolotalex06@gmail.com", "@lexandr1", new Coordinates(1, 2, "Ville"));

            alex.save();

            //endregion
            //region User chloe = new User(...); chloe.save();
            User chloe = new User("coupigny-Warot",
                    "chloe",
                    "chloee",
                    "chloe.coupwarot@orange.fr",
                    "Chloe01234",
                    new Coordinates(1, 2, "Ville"));
            chloe.save();
            //endregion
            //region Admin admin = new Admin(...); admin.save();
            Admin admin = new Admin("Ad", "min", "administrateur", "aa@gmail.com", "a", new Coordinates(1, 2, "Ville"));
            admin.setAdmin(true);
            admin.save();
            //endregion

            //region uncomment to create a Roadtrip
        /*
        RoadTrip roadTrip = new RoadTrip("myRoadTrip", alex);
        
        Coordinates coordinates1 = new Coordinates(getRandFloat(0, 120), getRandFloat(0, 120), "Nice");
        Coordinates coordinates2 = new Coordinates(getRandFloat(0, 120), getRandFloat(0, 120), "Mento");
        Coordinates coordinates3 = new Coordinates(getRandFloat(0, 120), getRandFloat(0, 120), "Monaco");
        
        PointInterest p1 = new PointInterest("Church", CHURCH, getRandFloat(1, 25), coordinates1, alex);
        PointInterest p2 = new PointInterest("Museum", MUSEUM, getRandFloat(1, 25), coordinates2, alex);
        PointInterest p3 = new PointInterest("Shop", SHOP, getRandFloat(1, 25), coordinates3, chloe);
        
        Comment comment1 = new Comment("I'm feeling very very spiritual", getRandInt(0, 5));
        Comment comment2 = new Comment("I'm looking at the moon, I'm looking at the moon", getRandInt(0, 5));
        Comment comment3 = new Comment("Ouah on a apprit masse de choses", getRandInt(0, 5));
        Comment comment4 = new Comment("c t nul je me sui fé chié", getRandInt(0, 5));
        Comment comment5 = new Comment("beaucoup de trucs à acheter", getRandInt(0, 5));
        Comment comment6 = new Comment("Ideal pour ramener des souvenirs", getRandInt(0, 5));
        
        p1.addComment(comment1.getMessage(), comment1.getGrade());
        p1.addComment(comment2.getMessage(), comment2.getGrade());
        p2.addComment(comment3.getMessage(), comment3.getGrade());
        p2.addComment(comment4.getMessage(), comment4.getGrade());
        p3.addComment(comment5.getMessage(), comment5.getGrade());
        p3.addComment(comment6.getMessage(), comment6.getGrade());
        
        p1.save();
        p2.save();
        p3.save();
        
        roadTrip.addPointInterest(p1);
        roadTrip.addPointInterest(p2);
        roadTrip.addPointInterest(p3);
        
        roadTrip.save();
        */
            //endregion
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../HomePage.fxml"));
            primaryStage.setTitle("IUTGo");
            Scene scene = new Scene(root, 800, 550);
            scene.getStylesheets().add(getClass().getResource("../styles/myCss.css").toString());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        }
    }
}
