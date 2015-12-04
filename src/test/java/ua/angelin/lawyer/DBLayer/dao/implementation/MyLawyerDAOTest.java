package ua.angelin.lawyer.DBLayer.dao.implementation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.angelin.lawyer.DBLayer.dao.AddressDAO;
import ua.angelin.lawyer.DBLayer.dao.AffairDAO;
import ua.angelin.lawyer.DBLayer.dao.LawyerDAO;
import ua.angelin.lawyer.DBLayer.dao.UserDAO;
import ua.angelin.lawyer.DBLayer.exceptions.UserNotFoundException;
import ua.angelin.lawyer.DBLayer.pojo.Address;
import ua.angelin.lawyer.DBLayer.pojo.Affair;
import ua.angelin.lawyer.DBLayer.pojo.Lawyer;
import ua.angelin.lawyer.DBLayer.pojo.User;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Ангелин on 04.12.2015.
 */
public class MyLawyerDAOTest {
    private User user;
    private Connection connection;

    @Before
    public void before() throws UserNotFoundException {
        connection = DBFactory.getConnection();
        UserDAO userDAO = DBFactory.getUserDAO(connection);
        user = userDAO.getUserByLogin("law", "law");
        if (user.isLawyer()) {
            System.out.println("User is - Lawyer");
        }else{
            System.out.println("User is - Client");
        }
    }

    @Test
    public void testGetLawyerByUser() throws Exception {
        if (user instanceof Lawyer) {
            LawyerDAO lawyerDAO = DBFactory.getLawyerDAO(connection);
            Lawyer lawyer = lawyerDAO.getLawyerByUser(user);
            AddressDAO addressDAO = DBFactory.getAddressDAO(connection);
            Address address = addressDAO.getAddressByID(lawyer.getAddressID());
            lawyer.setAddress(address);
            AffairDAO affairDAO = DBFactory.getAffairDAO(connection);
            List<Affair> affairs = affairDAO.getAffairsByLawyerID(lawyer.getLawyerID());
            lawyer.setAffairs(affairs);
            assertEquals("Иван", lawyer.getName());
            assertEquals("Ангелин", lawyer.getSurname());
            assertEquals("256.566.15.15", lawyer.getLawyerLicense());
            assertEquals("Киев", lawyer.getAddress().getCity());
            assertEquals(1, lawyer.getLawyerID());
            assertEquals("femida@mail.ru", lawyer.getEmail());
            assertEquals("050-557-24-33", lawyer.getTelephoneNumber());
            assertEquals(2, lawyer.getAffairs().size());
            assertEquals("Развод", lawyer.getAffairs().get(1).getSubjectOfDispute());
            assertTrue(lawyer.isLawyer());
            System.out.println(lawyer);
        }
        else {
            assertTrue(false);
        }
    }

    @After
    public void after(){
        user = null;
        DBFactory.closeConnection(connection);
    }
}