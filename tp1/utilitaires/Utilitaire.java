

package utilitaires;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Classe qui a des méthodes de formatage et 
 * affichage des messages
 *
 * @author William Taylor
 * @version 2.00 
 * date: 27/02/2015
 */
public class Utilitaire {
    
    /*Méthode que permettre d'afficher un message d'erreur*/
    public static void afficherErreur(String message){
        JOptionPane.showMessageDialog(null, message, "Erreur!", JOptionPane.ERROR_MESSAGE);
    }
    
    /*Méthode que permettre d'afficher un message d'erreur*/
    public static void afficherOk(String message){
        JOptionPane.showMessageDialog(null, message, "Operation reussi", JOptionPane.INFORMATION_MESSAGE);
    }
    /** Méthode pour valider si il y a des champs vides**/
    public static void viderChamps(ArrayList<JTextField> champs){
        for (JTextField champ:champs){
            champ.setText("");
            }
            
        }
    /** Méthode pôur valider si le donnée tape est de type float**/
    public static void validerFloat(java.awt.event.KeyEvent evt){
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) && (c != '.') && c != KeyEvent.VK_BACK_SPACE) {          
              evt.consume();
            Utilitaire.afficherErreur("La champ revenue doit être un nombre.");
          }
    }
    
        /** Méthode pôur valider si le donnée tapé est de type entier**/
    public static void validerEntier(java.awt.event.KeyEvent evt){
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) && c != KeyEvent.VK_BACK_SPACE) {          
              evt.consume();
            Utilitaire.afficherErreur("La champ revenue doit être un nombre.");
          }
    }
}
