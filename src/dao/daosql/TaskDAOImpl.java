package dao.daosql;

import dao.TaskDAO;
import entity.Task;
import resource.DBConnectionManager;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDAOImpl extends DBConnectionManager implements TaskDAO {
    /**
     * Create Task in database.
     *
     * @param task for create.
     */
    @Override
    public void create(Task task) {
        try (PreparedStatement statement = getConnection().prepareStatement(SQLTask.INSERT.QUERY)) {
            statement.setString(1, task.getTextField());
            statement.setBoolean(2, task.isCompleted());
            statement.setInt(3, task.getUserId());
            statement.setDate(4, Date.valueOf(task.getData()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Select Tasks by user id.
     *
     * @param userId for select.
     * @return list of tasks.
     */
    @Override
    public List<Task> getAll(int userId) {
        List<Task> list = new ArrayList<>();
        try (PreparedStatement statement = getConnection().prepareStatement(SQLTask.GET.QUERY)) {
            statement.setInt(1, userId);
            final ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Task task = new Task();
                task.setId(Integer.parseInt(rs.getString("task_id")));
                task.setTextField(rs.getString("text_field"));
                task.setCompleted(rs.getBoolean("completed"));
                task.setUserId(Integer.parseInt(rs.getString("task_user_id")));
                task.setData(String.valueOf(rs.getDate("data")));
                list.add(task);
            }
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Update Task's textfield by task id.
     *
     * @param task new task's state.
     */
    @Override
    public void update(Task task) {
        try (PreparedStatement statement = getConnection().prepareStatement(SQLTask.UPDATE.QUERY)) {
            statement.setString(1, task.getTextField());
            statement.setBoolean(2, task.isCompleted());
            statement.setDate(3, Date.valueOf(task.getData()));
            statement.setInt(4, task.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete Task by task id.
     *
     * @param task for delete.
     */
    @Override
    public void delete(Task task) {
        try (PreparedStatement statement = getConnection().prepareStatement(SQLTask.DELETE.QUERY)) {
            statement.setInt(1, task.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * SQL queries for todolist table.
     */
    enum SQLTask {
        GET("SELECT * FROM todolist WHERE todolist.task_user_id=?"),
        INSERT("INSERT INTO todolist (todolist.text_field, todolist.completed, todolist.task_user_id, todolist.data) VALUES (?,?,?,?)"),
        DELETE("DELETE FROM todolist WHERE todolist.task_id=?"),
        UPDATE("UPDATE todolist SET todolist.text_field=?, todolist.completed=?, todolist.data=?  WHERE todolist.task_id=?");
        String QUERY;

        SQLTask(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
