package dao;

import entity.User;

import java.sql.SQLException;

public interface UserDAO {
    void create(User user);

    User read(String login);

    void update(User user);

    void delete(User user);
}
