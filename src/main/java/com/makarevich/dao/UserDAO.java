package com.makarevich.dao;

import com.makarevich.beans.User;
import com.makarevich.connection.ConnectionPool;
import com.makarevich.constants.ColumnNames;
import com.makarevich.constants.SqlRequests;
import com.makarevich.filter.UserType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by j on 11.11.16.
 */
public enum UserDAO implements AbstractDAO<User>{
    INSTANCE ;

    public void updateEntity(User user) throws SQLException {
        Connection connection= ConnectionPool.getInstance().getConnection();
        PreparedStatement statement=connection.prepareStatement(SqlRequests.UPDATE_USER);
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3,user.getPassword());
        statement.setLong(4, user.getIdRole());
        statement.setLong(5, user.getIdState());
        statement.setLong(6, user.getId());
        statement.setString(7, user.getEmail());
        statement.executeUpdate();
        ConnectionPool.getInstance().releaseConnection(connection, statement);

    }


    @Override
    public List<User> findAll() throws SQLException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement =connection.prepareStatement(SqlRequests.GET_ALL_USERS);
        ResultSet resultSet = statement.executeQuery();
        List<User> list= new ArrayList<>();
        while(resultSet.next()){
            User user = new User();
            user.setFirstName(resultSet.getString(ColumnNames.USER_FIRST_NAME));
            user.setLastName(resultSet.getString(ColumnNames.USER_LAST_NAME));
            user.setEmail(resultSet.getString(ColumnNames.USER_EMAIL));
            user.setIdState(resultSet.getLong(ColumnNames.USER_USER_STATE_ID));
            list.add(user);
        }
        ConnectionPool.getInstance().releaseConnection(connection, statement,resultSet);
        return list ;
    }

    @Override
    public void createEntity(User user) throws SQLException{
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.ADD_USER);
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getPassword());
        statement.setString(4, user.getEmail());
        statement.setLong(5,user.getIdRole());
        statement.setLong(6, user.getIdState());
        statement.executeUpdate();
        ConnectionPool.getInstance().releaseConnection(connection, statement);
    }

    //@Override
    public User getEntityById(Long id) throws SQLException {
        return null;
    }

  //  @Override
    public void deleteEntity(Long id, String email) throws SQLException {
        Connection connection=ConnectionPool.getInstance().getConnection();
        PreparedStatement statement= connection.prepareStatement(SqlRequests.DELETE_USER);
        statement.setLong(1, id);
        statement.setString(2, email);
        statement.executeUpdate();
        ConnectionPool.getInstance().releaseConnection(connection, statement);

    }

    public  boolean isAuthorized(String email, String password) throws SQLException{
        boolean isLogIn = false;
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.CHECK_AUTHORIZATION);
        statement.setString(1, email);
        statement.setString(2, password);
        ResultSet result = statement.executeQuery();
        if(result.next()){
            isLogIn = true;
        }
        ConnectionPool.getInstance().releaseConnection(connection, statement, result);
        return isLogIn;
    }

    public User getUserByEmail(String email) throws SQLException{
        User user = null;
        Connection connection = ConnectionPool.getInstance().getConnection();
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
            user.setIdRole(result.getLong(ColumnNames.USER_USER_ROLE_ID));
            user.setIdState(result.getLong(ColumnNames.USER_USER_STATE_ID));
        }
        ConnectionPool.getInstance().releaseConnection(connection, statement, result);
        return user;
    }

   /* public UserStates getUserState(String email) throws SQLException{
        UserStates userState=null;
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_STATE_BY_EMAIL);
        statement.setString(1,email);
        ResultSet result = statement.executeQuery();
        while (result.next()){
             userState=(UserStates.valueOf(result.getString(ColumnNames.USER_STATE_STATE)));
        }
        ConnectionPool.getInstance().releaseConnection(connection);
        return userState;
    }
*/
    public UserType getUserRole(String email) throws SQLException{
        UserType userType=null;
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ROLE_BY_EMAIL);
        statement.setString(1,email);
        ResultSet result = statement.executeQuery();
        while (result.next()){
            userType=(UserType.valueOf(result.getString(ColumnNames.USER_ROLE_TYPE)));
        }
        ConnectionPool.getInstance().releaseConnection(connection, statement,result);
        return userType;
    }

    public boolean isNewUser(String email) throws SQLException{
        boolean isNew = true;
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.CHECK_EMAIL);
        statement.setString(1, email);
        ResultSet result = statement.executeQuery();
        if(result.next()){
            isNew = false;
        }
        ConnectionPool.getInstance().releaseConnection(connection, statement,result);
        return isNew;
    }

    public String getIdByEmail(String userEmail) throws SQLException {
        String id = null;
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_USER_ID_BY_NAME);
        statement.setString(1, userEmail);
        ResultSet result = statement.executeQuery();
        while(result.next()){
            id=(result.getString(ColumnNames.USER_ID));
        }
        ConnectionPool.getInstance().releaseConnection(connection, statement, result);
        return id;
    }
}
