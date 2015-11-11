package ua.angelin.lawyer.DBLayer.exceptions;

/**
 * Created by Ангелин on 28.10.2015.
 */
public class UserNotFoundException extends Exception{

    @Override
    public String toString() {
        return "Неверный логин или пароль";
    }
}
