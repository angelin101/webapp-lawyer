package ua.angelin.lawyer.UILayer.servlets;

import ua.angelin.lawyer.ServiceLayer.client.ClientSet;
import ua.angelin.lawyer.ServiceLayer.exceptions.ClientNotFoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ангелин on 27.10.2015.
 */
public class AuthorizeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // Определяем какой submit был активирован (Регистрация или Войти)
        String submitValue = req.getParameter("submit");
        if (submitValue.equals("ВОЙТИ")){
            String login = req.getParameter("username");
            String password = req.getParameter("password");
            // По логике для подтверждения пользователя будет возвращаться его ID и методом GET передаваться
            // сервлету USER, где уже по ID будет вытягиваться из БД класс Client
            // (такая реализация, по идее, должна ускорять работу методов в DB layer)
            int clientID = 0;
            try {
                // Проверяем из списка уже зарегестрированых пользователей,
                // если такого нет, тогда метод вместо нужного ID возвращает Exception
                 clientID = ClientSet.getClientId(login, password);
            } catch (ClientNotFoundException e) {
                req.setAttribute("error", e);
                req.getRequestDispatcher("authorize.jsp").forward(req, resp);
            }
            resp.sendRedirect("/user?id="+clientID);// Передается методом GET
/*
            Использовать этот блок кода если будет использовать метод POST
            req.setAttribute("client", client);
            req.getRequestDispatcher("user.jsp").forward(req, resp);// Передается методом POST
*/
        }
        else{
            resp.sendRedirect("/registration");
        }
    }
}
