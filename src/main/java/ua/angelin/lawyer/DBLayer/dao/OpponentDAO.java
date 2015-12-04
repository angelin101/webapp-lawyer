package ua.angelin.lawyer.DBLayer.dao;

import ua.angelin.lawyer.DBLayer.pojo.Opponent;

/**
 * Created by Ангелин on 04.12.2015.
 */
public interface OpponentDAO {
    Opponent getOpponentByID(int opponentID);
}
