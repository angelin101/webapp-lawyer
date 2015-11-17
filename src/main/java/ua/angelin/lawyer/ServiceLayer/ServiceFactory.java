package ua.angelin.lawyer.ServiceLayer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.angelin.lawyer.DBLayer.dao.UserDAO;
import ua.angelin.lawyer.DBLayer.dao.implementation.DBFactory;
import ua.angelin.lawyer.DBLayer.exceptions.UserNotFoundException;
import ua.angelin.lawyer.DBLayer.pojo.User;

import java.sql.Connection;

/**
 * Created by Ангелин on 15.11.2015.
 */
public class ServiceFactory {
    private static final Logger LOG = LogManager.getLogger(ServiceFactory.class);

    public static User getUser(String login, String password) throws UserNotFoundException {
        User user = null;
        Connection connection = DBFactory.getConnection();
        UserDAO userDAO = DBFactory.getUserDAO(connection);
        // Блок try для аварийного закрытия соединения с БД (если пользователя такого нет)
        try {
            user = userDAO.getUserByLogin(login, password);
            if (user.isLawyer()){
                // Вызываем метод возвращающий обьект Lawyer
                // client = (User) pullLawyer(client);
            }
            else{
                user = MadeClient.pullClient(connection, user);
            }
        } catch (UserNotFoundException e) {
            LOG.warn(e);
            throw new UserNotFoundException();// Выкидываем исклучение выше в сервлет
        } finally {
            DBFactory.closeConnection(connection);
        }
        return user;
    }
}
