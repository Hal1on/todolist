package dao.daosql;

import dao.UserDAO;
import entity.User;
import resource.DBConnectionManager;

import java.sql.PreparedStatement;
import java.sql.*;

public class UserDAOImpl extends DBConnectionManager implements UserDAO {
    /**
     * Create User in database.
     *
     * @param user for create.
     */
    @Override
    public void create(final User user) {
        try (PreparedStatement statement = getConnection().prepareStatement(SQLUser.INSERT.QUERY)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Select User by login.
     *
     * @param login for select.
     * @return return valid entity if she exist. If entity does not exist return empty User with id = -1.
     */
    @Override
    public User read(final String login) {
        final User result = new User();
        result.setId(-1);
        try (PreparedStatement statement = getConnection().prepareStatement(SQLUser.GET.QUERY)) {
            statement.setString(1, login);
            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                result.setId(Integer.parseInt(rs.getString("user_id")));
                result.setLogin(login);
                result.setPassword(rs.getString("password"));
            }
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Update User's password by id.
     *
     * @param user new user's state.
     */
    @Override
    public void update(final User user) {
        try (PreparedStatement statement = getConnection().prepareStatement(SQLUser.UPDATE.QUERY)) {
            statement.setString(1, user.getPassword());
            statement.setInt(2, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete User by id AND login AND password.
     *
     * @param user for delete.
     */
    @Override
    public void delete(final User user) {
        try (PreparedStatement statement = getConnection().prepareStatement(SQLUser.DELETE.QUERY)) {
            statement.setInt(1, user.getId());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * SQL queries for users table.
     */
    enum SQLUser {
        GET("SELECT * FROM users where users.login=?"),
        INSERT("INSERT INTO users (users.login, users.password) VALUES (?,?)"),
        DELETE("DELETE FROM users WHERE users.user_id =? AND users.login =? AND users.password =?"),
        UPDATE("UPDATE users SET users.password =? WHERE users.user_id =?");

        String QUERY;

        SQLUser(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}