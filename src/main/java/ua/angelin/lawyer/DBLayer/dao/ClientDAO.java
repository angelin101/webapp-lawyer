package ua.angelin.lawyer.DBLayer.dao;

import ua.angelin.lawyer.DBLayer.pojo.Client;
import ua.angelin.lawyer.DBLayer.pojo.User;

/**
 * Created by Ангелин on 11.11.2015.
 */
public interface ClientDAO {
    Client getClientByUser(User user);
}
