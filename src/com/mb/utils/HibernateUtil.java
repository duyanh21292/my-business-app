/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author ldanh
 */
public class HibernateUtil {

    public static Session createSession(String pack, Class className) {
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().addPackage(pack).addAnnotatedClass(className).buildSessionFactory();
        return sessionFactory.openSession();
    }
    
    public static void closeSession(Session session) {
        if(session != null && session.isConnected()) {
            session.close();
        }
    }
}
