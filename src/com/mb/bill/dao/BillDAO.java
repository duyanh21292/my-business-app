/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.bill.dao;

import com.mb.bill.bean.Bill;
import com.mb.main.AbstractDAO;
import com.mb.main.IBusinessDAO;
import com.mb.product.bean.Product;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ldanh
 */
public class BillDAO extends AbstractDAO implements IBusinessDAO<Bill>{

    public BillDAO() {
        super(Bill.class);
    }

    @Override
    public boolean addNew(Bill bean) {
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
    public boolean addAll(List<Bill> listBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Bill> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Bill bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Bill> updateAll(List<Bill> listBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
