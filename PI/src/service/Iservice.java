/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface Iservice<T> {
    
    
  void insert(T t);
    boolean update(T t);
    boolean delete(T t);
    List<T>displayAll();
    }