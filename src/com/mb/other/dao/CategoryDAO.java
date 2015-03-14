/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.other.dao;

import com.mb.other.bean.Category;
import com.mb.main.IBusinessDAO;
import com.mb.main.AbstractDAO;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DUYANH
 */
public class CategoryDAO extends AbstractDAO implements IBusinessDAO<Category>{

    public CategoryDAO() {
        super(Category.class);
    }
    
    @Override
    public boolean addNew(Category bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Category> getAll() {
        List<Category> listData = null;
        Transaction trans = null;
        try {
            Session session = getSession();
            trans = session.beginTransaction();
            listData = session.createQuery("from Category").list();
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
    public boolean addAll(List<Category> listBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Category bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Category> updateAll(List<Category> listBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
