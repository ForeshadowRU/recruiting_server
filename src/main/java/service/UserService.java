package service;

import model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void save(User user) throws Exception;

    User getById(int id);

    void update(User user);

    void delete(int id);
}
