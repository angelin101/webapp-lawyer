package ua.angelin.lawyer.DBLayer;

import ua.angelin.lawyer.DBLayer.dao.AddressDAO;
import ua.angelin.lawyer.DBLayer.dao.AffairDAO;
import ua.angelin.lawyer.DBLayer.dao.ClientDAO;
import ua.angelin.lawyer.DBLayer.dao.UserDAO;


/**
 * Created by Ангелин on 11.11.2015.
 * Класс со статическими методами, который будет "торчать" наружу из Layer'а. Доступ к БД будет только через него.
 */

public class DBFactory{

    public static UserDAO getUserDAO(){
        return null;
    }
    public static ClientDAO getClientDAO(){
        return null;
    }
    public static AddressDAO getAddressDAO(){
        return null;
    }
    public static AffairDAO getAffairDAO(){
        return null;
    }
}
