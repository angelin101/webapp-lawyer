package ua.angelin.lawyer.ServiceLayer.client;


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
    private static final Logger LOG = LogManager.getLogger(ClientSet.class);
    static{
        clientSet = new LinkedHashSet<>();
        clientSet.add(new Client(1, "Andrey", "Angelin", "user", "user"));
        clientSet.add(new Client(2, "Ivan", "Angelin", "test", "test"));
    }
    public static int getClientId(String login, String password) throws ClientNotFoundException{
        for (Client client : clientSet){
            if(client.getLogin().equals(login) && (client.getPassword().equals(password))){
                LOG.info("Клиент под ID - "+client.getID()+", авторизировался.");
                return client.getID();
            }
        }
        LOG.warn("Клиент с логином: "+login+", и паролем: "+ password+" не найден!");
        throw new ClientNotFoundException();
    }
    public static Client getClientById(int id){
        for (Client client : clientSet){
            if(client.getID() == id){
                return client;
            }
        }
        return null;
    }
}
