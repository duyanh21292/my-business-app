/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.main;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ldanh
 */
public abstract class AbstractPanelModel implements IPanelModel{
    
    protected AppManager app;
    
    public AbstractPanelModel(AppManager app) {
        this.app = app;
        this.app.addPanelModel(this);
    }

    public AppManager getApp() {
        return app;
    }
    
}
