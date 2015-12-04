package ua.angelin.lawyer.DBLayer.dao;

import ua.angelin.lawyer.DBLayer.pojo.Lawyer;
import ua.angelin.lawyer.DBLayer.pojo.User;

/**
 * Created by Ангелин on 04.12.2015.
 */
public interface LawyerDAO {
    Lawyer getLawyerByUser(User user);
}
