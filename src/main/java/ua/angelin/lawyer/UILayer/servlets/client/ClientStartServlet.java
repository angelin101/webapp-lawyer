package ua.angelin.lawyer.UILayer.servlets.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.angelin.lawyer.DBLayer.pojo.Client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ангелин on 29.10.2015.
 *
 * В это сервлете сначала вызываеться метод doPost, который вызывает doGet и инициализирует перемменную экземпляра
 * Если пользователь пытаеться зайти на страничку без POST, т.е. введя URL, то будет (в будущем) выводиться какая нибудь заглушка!!!
 *
 */
public class ClientStartServlet extends HttpServlet {

    private static final Logger LOG = LogManager.getLogger(ClientStartServlet.class);
    private Client client;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 /*!!!!!! Написать код - если client = null, тогда пользователь пытаеться наебать судьбу!!!*/
        LOG.info("GET");
        // Содержимое переменной client (только если первым вызывался метод POST, т.е. прошла авторизация) передаеться
        // в *.jsp страничку и там уже разворачиваеться!!!
        req.setAttribute("client", client);
        req.getRequestDispatcher("client.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("POST");
        // Сначала в теле POST приходит обьект Client и мы его засовываем в переменную экземпляра
        client = (Client) req.getAttribute("client");
        // Вызываеться метод GET этого же сервлета (в GET запросе учавствует ID клиента)
        resp.sendRedirect("/client?id="+client.getId());
    }

}
