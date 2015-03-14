/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.main;

import java.awt.Font;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author DUYANH
 */
public class  MyTable extends JTable {

    public MyTable() {
        initMyUI();
    }

    public MyTable(TableModel dm) {
        super(dm);
        initMyUI();
    }

    public MyTable(TableModel dm, TableColumnModel cm) {
        super(dm, cm);
        initMyUI();
    }

    public MyTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm) {
        super(dm, cm, sm);
        initMyUI();
    }

    public MyTable(int numRows, int numColumns) {
        super(numRows, numColumns);
        initMyUI();
    }

    public MyTable(Vector rowData, Vector columnNames) {
        super(rowData, columnNames);
        initMyUI();
    }

    public MyTable(Object[][] rowData, Object[] columnNames) {
        super(rowData, columnNames);
        initMyUI();
    }
    
    private void initMyUI(){
        this.setRowHeight(30);
        this.setFont(new Font("Calibri", -1, 16));
        this.setAutoCreateRowSorter(true);
        this.setShowGrid(true);
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setHeaderRenderer(new MyDefaultTableCellHeaderRenderer());
        }
        
    }
    
} 
