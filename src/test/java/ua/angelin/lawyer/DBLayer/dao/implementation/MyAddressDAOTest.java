package ua.angelin.lawyer.DBLayer.dao.implementation;

import org.junit.Test;
import ua.angelin.lawyer.DBLayer.dao.AddressDAO;
import ua.angelin.lawyer.DBLayer.pojo.Address;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * Created by Ангелин on 14.11.2015.
 */
public class MyAddressDAOTest {

    @Test
    public void testGetAddressByID() throws Exception {
        Connection connection;
        connection = DBFactory.getConnection();
        Address myAddress = new Address("Горловка","Победы","18/31");
        AddressDAO dao = DBFactory.getAddressDAO(connection);
        Address dbAddress = dao.getAddressByID(1);
        Address address = dao.getAddressByID(4);
        DBFactory.closeConnection(connection);
        assertEquals(myAddress, dbAddress);
        assertEquals(4, address.getAddressID());
        assertEquals("Киев", address.getCity());
        System.out.println(dbAddress);
    }
}