package command.commands.todolist;

import command.ActionCommand;
import entity.Task;
import logic.TaskLogic;
import resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class EditTaskCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        // извлечение из запроса логина и пароля
        String textField = request.getParameter(TEXT_FIELD);
        String data = request.getParameter(DATA);
        String previousData = request.getParameter(PREVIOUS_DATA);
        String previousTextField = request.getParameter(PREVIOUS_TEXT_FIELD);
        boolean completed = Boolean.parseBoolean(request.getParameter(COMPLETED));
        String login = request.getParameter(LOGIN);
        int task_id = Integer.parseInt(request.getParameter(TASK_ID));
        int userId = Integer.parseInt(request.getParameter(USER_ID));

        if (textField != null && data != null) {
            TaskLogic.editTask(textField, completed, data, task_id);
            List<Task> tasks = TaskLogic.getTasks(userId);
            request.setAttribute(TASKS, tasks);
            request.setAttribute(LOGIN, login);
            page = ConfigurationManager.getProperty("path.page.main");
        } else {
            List<Task> tasks = TaskLogic.getTasks(userId);
            request.setAttribute(LOGIN, login);
            request.setAttribute(USER_ID, userId);
            request.setAttribute(TASK_ID, task_id);
            request.setAttribute(TASKS, tasks);
            request.setAttribute(PREVIOUS_TEXT_FIELD, previousTextField);
            request.setAttribute(PREVIOUS_DATA, previousData);
            request.setAttribute(COMPLETED, completed);
            page = ConfigurationManager.getProperty("path.page.editTask");
        }
        return page;
    }
}
