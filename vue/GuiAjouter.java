package vue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTextField;
import model.DAOMembre;
import utilitaires.Constantes;
import utilitaires.Regles;
import utilitaires.Utilitaire;

/**
 * Interface utilisateur que permettre d'ajouter un membre a la Base de données.
 *
 * @author William Taylor
 * @version 2.00 date: 25/02/2015
 */
public class GuiAjouter extends javax.swing.JFrame {

    public GuiAjouter() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        lblCodeMembre = new javax.swing.JLabel();
        lblNom = new javax.swing.JLabel();
        lblPrenom = new javax.swing.JLabel();
        lblAdresse = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblRevenue = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        txtNom = new javax.swing.JTextField();
        txtPrenom = new javax.swing.JTextField();
        txtAdresse = new javax.swing.JTextField();
        txtRevenue = new javax.swing.JTextField();
        cbStatus = new javax.swing.JComboBox();
        btnAjouter = new javax.swing.JButton();
        btnFermerAjouter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ajouter membre");

        lblCodeMembre.setText("Code membre:");

        lblNom.setText("Nom:");

        lblPrenom.setText("Prénom:");

        lblAdresse.setText("Adresse:");

        lblStatus.setText("Status:");

        lblRevenue.setText("Revenue annuel:");

        txtCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodeActionPerformed(evt);
            }
        });
        txtCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodeKeyTyped(evt);
            }
        });

        txtRevenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRevenueActionPerformed(evt);
            }
        });
        txtRevenue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRevenueKeyTyped(evt);
            }
        });

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "OR", "ARGENT", "REGULIER" }));
        cbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStatusActionPerformed(evt);
            }
        });

        btnAjouter.setText("Ajouter");
        btnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });

        btnFermerAjouter.setText("Fermer");
        btnFermerAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFermerAjouterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRevenue)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCodeMembre)
                                    .addComponent(lblNom)
                                    .addComponent(lblPrenom)
                                    .addComponent(lblAdresse)
                                    .addComponent(lblStatus))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNom, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                        .addComponent(txtPrenom))
                                    .addComponent(txtAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(btnAjouter)
                        .addGap(138, 138, 138)
                        .addComponent(btnFermerAjouter)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodeMembre)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNom)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrenom)
                    .addComponent(txtPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdresse)
                    .addComponent(txtAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRevenue)
                    .addComponent(txtRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAjouter)
                    .addComponent(btnFermerAjouter))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>                        

    private void btnFermerAjouterActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        this.dispose();
    }                                                

    private void btnAjouterActionPerformed(java.awt.event.ActionEvent evt) {                                           
        //Pour ajouter je vais utiliser una méthode qui a besoin des valeurs tapez par l'utilisateur.
        String nomChamp = "";
        ArrayList<JTextField> champs = new ArrayList<>();
        ArrayList<String> parametres = new ArrayList<>();
        champs = preparerChamps();

        //Creation de ma requete
        String requete = Constantes.REQUETE_INSERT_MEMBRE;

        DAOMembre dao = new DAOMembre(Constantes.FICHER_CONNEXION);

        if ((nomChamp = Regles.sontVides(champs)).trim().equals(Constantes.VIDE)) {
            try {
                parametres = preparerParametres();
                dao.executerRequete(requete, parametres);
                dao.fermerConnexion();
                Utilitaire.afficherOk(Constantes.INSERTION_OK);
                Utilitaire.viderChamps(champs);
            } catch (IOException | ClassNotFoundException | SQLException ex) {
                Utilitaire.afficherErreur(Constantes.INSERTION_ERREUR);
            }
        } else {
            Utilitaire.afficherErreur("Le champ " + nomChamp + " ne peut pas être vide!");
        }
    }                                          

    private void cbStatusActionPerformed(java.awt.event.ActionEvent evt) {                                         

    }                                        

    private void txtRevenueActionPerformed(java.awt.event.ActionEvent evt) {                                           

    }                                          

    private void txtRevenueKeyTyped(java.awt.event.KeyEvent evt) {                                    
        Utilitaire.validerFloat(evt);
    }                                   

    private void txtCodeActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void txtCodeKeyTyped(java.awt.event.KeyEvent evt) {                                 
        Utilitaire.validerEntier(evt);
    }                                

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAjouter;
    private javax.swing.JButton btnFermerAjouter;
    private javax.swing.JComboBox cbStatus;
    private javax.swing.JLabel lblAdresse;
    private javax.swing.JLabel lblCodeMembre;
    private javax.swing.JLabel lblNom;
    private javax.swing.JLabel lblPrenom;
    private javax.swing.JLabel lblRevenue;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTextField txtAdresse;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtPrenom;
    private javax.swing.JTextField txtRevenue;
    // End of variables declaration                   
    /* Méthode pour créer un arraylist avec les champs de l'écran
     pour les utiliser comme parametres.*/
    private ArrayList<JTextField> preparerChamps() {
        ArrayList<JTextField> champs = new ArrayList<>();

        //Je mets des noms a chaque textfield pour povoir les identifier
        //Je mets des noms a chaque textfield pour povoir les identifier
        txtCode.setName("Code membre");
        txtNom.setName("Nom");
        txtPrenom.setName("Prenom");
        txtAdresse.setName("Adresse");
        txtRevenue.setName("Revenue");

        //Je ajoute les textfields au Array parametres.
        champs.add(txtCode);
        champs.add(txtNom);
        champs.add(txtPrenom);
        champs.add(txtAdresse);
        champs.add(txtRevenue);

        return champs;
    }

    private ArrayList<String> preparerParametres() {
        ArrayList<String> parametres = new ArrayList<>();

        //Je ajoute les textfields au Array parametres.
        parametres.add(txtCode.getText());
        parametres.add(txtNom.getText());
        parametres.add(txtPrenom.getText());
        parametres.add(txtAdresse.getText());
        parametres.add(cbStatus.getSelectedItem().toString());
        parametres.add(txtRevenue.getText());

        return parametres;
    }
}
