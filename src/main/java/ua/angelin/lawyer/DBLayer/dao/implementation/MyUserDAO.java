package ua.angelin.lawyer.DBLayer.dao.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.angelin.lawyer.DBLayer.dao.UserDAO;
import ua.angelin.lawyer.DBLayer.exceptions.UserNotFoundException;
import ua.angelin.lawyer.DBLayer.pojo.Client;
import ua.angelin.lawyer.DBLayer.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Ангелин on 14.11.2015.
 */

class MyUserDAO implements UserDAO {
    private static final Logger LOG = LogManager.getLogger(MyUserDAO.class);
    private Connection connection;
    private final String queryGetUserByLogin;

    public MyUserDAO(Connection connection){
        queryGetUserByLogin = "select * from users where login = ? and password = ?";
        this.connection = connection;
    }

    @Override
    public User getUserByLogin(String login, String password) throws UserNotFoundException {
        User user = null; // null потому что в будушем это может быть Адвокат, а прямой реализации User - нет
        try(PreparedStatement statement = connection.prepareStatement(queryGetUserByLogin)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            boolean isLawyer = true;
            if (resultSet.getInt("lawyer")==0){
                isLawyer = false;
                user = new Client(); // Если false значит Клиент
            }
            else{
                // client = new Lawyer();
            }
            user.setUserID(resultSet.getInt("user_id"));
            user.setIsLawyer(isLawyer);
            user.setLogin(login);
            user.setPassword(password);
        }catch (SQLException e) {
            LOG.warn("UserNotFoundException", e.getMessage());
            throw new UserNotFoundException();
        }
        return user;
    }
}
