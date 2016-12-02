package com.makarevich.dao;

import com.makarevich.beans.Order;
import com.makarevich.beans.User;
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
 * Created by j on 30.11.16.
 */
public enum  OrderDAO implements AbstractDAO<Order> {
    INSTANCE {

        @Override
        public List<Order> findAll() throws SQLException {
            Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement =connection.prepareStatement(SqlRequests.GET_ALL_ORDERS);
            ResultSet resultSet = statement.executeQuery();
            List<Order> list= new ArrayList<>();
            while(resultSet.next()){
                Order order = new Order();
                order.setId(resultSet.getLong(ColumnNames.ORDER_ID));
                order.setDishName(resultSet.getString(ColumnNames.DISH_NAME));
                order.setDishPrice(Float.valueOf(resultSet.getString(ColumnNames.DISH_PRICE)));
                order.setUserEmail(resultSet.getString(ColumnNames.USER_EMAIL));
                order.setState(resultSet.getLong(ColumnNames.ORDER_STATE_ID));
                list.add(order);
            }
            ConnectionPool.getInstance().releaseConnection(connection, statement,resultSet);
            return list ;
        }
    };

    public List<Order> findAll(User user) throws SQLException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement =connection.prepareStatement(SqlRequests.GET_ALL_ORDERS_FOR_USER);
        statement.setString(1, String.valueOf(user.getEmail()));
        ResultSet resultSet = statement.executeQuery();
        List<Order> list= new ArrayList<>();
        while(resultSet.next()){
            Order order = new Order();
            order.setId(resultSet.getLong("ORDER.id"));
            order.setDishName(resultSet.getString(ColumnNames.DISH_NAME));
            order.setDishPrice(Float.valueOf(resultSet.getString(ColumnNames.DISH_PRICE)));
            order.setUserEmail(resultSet.getString(ColumnNames.USER_EMAIL));
            order.setState(resultSet.getLong(ColumnNames.ORDER_STATE_ID));
            list.add(order);
        }
        ConnectionPool.getInstance().releaseConnection(connection, statement,resultSet);
        return list ;
    }

    @Override
    public void createEntity(Order entity) throws SQLException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.ADD_TO_ORDER);
        statement.setString(1, entity.getDishName());
        statement.setString(3, UserDAO.INSTANCE.getIdByEmail(entity.getUserEmail()));
        statement.setString(2, String.valueOf(1));
        statement.executeUpdate();
        ConnectionPool.getInstance().releaseConnection(connection, statement);

    }

    public void deleteByOrderId(String orderId) throws SQLException{
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.DELETE_DISH_FROM_ORDER_BY_ID);
        statement.setString(1,orderId);
        statement.executeUpdate();
        ConnectionPool.getInstance().releaseConnection(connection,statement);
    }
}
