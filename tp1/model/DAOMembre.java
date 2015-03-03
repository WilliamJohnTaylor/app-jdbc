package model;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilitaires.Constantes;
import utilitaires.UtilDB;
import utilitaires.Utilitaire;

/**
 * Classe qui execute les requetes et les interactions avec la base de données.
 *
 * @author William Taylor
 * @version 1.00 date: 24/02/2015
 */
public class DAOMembre {
    //Attributs

    PreparedStatement stmt = null;
    Connection connexion = null;
    String fichierConnexion;
    ResultSet rset = null;

    //Constructeurs
    public DAOMembre(String fichierConnexion) {

        this.fichierConnexion = fichierConnexion;
    }

    /**
     * Méthode pour ouvris la connexion à la base de données Reçoi comme
     * parametre l'adresse d'un fichier avec les données de connexion.
     */
    public void openConnexion() {
        try {
            connexion = UtilDB.getConnection(fichierConnexion);
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Utilitaire.afficherErreur(Constantes.CONEXION_ERREUR);
        }
    }

    /**
     * Méthode pour fermer la connexion à la base de données
     */
    public void fermerConnexion() {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Utilitaire.afficherErreur(Constantes.CONEXION_ERREUR);
            }
        }
    }

    /**
     * Méthode que permet d'executer une requete avec des paramétres
     * Restriccion: Le premier et le dernier parametre doivent être numerique et
     * float respectivement.
     *
     * @param requete
     * @param parametres
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public void executerRequete(String requete, ArrayList<String> parametres)
            throws IOException, ClassNotFoundException, SQLException {
        int i = 1;

        openConnexion();
        stmt = connexion.prepareStatement(requete);

        stmt.setInt(i, Integer.parseInt(parametres.get(i - 1)));
        i++;
        //Boucle pour inserer les valeurs des parametres
        while (i < parametres.size()) {
            stmt.setString(i, parametres.get(i - 1));
            i++;
        }
        stmt.setFloat(i, Float.parseFloat(parametres.get(i - 1)));

        try {
            stmt.executeQuery();

        } catch (SQLIntegrityConstraintViolationException ex) {
            Utilitaire.afficherErreur(Constantes.CODE_EXISTE);

        } catch (SQLDataException ex) {
            Utilitaire.afficherErreur(Constantes.ERREUR_DONEES);
        } catch (SQLException ex) {
            Utilitaire.afficherErreur(Constantes.ERREUR_REQUETE);
        }
    }

    /**
     * Méthode que permet effacer des registres avec un parametre.
     */
    public void executerDelete(String requete, int parametres)
            throws IOException, ClassNotFoundException, SQLException {
        int i = 1;

        openConnexion();
        stmt = connexion.prepareStatement(requete);

        stmt.setInt(i, parametres);
        try {
            stmt.executeQuery();
            fermerConnexion();
        } catch (SQLException ex) {

            Utilitaire.afficherErreur(Constantes.ERREUR_REQUETE);
        }
    }

    /**
     * Méthode que permet d'executer une requete select sans parametres
     */
    public void executerSelect(String requete)
            throws IOException, ClassNotFoundException, SQLException {
        rset = null;
        openConnexion();
        stmt = connexion.prepareStatement(requete);

        try {
            rset = stmt.executeQuery();

        } catch (SQLException ex) {

            Utilitaire.afficherErreur(Constantes.ERREUR_REQUETE);
        }
    }

    /**
     * Méthode que permet d'inserer les enregistrements dans une liste
     */
    public void resultSetToList(Registre listing) {
        try {
            while (rset.next()) {
                Membre mem = new Membre(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
                        rset.getString(5), rset.getFloat(6));
                listing.ajouterMembre(mem);

            }
        } catch (SQLException ex) {
            Utilitaire.afficherErreur(Constantes.ERREUR_REQUETE);
        }
    }

    /**
     * Méthode que permet la execution d'une requete select avec un parametre de
     * type status
     *
     * @param requete
     * @param status
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public void selectStatus(String requete, String status)
            throws IOException, ClassNotFoundException, SQLException {
        openConnexion();
        rset = null;
        stmt = connexion.prepareStatement(requete);
        stmt.setString(1, status.toUpperCase());

        try {
            rset = stmt.executeQuery();

        } catch (SQLException ex) {

            Utilitaire.afficherErreur(Constantes.CONEXION_ERREUR);
        }

    }

    /**
     * Méthode que permet la execution d'une procedure stockée
     *
     * @param code
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public void mettreJour(int code)
            throws IOException, ClassNotFoundException, SQLException {

        openConnexion();
        CallableStatement cs = connexion.prepareCall("{call update_status(?)}");
        cs.setInt(1, code);
        cs.execute();

    }
}
