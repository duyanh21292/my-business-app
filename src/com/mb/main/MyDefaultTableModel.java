/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.main;

import com.mb.utils.ITableColumnString;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DUYANH
 */
public class MyDefaultTableModel extends DefaultTableModel implements ITableColumnString{

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(this.getColumnName(columnIndex).equals(GIA_BAN) || this.getColumnName(columnIndex).equals(GIA_NHAP))
            return String.class;
        return super.getClass();
    }
    
}
