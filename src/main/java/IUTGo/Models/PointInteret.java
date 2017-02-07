package IUTGo.Models;

import java.io.*;
import java.util.HashMap;

public class PointInteret implements Serializable {

    private String nom;
    private String description;
    private String type;
    private int prixMin;
    private int prixMax;
    private int coefficient;
    private Coordonee coordonee;

    public PointInteret(String nom, String description, String type, int prixMin, int prixMax, Coordonee cordonnee) {

        this.nom = nom;
        this.description = description;
        this.type = type;
        this.prixMin = prixMin;
        this.prixMax = prixMax;
        this.coefficient = 0;
        this.coordonee = cordonnee;

    }

    public static HashMap<String, PointInteret> read() throws IOException, ClassNotFoundException {
        File fichier = new File("./Sauv/PI.ser");

        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream(fichier));

        HashMap<String, PointInteret> tab;
        tab = (HashMap<String, PointInteret>) ooi.readObject();
        return tab;
    }

    public void creerFichier() throws IOException {
        File fichier = new File("./Sauv/PI.ser");

        HashMap<String, PointInteret> tab = new HashMap<String, PointInteret>();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier));
        oos.writeObject(tab);

    }

    public void save() throws IOException, ClassNotFoundException {

        File fichier = new File("./Sauv/PI.ser");

        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream(fichier));

        HashMap<String, PointInteret> tab;
        tab = (HashMap<String, PointInteret>) ooi.readObject();
        tab.put(this.getNom(), this);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier));
        oos.writeObject(tab);

    }

    public void like() {
        this.coefficient += 1;
    }

    public void dislike() {
        this.coefficient -= 1;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public Coordonee getCoordonee() {
        return coordonee;
    }

    public float getPrixMin() {
        return prixMin;
    }

    public void setPrixMin(int prixMin) {
        this.prixMin = prixMin;
    }

    public float getPrixMax() {
        return prixMax;
    }

    public void setPrixMax(int prixMax) {
        this.prixMax = prixMax;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PointInteret{" +
                "nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", prixMin=" + prixMin +
                ", prixMax=" + prixMax +
                ", coefficient=" + coefficient +
                ", coordonee=" + coordonee.toString() +
                '}';
    }
}
