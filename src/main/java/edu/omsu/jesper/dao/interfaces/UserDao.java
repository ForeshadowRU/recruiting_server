package edu.omsu.jesper.dao.interfaces;

import edu.omsu.jesper.model.User;

import java.util.List;

public interface UserDao {

    User get(String username);

    List<User> get();

    void save(User user);

    void update(String username, User newValue);

    void delete(String username);
}
