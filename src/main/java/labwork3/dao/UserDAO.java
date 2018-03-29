package labwork3.dao;

import labwork3.entities.User;

public class UserDAO extends DAO<User, Integer> {
    public UserDAO() {
        super(User.class);
    }

    public User findUser(String username, String password) {
        return null;
    }
}
