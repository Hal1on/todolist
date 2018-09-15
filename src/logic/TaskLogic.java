package logic;

import dao.TaskDAO;
import dao.daosql.TaskDAOImpl;
import dao.daosql.UserDAOImpl;
import entity.Task;
import entity.User;

import java.util.List;

public class TaskLogic {
    public static List<Task> getTasks(int userId) {
        TaskDAO taskDAO = new TaskDAOImpl();
        return taskDAO.getAll(userId);
    }
    public static List<Task> addTask(String textField, String login, boolean completed) {
        if (textField != null && login != null) {
            UserDAOImpl userDAO = new UserDAOImpl();
            User user = userDAO.read(login);
            Task task = new Task();
            task.setTextField(textField);
            task.setCompleted(completed);
            task.setUserId(user.getId());
            TaskDAO taskDAO = new TaskDAOImpl();
            taskDAO.create(task);
            return taskDAO.getAll(user.getId());
        }
        return null;
    }

    public static void editTask(String textField, boolean completed, int taskId) {
        Task task = new Task();
        task.setCompleted(completed);
        task.setTextField(textField);
        task.setId(taskId);
        TaskDAO taskDAO = new TaskDAOImpl();
        taskDAO.update(task);
    }
}
