/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import model.Registre;

/**
 * Interface utilisateur principale. Elle envoi l'utilisateur vers l'écran
 * qui corresponde à sa choix
 *
 * @author William Taylor
 * @version 1.00 
 * date: 24/02/2015
 */
public class GuiGererMembres extends javax.swing.JFrame {
    private Registre listeMembres = new Registre();

    public GuiGererMembres(Registre listeMembres) {
        this.listeMembres = listeMembres;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        mnHaut = new javax.swing.JMenuBar();
        opAjouter = new javax.swing.JMenu();
        sopAjouterMembre = new javax.swing.JMenuItem();
        opLister = new javax.swing.JMenu();
        sopListerTous = new javax.swing.JMenuItem();
        sopListerStatus = new javax.swing.JMenuItem();
        opActualiser = new javax.swing.JMenu();
        sopActualiser = new javax.swing.JMenuItem();
        opEffacer = new javax.swing.JMenu();
        sopEffacerCode = new javax.swing.JMenuItem();
        opSortir = new javax.swing.JMenu();
        sopFermer = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Club de fleuriste");

        mnHaut.setName("mnHaut"); // NOI18N

        opAjouter.setText("Ajouter");

        sopAjouterMembre.setText("Membre");
        sopAjouterMembre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sopAjouterMembreActionPerformed(evt);
            }
        });
        opAjouter.add(sopAjouterMembre);

        mnHaut.add(opAjouter);

        opLister.setText("Lister");

        sopListerTous.setText("Lister tous les membres");
        sopListerTous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sopListerTousActionPerformed(evt);
            }
        });
        opLister.add(sopListerTous);

        sopListerStatus.setText("Lister par status");
        sopListerStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sopListerStatusActionPerformed(evt);
            }
        });
        opLister.add(sopListerStatus);

        mnHaut.add(opLister);

        opActualiser.setText("Actualiser");

        sopActualiser.setText("Par code");
        sopActualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sopActualiserActionPerformed(evt);
            }
        });
        opActualiser.add(sopActualiser);

        mnHaut.add(opActualiser);

        opEffacer.setLabel("Effacer");

        sopEffacerCode.setLabel("Par code");
        sopEffacerCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sopEffacerCodeActionPerformed(evt);
            }
        });
        opEffacer.add(sopEffacerCode);

        mnHaut.add(opEffacer);

        opSortir.setText("Sortir");

        sopFermer.setText("Fermer");
        sopFermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sopFermerActionPerformed(evt);
            }
        });
        opSortir.add(sopFermer);

        mnHaut.add(opSortir);

        setJMenuBar(mnHaut);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void sopListerStatusActionPerformed(java.awt.event.ActionEvent evt) {                                                
       GuiListerStatus objListerStatus = new GuiListerStatus(listeMembres);
        objListerStatus.setVisible(true);
    }                                               

    private void sopAjouterMembreActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        GuiAjouter objAjouter = new GuiAjouter();
        objAjouter.setVisible(true);        
    }                                                

    private void sopFermerActionPerformed(java.awt.event.ActionEvent evt) {                                          
        System.exit(0);
    }                                         

    private void sopListerTousActionPerformed(java.awt.event.ActionEvent evt) {                                              
        GuiListerTous objListerTous = new GuiListerTous();
        objListerTous.setVisible(true);  
    }                                             

    private void sopEffacerCodeActionPerformed(java.awt.event.ActionEvent evt) {                                               
        GuiEffacerCode objEffacerCode = new GuiEffacerCode();
        objEffacerCode.setVisible(true); 
    }                                              

    private void sopActualiserActionPerformed(java.awt.event.ActionEvent evt) {                                              
       GuiMettreJourStatus objMettreJour = new GuiMettreJourStatus();
        objMettreJour.setVisible(true); 
    }                                             

   
    // Variables declaration - do not modify                     
    private javax.swing.JMenuBar mnHaut;
    private javax.swing.JMenu opActualiser;
    private javax.swing.JMenu opAjouter;
    private javax.swing.JMenu opEffacer;
    private javax.swing.JMenu opLister;
    private javax.swing.JMenu opSortir;
    private javax.swing.JMenuItem sopActualiser;
    private javax.swing.JMenuItem sopAjouterMembre;
    private javax.swing.JMenuItem sopEffacerCode;
    private javax.swing.JMenuItem sopFermer;
    private javax.swing.JMenuItem sopListerStatus;
    private javax.swing.JMenuItem sopListerTous;
    // End of variables declaration                   
}
