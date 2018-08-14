package edu.omsu.jesper.dao.implementations;

import edu.omsu.jesper.dao.interfaces.UserDao;
import edu.omsu.jesper.mapper.CompanyMapper;
import edu.omsu.jesper.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao {

    private final JdbcTemplate template;

    @Autowired
    public UserDaoImpl(JdbcTemplate template) {
        this.template = template;
    }

    public User get(String username) {
        String sql = "SELECT * FROM `recruiting-server`.users WHERE username = ?";
        return template.query(sql, setter -> setter.setString(1, username),
                extractor -> {
                    if (extractor.next()) {
                        User user = new User();
                        user.setUsername(extractor.getString("username"));
                        user.setPassword(extractor.getString("password"));
                        user.setFirstName(extractor.getString("first_name"));
                        user.setSecondName(extractor.getString("second_name"));
                        user.setAuthorities(Collections.singleton(new SimpleGrantedAuthority(extractor.getString("privileges"))));
                        user.setEnabled(extractor.getBoolean("enabled"));
                        user.setAccountNonLocked(!extractor.getBoolean("locked"));
                        user.setCredentialsNonExpired(!extractor.getBoolean("expired"));
                        user.setAccountNonExpired(true);
                        String company_id = extractor.getString("company_id");
                        if (company_id.trim().isEmpty()) return user;
                        String companySql = "SELECT * FROM `recruiting-server`.companies WHERE id = ?";
                        user.setCompany(template.query(companySql, new CompanyMapper(), company_id).get(0));
                        return user;
                    } else return null;
                });


    }

    @Override
    public List<User> get() {
        String sql = "SELECT * FROM `recruiting-server`.users";
        return template.query(sql,
                extractor -> {
                    List<User> users = new ArrayList<>();
                    while (extractor.next()) {
                        User user = new User();
                        user.setUsername(extractor.getString("username"));
                        user.setPassword(extractor.getString("password"));
                        user.setFirstName(extractor.getString("first_name"));
                        user.setSecondName(extractor.getString("second_name"));
                        user.setAuthorities(Collections.singleton(new SimpleGrantedAuthority(extractor.getString("privileges"))));
                        user.setEnabled(extractor.getBoolean("enabled"));
                        user.setAccountNonLocked(!extractor.getBoolean("locked"));
                        user.setCredentialsNonExpired(!extractor.getBoolean("expired"));
                        user.setAccountNonExpired(true);
                        String company_id = extractor.getString("company_id");
                        if (company_id.trim().isEmpty()) users.add(user);
                        else {
                            String companySql = "SELECT * FROM `recruiting-server`.companies WHERE id = ?";
                            user.setCompany(template.query(companySql, new CompanyMapper(), company_id).get(0));
                        }
                        users.add(user);
                    }
                    return users;
                });

    }

    public void save(User user) {
        String sql = "INSERT INTO `recruiting-server`.users " +
                "VALUES(?,?,?,?,?,?,?,?,?) ";
        template.update(sql, setter -> {
            setter.setString(1, user.getUsername());
            setter.setString(2, user.getPassword());
            setter.setString(3, user.getFirstName());
            setter.setString(4, user.getSecondName());

            if (!(user.getCompany() == null))
                setter.setString(5, user.getCompany().getId().toString());
            else setter.setString(5, "");
            setter.setString(6, "ROLE_USER");
            setter.setBoolean(7, user.isEnabled());
            setter.setBoolean(8, !user.isAccountNonLocked());
            setter.setBoolean(9, !user.isCredentialsNonExpired());
        });
    }

    @Override
    public void update(String username, User newValue) {
        //later
    }

    @Override
    public void delete(String username) {
//later
    }

}
