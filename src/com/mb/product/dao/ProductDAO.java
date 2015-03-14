/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.product.dao;

import com.mb.main.IBusinessDAO;
import com.mb.main.AbstractDAO;
import com.mb.product.bean.Product;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ldanh
 */
public class ProductDAO extends AbstractDAO implements IBusinessDAO<Product>{

    public ProductDAO() {
        super(Product.class);
    }
    
    @Override
    public List<Product> getAll() {
        List<Product> listData = null;
        Transaction trans = null;
        try {
            Session session = getSession();
            trans = session.beginTransaction();
            listData = session.createQuery("from Product order by productId").list();
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
    public boolean addNew(Product bean) {
        Transaction trans = null;
        try {
            Session session = getSession();
            trans = session.beginTransaction();
            session.save(bean);
            trans.commit();
            return true;
        } catch (HibernateException ex) {
            trans.rollback();
            ex.printStackTrace();
            return false;
        } finally {
            closeSession();
        }
    }

    @Override
    public boolean addAll(List<Product> listBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Product bean) {
        Transaction trans = null;
        try {
            Session session = getSession();
            trans = session.beginTransaction();
            session.update(bean);
            trans.commit();
            return true;
        } catch (HibernateException ex) {
            trans.rollback();
            ex.printStackTrace();
            return false;
        } finally {
            closeSession();
        }
    }

    @Override
    public List<Product> updateAll(List<Product> listBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
