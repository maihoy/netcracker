package com.makarevich.connection;

import com.makarevich.constants.ConfigsConstants;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * Created by j on 4.11.16.
 */
public enum  ConnectionPool {
    INSTANCE;

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

    public void releaseConnection(Connection connection) {
        if(connection != null){
            try {
                connection.close();
            }
            catch (SQLException e) {
                //PaymentSystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            }
        }
    }
}
