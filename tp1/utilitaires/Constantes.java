package utilitaires;

/**
 * Classe qui a les valeur des constantes qu'on utilisera dans la code
 *
 * @author William Taylor
 * @version 1.00 
 * date: 27/02/2015
 */
public class Constantes {
    /** Requetes **/
    public static final String REQUETE_INSERT_MEMBRE = "INSERT INTO Membres( code_membre," + 
                            " nom, prenom, adresse, status, revenue_annuel) " +
                            "VALUES ( ?, ?, ?, ?, ?, ?)";
    public static final String REQUETE_DELETE_MEMBRE_CODE = "DELETE FROM Membres where code_membre = ?";
    public static final String REQUETE_SELECT_TOUS_MEMBRE = "SELECT * FROM Membres";
    public static final String REQUETE_SELECT_STATUS = "SELECT * FROM Membres where status like ?";
    
    /** Constantes **/
    public static final String FICHER_CONNEXION = "/control/infoconnexion.prp";
    public static final String VIDE = "";
    public static final String STATUS_OR = "OR";
    public static final String STATUS_ARGENT = "ARGENT";
    public static final String STATUS_REGULIER = "REGULIER";
    
    /**Messages**/
    public static final String INSERTION_OK = "Les données ont été inseres correctement!!";
    public static final String INSERTION_ERREUR = "Les données n'ont pas été inseres";
    public static final String EFFACER_ERREUR = "L'enregistrement n'a pas pu être supprimé.";
    public static final String LISTER_ERREUR = "Le système ne peut pas lister les membres.";
    public static final String CONEXION_ERREUR = "Il y a eu une erreur dans la conexion";
    public static final String CODE_EXISTE = "Le code Membre existe déjà dans la base de données!!";
    public static final String ERREUR_DONEES = "Il y a des erreurs dans le type de données!!";
    public static final String ERREUR_REQUETE = "Il y a eu un erreur dans la requete!!";
}

