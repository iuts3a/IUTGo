package IUTGo.Models;

import java.io.*;
import java.util.HashMap;

public class Itinineraire implements Serializable {

    private String nom;
    private HashMap<String, PointInteret> listePI;
    private float prixMin;
    private float prixMax;

    public Itinineraire(String nom) {
        this.listePI = new HashMap<String, PointInteret>();
        this.nom = nom;
    }

    public static HashMap<String, Itinineraire> read() throws IOException, ClassNotFoundException {
        File fichier = new File("./Sauv/Itineraire.ser");

        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream(fichier));

        HashMap<String, Itinineraire> tab;
        tab = (HashMap<String, Itinineraire>) ooi.readObject();
        return tab;
    }

    public void addPI(PointInteret PI) {
        this.listePI.put(PI.getNom(), PI);
        this.prixMin += PI.getPrixMin();
        this.prixMax += PI.getPrixMax();
    }

    public void deletePI(String PI) {
        this.prixMin -= this.listePI.get(PI).getPrixMin();
        this.prixMax -= this.listePI.get(PI).getPrixMax();
        this.listePI.remove(PI);
    }

    public void creerFichier() throws IOException {
        File fichier = new File("./Sauv/Itineraire.ser");

        HashMap<String, Itinineraire> tab = new HashMap<String, Itinineraire>();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier));
        oos.writeObject(tab);

    }

    public void save() throws IOException, ClassNotFoundException {

        File fichier = new File("./Sauv/Itineraire.ser");

        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream(fichier));

        HashMap<String, Itinineraire> tab;
        tab = (HashMap<String, Itinineraire>) ooi.readObject();
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

    public float getPrixMin() {
        return prixMin;
    }

    public float getPrixMax() {
        return prixMax;
    }

    @Override
    public String toString() {
        return "Itinineraire{" +
                "nom='" + nom + '\'' +
                ", listePI=" + listePI.toString() +
                ", prixMin Itinéraire=" + prixMin +
                ", prixMax Itinéraire=" + prixMax +
                '}';
    }
}
