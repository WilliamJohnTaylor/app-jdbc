/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 * Classe qui garde la liste de membres et les méthodes pour la manipuler.
 *
 * @author William Taylor
 * @version 1.00 
 * date: 24/02/2015
 */
public class Registre {
    //Attributs
    private final ArrayList<Membre> listeMembres;

    //Constructeur
    public Registre() {
        listeMembres = new ArrayList<>();
    }
    
    //Méthode que permettre d'ajouter des membres à la liste
    public void ajouterMembre(Membre mem){
        listeMembres.add(mem);
    }
    
    //Méthode que permettre d'avoir la liste de membres.
    public ArrayList<Membre> getMembres(){
        return listeMembres;
    }
}
