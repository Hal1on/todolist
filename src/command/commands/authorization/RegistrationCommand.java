package command.commands.authorization;

import command.ActionCommand;
import logic.RegistrationLogic;
import resource.ConfigurationManager;
import resource.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        // extracting from the request login and password.
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        if (login == null || password == null) {
            page = ConfigurationManager.getProperty("path.page.registration");
            return page;
        }
        // login and password verification.
        if (RegistrationLogic.userRegistered(login, password)) {
            // path definition to login.jsp
            request.getSession().invalidate();
            page = ConfigurationManager.getProperty("path.page.login");
        } else {
            request.setAttribute(USER_EXIST,
                    MessageManager.getProperty("message.userExist"));
            page = ConfigurationManager.getProperty("path.page.registration");
        }
        return page;
    }
}

