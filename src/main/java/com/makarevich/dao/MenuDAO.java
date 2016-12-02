package com.makarevich.dao;

import com.makarevich.beans.Dish;
import com.makarevich.connection.ConnectionPool;
import com.makarevich.constants.ColumnNames;
import com.makarevich.constants.SqlRequests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by j on 29.11.16.
 */
public enum  MenuDAO implements AbstractDAO<Dish> {
    INSTANCE;

    @Override
    public List<Dish> findAll() throws SQLException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement =connection.prepareStatement(SqlRequests.GET_ALL_DISHES);
        ResultSet resultSet = statement.executeQuery();
        List<Dish> list= new ArrayList<>();
        while(resultSet.next()){
            Dish dish = new Dish();
            dish.setId(resultSet.getLong(ColumnNames.DISH_ID));
            dish.setName(resultSet.getString(ColumnNames.DISH_NAME));
            dish.setPrice(Double.valueOf(resultSet.getString(ColumnNames.DISH_PRICE)));
            list.add(dish);
        }
        ConnectionPool.getInstance().releaseConnection(connection, statement, resultSet);
        return list ;
    }

    @Override
    public void createEntity(Dish entity) throws SQLException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.ADD_DISH);
        statement.setString(1, entity.getName());
        statement.setString(2, String.valueOf(entity.getPrice()));
       // statement.setString(3, String.valueOf(entity.getMenuId()));
        statement.executeUpdate();
        ConnectionPool.getInstance().releaseConnection(connection, statement);

    }

    public Dish getDishById(String dishId) throws SQLException {
        Dish dish = null;
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_DISH_BY_ID);
        statement.setString(1, dishId);
        ResultSet result = statement.executeQuery();
        while(result.next()){
            dish = new Dish();
            dish.setId(result.getLong(ColumnNames.DISH_ID));
            dish.setName(result.getString(ColumnNames.DISH_NAME));
            dish.setPrice(result.getDouble(ColumnNames.DISH_PRICE));
        }
        ConnectionPool.getInstance().releaseConnection(connection, statement, result);
        return dish;
    }

    public boolean isNewDish(String name) throws SQLException{
        //Dish dish = null;
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_DISH_BY_NAME);
        statement.setString(1,name);
        ResultSet result = statement.executeQuery();
        if(result.next()){
            ConnectionPool.getInstance().releaseConnection(connection, statement,result);
            return false;
        }else {
            ConnectionPool.getInstance().releaseConnection(connection, statement, result);
            return true;
        }
    }

    public void deleteById(String dishId) throws SQLException{
        //Dish dish = null;
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.DELETE_DISH_BY_ID);
        statement.setString(1,dishId);
        statement.executeUpdate();
        ConnectionPool.getInstance().releaseConnection(connection, statement);
    }

    public void updateEntity(Dish dish) throws SQLException {
        Connection connection= ConnectionPool.getInstance().getConnection();
        PreparedStatement statement=connection.prepareStatement(SqlRequests.UPDATE_DISH);
        statement.setString(1, dish.getName());
        statement.setString(2, String.valueOf(dish.getPrice()));
        statement.setString(3, String.valueOf(dish.getId()));
        statement.executeUpdate();
        ConnectionPool.getInstance().releaseConnection(connection, statement);
    }

    public String getIdByName(String dishName) throws SQLException{
        String id = null;
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_DISH_ID_BY_NAME);
        statement.setString(1, dishName);
        ResultSet result = statement.executeQuery();
        while(result.next()){
            id=(result.getString(ColumnNames.DISH_ID));
        }
        ConnectionPool.getInstance().releaseConnection(connection, statement);
        return id;
    }
}
