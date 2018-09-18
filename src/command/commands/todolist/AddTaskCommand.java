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
        String data = request.getParameter(DATA);
        boolean completed = Boolean.parseBoolean(request.getParameter(COMPLETED));
        String login = request.getParameter(LOGIN);

        TaskLogic.addTask(textField, data, login, completed);
        List<Task> tasks = TaskLogic.getTasks(Integer.parseInt(request.getParameter(USER_ID)));
        if (tasks != null && data != null) {
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
