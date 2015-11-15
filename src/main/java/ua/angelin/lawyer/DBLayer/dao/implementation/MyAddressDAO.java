package ua.angelin.lawyer.DBLayer.dao.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.angelin.lawyer.DBLayer.dao.AddressDAO;
import ua.angelin.lawyer.DBLayer.pojo.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Ангелин on 14.11.2015.
 */
public class MyAddressDAO implements AddressDAO {
    private static final Logger LOG = LogManager.getLogger(MyAddressDAO.class);
    private Connection connection;
    private final String queryGetAddressByID;

    public MyAddressDAO(Connection connection){
        this.connection = connection;
        queryGetAddressByID = "select * from address where address_id = ?";
    }

    @Override
    public Address getAddressByID(int addressID) {
        Address address = new Address();
        try(PreparedStatement statement = connection.prepareStatement(queryGetAddressByID)) {
            statement.setInt(1, addressID);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            address.setCity(resultSet.getString("city"));
            address.setStreet(resultSet.getString("street"));
            address.setApartments(resultSet.getString("apartment"));
        } catch (SQLException e) {
            LOG.error(e);
        }
        return address;
    }
}
