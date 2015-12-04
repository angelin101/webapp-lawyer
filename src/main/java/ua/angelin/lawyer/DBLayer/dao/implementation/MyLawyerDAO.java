package ua.angelin.lawyer.DBLayer.dao.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.angelin.lawyer.DBLayer.dao.LawyerDAO;
import ua.angelin.lawyer.DBLayer.pojo.Lawyer;
import ua.angelin.lawyer.DBLayer.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Ангелин on 04.12.2015.
 */
class MyLawyerDAO implements LawyerDAO {
    private static final Logger LOG = LogManager.getLogger(MyLawyerDAO.class);
    private Connection connection;
    private final String queryGetLawyerByUser;

    public MyLawyerDAO(Connection connection){
        queryGetLawyerByUser = "select * from lawyers where user_id = ?";
        this.connection = connection;
    }

    @Override
    public Lawyer getLawyerByUser(User user) {
        Lawyer lawyer = new Lawyer();
        try(PreparedStatement statement = connection.prepareStatement(queryGetLawyerByUser)) {
            statement.setInt(1, user.getUserID());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            lawyer.setUserID(user.getUserID());
            lawyer.setLogin(user.getLogin());
            lawyer.setPassword(user.getPassword());
            lawyer.setLawyerID(resultSet.getInt("lawyer_id"));
            lawyer.setName(resultSet.getString("name"));
            lawyer.setSurname(resultSet.getString("surname"));
            lawyer.setLawyerLicense(resultSet.getString("license"));
            lawyer.setTelephoneNumber(resultSet.getString("telephone"));
            lawyer.setEmail(resultSet.getString("email"));
            lawyer.setAddressID(resultSet.getInt("address_id"));
            /*
            * Поле isLawyer инициализируеться в конструкторе Lawyer при создании обьекта
            * Поле Дела будет заполняться в Сервисном уровне, после получения обьекта Lawyer
            * Поле Адрес тоже заполнять в Сервисном уровне, после получения обьекта Lawyer
            */
        } catch (SQLException e) {
            LOG.error(e);
        }
        return lawyer;
    }
}
