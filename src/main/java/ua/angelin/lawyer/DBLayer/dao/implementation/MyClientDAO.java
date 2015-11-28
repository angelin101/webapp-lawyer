package ua.angelin.lawyer.DBLayer.dao.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.angelin.lawyer.DBLayer.dao.ClientDAO;
import ua.angelin.lawyer.DBLayer.pojo.Client;
import ua.angelin.lawyer.DBLayer.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by Ангелин on 15.11.2015.
 */
class MyClientDAO implements ClientDAO {
    private static final Logger LOG = LogManager.getLogger(MyClientDAO.class);
    private Connection connection;
    private final String queryGetClientByUser;

    public MyClientDAO(Connection connection){
        queryGetClientByUser = "select * from clients where user_id = ?";
        this.connection = connection;
    }

    @Override
    public Client getClientByUser(User user) {
        Client client = new Client();
        try(PreparedStatement statement = connection.prepareStatement(queryGetClientByUser)){
            statement.setInt(1, user.getUserID());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            client.setUserID(user.getUserID());
            client.setLogin(user.getLogin());
            client.setPassword(user.getPassword());
            client.setId(resultSet.getInt("client_id"));
            client.setName(resultSet.getString("name"));
            client.setSurname(resultSet.getString("surname"));
            client.setInn(resultSet.getString("inn"));
            client.setPassport(resultSet.getString("passport"));
            client.setTelephoneNumber(resultSet.getString("telephone"));
            client.setEmail(resultSet.getString("email"));
            client.setAddressID(resultSet.getInt("address_id"));
            /*
            * Поле isLawyer инициализируеться блоком кода в Client при создании обьекта
            * Поле Дела будет заполняться в Сервисном уровне, после получения обьекта Client
            * Поле Адрес тоже заполнять в Сервисном уровне, после получения обьекта Client
            */
        } catch (SQLException e) {
            LOG.error(e);
        }
        return client;
    }
}
