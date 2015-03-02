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
 * Interface utilisateur que permettre d'effacer un membre a la Base de données selon
 * un code de membre donnée comme parametre.
 *
 * @author William Taylor
 * @version 1.00 
 * date: 24/02/2015
 */
public class GuiEffacerCode extends javax.swing.JFrame {

    public GuiEffacerCode() {
        initComponents();
        
        //Afficher les données actuelles
        Registre listeMembres = new Registre() ;
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        btnFermerEffacer = new javax.swing.JButton();
        lblCodeEffacer = new javax.swing.JLabel();
        txtCodeEffacer = new javax.swing.JTextField();
        btnEffacerCode = new javax.swing.JButton();
        spEffacerCode = new javax.swing.JScrollPane();
        tblEffacerCode = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnFermerEffacer.setText("Fermer");
        btnFermerEffacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFermerEffacerActionPerformed(evt);
            }
        });

        lblCodeEffacer.setText("Tapez code à effacer : ");

        txtCodeEffacer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodeEffacerKeyTyped(evt);
            }
        });

        btnEffacerCode.setText("Effacer");
        btnEffacerCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEffacerCodeActionPerformed(evt);
            }
        });

        tblEffacerCode.setModel(new javax.swing.table.DefaultTableModel(
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
        spEffacerCode.setViewportView(tblEffacerCode);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblCodeEffacer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodeEffacer, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFermerEffacer)))
                .addGap(49, 49, 49)
                .addComponent(btnEffacerCode)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spEffacerCode, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodeEffacer)
                    .addComponent(txtCodeEffacer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEffacerCode))
                .addGap(18, 18, 18)
                .addComponent(spEffacerCode, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnFermerEffacer)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>                        

    private void btnFermerEffacerActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        this.dispose();
    }                                                

    private void btnEffacerCodeActionPerformed(java.awt.event.ActionEvent evt) {                                               
        //Creation de requete.
        String parametres = txtCodeEffacer.getText(); //Code membre tape par l'utilisateur
        
        DAOMembre dao = new DAOMembre(Constantes.FICHER_CONNEXION);
        Registre listeMembres = new Registre() ;
        
       try{
           //Effacer
            dao.executerDelete(Constantes.REQUETE_DELETE_MEMBRE_CODE, Integer.parseInt(parametres));
            //Lister nouvelle information
            dao.executerSelect(Constantes.REQUETE_SELECT_TOUS_MEMBRE);    
            dao.resultSetToList(listeMembres);
            dataBinding(listeMembres);
            dao.fermerConnexion();
        }catch ( IOException | ClassNotFoundException | SQLException e){
            Utilitaire.afficherErreur(Constantes.EFFACER_ERREUR);
        }
    }                                              

    private void txtCodeEffacerKeyTyped(java.awt.event.KeyEvent evt) {                                        
        Utilitaire.validerEntier(evt);
    }                                       

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnEffacerCode;
    private javax.swing.JButton btnFermerEffacer;
    private javax.swing.JLabel lblCodeEffacer;
    private javax.swing.JScrollPane spEffacerCode;
    private javax.swing.JTable tblEffacerCode;
    private javax.swing.JTextField txtCodeEffacer;
    // End of variables declaration                   

    private void dataBinding(Registre maListe){
       tblEffacerCode.setModel(new ResultSetTableModel(maListe.getMembres()));
    }
}
