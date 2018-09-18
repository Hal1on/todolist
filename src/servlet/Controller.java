package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.ActionCommand;
import command.factory.ActionFactory;
import dao.TaskDAO;
import dao.UserDAO;
import dao.daosql.TaskDAOImpl;
import dao.daosql.UserDAOImpl;
import entity.Task;
import entity.User;
import resource.ConfigurationManager;
import resource.MessageManager;

/**
 * Controller accepts all requests.
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP GET and POST method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if the included resource(servlet, JSP page, HTML file) throws this exception
     * @throws IOException      if the included resource throws this exception
     */
    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;

        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);

        // Process execute() method and gets parameters to class-handler.
        page = command.execute(request);
        if (page.equals("/jsp/main.jsp")) {
            String login = request.getParameter(ActionCommand.LOGIN);
            UserDAO userDAO = new UserDAOImpl();
            User user = userDAO.read(login);
            TaskDAO taskDAO = new TaskDAOImpl();
            List<Task> tasks = taskDAO.getAll(user.getId());
            request.setAttribute(ActionCommand.TASKS, tasks);
            request.setAttribute(ActionCommand.USER_ID, user.getId());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else if (!page.equals("/jsp/main.jsp")) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            // Sets page with error message.
            page = ConfigurationManager.getProperty("path.page.index");
            request.getSession().setAttribute("nullPage",
                    MessageManager.getProperty("message.nullpage"));
            response.sendRedirect(request.getContextPath() + page);
            request.getSession().invalidate();
        }
    }
}