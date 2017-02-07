package IUTGo.Models.Users;

import IUTGo.Models.Coordonee;
import IUTGo.Models.PointInteret;
import IUTGo.Models.RoadTrip;

import java.io.IOException;

public class Admin extends Utilisateur {

    public Admin(String nom, String prenom, String email, String motDePasse, Coordonee coordonee) {
        super(nom, prenom, email, motDePasse, coordonee);
    }

    public boolean changePIPrice(String name, float price){
        try {
            PointInteret.read().get(name).setPrix(price);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletePI(String name){
        try {
            PointInteret.read().remove(name);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean validatePI(String name){
        try {
            PointInteret.read().get(name).isValidated();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
