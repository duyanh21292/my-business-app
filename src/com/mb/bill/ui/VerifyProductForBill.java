/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.bill.ui;

import com.mb.bill.bean.ProductBill;
import com.mb.main.AppManager;
import com.mb.other.bean.Size;
import com.mb.product.bean.Product;
import com.mb.product.bean.ProductDetail;
import com.mb.product.dao.ProductDetailDAO;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ldanh
 */
public class VerifyProductForBill extends javax.swing.JDialog {
    private ProductBill productBill;
    private AppManager app;
    private CreateBillFormDialog createBillDialog;
    
    /**
     * Creates new form VerifyProductForBill
     */
    public VerifyProductForBill(java.awt.Frame parent, boolean modal, AppManager app, ProductBill productBill, CreateBillFormDialog createBillDialog) {
        super(parent, modal);
        this.app = app;
        this.createBillDialog = createBillDialog;
        this.productBill = productBill;
        if (this.productBill == null)
            this.productBill = new ProductBill();
        initComponents();
    }
    
    private void loadQuantityContent(String size, int quantity) {
        JLabel label = new JLabel(size);
        Dimension preferredSizeLabel = label.getPreferredSize();
        preferredSizeLabel.width = 50;
        label.setPreferredSize(preferredSizeLabel);
        
        Vector<Integer> comboBoxData = new Vector<Integer>();
        for (int i = 0; i <= quantity; i++) {
            comboBoxData.add(i);
        }
        JComboBox comboBox = new JComboBox(comboBoxData);
        comboBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                int item = (int) e.getItem();
                if(item > 0) {
                    productBill.getMapQuantity().put(size, item);
                } else {
                    productBill.getMapQuantity().remove(size);
                }
                updateBtOkState();
            }
        });
        comboBox.setEnabled(quantity > 0);
        Dimension preferredSizeComboBox = comboBox.getPreferredSize();
        preferredSizeComboBox.width = 100;
        comboBox.setPreferredSize(preferredSizeComboBox);
        
        JPanel newPanel = new JPanel(new FlowLayout());
        newPanel.add(label);
        newPanel.add(comboBox);
        
        pnCenter.add(newPanel);
    }
    
    private void updateBtOkState() {
        btOk.setEnabled(productBill.getTotalQuantity() > 0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfProductId = new javax.swing.JTextField();
        btVerify = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btOk = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        pnCenter = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Mã sản phẩm:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        tfProductId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfProductIdKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.weightx = 0.3;
        jPanel1.add(tfProductId, gridBagConstraints);

        btVerify.setText("Lấy thông tin");
        btVerify.setEnabled(false);
        btVerify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerifyActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel1.add(btVerify, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        btOk.setText("Thêm");
        btOk.setEnabled(false);
        btOk.setPreferredSize(new java.awt.Dimension(70, 23));
        btOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOkActionPerformed(evt);
            }
        });
        jPanel3.add(btOk);

        btCancel.setText("Hủy bỏ");
        btCancel.setPreferredSize(new java.awt.Dimension(70, 23));
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });
        jPanel3.add(btCancel);

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        pnCenter.setBorder(javax.swing.BorderFactory.createTitledBorder("Số lượng"));

        javax.swing.GroupLayout pnCenterLayout = new javax.swing.GroupLayout(pnCenter);
        pnCenter.setLayout(pnCenterLayout);
        pnCenterLayout.setHorizontalGroup(
            pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 326, Short.MAX_VALUE)
        );
        pnCenterLayout.setVerticalGroup(
            pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
        );

        getContentPane().add(pnCenter, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    private void btVerifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerifyActionPerformed
        // TODO add your handling code here:
        String productId = tfProductId.getText();
        Product product = app.getMapProduct().get(productId);
        if (product == null) {
            JOptionPane.showMessageDialog(this, "Mã sản phẩm không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            pnCenter.removeAll();
            pnCenter.setLayout(new BoxLayout(pnCenter, javax.swing.BoxLayout.Y_AXIS));
            productBill.setProduct(product);
            ProductDetailDAO productDetailDao = new ProductDetailDAO();
            List<ProductDetail> listProductDetail = productDetailDao.getAll(productId);
            for (ProductDetail productDetail : listProductDetail) {
                Size size = app.getMapSize().get(productDetail.getSizeId());
                loadQuantityContent(size.getSizeName(), productDetail.getQuantity());
            }
        }
    }//GEN-LAST:event_btVerifyActionPerformed

    private void tfProductIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfProductIdKeyReleased
        // TODO add your handling code here:
        btVerify.setEnabled(!tfProductId.getText().isEmpty());
    }//GEN-LAST:event_tfProductIdKeyReleased

    private void btOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOkActionPerformed
        // TODO add your handling code here:
        if (createBillDialog.addProductBill(productBill)) {
            this.dispose();
        }
    }//GEN-LAST:event_btOkActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btOk;
    private javax.swing.JButton btVerify;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel pnCenter;
    private javax.swing.JTextField tfProductId;
    // End of variables declaration//GEN-END:variables
}
