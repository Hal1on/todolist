package command.commands.authorization;

import javax.servlet.http.HttpServletRequest;

import command.ActionCommand;
import entity.Task;
import entity.User;
import logic.TaskLogic;
import logic.LoginLogic;
import resource.ConfigurationManager;
import resource.MessageManager;

import java.util.List;

public class LoginCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        // extracting from the request login and password.
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        // login and password verification.
        User user = LoginLogic.checkLogin(login, password);
        if (user != null) {
            request.getSession().setAttribute(LOGIN, login);
            request.getSession().setAttribute(PASSWORD, password);
            request.setAttribute(LOGIN, login);
            List<Task> tasks = TaskLogic.getTasks(user.getId());
            request.setAttribute(TASKS, tasks);
            // path definition to main.jsp
            page = ConfigurationManager.getProperty("path.page.main");
        } else {
            request.setAttribute(LOGIN, login);
            request.setAttribute(PASSWORD, password);
            request.setAttribute("errorLoginPassMessage",
                    MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }
}