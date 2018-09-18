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

    public static void addTask(String textField, String data, String login, boolean completed) {
        if (textField != null && login != null) {
            UserDAOImpl userDAO = new UserDAOImpl();
            User user = userDAO.read(login);
            Task task = new Task();
            task.setTextField(textField);
            task.setData(data);
            task.setCompleted(completed);
            task.setUserId(user.getId());
            TaskDAO taskDAO = new TaskDAOImpl();
            taskDAO.create(task);
        }
    }

    public static void editTask(String textField, boolean completed, String data, int taskId) {
        Task task = new Task();
        task.setCompleted(completed);
        task.setTextField(textField);
        task.setData(data);
        task.setId(taskId);
        TaskDAO taskDAO = new TaskDAOImpl();
        taskDAO.update(task);
    }
}
