/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.product.ui;

import com.mb.main.AbstractPanelModel;
import com.mb.main.IPanelModel;
import com.mb.main.AppManager;
import com.mb.main.MyDefaultTableModel;
import com.mb.product.bean.Product;
import com.mb.product.bean.ProductDetail;
import com.mb.product.dao.ProductDetailDAO;
import com.mb.utils.ITableColumnString;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DUYANH
 */
public class ProductPanelModel extends AbstractPanelModel implements IPanelModel,ITableColumnString {
    
    private final String[] colsName = {STT, MA, LOAI, HANG, TEN, MO_TA_MAU, SO_LUONG, GIA_BAN, GIA_NHAP};
    private DefaultTableModel tableModel = null;

    public ProductPanelModel(AppManager app) {
        super(app);
    }

    @Override
    public DefaultTableModel getTableModel() {
        if (tableModel == null) {
            tableModel = new MyDefaultTableModel();
            tableModel.setColumnIdentifiers(colsName);
            loadRowData();
        }
        return tableModel;
    }

    private void loadRowData() {
        if (tableModel == null || tableModel.getColumnCount() == 0) {
            return;
        }
        int i = 0;
        if (tableModel.getRowCount() > 0) {
            while (i < tableModel.getRowCount()) {
                tableModel.removeRow(i);
            }
        }
        Map<String, Product> mapProduct = app.getMapProduct();

        for (String productId : mapProduct.keySet()) {
            i++;
            Product product = mapProduct.get(productId);
            String category = app.getMapCategory().get(product.getCategoryId()).getCategoryName();
            String trademark = app.getMapTrademark().get(product.getTrademarkId()).getTrademarkName();
            String sizeInfo = "";
            ProductDetailDAO productDetailDao = new ProductDetailDAO();
            List<ProductDetail> listProductDetail = productDetailDao.getAll(productId);
            for (ProductDetail productDetail : listProductDetail) {
                int quantity = productDetail.getQuantity();
                if (quantity == 0)
                    continue;
                if (!sizeInfo.isEmpty())
                    sizeInfo += " - ";
                sizeInfo += app.getMapSize().get(productDetail.getSizeId()).getSizeName() + "(" + quantity + ")";
            }
            String price = String.valueOf(product.getProductPrice());
            String priceOrg = String.valueOf(product.getProductPriceOrg());
            String[] row = {String.valueOf(i), productId, category, trademark, product.getProductName(), product.getProductColorDesc(),sizeInfo.isEmpty() ? EMPTY : sizeInfo ,price, priceOrg};
            tableModel.addRow(row);
        }
    }

    @Override
    public void refresh() {
        loadRowData();
    }
}
