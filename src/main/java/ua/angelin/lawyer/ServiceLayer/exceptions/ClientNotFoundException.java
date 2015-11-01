package ua.angelin.lawyer.ServiceLayer.exceptions;

/**
 * Created by Ангелин on 28.10.2015.
 */
public class ClientNotFoundException extends Exception{

    @Override
    public String toString() {
        return "Неверный логин или пароль";
    }
}
