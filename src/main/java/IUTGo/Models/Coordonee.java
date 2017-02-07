package IUTGo.Models;

import java.io.*;
import java.util.HashMap;

public class Coordonee implements Serializable {

    private float latitude;
    private float longitude;
    private String ville;

    public Coordonee(float latitude, float longitude, String ville) throws IOException {
        this.latitude = latitude;
        this.longitude = longitude;
        this.ville = ville;
    }

    public Coordonee() {
        this.latitude = 1;
        this.longitude = 1;
        this.ville = "Paris";
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public static HashMap<String, Coordonee> read() throws IOException, ClassNotFoundException {
        File fichier = new File("./Sauv/CO.ser");

        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream(fichier));

        HashMap<String, Coordonee> tab;
        tab = (HashMap<String, Coordonee>) ooi.readObject();
        return tab;
    }

    public void createFile() throws IOException {
        File fichier = new File("./Sauv/CO.ser");

        HashMap<String, PointInteret> tab = new HashMap<String, PointInteret>();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier));
        oos.writeObject(tab);

    }

    public void save() throws IOException, ClassNotFoundException {

        File fichier = new File("./Sauv/CO.ser");

        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream(fichier));

        HashMap<String, Coordonee> tab;
        tab = (HashMap<String, Coordonee>) ooi.readObject();
        tab.put(this.getVille(), this);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier));
        oos.writeObject(tab);

    }

    @Override
    public String toString() {
        return "Coordonee{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", ville='" + ville + '\'' +
                '}';
    }
}