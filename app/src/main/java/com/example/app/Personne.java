package com.example.app;

public class Personne {

    private String prenom;
    private String nom;
    private String eMail;

    public Personne() {
        this.prenom = "";
        this.nom = "";
        this.eMail = "";
    }

    public Personne(String prenom, String nom, String eMail) {
        this.prenom = prenom;
        this.nom = nom;
        this.eMail = eMail;
    }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getMail() { return eMail; }
    public void setMail(String eMail) { this.eMail = eMail; }


}
