package IUTGo.Models;

/**
 * Created by LERAT Antoine on 18/10/2016.
 */

public class Passager {
    public String nom;
    public String prenom;
    public String mail;
    public String numTel;
    public boolean conducteur;

    /**
     * Constructeur par defaut
     **/

    public Passager () {
        nom = "defaut";
        prenom = "defaut";
        mail = "defaut@hotmail.fr";
        numTel = "0700000000";
        conducteur = false;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public void setConducteur(boolean conducteur) {
        this.conducteur = conducteur;
    }

    public Passager(String nom, String prenom, String mail, String numTel, boolean conducteur) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;

        this.numTel = numTel;
        this.conducteur = conducteur;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMail() {
        return mail;
    }

    public String getNumTel() {
        return numTel;
    }

    public boolean isConducteur() {
        return conducteur;
    }

    public void SupprimerCompte(Passager nom) {}

    public Passager RechercheUtilisateur(Passager nom){
        return nom;
    }

    public void ConsulterHistorique(){}

    public void ChangerMdp(){}

    public void ModifierProfil() {}

    @Override
    public String toString() {
        return "Passager{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mail='" + mail + '\'' +
                ", numTel='" + numTel + '\'' +
                ", conducteur=" + conducteur +
                '}';
    }
}
