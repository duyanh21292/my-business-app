/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.main;

import com.mb.utils.MyBusinessUtils;
import java.awt.Component;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author DUYANH
 */
public class MyDefaultTableCellRenderer extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        JLabel lbNumber = (JLabel) c;
        lbNumber.setText(MyBusinessUtils.formatDecimalString(String.valueOf(value), true));
        lbNumber.setHorizontalAlignment(RIGHT);
        return lbNumber;
    }
    
}
