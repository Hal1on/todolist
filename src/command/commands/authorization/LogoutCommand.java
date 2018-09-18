package command.commands.authorization;

import javax.servlet.http.HttpServletRequest;

import command.ActionCommand;
import resource.ConfigurationManager;

public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.index");
        request.getSession().invalidate();
        return page;
    }
}