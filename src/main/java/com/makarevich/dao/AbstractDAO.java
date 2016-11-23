package com.makarevich.dao;

import com.makarevich.beans.Entity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by j on 11.11.16.
 */
public interface AbstractDAO <T extends Entity>{
    List<T> findAll() throws SQLException;
    void createEntity(T entity) throws SQLException;
  //  public T getEntityById(Long id) throws SQLException;
  //  public void deleteEntity(Long id) throws SQLException;
  //  public void updateEntity(Long id) throws SQLException;
}
