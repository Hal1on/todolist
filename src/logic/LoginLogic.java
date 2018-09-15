package logic;

import dao.daosql.UserDAOImpl;
import entity.User;

public class LoginLogic {
    public static User checkLogin(String enterLogin, String enterPassword) {
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.read(enterLogin);
        if (user.getId() != -1 && user.getPassword().equals(enterPassword)) {
            return user;
        }
        return null;
    }
}