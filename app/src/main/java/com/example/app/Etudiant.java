package com.example.app;

public class Etudiant extends Personne {

    private int annee;
    private String matiere;
    private double moyenne;

    public Etudiant() {
        super();
        this.annee = 0;
        this.matiere = "";
        this.moyenne = 0.0;
    }

    public Etudiant(String prenom, String nom, String eMail, int annee, String matiere, double moyenne) {
        super(prenom, nom, eMail);
        this.annee = annee;
        this.matiere = matiere;
        this.moyenne = moyenne;
    }

    public int getAnnee() { return annee; }
    public void setAnnee(int annee) { this.annee = annee; }

    public String getMatiere() { return matiere; }
    public void setMatiere(String matiere) { this.matiere = matiere; }

    public double getMoyenne() { return moyenne; }
    public void setMoyenne(double moyenne) { this.moyenne = moyenne; }


}
