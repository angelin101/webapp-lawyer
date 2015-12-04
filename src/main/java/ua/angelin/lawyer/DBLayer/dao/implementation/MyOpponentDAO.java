package ua.angelin.lawyer.DBLayer.dao.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.angelin.lawyer.DBLayer.dao.OpponentDAO;
import ua.angelin.lawyer.DBLayer.pojo.Opponent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Ангелин on 04.12.2015.
 */
class MyOpponentDAO implements OpponentDAO{
    private static final Logger LOG = LogManager.getLogger(MyOpponentDAO.class);
    private Connection connection;
    private final String queryGetOpponentByID;

    public MyOpponentDAO(Connection connection){
        queryGetOpponentByID = "select * from opponents where opponent_id = ?";
        this.connection = connection;
    }

    @Override
    public Opponent getOpponentByID(int opponentID) {
        Opponent opponent = new Opponent();
        try(PreparedStatement statement = connection.prepareStatement(queryGetOpponentByID)) {
            statement.setInt(1, opponentID);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            opponent.setId(opponentID);
            opponent.setName(resultSet.getString("name"));
            opponent.setSurname(resultSet.getString("surname"));
            opponent.setInn(resultSet.getString("inn"));
            opponent.setPassport(resultSet.getString("passport"));
            opponent.setStatus(resultSet.getString("status"));
            opponent.setTelephoneNumber(resultSet.getString("telephone"));
            opponent.setEmail(resultSet.getString("email"));
            opponent.setAddressID(resultSet.getInt("address_id"));
            // Адрес заполняеться отдельно

        } catch (SQLException e) {
            LOG.error(e);
        }
        return opponent;
    }
}
