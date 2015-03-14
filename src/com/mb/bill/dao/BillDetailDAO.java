/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.bill.dao;

import com.mb.bill.bean.BillDetail;
import com.mb.main.AbstractDAO;
import com.mb.main.IBusinessDAO;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ldanh
 */
public class BillDetailDAO extends AbstractDAO implements IBusinessDAO<BillDetail>{

    public BillDetailDAO() {
        super(BillDetail.class);
    }

    @Override
    public boolean addNew(BillDetail bean) {
        Transaction trans = null;
        try {
            Session session = getSession();
            trans = session.beginTransaction();
            session.save(bean);
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
    public boolean addAll(List<BillDetail> listBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BillDetail> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(BillDetail bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BillDetail> updateAll(List<BillDetail> listBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
