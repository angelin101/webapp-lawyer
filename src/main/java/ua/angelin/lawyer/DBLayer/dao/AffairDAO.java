package ua.angelin.lawyer.DBLayer.dao;

import ua.angelin.lawyer.DBLayer.pojo.Affair;

import java.util.List;

/**
 * Created by Ангелин on 11.11.2015.
 */
public interface AffairDAO {
    List<Affair> getAffairsByClientID(int clientID);
}
