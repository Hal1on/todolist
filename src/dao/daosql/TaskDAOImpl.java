package dao.daosql;

import dao.TaskDAO;
import entity.Task;
import resource.DBConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDAOImpl extends DBConnectionManager implements TaskDAO {

    @Override
    public void create(Task task) {
        try (PreparedStatement statement = getConnection().prepareStatement(SQLTask.INSERT.QUERY)) {
            statement.setString(1, task.getTextField());
            statement.setBoolean(2, task.isCompleted());
            statement.setInt(3, task.getUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
                list.add(task);
            }
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(Task task) {
        try (PreparedStatement statement = getConnection().prepareStatement(SQLTask.UPDATE.QUERY)) {
            statement.setString(1, task.getTextField());
            statement.setBoolean(2, task.isCompleted());
            statement.setInt(3, task.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Task task) {
        try (PreparedStatement statement = getConnection().prepareStatement(SQLTask.DELETE.QUERY)) {
            statement.setInt(1, task.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    enum SQLTask {
        GET("SELECT * FROM todolist WHERE todolist.task_user_id=?"),
        INSERT("INSERT INTO todolist (todolist.text_field, todolist.completed, todolist.task_user_id) VALUES (?,?,?)"),
        DELETE("DELETE FROM todolist WHERE todolist.task_id=?"),
        UPDATE("UPDATE todolist SET todolist.text_field=?, todolist.completed=? WHERE todolist.task_id=?");
        String QUERY;

        SQLTask(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
