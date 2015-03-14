/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.main;

import com.mb.bill.ui.CreateBillFormDialog;
import com.mb.product.ui.ProductPanelModel;
import com.mb.product.ui.ProductTablePanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 *
 * @author DUYANH
 */
public class MyBusinessMainFrame extends javax.swing.JFrame {
    
    private AppManager appMng = null;
    private IPanelModel panelModel = null;
    
    /**
     * Creates new form MyBusinessMainFrame
     */
    public MyBusinessMainFrame() {
        setTitle("My Business");
        appMng = AppManager.createInstance();
        panelModel = new ProductPanelModel(appMng);
        initComponents();
        panelContent.setLayout(new BorderLayout());
        loadTableProduct();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btProduct = new javax.swing.JButton();
        btCategory = new javax.swing.JButton();
        btTrademark = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btCreateBill = new javax.swing.JButton();
        btOutputProductLog = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btInputProduct = new javax.swing.JButton();
        btInputProductLog = new javax.swing.JButton();
        panelContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMenu.setLayout(new javax.swing.BoxLayout(panelMenu, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Quản lý chung"));

        btProduct.setText("Danh sách sản phẩm");
        btProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProductActionPerformed(evt);
            }
        });
        jPanel3.add(btProduct);

        btCategory.setText("Danh sách loại");
        jPanel3.add(btCategory);

        btTrademark.setText("Danh sách hãng");
        jPanel3.add(btTrademark);

        panelMenu.add(jPanel3);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Quản lý đầu vào"));

        btCreateBill.setText("Tạo đơn hàng");
        btCreateBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCreateBillActionPerformed(evt);
            }
        });
        jPanel2.add(btCreateBill);

        btOutputProductLog.setText("Theo dõi bán ra");
        jPanel2.add(btOutputProductLog);

        panelMenu.add(jPanel2);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Quản lý đầu ra"));

        btInputProduct.setText("Nhập thêm");
        jPanel1.add(btInputProduct);

        btInputProductLog.setText("Theo dõi nhập vào");
        jPanel1.add(btInputProductLog);

        panelMenu.add(jPanel1);

        getContentPane().add(panelMenu, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout panelContentLayout = new javax.swing.GroupLayout(panelContent);
        panelContent.setLayout(panelContentLayout);
        panelContentLayout.setHorizontalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 839, Short.MAX_VALUE)
        );
        panelContentLayout.setVerticalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
        );

        getContentPane().add(panelContent, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProductActionPerformed
        // TODO add your handling code here:
        loadTableProduct();
    }//GEN-LAST:event_btProductActionPerformed

    private void btCreateBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCreateBillActionPerformed
        // TODO add your handling code here:
        CreateBillFormDialog createBillDialog = new CreateBillFormDialog(this, true, appMng);
        createBillDialog.setPreferredSize(new Dimension(1000, 800));
        createBillDialog.setVisible(true);
    }//GEN-LAST:event_btCreateBillActionPerformed

    private void loadTableProduct() {
        ProductTablePanel productTblPanel = new ProductTablePanel((ProductPanelModel)panelModel);
        panelContent.removeAll();
        panelContent.add(productTblPanel, BorderLayout.CENTER);
        panelContent.validate();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyBusinessMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyBusinessMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyBusinessMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyBusinessMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyBusinessMainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCategory;
    private javax.swing.JButton btCreateBill;
    private javax.swing.JButton btInputProduct;
    private javax.swing.JButton btInputProductLog;
    private javax.swing.JButton btOutputProductLog;
    private javax.swing.JButton btProduct;
    private javax.swing.JButton btTrademark;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables
}
