package IUTGo.Models.Users;

import IUTGo.Models.Coordonee;
import IUTGo.Models.PointInteret;

public class Utilisateur {

    private String nom;
    private String prenom;
    private Coordonee adresse;
    private String motDePasse;
    private String email;

    public Utilisateur(String nom, String prenom, String email, String motDePasse) {

    }

    public Utilisateur(String nom, String prenom, String email, String motDePasse, Coordonee coordonee) {

    }

    public boolean SuggestPointInteret(PointInteret pointInteret)
    {
        return true;
    }


}