package IUTGo.Models;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PointInteret implements Serializable {

    private String nom;
    private String description;
    private TypePointInteret type;
    private int prix;
    private boolean validated;
    private Coordonee coordonee;

    private ArrayList<Comment> comments;

    public PointInteret(String nom, TypePointInteret type, int prix, Coordonee coordonee) {
        setNom(nom);
        setType(type);
        setPrix(prix);
        setCoordonee(coordonee);
        setValidated(false);
        setDescription("");
        setComments(new ArrayList<Comment>());
    }

    public PointInteret(String nom, String description, TypePointInteret type, int prix, Coordonee coordonee) {
        setNom(nom);
        setType(type);
        setPrix(prix);
        setCoordonee(coordonee);
        setValidated(false);
        setDescription(description);
        setComments(new ArrayList<Comment>());
    }

    @SuppressWarnings("unchecked")
    public static HashMap<String, PointInteret> read() throws IOException, ClassNotFoundException {
        File fichier = new File("./Sauv/PI.ser");

        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream(fichier));

        HashMap<String, PointInteret> tab;
        tab = (HashMap<String, PointInteret>) ooi.readObject();
        return tab;
    }

    //region Getters and Setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypePointInteret getType() {
        return type;
    }

    public void setType(TypePointInteret type) {
        this.type = type;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public Coordonee getCoordonee() {
        return coordonee;
    }

    public void setCoordonee(Coordonee coordonee) {
        this.coordonee = coordonee;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }


    //endregion

    public float getGrade()
    {
        float grade = 0;

        for (Comment comment:comments)
        {
            grade += comment.getGrade();
        }

        return grade/comments.size();
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

    @Override
    public String toString() {
        return "PointInteret{" +
                "nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", type='" + getType() + '\'' +
                ", prix=" + prix +
                ", note=" + getGrade() +
                '}';
    }
}
