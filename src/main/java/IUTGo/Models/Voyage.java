package fr.unice.iut.info.methodo.s3a;

import java.util.Date;

/**
 * Created by LERAT Antoine on 18/10/2016.
 */

public class Voyage {

    public Passager nomConducteur;
    public Coordonne depart;
    public Coordonne arrive;
    public int nbPassager;
   // public Date dateDepart;

    public Passager getNomConducteur() {
        return nomConducteur;
    }

    public Coordonne getDepart() {
        return depart;
    }

    public Coordonne getArrive() {
        return arrive;
    }

    public int getNbPassager() {
        return nbPassager;
    }


    public Voyage(Passager nomConducteur, Coordonne depart, Coordonne arrive, int nbPassager) {
        this.nomConducteur = nomConducteur;
        this.depart = depart;
        this.arrive = arrive;
        this.nbPassager = nbPassager;
       // this.dateDepart = dateDepart;
    }

    public void setDepart(Coordonne depart) {
        this.depart = depart;
    }

    public void setArrive(Coordonne arrive) {
        this.arrive = arrive;
    }

    public void setNbPassager(int nbPassager) {
        this.nbPassager = nbPassager;
    }

    public Voyage() {
        Passager bob = new Passager();
        Coordonne depart = new Coordonne();
        Coordonne arrive = new Coordonne();
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
