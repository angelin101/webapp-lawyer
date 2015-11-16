package ua.angelin.lawyer.ServiceLayer;

import org.junit.Test;
import ua.angelin.lawyer.DBLayer.pojo.User;

import static org.junit.Assert.*;

/**
 * Created by Ангелин on 16.11.2015.
 */
public class ServiceFactoryTest {

    @Test
    public void testGetUser() throws Exception {
        User user = ServiceFactory.getUser("test2","test2");
        System.out.println(user);
    }
}