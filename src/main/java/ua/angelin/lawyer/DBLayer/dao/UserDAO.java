package ua.angelin.lawyer.DBLayer.dao;

import ua.angelin.lawyer.DBLayer.pojo.User;
import ua.angelin.lawyer.DBLayer.exceptions.*;

/**
 * Created by Ангелин on 11.11.2015.
 */
public interface UserDAO {
    User getUserByLogin(String login, String password) throws UserNotFoundException;
}
