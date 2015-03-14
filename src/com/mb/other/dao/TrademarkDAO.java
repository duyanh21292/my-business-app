/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.other.dao;

import com.mb.main.IBusinessDAO;
import com.mb.main.AbstractDAO;
import com.mb.other.bean.Trademark;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DUYANH
 */
public class TrademarkDAO extends AbstractDAO implements IBusinessDAO<Trademark>{

    public TrademarkDAO() {
        super(Trademark.class);
    }

    @Override
    public boolean addNew(Trademark bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Trademark> getAll() {
        List<Trademark> listData = null;
        Transaction trans = null;
        try {
            Session session = getSession();
            trans = session.beginTransaction();
            listData = session.createQuery("from Trademark").list();
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
    public boolean addAll(List<Trademark> listBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Trademark bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Trademark> updateAll(List<Trademark> listBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
