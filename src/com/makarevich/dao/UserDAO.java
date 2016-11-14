package com.makarevich.dao;

import com.makarevich.constants.ColumnNames;
import com.makarevich.constants.SqlRequests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by j on 11.11.16.
 */
public class UserDAO implements AbstractDAO<UserProfile>{
    @Override
    public List<UserProfile> findAll() throws SQLException {

        Connection connection = null;
        connection =
        PreparedStatement statement =connection.prepareStatement(SqlRequests.GET_ALL_USER_PROFILES);
            ResultSet resultSet = statement.executeQuery();
            List<UserProfile> list= new ArrayList<>();
            while(resultSet.next()){
                UserProfile user = new UserProfile();
                user.setUserId(Long.valueOf(resultSet.getString(ColumnNames.USER_ID)));
                user.setUserRoleId(Long.valueOf(resultSet.getString(ColumnNames.USER_ROLE_ID)));
                list.add(user);
            }

        return list ;
    }

    @Override
    public void createEntity(UserProfile entity) throws SQLException {

    }



    @Override
    public UserProfile getEntityById(int id) throws SQLException {
        return null;
    }
}
