package ua.angelin.lawyer.UILayer.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.angelin.lawyer.DBLayer.pojo.Client;
import ua.angelin.lawyer.DBLayer.pojo.User;
import ua.angelin.lawyer.DBLayer.exceptions.*;
import ua.angelin.lawyer.ServiceLayer.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ангелин on 27.10.2015.
 */
public class AuthorizeServlet extends HttpServlet {
    private static final Logger LOG = LogManager.getLogger(AuthorizeServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String submitValue = req.getParameter("submit");
        // Определяем какой submit был активирован (Регистрация или Войти)
        if (submitValue.equals("ВОЙТИ")){
            String login = req.getParameter("username");
            String password = req.getParameter("password");
            try {
               User user = ServiceFactory.getUser(login,password);
               // Проверяем кто авторизировался
                if (user instanceof Client){
                   LOG.info("Клиент под логином - "+user.getLogin()+" зашел на страничку!");
                   Client client = (Client) user;
                   // Кидаем POST в сервлет ClientStartServlet
                   req.setAttribute("client", client);
                   req.getRequestDispatcher("/client").forward(req, resp);
               }
               else {
                   LOG.info("Это Адвокат");
                   // Аналогичный Клиенту код
               }
            } catch (UserNotFoundException e) {
                LOG.warn("Клиент с логином: "+login+", и паролем: "+ password+" не найден!");
                req.setAttribute("error", e);
                req.getRequestDispatcher("authorize.jsp").forward(req, resp);
            }
        }
        else{
            resp.sendRedirect("/registration");
        }
    }
}
