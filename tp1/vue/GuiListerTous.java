package vue;

import java.io.IOException;
import java.sql.SQLException;
import model.DAOMembre;
import model.Registre;
import model.ResultSetTableModel;
import utilitaires.Constantes;
import utilitaires.Utilitaire;

/**
 * Interface utilisateur que permettre de lister tous les membres qui sont dans
 * la base de données
 *
 * @author William Taylor
 * @version 1.00 date: 24/02/2015
 */
public class GuiListerTous extends javax.swing.JFrame {

    public GuiListerTous() {

        initComponents();
        afficherMembres();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        btnFermerTous = new javax.swing.JButton();
        jspListerTous = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTousMembres = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Membres");

        btnFermerTous.setText("Fermer");
        btnFermerTous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFermerTousActionPerformed(evt);
            }
        });

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tblTousMembres.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblTousMembres);

        jspListerTous.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jspListerTous, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(btnFermerTous)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jspListerTous, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFermerTous)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnFermerTousActionPerformed(java.awt.event.ActionEvent evt) {                                              
        this.dispose();
    }                                             

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnFermerTous;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jspListerTous;
    private javax.swing.JTable tblTousMembres;
    // End of variables declaration                   
    private void dataBinding(Registre maListe) {
        tblTousMembres.setModel(new ResultSetTableModel(maListe.getMembres()));
    }

    private void afficherMembres() {
        Registre listeMembres = new Registre();
        DAOMembre dao = new DAOMembre(Constantes.FICHER_CONNEXION);

        try {
            dao.executerSelect(Constantes.REQUETE_SELECT_TOUS_MEMBRE);
            dao.resultSetToList(listeMembres);
            dataBinding(listeMembres);

        } catch (IOException | ClassNotFoundException | SQLException e) {
            Utilitaire.afficherErreur(Constantes.LISTER_ERREUR);
        }

        dao.fermerConnexion();
    }
}
