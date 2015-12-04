package ua.angelin.lawyer.DBLayer.dao.implementation;

import org.junit.Test;
import ua.angelin.lawyer.DBLayer.dao.AffairDAO;
import ua.angelin.lawyer.DBLayer.dao.OpponentDAO;
import ua.angelin.lawyer.DBLayer.pojo.Affair;
import ua.angelin.lawyer.DBLayer.pojo.Opponent;

import java.sql.Connection;
import java.util.Iterator;
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
                assertEquals("Хулиганство", affair.getSubjectOfDispute());
                assertEquals("В производстве", affair.getStatus());
                assertEquals("905/1153/15", affair.getAffairNumber());
                assertEquals(1, affair.getAffairID());
                assertEquals(1, affair.getOpponentID());
            }
            if (affair.getAffairID()==2){
                assertEquals("Развод", affair.getSubjectOfDispute());
                assertEquals("Закрыто", affair.getStatus());
                assertEquals("367/3296/30", affair.getAffairNumber());
            }
            System.out.println(affair);
        }
    }

    @Test
    public void testGetAffairsByLawyerID() throws Exception {
        Connection connection = DBFactory.getConnection();
        AffairDAO affairDAO = DBFactory.getAffairDAO(connection);
        List<Affair> affairList = affairDAO.getAffairsByLawyerID(1);
        OpponentDAO opponentDAO = DBFactory.getOpponentDAO(connection);
        assertEquals(2, affairList.size());
        Affair affair2 = affairList.get(1);
        assertEquals(2, affair2.getAffairID());
        assertEquals("367/3296/30", affair2.getAffairNumber());
        assertEquals("Развод", affair2.getSubjectOfDispute());
        assertEquals("Закрыто", affair2.getStatus());
        assertEquals(2, affair2.getOpponentID());
        /**
        * С помощью итератора список Affair будет заполняться обьектами Opponent для каждого Affair!!!
        */
        Iterator<Affair> iterator = affairList.iterator();
        while (iterator.hasNext()){
            Affair affair = iterator.next();
            Opponent opponent = opponentDAO.getOpponentByID(affair.getOpponentID());
            affair.setOpponent(opponent);
        }
        for (Affair af : affairList){
            System.out.println(af);
            System.out.println(af.getOpponent());
            System.out.println("********");
        }
        DBFactory.closeConnection(connection);
    }
}