package ua.angelin.lawyer.DBLayer.dao;

import ua.angelin.lawyer.DBLayer.pojo.Affair;

import java.util.List;

/**
 * Created by Ангелин on 11.11.2015.
 */
public interface AffairDAO {
    List<Affair> getAffairsByClientID(int clientID);
    /**
     * Можно было всё поместить в один метод (getAffairsByUser(User user, int id) или что-то в этом роде)
     * и придумать универсальный код, но тогда бы этот код очень ТЯЖЕЛО читался!!!
     */
    List<Affair> getAffairsByLawyerID(int lawyerID);
}
