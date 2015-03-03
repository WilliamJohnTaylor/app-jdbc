package vue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DAOMembre;
import model.Registre;
import model.ResultSetTableModel;
import utilitaires.Constantes;
import utilitaires.Utilitaire;

/**
 * Interface utilisateur que permettre de mettre à jour le status d'un membre.
 * Le status est changé par REGULIER.
 *
 * @author William Taylor
 * @version 2.00 date: 27/02/2015
 */
public class GuiMettreJourStatus extends javax.swing.JFrame {

    public GuiMettreJourStatus() {
        initComponents();
        afficherTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        btnFermerEffacer = new javax.swing.JButton();
        lblMettreJour = new javax.swing.JLabel();
        txtCodeMettreJour = new javax.swing.JTextField();
        btnMettreJour = new javax.swing.JButton();
        spMettreJour = new javax.swing.JScrollPane();
        tblMettreJour = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnFermerEffacer.setText("Fermer");
        btnFermerEffacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFermerEffacerActionPerformed(evt);
            }
        });

        lblMettreJour.setText("Tapez code à mettre à jour : ");

        btnMettreJour.setText("Mettre à jour");
        btnMettreJour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMettreJourActionPerformed(evt);
            }
        });

        tblMettreJour.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        spMettreJour.setViewportView(tblMettreJour);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFermerEffacer)
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblMettreJour)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodeMettreJour, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 36, Short.MAX_VALUE)))
                .addComponent(btnMettreJour)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spMettreJour, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMettreJour)
                    .addComponent(txtCodeMettreJour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMettreJour))
                .addGap(18, 18, 18)
                .addComponent(spMettreJour, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnFermerEffacer)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>                        

    private void btnFermerEffacerActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        this.dispose();
    }                                                

    private void btnMettreJourActionPerformed(java.awt.event.ActionEvent evt) {                                              
        DAOMembre dao = new DAOMembre(Constantes.FICHER_CONNEXION);
        try {
            //Appel à la méthode mettreJour qui s'en charge de changer les Status.
            dao.mettreJour(Integer.parseInt(txtCodeMettreJour.getText()));
            afficherTable();
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GuiMettreJourStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                             

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnFermerEffacer;
    private javax.swing.JButton btnMettreJour;
    private javax.swing.JLabel lblMettreJour;
    private javax.swing.JScrollPane spMettreJour;
    private javax.swing.JTable tblMettreJour;
    private javax.swing.JTextField txtCodeMettreJour;
    // End of variables declaration                   
private void dataBinding(Registre maListe) {
        tblMettreJour.setModel(new ResultSetTableModel(maListe.getMembres()));
    }

    /**
     * Méthode pour afficher le recordset dans la table**/
    private void afficherTable() {
      //Afficher l'information actuelle

        Registre listeMembres = new Registre();
        DAOMembre dao = new DAOMembre(Constantes.FICHER_CONNEXION);
        try {

            dao.executerSelect(Constantes.REQUETE_SELECT_TOUS_MEMBRE);
            dao.resultSetToList(listeMembres);
            dataBinding(listeMembres);
            dao.fermerConnexion();
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Utilitaire.afficherErreur(Constantes.LISTER_ERREUR);
        }
    }
}
