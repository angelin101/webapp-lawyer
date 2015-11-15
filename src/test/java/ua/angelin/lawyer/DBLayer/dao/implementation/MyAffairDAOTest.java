package ua.angelin.lawyer.DBLayer.dao.implementation;

import org.junit.Test;
import ua.angelin.lawyer.DBLayer.DBFactory;
import ua.angelin.lawyer.DBLayer.dao.AffairDAO;
import ua.angelin.lawyer.DBLayer.pojo.Affair;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Ангелин on 15.11.2015.
 */
public class MyAffairDAOTest {

    @Test
    public void testGetAffairsByClientID() throws Exception {
        Connection connection = DBFactory.getConnection();
        AffairDAO affairDAO = DBFactory.getAffairDAO(connection);
        List<Affair> list = affairDAO.getAffairsByClientID(1);
        DBFactory.closeConnection(connection);
        for (Affair affair : list){
            if (affair.getAffairID()==1) {
                assertEquals("Конокрадство", affair.getSubjectOfDispute());
            }
            if (affair.getAffairID()==3){
                assertEquals("Хулиганство", affair.getSubjectOfDispute());
            }
            System.out.println(affair);
        }
    }
}