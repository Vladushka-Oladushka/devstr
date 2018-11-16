package com.devstr.model.dao;

import com.devstr.model.User;
import com.devstr.model.enumerations.UserRole;

import javax.sql.DataSource;

public interface UserDAO {
    void setDataSource(DataSource dataSource);
    void createUser(String login, String firstname, String lastname, String email, String password, UserRole userRole);
    User readUserById(int id);
    User readUserByLogin(String login);
    void updateUser(User user);
    void inactivateUser(User user);
}
