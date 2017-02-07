package IUTGo.Models.Users;

import IUTGo.Models.Coordonee;
import IUTGo.Models.PointInteret;

public class Admin extends Utilisateur {

    public Admin(String nom, String prenom, String email, String motDePasse, Coordonee coordonee) {
        super(nom, prenom, email, motDePasse, coordonee);
    }

    public boolean changePIPrice(float price){
        return true;
    }

    public boolean deletePI(PointInteret pointInteret){
        return true;
    }

    public boolean validatePI(PointInteret pointInteret){
        return true;
    }
}
