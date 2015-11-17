package ua.angelin.lawyer.ServiceLayer;

import ua.angelin.lawyer.DBLayer.dao.AddressDAO;
import ua.angelin.lawyer.DBLayer.dao.AffairDAO;
import ua.angelin.lawyer.DBLayer.dao.ClientDAO;
import ua.angelin.lawyer.DBLayer.dao.implementation.DBFactory;
import ua.angelin.lawyer.DBLayer.pojo.Address;
import ua.angelin.lawyer.DBLayer.pojo.Affair;
import ua.angelin.lawyer.DBLayer.pojo.Client;
import ua.angelin.lawyer.DBLayer.pojo.User;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Ангелин on 15.11.2015.
 *
 * Подумать о перейменовании класса!!!!
 */
public class MadeClient {

    // В этом методе собираеться обьект Client
    public static Client pullClient(Connection connection, User user){
        ClientDAO clientDAO = DBFactory.getClientDAO(connection);
        Client client = clientDAO.getClientByUser(user);
        AffairDAO affairDAO = DBFactory.getAffairDAO(connection);
        List<Affair> affairList = affairDAO.getAffairsByClientID(client.getClientID());
        client.setAffairs(affairList);
        AddressDAO addressDAO = DBFactory.getAddressDAO(connection);
        Address address = addressDAO.getAddressByID(client.getAddressID());
        client.setAddress(address);
        return client;
    }

}
