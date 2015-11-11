package ua.angelin.lawyer.DBLayer.dao;

import ua.angelin.lawyer.DBLayer.pojo.Address;

/**
 * Created by Ангелин on 11.11.2015.
 */
public interface AddressDAO {
    Address getAddressByID(int addressID);
}
