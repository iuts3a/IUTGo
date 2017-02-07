package IUTGo.Models;

import java.util.Date;

/**
 * Created by LERAT Antoine on 18/10/2016.
 */

public class Voyage {

    public Passager nomConducteur;
    public Coordonee depart;
    public Coordonee arrive;
    public int nbPassager;
    // public Date dateDepart;

    public Passager getNomConducteur() {
        return nomConducteur;
    }

    public Coordonee getDepart() {
        return depart;
    }

    public Coordonee getArrive() {
        return arrive;
    }

    public int getNbPassager() {
        return nbPassager;
    }


    public Voyage(Passager nomConducteur, Coordonee depart, Coordonee arrive, int nbPassager) {
        this.nomConducteur = nomConducteur;
        this.depart = depart;
        this.arrive = arrive;
        this.nbPassager = nbPassager;
        // this.dateDepart = dateDepart;
    }

    public void setDepart(Coordonee depart) {
        this.depart = depart;
    }

    public void setArrive(Coordonee arrive) {
        this.arrive = arrive;
    }

    public void setNbPassager(int nbPassager) {
        this.nbPassager = nbPassager;
    }

    public Voyage() {
        Passager bob = new Passager();
        Coordonee depart = new Coordonee();
        Coordonee arrive = new Coordonee();
        // Date dateDepart = new Date(2016,10,15);
        this.nomConducteur = bob;
        this.depart = depart;
        this.arrive = arrive;
        this.nbPassager = 2;
    }

    @Override
    public String toString() {
        return "Voyage{" +
                "nomConducteur=" + nomConducteur +
                ", depart=" + depart +
                ", arrive=" + arrive +
                ", nbPassager=" + nbPassager +
                '}';
    }
}
