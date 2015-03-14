/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.other.dao;

import com.mb.main.IBusinessDAO;
import com.mb.main.AbstractDAO;
import com.mb.other.bean.Size;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DUYANH
 */
public class SizeDAO extends AbstractDAO implements IBusinessDAO<Size>{

    public SizeDAO() {
        super(Size.class);
    }

    @Override
    public boolean addNew(Size bean) {
        return false;
    }

    @Override
    public List<Size> getAll() {
        List<Size> listData = null;
        Transaction trans = null;
        try {
            Session session = getSession();
            trans = session.beginTransaction();
            listData = session.createQuery("from Size").list();
            trans.commit();
        } catch (HibernateException ex) {
            trans.rollback();
            ex.printStackTrace();
        }
        return listData;
    }

    @Override
    public boolean addAll(List<Size> listBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Size bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Size> updateAll(List<Size> listBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
