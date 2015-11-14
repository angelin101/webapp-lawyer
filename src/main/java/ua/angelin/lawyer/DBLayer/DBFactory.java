package ua.angelin.lawyer.DBLayer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.angelin.lawyer.DBLayer.dao.AddressDAO;
import ua.angelin.lawyer.DBLayer.dao.AffairDAO;
import ua.angelin.lawyer.DBLayer.dao.ClientDAO;
import ua.angelin.lawyer.DBLayer.dao.UserDAO;
import ua.angelin.lawyer.DBLayer.dao.implementation.MyAddressDAO;
import ua.angelin.lawyer.DBLayer.dao.implementation.MyUserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by Ангелин on 11.11.2015.
 * Класс со статическими методами, который будет "торчать" наружу из Layer'а. Доступ к БД будет только через него.
 * Он будет выдавать Connection и закрывать его отдельными методами
 */


public class DBFactory{
    private static final Logger LOG = LogManager.getLogger(DBFactory.class);
    private static final String URL = "jdbc:mysql://localhost:3306/lawyer_db";
    private static final String USER = "root";
    private static final String PASSWORD = "aass8885";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            if (connection != null){
                closeConnection(connection);
            }
            LOG.error(ex);
        }
        return connection;
    }
    public static void closeConnection(Connection connection){
        try {
            connection.close();
        } catch (SQLException ex) {
            LOG.error(ex);
        }
    }

    public static UserDAO getUserDAO(Connection connection){
        return new MyUserDAO(connection);
    }
    public static ClientDAO getClientDAO(Connection connection){
        return null;
    }
    public static AddressDAO getAddressDAO(Connection connection){
        return new MyAddressDAO(connection);
    }
    public static AffairDAO getAffairDAO(Connection connection){
        return null;
    }
}
