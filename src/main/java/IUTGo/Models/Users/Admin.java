package IUTGo.Models.Users;

import IUTGo.Models.Coordonee;

public class Admin extends Utilisateur {

    public Admin(String nom, String prenom, String email, String motDePasse) {
        super(nom, prenom, email, motDePasse);
    }

    public Admin(String nom, String prenom, String email, String motDePasse, Coordonee coordonee) {
        super(nom, prenom, email, motDePasse, coordonee);
    }


}
