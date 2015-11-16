package ua.angelin.lawyer.ServiceLayer;

import org.junit.Test;
import ua.angelin.lawyer.DBLayer.dao.implementation.DBFactory;
import ua.angelin.lawyer.DBLayer.pojo.Client;
import ua.angelin.lawyer.DBLayer.pojo.User;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * Created by Ангелин on 16.11.2015.
 */
public class MadeClientTest {

    @Test
    public void testPullClient() throws Exception {
        Connection connection = DBFactory.getConnection();
        User user = DBFactory.getUserDAO(connection).getUserByLogin("test2","test2");
        Client client = MadeClient.pullClient(connection, user);
        System.out.println(client);
        DBFactory.closeConnection(connection);
    }
}