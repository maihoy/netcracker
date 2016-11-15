package com.makarevich.dao;

import com.makarevich.beans.Entity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by j on 11.11.16.
 */
public interface AbstractDAO <T extends Entity>{
    List<T> findAll() throws SQLException;
    public void createEntity(T entity) throws SQLException;
    public T getEntityById(int id) throws SQLException;
    public void deleteEntity(T entity) throws SQLException;
}
