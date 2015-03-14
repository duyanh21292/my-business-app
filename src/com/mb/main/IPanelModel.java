/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.main;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DUYANH
 */
public interface IPanelModel {
    public DefaultTableModel getTableModel();
    public void refresh();
}
