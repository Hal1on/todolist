package command;

import javax.servlet.http.HttpServletRequest;

import resource.ConfigurationManager;

public class EmptyCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        /**
         * in case of error or direct access to the controller
         * redirecting to login page
         */
        request.getSession().invalidate();
        return ConfigurationManager.getProperty("path.page.login");
    }
}