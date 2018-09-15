package command.commands.todolist;

import command.ActionCommand;
import dao.TaskDAO;
import dao.daosql.TaskDAOImpl;
import dao.daosql.UserDAOImpl;
import entity.Task;
import entity.User;
import resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DeleteTaskCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        String login = request.getParameter(LOGIN);
        int id = Integer.parseInt(request.getParameter(TASK_ID));
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.read(login);
        Task task = new Task();
        task.setId(id);
        TaskDAO taskDAO = new TaskDAOImpl();
        taskDAO.delete(task);
        page = ConfigurationManager.getProperty("path.page.main");
        List<Task> tasks = taskDAO.getAll(user.getId());
        request.setAttribute(TASKS, tasks);
        request.setAttribute(LOGIN, login);
        return page;
    }
}
