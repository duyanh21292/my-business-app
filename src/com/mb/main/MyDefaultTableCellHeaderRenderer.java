/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.main;

import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author DUYANH
 */
public class MyDefaultTableCellHeaderRenderer extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        JLabel lbheader = (JLabel) super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
        lbheader.setFont(new Font("Arial", Font.BOLD, 12));
        lbheader.setHorizontalAlignment(CENTER);
        lbheader.setBorder(BorderFactory.createEtchedBorder());
        return lbheader;
    }
    
}
