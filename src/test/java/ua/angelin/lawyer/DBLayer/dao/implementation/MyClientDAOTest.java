package ua.angelin.lawyer.DBLayer.dao.implementation;

import org.junit.*;
import ua.angelin.lawyer.DBLayer.dao.AddressDAO;
import ua.angelin.lawyer.DBLayer.dao.AffairDAO;
import ua.angelin.lawyer.DBLayer.dao.ClientDAO;
import ua.angelin.lawyer.DBLayer.dao.UserDAO;
import ua.angelin.lawyer.DBLayer.exceptions.UserNotFoundException;
import ua.angelin.lawyer.DBLayer.pojo.Address;
import ua.angelin.lawyer.DBLayer.pojo.Affair;
import ua.angelin.lawyer.DBLayer.pojo.Client;
import ua.angelin.lawyer.DBLayer.pojo.User;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Ангелин on 15.11.2015.
 */
public class MyClientDAOTest {
    private User user;
    private Connection connection;

    @Before
    public void startMethod() throws UserNotFoundException {
        connection = DBFactory.getConnection();
        UserDAO userDAO = DBFactory.getUserDAO(connection);
        user = userDAO.getUserByLogin("test1", "test1");
        if (!user.isLawyer()) {
            System.out.println("User is - Client");
        }else{
            System.out.println("User is - Lawyer");
        }
    }

    @Test
    public void testGetClientByUser() throws Exception {
        ClientDAO clientDAO = DBFactory.getClientDAO(connection);
        Client client = clientDAO.getClientByUser(user);
        AffairDAO affairDAO = DBFactory.getAffairDAO(connection);
        List<Affair> affairList = affairDAO.getAffairsByClientID(client.getClientID());
        client.setAffairs(affairList);
        AddressDAO addressDAO = DBFactory.getAddressDAO(connection);
        Address address = addressDAO.getAddressByID(client.getAddressID());
        client.setAddress(address);
        Address myAddress = new Address("Горловка","Победы","18/31");
        assertEquals(myAddress, client.getAddress());
        assertEquals(2, client.getAffairs().size());
        assertEquals("Хулиганство", client.getAffairs().get(1).getSubjectOfDispute());
        System.out.println(client);
    }

    @After
    public void cleaningMethod(){
        user = null;
        DBFactory.closeConnection(connection);
    }
}