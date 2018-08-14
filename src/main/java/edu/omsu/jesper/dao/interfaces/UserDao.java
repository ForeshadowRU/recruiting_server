package edu.omsu.jesper.dao.interfaces;

import edu.omsu.jesper.model.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    User get(String username);

    List<User> get();

    void save(User user);

    boolean checkExistence(String username);

    Map<String, Object> getDifference(String username, User newValue) throws IllegalAccessException;

    boolean checkExistence(User user);

    void update(String username, User newValue);

    void delete(String username);
}
