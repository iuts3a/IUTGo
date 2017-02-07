package IUTGo.Models.Users;

import IUTGo.Models.Coordonee;
import IUTGo.Models.PointInteret;
import IUTGo.Models.RoadTrip;
import IUTGo.Models.TypePointInteret;

import java.io.Serializable;
import java.util.ArrayList;

public class Utilisateur implements Serializable {

    private String nom;
    private String prenom;
    private Coordonee adresse;
    private String motDePasse;
    private String email;

    private ArrayList<RoadTrip> favoriteRoadTrips;

    public Utilisateur(String nom, String prenom, String email, String motDePasse, Coordonee coordonee) {
        setNom(nom);
        setPrenom(prenom);
        setEmail(email);
        setMotDePasse(motDePasse);
        setAdresse(coordonee);
    }

    //region Getters and Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Coordonee getAdresse() {
        return adresse;
    }

    public void setAdresse(Coordonee adresse) {
        this.adresse = adresse;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<RoadTrip> getFavoriteRoadTrips() {
        return favoriteRoadTrips;
    }

    public void setFavoriteRoadTrips(ArrayList<RoadTrip> favoriteRoadTrips) {
        this.favoriteRoadTrips = favoriteRoadTrips;
    }
    //endregion

    public boolean suggestPointInteret(PointInteret pointInteret) {
        return true;
    }

    public boolean commentPointInteret(PointInteret pointInteret, String commentaire) {
        return true;
    }

    public boolean createRoadTrip(String roadTripName) {
        return true;
    }

    public boolean deleteRoadTrip(String roadTripName) {
        return true;
    }

    public boolean addPointInteretToRoadTrip(String roadTripName, float price, TypePointInteret type) {
        return true;
    }

    public boolean deletePointInteretFromRoadTrip(String roadTripName, String pointInteretName) {
        return true;
    }

    public boolean addRoadTripToFavorite(String roadTripName) {
        return true;
    }

    public float getRoadTripPrice(String roadTripName) {
        return 0;
    }

    public ArrayList<String> getRoadTripByScore(float score) {
        return null;
    }
}