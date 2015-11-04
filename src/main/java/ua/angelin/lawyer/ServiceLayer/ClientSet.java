package ua.angelin.lawyer.ServiceLayer;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.angelin.lawyer.ServiceLayer.exceptions.ClientNotFoundException;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Ангелин on 28.10.2015.
 *
 * Класс заглушка для тестирования авторизации, до подключения базы данных!!!
 */
public class ClientSet {
    private static Set<Client> clientSet;
    private static Set<Affair> affairSet;
    private static final Logger LOG = LogManager.getLogger(ClientSet.class);
    static{
        clientSet = new LinkedHashSet<>();
        affairSet = new LinkedHashSet<>();
        affairSet.add(new Affair(1, "Конокрадство", "ЧП \"Рога и копыта\""));
        affairSet.add(new Affair(2, "Хищение гос средств", "ЧП \"Фемида\""));
        affairSet.add(new Affair(3, "Разбой", "ЧП \"Сосулька\""));
        clientSet.add(new Client(1, "user", "user", false, "Андрей", "Ангелин",  new Address("Украина", "Горловка", "Победы", "18/31"), "050-270-04-80", "sobaka_barabaka@mail.ua", affairSet, "3225203695","ВК 074912"));
        clientSet.add(new Client(2, "ivan", "ivan", false, "Иван", "Ангелин",  new Address("Украина", "Горловка", "Малышева", "45/74"), "050-557-24-33", "sobaka_barabaka@mail.ua", affairSet, "3225203695","ВК 074912"));


    }
    public static int getClientId(String login, String password) throws ClientNotFoundException{
        for (Client client : clientSet){
            if(client.getLogin().equals(login) && (client.getPassword().equals(password))){
                LOG.info("Клиент под ID - "+client.getUserID()+", авторизировался.");
                return client.getUserID();
            }
        }
        LOG.warn("Клиент с логином: "+login+", и паролем: "+ password+" не найден!");
        throw new ClientNotFoundException();
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
