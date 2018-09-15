package command.commands.todolist;

import command.ActionCommand;

import entity.Task;
import logic.TaskLogic;
import resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AddTaskCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String textField = request.getParameter(TEXT_FIELD);
        boolean completed = Boolean.parseBoolean(request.getParameter(COMPLETED));
        String login = request.getParameter(LOGIN);

        List<Task> tasks = TaskLogic.addTask(textField, login, completed);

        if (tasks != null) {
            page = ConfigurationManager.getProperty("path.page.main");
            request.setAttribute(TASKS, tasks);
            request.setAttribute(LOGIN, login);
        } else {
            page = ConfigurationManager.getProperty("path.page.error");
            return page;
        }
        return page;
    }
}
