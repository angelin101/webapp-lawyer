package ua.angelin.lawyer.DBLayer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Ангелин on 11.11.2015.
 * Класс с модификатором доступа по умолчанию для инкапсуляции(виден только в пакете)
 */
class DBConnection {
    private static final Logger LOG = LogManager.getLogger(DBConnection.class);
    private static final String URL = "jdbc:mysql://localhost:3306/lawyer_db";
    private static final String USER = "root";
    private static final String PASSWORD = "aass8885";
    private Connection connection;
    //
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            if (connection != null){
                closeConnection();
            }
            LOG.error(ex);
        }
        return connection;
    }

    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException ex) {
            LOG.error(ex);
        }
    }

}
