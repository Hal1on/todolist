package logic;

import dao.daosql.UserDAOImpl;
import entity.User;

public class RegistrationLogic {
    public static boolean userRegistered(String enterLogin, String enterPassword) {
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.read(enterLogin);
        if (user.getId() == -1) {
            User newUser = new User();
            newUser.setLogin(enterLogin);
            newUser.setPassword(enterPassword);
            userDAO.create(newUser);
            return true;
        }
        return false;
    }

}


