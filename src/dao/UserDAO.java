package dao;

import entity.User;

import java.sql.SQLException;

public interface UserDAO { // CRUD : created, read, update, delete.
    void create(User user);

    User read(String login);

    void update(User user);

    void delete(User user);
}
