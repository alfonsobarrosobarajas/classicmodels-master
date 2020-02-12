package com.classicmodels.repositories;

import java.util.List;

public interface ICRUD<T> {

    List<T> getAll() throws Exception;
    T getById(int id) throws Exception;
    void save(T obj) throws Exception;
    void update (T obj, int id) throws Exception;
    void deleteById(int id) throws Exception;

}
