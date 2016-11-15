package com.makarevich.dao;

import com.makarevich.beans.User;
import com.makarevich.connection.ConnectionPool;
import com.makarevich.constants.ColumnNames;
import com.makarevich.constants.SqlRequests;
import com.makarevich.enums.Roles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by j on 11.11.16.
 */
public enum UserDAO implements AbstractDAO<User>{
    INSTANCE;

    @Override
    public List<User> findAll() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement =connection.prepareStatement(SqlRequests.GET_ALL_USER_PROFILES);
        ResultSet resultSet = statement.executeQuery();
        List<User> list= new ArrayList<>();
        while(resultSet.next()){
            User user = new User();
            user.setFirstName(resultSet.getString(ColumnNames.USER_FIRST_NAME));
            user.setLastName(resultSet.getString(ColumnNames.USER_LAST_NAME));
            user.setEmail(resultSet.getString(ColumnNames.USER_EMAIL));
            list.add(user);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return list ;
    }

    @Override
    public void createEntity(User entity) throws SQLException {

    }

    @Override
    public User getEntityById(int id) throws SQLException {
        return null;
    }

    @Override
    public void deleteEntity(User entity) throws SQLException {

    }

    public static boolean isAuthorized(String login, String password) throws SQLException{
        boolean isLogIn = false;
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.CHECK_AUTHORIZATION);
        statement.setString(1, login);
        statement.setString(2, password);
        ResultSet result = statement.executeQuery();
        if(result.next()){
            isLogIn = true;
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return isLogIn;
    }

    public static User getUserByEmail(String email) throws SQLException{
        User user = null;
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_USER_BY_EMAIL);
        statement.setString(1, email);
        ResultSet result = statement.executeQuery();
        while(result.next()){
            user = new User();
            user.setId(result.getLong(ColumnNames.USER_ID));
            user.setFirstName(result.getString(ColumnNames.USER_FIRST_NAME));
            user.setLastName(result.getString(ColumnNames.USER_LAST_NAME));
            user.setEmail(result.getString(ColumnNames.USER_EMAIL));
            user.setPassword(result.getString(ColumnNames.USER_PASSWORD));
            user.setRoles((Set) result.getArray(ColumnNames.USER_ROLE_TYPE));
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return user;
    }

    public static Set<Roles> checkAccessLevel(String email) throws SQLException{
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.CHECK_ACCESS_LEVEL);
        ResultSet result = statement.executeQuery();
        Set<Roles> roles=new HashSet<>();
        while(result.next()){
            User user=new User();
            user.setRoles(roles);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return roles;
    }
}
