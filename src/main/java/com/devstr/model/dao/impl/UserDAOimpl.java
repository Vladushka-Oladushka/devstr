package com.devstr.model.dao.impl;

import com.devstr.model.User;
import com.devstr.model.dao.UserDAO;
import com.devstr.model.enumerations.UserRole;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class UserDAOimpl implements UserDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createUser(String login, String firstname, String lastname, String email, String password, UserRole userRole) {
        String obSQL = "INSERT INTO OBJECTS(NAME, OBJECT_TYPE_ID) VALUES(?, 1)";
        jdbcTemplate.update(obSQL, login);
        String atrSQL = "INSERT INTO ATTRIBUTES(ATTRN_ID, OBJECT_ID, VALUE) VALUES(?, ?, ?)";
        int object_id = jdbcTemplate.queryForObject("SELECT OBJECT_ID FROM OBJECTS WHERE NAME = ?",
                new Object[]{login}, Integer.class);
        jdbcTemplate.update(atrSQL, 1, object_id, firstname);;
        jdbcTemplate.update(atrSQL, 2, object_id, lastname);
        jdbcTemplate.update(atrSQL, 3, object_id, email);
        jdbcTemplate.update("INSERT INTO ATTRIBUTES (ATTRN_ID, OBJECT_ID, DATE_VALUE) VALUES (5, ?, SYSDATE)", object_id);
        jdbcTemplate.update(atrSQL, 6, object_id, password);
        String roleSQL = "INSERT INTO ATTRIBUTES(ATTRN_ID, OBJECT_ID, LIST_VALUE_ID) VALUES(4, ?, ?)";
        int roleId = jdbcTemplate.queryForObject("SELECT LIST_VALUE_ID FROM LISTS WHERE VALUE = ?",
                new Object[]{userRole.getUserRole()}, Integer.class);
        jdbcTemplate.update(atrSQL, 7, object_id, 1);
        jdbcTemplate.update(roleSQL, object_id, roleId);
    }

    @Override
    public User readUserById(int id) {
        User.UserBuilder result = User.builder();
        String username = jdbcTemplate.queryForObject("SELECT NAME FROM OBJECTS WHERE OBJECT_ID = ?",
                new Object[]{id}, String.class);
        result.setUserId(id);
        result.setLogin(username);
        String atrSQL = "SELECT VALUE FROM ATTRIBUTES WHERE OBJECT_ID = ? AND ATTRN_ID = ?";
        result.setFirstName(jdbcTemplate.queryForObject(atrSQL, new Object[]{id, 1}, String.class));
        result.setLastName(jdbcTemplate.queryForObject(atrSQL, new Object[]{id, 2}, String.class));
        result.setEmail(jdbcTemplate.queryForObject(atrSQL, new Object[]{id, 3}, String.class));
        result.setPassword(jdbcTemplate.queryForObject(atrSQL, new Object[]{id, 5}, String.class));
        int userRoleId = jdbcTemplate.queryForObject(atrSQL, new Object[]{id, 4}, Integer.class);
        String userRole = jdbcTemplate.queryForObject("SELECT VALUE FROM LISTS WHERE LIST_VALUE_ID = ?",
                new Object[]{userRoleId}, String.class);
        result.setRole(UserRole.valueOf(userRole));
        result.setStatus(jdbcTemplate.queryForObject(atrSQL, new Object[]{id, 5}, Boolean.class));
        return result.build();
    }

    @Override
    public User readUserByLogin(String login) {
        int userId = jdbcTemplate.queryForObject("SELECT OBJECT_ID FROM OBJECTS WHERE NAME = ?",
                new Object[]{login}, Integer.class);
        return readUserById(userId);
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void inactivateUser(User user) {

    }
}
