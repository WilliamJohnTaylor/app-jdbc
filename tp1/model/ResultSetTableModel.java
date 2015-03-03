package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * Classe que permettre de modeliser un ArrayList pour l'afficher dans une
 * tableau.
 *
 * @author William Taylor
 * @version 1.00 date: 24/02/2015
 */
public class ResultSetTableModel extends AbstractTableModel {
    //Attributs

    private ArrayList<Membre> listeMembres;
    private String[] columnNames = {"CODE", "NOM", "PRENOM", "ADRESSE", "STATUS", "REVENUE_ANNUEL"};

    //Constructeur
    public ResultSetTableModel(ArrayList<Membre> listeMembres) {
        this.listeMembres = listeMembres;
    }

    //Getters
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return listeMembres.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listeMembres.get(rowIndex).getCodeMembre();
            case 1:
                return listeMembres.get(rowIndex).getNom();
            case 2:
                return listeMembres.get(rowIndex).getPrenom();
            case 3:
                return listeMembres.get(rowIndex).getAdresse();
            case 4:
                return listeMembres.get(rowIndex).getStatut();
            case 5:
                return listeMembres.get(rowIndex).getRevenue_annuel();
            default:
                return listeMembres.get(rowIndex).getRevenue_annuel();
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
