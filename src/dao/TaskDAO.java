package dao;

import entity.Task;

import java.util.List;

public interface TaskDAO {
    void create(Task task);

    List<Task> getAll(int userId);

    void update(Task task);

    void delete(Task task);
}
