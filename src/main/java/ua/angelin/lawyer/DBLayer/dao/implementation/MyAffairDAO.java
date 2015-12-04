package ua.angelin.lawyer.DBLayer.dao.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.angelin.lawyer.DBLayer.dao.AffairDAO;
import ua.angelin.lawyer.DBLayer.pojo.Affair;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ангелин on 15.11.2015.
 */
class MyAffairDAO implements AffairDAO {
    private static final Logger LOG = LogManager.getLogger(MyAffairDAO.class);
    private Connection connection;
    private final String queryGetAffairsByClientID;
    private final String queryGetAffairsByLawyerID;

    public MyAffairDAO(Connection connection){
        queryGetAffairsByClientID = "select * from affairs where client_id = ?";
        queryGetAffairsByLawyerID = "select * from affairs where lawyer_id = ?";
        this.connection = connection;
    }
    @Override
    public List<Affair> getAffairsByClientID(int clientID) {
        List<Affair> affairList = new ArrayList<>(20);
        try(PreparedStatement statement = connection.prepareStatement(queryGetAffairsByClientID)){
            statement.setInt(1, clientID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Affair affair = new Affair();
                affair.setAffairID(resultSet.getInt("affair_id"));
                affair.setAffairNumber(resultSet.getString("number"));
                affair.setSubjectOfDispute(resultSet.getString("subject"));
                affair.setStatus(resultSet.getString("status"));
                affair.setOpponentID(resultSet.getInt("opponent_id"));
                affairList.add(affair);
            }
        }catch (SQLException e) {
            LOG.error(e);
        }
        return affairList;
    }

    @Override
    public List<Affair> getAffairsByLawyerID(int lawyerID) {
        List<Affair> affairList = new ArrayList<>(20);
        try(PreparedStatement statement = connection.prepareStatement(queryGetAffairsByLawyerID)){
            statement.setInt(1, lawyerID);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Affair affair = new Affair();
                affair.setAffairID(resultSet.getInt("affair_id"));
                affair.setAffairNumber(resultSet.getString("number"));
                affair.setSubjectOfDispute(resultSet.getString("subject"));
                affair.setStatus(resultSet.getString("status"));
                affair.setOpponentID(resultSet.getInt("opponent_id"));
                affairList.add(affair);
            }
        } catch (SQLException e) {
           LOG.error(e);
        }
        return affairList;
    }
}
