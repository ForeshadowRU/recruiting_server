package edu.omsu.jesper.service.interfaces;

import edu.omsu.jesper.model.Company;
import edu.omsu.jesper.model.User;

public interface UserService {

    void setCompany(User user, Company company);

    void setCompany(String username, Company company);

}
