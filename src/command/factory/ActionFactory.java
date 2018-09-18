package command.factory;

import javax.servlet.http.HttpServletRequest;

import command.ActionCommand;
import command.EmptyCommand;
import command.client.CommandEnum;
import resource.MessageManager;

/**
 * Class that define command that came from JSP.
 */
public class ActionFactory {
    /**
     * @param request servlet request.
     * @return current command.
     */
    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
        // Extracts command from request.
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return current;
        }
        // Gets object of command.
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action
                    + MessageManager.getProperty("message.wrongaction"));
        }
        return current;
    }
}