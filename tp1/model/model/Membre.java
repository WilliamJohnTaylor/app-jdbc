/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Classe represente les membres du club de fleuristes.
 *
 * @author William Taylor
 * @version 1.00 
 * date: 24/02/2015
 */
public class Membre {
    //Attributs
    private int CodeMembre;
    private String Nom, Prenom, Adresse, Statut;
    private float revenue_annuel;

    //Constructeurs
    public Membre() { }

    public Membre(int CodeMembre, String Nom, String Prenom, String Adresse, String Statut, float revenue_annuel) {
        this.CodeMembre = CodeMembre;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Adresse = Adresse;
        this.Statut = Statut;
        this.revenue_annuel = revenue_annuel;
    }
    
    //Getters et Setters
    public int getCodeMembre() {
        return CodeMembre;
    }

    public void setCodeMembre(int CodeMembre) {
        this.CodeMembre = CodeMembre;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getStatut() {
        return Statut;
    }

    public void setStatut(String Statut) {
        this.Statut = Statut;
    }

    public float getRevenue_annuel() {
        return revenue_annuel;
    }

    public void setRevenue_annuel(float revenue_annuel) {
        this.revenue_annuel = revenue_annuel;
    }

    //Méethode toString()
    @Override
    public String toString() {
        return "Membre{" + "CodeMembre=" + CodeMembre + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Adresse=" + Adresse + ", Statut=" + Statut + ", revenue_annuel=" + revenue_annuel + '}';
    }
}
