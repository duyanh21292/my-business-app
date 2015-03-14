/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.main;

import java.util.List;

/**
 *
 * @author ldanh
 */
public interface IBusinessDAO<E> {
    
    public boolean addNew(E bean);
    public boolean addAll (List<E> listBean);
    public List<E> getAll();
    public boolean update(E bean);
    public List<E> updateAll (List<E> listBean);
}
