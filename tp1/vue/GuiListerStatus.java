package vue;

import java.io.IOException;
import java.sql.SQLException;
import model.DAOMembre;
import model.Registre;
import model.ResultSetTableModel;
import utilitaires.Constantes;
import utilitaires.Utilitaire;

/**
 * Interface utilisateur que permettre de lister les données par Status
 *
 * @author William Taylor
 * @version 2.00 date: 27/02/2015
 */
public class GuiListerStatus extends javax.swing.JFrame {

    public GuiListerStatus(Registre listeMembres) {

        initComponents();
        afficherTable(Constantes.STATUS_OR);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jspListerStatus = new javax.swing.JScrollPane();
        jtListerStatus = new javax.swing.JTable();
        lblStatus = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox();
        btnChercher = new javax.swing.JButton();
        bnrFermer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtListerStatus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CODE", "NOM", "PRENOM", "Title 4"
            }
        ));
        jspListerStatus.setViewportView(jtListerStatus);

        lblStatus.setText("Selectioner status: ");

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "OR", "ARGENT", "REGULIER" }));

        btnChercher.setText("Chercher");
        btnChercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChercherActionPerformed(evt);
            }
        });

        bnrFermer.setText("Fermer");
        bnrFermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnrFermerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblStatus)
                        .addGap(18, 18, 18)
                        .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btnChercher))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(bnrFermer))
                    .addComponent(jspListerStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChercher))
                .addGap(18, 18, 18)
                .addComponent(jspListerStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(bnrFermer)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void bnrFermerActionPerformed(java.awt.event.ActionEvent evt) {                                          

        this.dispose();
    }                                         

    private void btnChercherActionPerformed(java.awt.event.ActionEvent evt) {                                            
        afficherTable(cbStatus.getSelectedItem().toString());
    }                                           

    // Variables declaration - do not modify                     
    private javax.swing.JButton bnrFermer;
    private javax.swing.JButton btnChercher;
    private javax.swing.JComboBox cbStatus;
    private javax.swing.JScrollPane jspListerStatus;
    private javax.swing.JTable jtListerStatus;
    private javax.swing.JLabel lblStatus;
    // End of variables declaration                   
    private void dataBinding(Registre maListe) {
        jtListerStatus.removeAll();
        jtListerStatus.setModel(new ResultSetTableModel(maListe.getMembres()));
    }
    /** Méthode pour afficher le recordset dans la table**/
    private void afficherTable(String status) {
        Registre listeMembres = new Registre();
        DAOMembre dao = new DAOMembre(Constantes.FICHER_CONNEXION);
        try {
            //Je vais lister par default les membres qui ont le status OR
            //dao.selectStatus(Constantes.REQUETE_SELECT_STATUS, Constantes.STATUS_OR);
            dao.selectStatus(Constantes.REQUETE_SELECT_STATUS, status);
            dao.resultSetToList(listeMembres);
            dataBinding(listeMembres);
            dao.fermerConnexion();
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Utilitaire.afficherErreur(Constantes.LISTER_ERREUR);
        }
    }
}
