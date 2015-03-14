/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.main;

import com.mb.other.bean.Category;
import com.mb.other.bean.Size;
import com.mb.other.bean.Trademark;
import com.mb.other.dao.CategoryDAO;
import com.mb.other.dao.SizeDAO;
import com.mb.other.dao.TrademarkDAO;
import com.mb.product.bean.Product;
import com.mb.product.dao.ProductDAO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DUYANH
 */
public class AppManager {
    private Map<String, Product> mapProduct = null;
    private Map<Integer, Category> mapCategory = null;
    private Map<Integer, Size> mapSize = null;
    private Map<Integer, Trademark> mapTrademark = null;
    private List<IPanelModel> listPanelModel = new ArrayList<IPanelModel>();
    
    public static AppManager createInstance(){
        AppManager appManager = new AppManager();
        return appManager;
    }
    
    public void addPanelModel(IPanelModel panelModel) {
        listPanelModel.add(panelModel);
    }
    
    private void loadData() {
        ProductDAO productDao = new ProductDAO();
        addProduct(productDao.getAll());
        
        CategoryDAO categoryDao = new CategoryDAO();
        addCategory(categoryDao.getAll());
        
        SizeDAO sizeDao = new SizeDAO();
        addSize(sizeDao.getAll());
        
        TrademarkDAO trademarkDao = new TrademarkDAO();
        addTrademark(trademarkDao.getAll());
    }
    
    public void reloadData() {
        mapProduct.clear();
        mapCategory.clear();
        mapSize.clear();
        mapTrademark.clear();
        loadData();
        for (IPanelModel panelModel : listPanelModel) {
            panelModel.refresh();
        }
    }
    
    public AppManager() {
        this.mapProduct = new LinkedHashMap<String, Product>();
        this.mapCategory = new LinkedHashMap <Integer, Category>();
        this.mapSize = new LinkedHashMap<Integer, Size>();
        this.mapTrademark = new LinkedHashMap<Integer, Trademark>();
        loadData();
    }

    public Map<String, Product> getMapProduct() {
        return mapProduct;
    }

    public Map<Integer, Category> getMapCategory() {
        return mapCategory;
    }

    public Map<Integer, Size> getMapSize() {
        return mapSize;
    }

    public Map<Integer, Trademark> getMapTrademark() {
        return mapTrademark;
    }
    
    public void addProduct (List<Product> listProduct) {
        for (Product product : listProduct) {
            mapProduct.put(product.getProductId(), product);
        }
    }
    
    public void addCategory (List<Category> listCategory) {
        for (Category category : listCategory) {
            mapCategory.put(category.getCategoryId(), category);
        }
    }
    
    public void addSize (List<Size> listSize) {
        for (Size size : listSize) {
            mapSize.put(size.getSizeId(), size);
        }
    }
    
    public void addTrademark (List<Trademark> listTrademark) {
        for (Trademark trademark : listTrademark) {
            mapTrademark.put(trademark.getTrademarkId(), trademark);
        }
    }
    
    public Category[] mapCategoryToArray() {
        Collection<Category> listCategory = mapCategory.values();
        return listCategory.toArray(new Category[listCategory.size()]);
    }
    
    public Trademark[] mapTrademarkToArray() {
        Collection<Trademark> listTrademark = mapTrademark.values();
        return listTrademark.toArray(new Trademark[listTrademark.size()]);
    }
}
