/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.product.dao;

import com.mb.main.IBusinessDAO;
import com.mb.main.AbstractDAO;
import com.mb.product.bean.ProductDetail;
import com.mb.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DUYANH
 */
public class ProductDetailDAO extends AbstractDAO implements IBusinessDAO<ProductDetail>{

    public ProductDetailDAO() {
        super(ProductDetail.class);
    }
    
    @Override
    public boolean addNew(ProductDetail bean) {
        if (bean instanceof ProductDetail) {
            ProductDetail productDetail = (ProductDetail) bean;
            Transaction trans = null;
            try {
                Session session = getSession();
                trans = session.beginTransaction();
                session.save(productDetail);
                trans.commit();
                return true;
            } catch (HibernateException ex) {
                trans.rollback();
                ex.printStackTrace();
            } finally {
                closeSession();
            }
            
        }
        return false;
    }

    @Override
    public List<ProductDetail> getAll() {
        List<ProductDetail> listData = null;
        Transaction trans = null;
        try {
            Session session = getSession();
            trans = session.beginTransaction();
            listData = session.createQuery("from ProductDetail").list();
            trans.commit();
        } catch (HibernateException ex) {
            trans.rollback();
            ex.printStackTrace();
        } finally {
            closeSession();
        }
        return listData;
    }
    
    public List<ProductDetail> getAll(String productId) {
        List<ProductDetail> listData = null;
        Transaction trans = null;
        try {
            Session session = getSession();
            trans = session.beginTransaction();
            Query query = session.createQuery("from ProductDetail where productId = :productId");
            query.setParameter("productId", productId);
            listData = query.list();
            trans.commit();
        } catch (HibernateException ex) {
            trans.rollback();
            ex.printStackTrace();
        } finally {
            closeSession();
        }
        return listData;
    }

    @Override
    public boolean addAll(List<ProductDetail> listBean) {
        Transaction trans = null;
        try {
            Session session = getSession();
            trans = session.beginTransaction();
            for (ProductDetail bean : listBean) {
                session.save(bean);
            }
            trans.commit();
            return true;
        } catch (HibernateException ex) {
            trans.rollback();
            ex.printStackTrace();
        } finally {
            closeSession();
        }
        return false;
    }

    @Override
    public boolean update(ProductDetail bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProductDetail> updateAll(List<ProductDetail> listBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
