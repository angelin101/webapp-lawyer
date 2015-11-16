package ua.angelin.lawyer.DBLayer.dao.implementation;

import org.junit.Test;
import ua.angelin.lawyer.DBLayer.dao.UserDAO;
import ua.angelin.lawyer.DBLayer.exceptions.UserNotFoundException;
import ua.angelin.lawyer.DBLayer.pojo.User;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * Created by Ангелин on 14.11.2015.
 */
public class MyUserDAOTest {

    @Test
    public void testGetUserByLogin() throws UserNotFoundException {
        Connection connection = DBFactory.getConnection();
        UserDAO userDAO = DBFactory.getUserDAO(connection);
        User user = userDAO.getUserByLogin("test1", "test1");
        User user2 = userDAO.getUserByLogin("test2", "test2");
        DBFactory.closeConnection(connection);
        assertTrue(!user.isLawyer());
        System.out.println(user.getUserID()+" | "+user.getLogin()+" | "+user.getPassword()+" | "+user.isLawyer());
        System.out.println(user2.getUserID()+" | "+user2.getLogin()+" | "+user2.getPassword()+" | "+user2.isLawyer());
    }
}