package com.makarevich.connection;

import com.makarevich.constants.ConfigsConstants;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class   ConnectionPool {
   // INSTANCE;

    private static volatile ConnectionPool instance;

    public static ConnectionPool getInstance() {
        ConnectionPool localInstance = instance;
        if (localInstance == null) {
            synchronized (ConnectionPool.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ConnectionPool();
                }
            }
        }
        return localInstance;
    }

    private  InitialContext ic;
    private  DataSource ds;
    {
        try {
            ic = new InitialContext();
            ds = (DataSource) ic.lookup(ConfigsConstants.DATABASE_SOURCE);
        }
        catch (NamingException e) {
            throw new ExceptionInInitializerError(" not found in JNDI"+ e);
        }
    }

    public Connection getConnection() throws SQLException {
            return ds.getConnection();
        }

    public void releaseConnection(Connection connection, PreparedStatement statement) {
            try { if (statement != null) statement.close(); } catch (Exception e) {};
            try { if (connection != null) connection.close(); } catch (Exception e) {};
        }

    public void releaseConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try { if (statement != null) statement.close(); } catch (Exception e) {};
        try { if (connection != null) connection.close(); } catch (Exception e) {};
        try { if (resultSet != null) resultSet.close(); } catch (Exception e) {};
    }
}

