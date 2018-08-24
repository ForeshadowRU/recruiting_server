package edu.omsu.jesper.dao.implementations;

import edu.omsu.jesper.dao.interfaces.UserDao;
import edu.omsu.jesper.mapper.CompanyMapper;
import edu.omsu.jesper.model.Company;
import edu.omsu.jesper.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;

@Service
public class UserDaoImpl implements UserDao {

    private final JdbcTemplate template;

    @Autowired
    public UserDaoImpl(JdbcTemplate template) {
        this.template = template;
    }

    public boolean checkExistence(String username) {

        String sql = "SELECT username FROM `recruiting-server`.users";
        List<String> list = template.query(sql, extractor -> {
            List<String> usernames = new ArrayList<>();
            while (extractor.next()) {
                usernames.add(extractor.getString("username"));
            }
            return usernames;
        });
        if (list == null) return false;
        return list.contains(username);
    }

    @Override
    public boolean checkExistence(User user) {
        return checkExistence(user.getUsername());
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
                        user.setAuthorities(Collections.singletonList(new SimpleGrantedAuthority(extractor.getString("privileges"))));
                        user.setEnabled(extractor.getBoolean("enabled"));
                        user.setAccountNonLocked(!extractor.getBoolean("locked"));
                        user.setCredentialsNonExpired(!extractor.getBoolean("expired"));
                        user.setAccountNonExpired(true);
                        user.setEmail(extractor.getString("email"));
                        user.setPhoneNumber(extractor.getString("phone-number"));
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
                        user.setAuthorities(Collections.singletonList(new SimpleGrantedAuthority(extractor.getString("privileges"))));
                        user.setEnabled(extractor.getBoolean("enabled"));
                        user.setAccountNonLocked(!extractor.getBoolean("locked"));
                        user.setCredentialsNonExpired(!extractor.getBoolean("expired"));
                        user.setAccountNonExpired(true);
                        user.setEmail(extractor.getString("email"));
                        user.setPhoneNumber(extractor.getString("phone-number"));
                        String company_id = extractor.getString("company_id");
                        if (company_id.trim().isEmpty()) users.add(user);
                        else {
                            String companySql = "SELECT * FROM `recruiting-server`.companies WHERE id = ?";
                            user.setCompany(template.query(companySql, new CompanyMapper(), company_id).get(0));
                            users.add(user);
                        }

                    }
                    return users;
                });

    }

    public void save(User user) {
        try {


            String sql = "INSERT INTO `recruiting-server`.users() " +
                    "VALUES(?,?,?,?,?,?,?,?,?,?,?) ";
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
                setter.setString(10, user.getEmail());
                setter.setString(11, user.getPhoneNumber());

            });
        } catch (DuplicateKeyException ex) {
            throw new DuplicateKeyException(String.format("User \"%s\" already exist.", user.getUsername()));
        }
    }

    public Map<String, Object> getDifference(String username, User newValue) throws IllegalAccessException {
        Field[] fields = User.class.getDeclaredFields();
        Map<String, Object> diff = new HashMap<>();
        User user = get(username);
        if (user == null)
            throw new UsernameNotFoundException(String.format("Username %s not found", username));
        for (Field field : fields) {
            field.setAccessible(true);

            Object firstValue = field.get(user);
            Object secondValue = field.get(newValue);
            if (firstValue == null && secondValue != null) {
                diff.put(field.getName(), secondValue);
                continue;
            }
            if (firstValue != null && secondValue == null) {
                diff.put(field.getName(), null);
                continue;
            }
            if (firstValue == null) continue;
            if (!firstValue.equals(secondValue)) {
                diff.put(field.getName(), field.get(newValue));
            }
        }
        return diff;
    }

    /*   private List<String> getColumnNames(String tableName) {
           String sql = "SELECT `COLUMN_NAME` \n" +
                   "FROM `information_schema`.`COLUMNS` \n" +
                   "WHERE `TABLE_SCHEMA`='recruiting-server' \n" +
                   "    AND `TABLE_NAME`= ?";
           return template.query(sql, setter -> setter.setString(1, tableName), extractor -> {
               List<String> list = new ArrayList<>();
               while (extractor.next()) {
                   list.add(extractor.getString("COLUMN_NAME"));
               }
               return list;
           });
       }/*

       private Map<String, Object> toDatabaseName(Map<String, Object> baseMap) {

           List<String> users = getColumnNames("users");
           List<Object> values = new ArrayList<>(baseMap.values());

           Set<String> keys = baseMap.keySet();
           for (String key : keys) {

           }
       }

   /*
       public void update(String fieldName, Object value) {
           String sql = "UPDATE `recruiting-server`.users" +
                   " SET ? = ?";
           if (value instanceof String)
               template.update(sql, setter -> {
                   setter.setString(1, fieldName);
                   setter.setString(2, (String) value);
               });
           else template.update(sql, setter -> {
               setter.setString(1, fieldName);
               setter.setBoolean(2, (Boolean) value);
           });

       }
   */
    //this is very boring Should write my own Hibernate with blackjack and hookers;
    @Override
    public void update(String username, User newValue) {
        String sql = "UPDATE `recruiting-server`.users " +
                "SET username = ?, " +
                "password = ?, " +
                "first_name = ?, " +
                "second_name = ?, " +
                "company_id = ?, " +
                "privileges = ?, " +
                "enabled = ?, " +
                "locked = ?,  " +
                "expired = ?,  " +
                "email = ?,  " +
                "`phone-number` = ?" +
                " WHERE username = ? ";
        template.update(sql, setter -> {
            setter.setString(1, username);
            setter.setString(2, newValue.getPassword());
            setter.setString(3, newValue.getFirstName());
            setter.setString(4, newValue.getSecondName());
            Company company = newValue.getCompany();
            if (company != null)
                setter.setString(5, company.getId().toString());
            else setter.setString(5, "");
            setter.setString(6, newValue.getAuthorities().get(0).toString());
            setter.setBoolean(7, newValue.isEnabled());
            setter.setBoolean(8, !newValue.isAccountNonLocked());
            setter.setBoolean(9, !newValue.isAccountNonExpired());
            setter.setString(10, newValue.getEmail());
            setter.setString(11, newValue.getPhoneNumber());
            setter.setString(12, username);
        });
    }

    @Override
    public void delete(String username) {
        String sql = "DELETE FROM `recruiting-server`.users WHERE username = ?";
        template.update(sql, setter -> setter.setString(1, username));
    }

}
