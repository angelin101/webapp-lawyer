package ua.angelin.lawyer.DBLayer.dao.implementation;

import org.junit.Test;
import ua.angelin.lawyer.DBLayer.dao.AddressDAO;
import ua.angelin.lawyer.DBLayer.dao.OpponentDAO;
import ua.angelin.lawyer.DBLayer.pojo.Address;
import ua.angelin.lawyer.DBLayer.pojo.Opponent;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * Created by Ангелин on 04.12.2015.
 */
public class MyOpponentDAOTest {

    @Test
    public void testGetOpponentByID() throws Exception {
        Connection connection = DBFactory.getConnection();
        OpponentDAO opponentDAO = DBFactory.getOpponentDAO(connection);
        Opponent opponent = opponentDAO.getOpponentByID(1);
        AddressDAO addressDAO = DBFactory.getAddressDAO(connection);
        Address address = addressDAO.getAddressByID(opponent.getAddressID());
        opponent.setAddress(address);
        System.out.println(opponent);
        assertEquals("Александр", opponent.getName());
        assertEquals("Должиков", opponent.getSurname());
        assertEquals("3904210894", opponent.getInn());
        assertEquals("ВК 341057", opponent.getPassport());
        assertEquals("Ответчик", opponent.getStatus());
        assertEquals("066-782-05-61", opponent.getTelephoneNumber());
        assertEquals("dolzhikov@ukr.net", opponent.getEmail());
        assertEquals(1, opponent.getId());
        assertEquals(3, opponent.getAddressID());
        assertEquals("18/32", opponent.getAddress().getApartments());
        DBFactory.closeConnection(connection);
    }
}