package ua.angelin.lawyer.ServiceLayer;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.angelin.lawyer.DBLayer.exceptions.*;
import ua.angelin.lawyer.DBLayer.pojo.Address;
import ua.angelin.lawyer.DBLayer.pojo.Affair;
import ua.angelin.lawyer.DBLayer.pojo.Client;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Ангелин on 28.10.2015.
 *
 * Класс заглушка для тестирования авторизации, до подключения базы данных!!!
 */
@Deprecated
public class ClientSet {
    private static Set<Client> clientSet;
    private static List<Affair> affairSet;
    private static final Logger LOG = LogManager.getLogger(ClientSet.class);
    static{
        clientSet = new LinkedHashSet<>();
        affairSet = new LinkedList<>();
        affairSet.add(new Affair(1, "Конокрадство", "ЧП \"Рога и копыта\""));
        affairSet.add(new Affair(2, "Хищение гос средств", "ЧП \"Фемида\""));
        affairSet.add(new Affair(3, "Разбой", "ЧП \"Сосулька\""));
        clientSet.add(new Client(1, "client", "client", false, "Андрей", "Ангелин",  new Address("Горловка", "Победы", "18/31"), "050-270-04-80", "sobaka_barabaka@mail.ua", affairSet, "3225203695","ВК 074912"));
        clientSet.add(new Client(2, "ivan", "ivan", false, "Иван", "Ангелин",  new Address("Горловка", "Малышева", "45/74"), "050-557-24-33", "sobaka_barabaka@mail.ua", affairSet, "3225203695","ВК 074912"));
    }
    public static int getClientId(String login, String password) throws UserNotFoundException{
        for (Client client : clientSet){
            if(client.getLogin().equals(login) && (client.getPassword().equals(password))){
                LOG.info("Клиент под ID - "+client.getUserID()+", авторизировался.");
                return client.getUserID();
            }
        }
        LOG.warn("Клиент с логином: "+login+", и паролем: "+ password+" не найден!");
        throw new UserNotFoundException();
    }
    public static Client getClientById(int id){
        for (Client client : clientSet){
            if(client.getUserID() == id){
                return client;
            }
        }
        return null;
    }
}
