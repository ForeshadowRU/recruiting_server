package edu.omsu.jesper.dao.implementations;

import edu.omsu.jesper.dao.interfaces.UserDao;
import edu.omsu.jesper.mapper.UserMapper;
import edu.omsu.jesper.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(User user) {
        String sql = "INSERT INTO heroku_cf3d0b7baed81fe.users (name, email, password) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword());

    }

    public User getById(int id) {
        String sql = "SELECT * FROM heroku_cf3d0b7baed81fe.users WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM heroku_cf3d0b7baed81fe.users";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    public void update(User user) {
        String sql = "UPDATE heroku_cf3d0b7baed81fe.users SET name=?, email=?, age=? WHERE id=?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword(), user.getId());
    }

    public void delete(int id) {
        String sql = "DELETE FROM heroku_cf3d0b7baed81fe.users WHERE id=?";
        jdbcTemplate.update(sql, id);

    }
}
