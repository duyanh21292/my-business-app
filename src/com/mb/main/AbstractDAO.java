/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.main;

import com.mb.utils.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author ldanh
 */
public abstract class AbstractDAO {
    
    private Session session;
    private String packageName;
    private Class className;
    
    public AbstractDAO(Class className) {
        this.className = className;
        this.packageName = className.getPackage().getName();
    }
    
    protected Session getSession() {
        if (session == null) {
            session = HibernateUtil.createSession(packageName, className);
        }
        return session;
    }
    
    protected void closeSession() {
        HibernateUtil.closeSession(session);
    }

    public String getPackageName() {
        return packageName;
    }

    public Class getClassName() {
        return className;
    }
}
