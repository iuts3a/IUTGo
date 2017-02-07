package IUTGo.Models.Users;

import IUTGo.Models.Coordonee;
import IUTGo.Models.PointInteret;
import IUTGo.Models.RoadTrip;
import IUTGo.Models.TypePointInteret;

import java.util.ArrayList;

public class Utilisateur {

    private String nom;
    private String prenom;
    private Coordonee adresse;
    private String motDePasse;
    private String email;

    private ArrayList<RoadTrip> favoriteRoadTrips;

    public Utilisateur(String nom, String prenom, String email, String motDePasse) {

    }

    public Utilisateur(String nom, String prenom, String email, String motDePasse, Coordonee coordonee) {

    }

    //region Point Interet
    public boolean suggestPointInteret(PointInteret pointInteret) {
        return true;
    }

    public boolean commentPointInteret(PointInteret pointInteret, String commentaire) {
        return true;
    }
    //endregion

    //region RoadTrip
    public boolean createRoadTrip(String roadTripName) {
        return true;
    }

    public boolean deleteRoadTrip(String roadTripName) {
        return true;
    }
    //endregion

    //region Edit RoadTrip
    public boolean addPointInteretToRoadTrip(String roadTripName, float price, TypePointInteret type) {
        return true;
    }

    public boolean deletePointInteretFromRoadTrip(String roadTripName, String pointInteretName) {
        return true;
    }
    //endregion

    public boolean addRoadTripToFavorite(String roadTripName) {
        return true;
    }

    public float getRoadTripPrice(String roadTripName)
    {
        return 0;
    }

    public ArrayList<String> getRoadTripByScore(float score)
    {
        return null;
    }
}