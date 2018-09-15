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
        // извлечение из запроса логина и пароля
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        // проверка логина и пароля
        if (login == null || password == null) {
            page = ConfigurationManager.getProperty("path.page.registration");
            return page;
        }
        if (RegistrationLogic.userRegistered(login, password)) {
            // определение пути к main.jsp
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

