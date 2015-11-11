package ua.angelin.lawyer.UILayer.servlets.user;

import ua.angelin.lawyer.DBLayer.pojo.Client;
import ua.angelin.lawyer.ServiceLayer.ClientSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ангелин on 29.10.2015.
 *
 * Позже, ОБЯЗАТЕЛЬНО для этого сервлета реализовать ФИЛЬТР для предотвращения несанкционированого доступа к чужим данным
 *  (к примеру если кто то захочет ввести вместо id=1 - /user?id=2)!!!
 */
public class UserStartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a = Integer.parseInt(req.getParameter("id"));
        Client client =  ClientSet.getClientById(a);
        req.setAttribute("client", client);
        req.getRequestDispatcher("user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
