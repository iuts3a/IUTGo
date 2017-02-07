package IUTGo.Models;

import IUTGo.Models.Users.Utilisateur;

import java.io.*;
import java.util.HashMap;

public class RoadTrip implements Serializable {

    private String nom;
    private HashMap<String, PointInteret> listePI;
    private HashMap<String, Utilisateur> participants;
    private float price;

    public RoadTrip(String nom, HashMap<String, Utilisateur> participants) {
        this.listePI = new HashMap<String, PointInteret>();
        this.participants = participants;
        this.nom = nom;
    }

    public static HashMap<String, RoadTrip> read() throws IOException, ClassNotFoundException {
        File fichier = new File("./Sauv/RoadTrip.ser");

        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream(fichier));

        HashMap<String, RoadTrip> tab;
        tab = (HashMap<String, RoadTrip>) ooi.readObject();
        return tab;
    }


    public void addPI(PointInteret PI) {
        this.listePI.put(PI.getNom(), PI);
        this.price += PI.getPrix();
    }

    public void deletePI(String PI) {
        this.price -= this.listePI.get(PI).getPrix();
        this.listePI.remove(PI);
    }

    public void creerFichier() throws IOException {
        File fichier = new File("./Sauv/RoadTrip.ser");

        HashMap<String, RoadTrip> tab = new HashMap<String, RoadTrip>();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier));
        oos.writeObject(tab);

    }

    public void save() throws IOException, ClassNotFoundException {

        File fichier = new File("./Sauv/RoadTrip.ser");

        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream(fichier));

        HashMap<String, RoadTrip> tab;
        tab = (HashMap<String, RoadTrip>) ooi.readObject();
        tab.put(this.getNom(), this);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier));
        oos.writeObject(tab);

    }

    public HashMap<String, PointInteret> getListePI() {
        return listePI;
    }

    public String getNom() {
        return nom;
    }

    public float getPrice(){
        return price;
    }

    public HashMap<String, Utilisateur> getParticipants() {
        return participants;
    }

    public void setParticipants(HashMap<String, Utilisateur> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "RoadTrip{" +
                "nom='" + nom + '\'' +
                ", listePI=" + listePI.toString() +
                ", prixMin Itinéraire=" + price +
                '}';
    }


}
