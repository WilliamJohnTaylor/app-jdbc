

package utilitaires;

import java.util.ArrayList;
import javax.swing.JTextField;

/**
 * Classe pour appliquer des regles.
 *
 * @author William Taylor
 * @version 1.00 
 * date: 25/02/2015
 */
public class Regles {
    /*Méethode pour valider si il y a un champ vide*/
    public static String sontVides(ArrayList<JTextField> parametres){
        for (JTextField champ:parametres){
            if (champ.getText().trim().equals(Constantes.VIDE)){
                return champ.getName();
            }
        }
        return Constantes.VIDE;
    }
    
}
