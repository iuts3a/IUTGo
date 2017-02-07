package IUTGo.Models.Users;

import IUTGo.Models.Coordonee;
import IUTGo.Models.PointInteret;
import IUTGo.Models.RoadTrip;
import IUTGo.Models.TypePointInteret;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

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

    //String nom, TypePointInteret type, int prix, Coordonee coordonee, Utilisateur createur

    public boolean suggestPointInteret(String nomPointInteret, TypePointInteret type, float prix, Coordonee coordonee, Utilisateur createur) {
        PointInteret newPointInteret = new PointInteret(nomPointInteret, type, prix, coordonee, this);

        try {
            newPointInteret.save();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean suggestPointInteret(String nomPointInteret, String commentaire, TypePointInteret type, float prix, Coordonee coordonee, Utilisateur createur) {
        PointInteret newPointInteret = new PointInteret(nomPointInteret, commentaire, type, prix, coordonee, this);

        try {
            newPointInteret.save();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean commentPointInteret(String nomPointInteret, String commentaire, Integer grade) {
        try {
            PointInteret.read().get(nomPointInteret).addComment(commentaire, grade);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean createRoadTrip(String roadTripName) {
        RoadTrip newRoadTrip = new RoadTrip(roadTripName, this);

        try {
            newRoadTrip.save();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteRoadTrip(String roadTripName) {
        try {
            RoadTrip.read().remove(roadTripName);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addPointInteretToRoadTrip(String roadTripName, float price, TypePointInteret type) {
        //TODO
        return true;
    }

    public boolean deletePointInteretFromRoadTrip(String roadTripName, String pointInteretName) {
        //TODO
        return true;
    }

    public boolean addRoadTripToFavorite(String roadTripName) {
        try {
            this.favoriteRoadTrips.add(RoadTrip.read().get(roadTripName));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public float getRoadTripPrice(String roadTripName) {
        try {
            return RoadTrip.read().get(roadTripName).getPrice();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public ArrayList<RoadTrip> getRoadTripByScore(float score) {
        ArrayList<RoadTrip> listResult = new ArrayList<RoadTrip>();

        try {
            for (RoadTrip roadTrip : RoadTrip.read().values()) {
                if (roadTrip.getGrade() >= score) {
                    listResult.add(roadTrip);
                }
            }
            return listResult;
        } catch (IOException e) {
            e.printStackTrace();
            return listResult;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return listResult;
        }
    }

    public void creerFichier() throws IOException {
        File fichier = new File("./Sauv/Utilisateur.ser");

        HashMap<String, Utilisateur> tab = new HashMap<String, Utilisateur>();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier));
        oos.writeObject(tab);

    }

    public void save() throws IOException, ClassNotFoundException {

        File fichier = new File("./Sauv/Utilisateur.ser");

        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream(fichier));

        HashMap<String, Utilisateur> tab;
        tab = (HashMap<String, Utilisateur>) ooi.readObject();
        tab.put(this.getEmail(),this);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier));
        oos.writeObject(tab);

    }

    public static HashMap<String, Utilisateur> read() throws IOException, ClassNotFoundException {
        File fichier = new File("./Sauv/Utilisateur.ser");

        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream(fichier));

        HashMap<String, Utilisateur> tab;
        tab = (HashMap<String, Utilisateur>) ooi.readObject();
        return tab;
    }

}