package IUTGo.Models;

import IUTGo.Models.Users.Utilisateur;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PointInteret implements Serializable {

    private String nom;
    private String description;
    private TypePointInteret type;
    private float prix;
    private boolean validated;
    private Coordonee coordonee;
    private Utilisateur createur;

    private ArrayList<Comment> comments;

    public PointInteret(String nom, TypePointInteret type, float prix, Coordonee coordonee, Utilisateur createur) {
        setNom(nom);
        setType(type);
        setPrix(prix);
        setCoordonee(coordonee);
        setValidated(false);
        setDescription("");
        setComments(new ArrayList<Comment>());
        setCreateur(createur);
    }

    public PointInteret(String nom, String description, TypePointInteret type, float prix, Coordonee coordonee, Utilisateur createur) {
        setNom(nom);
        setType(type);
        setPrix(prix);
        setCoordonee(coordonee);
        setValidated(false);
        setDescription(description);
        setComments(new ArrayList<Comment>());
        setCreateur(createur);
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

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
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

    public Utilisateur getCreateur() {
        return createur;
    }

    public void setCreateur(Utilisateur utilisateur) {
        this.createur = utilisateur;
    }
    //endregion

    public boolean addComment(String commentaire, Integer grade) {
        this.comments.add(new Comment(commentaire, grade));
        return true;
    }

    public float getGrade() {
        float grade = 0;

        for (Comment comment : comments) {
            grade += comment.getGrade();
        }

        return grade / comments.size();
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
