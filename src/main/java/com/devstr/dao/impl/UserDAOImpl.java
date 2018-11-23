package com.devstr.dao.impl;

import com.devstr.model.User;
import com.devstr.dao.UserDAO;
import com.devstr.model.enumerations.UserRole;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.math.BigInteger;
import java.util.Date;

public class UserDAOImpl implements UserDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private static final String INSERT_ATTRIBUTE = "INSERT INTO ATTRIBUTES(ATTRN_ID, OBJECT_ID, VALUE) VALUES(?, ?, ?)";
    private static final String SELECT_OBJECT_NAME = "SELECT NAME FROM OBJECTS WHERE OBJECT_ID = ?";
    private static final String SELECT_OBJECT_ID = "SELECT OBJECT_ID FROM OBJECTS WHERE NAME = ?";
    private static final String UPDATE_OBJECT = "UPDATE OBJECTS SET ? = ? WHERE OBJECT_ID = ?";
    private static final String UPDATE_ATTRIBUTE = "UPDATE ATTRIBUTES SET ? = ? WHERE OBJECT_ID = ? AND ATTRN_ID = ?";
    private static final String SELECT_LIST_ID = "SELECT LIST_VALUE_ID FROM LISTS WHERE VALUE = ?";
    private static final String SELECT_ATTRIBUTE = "SELECT VALUE FROM ATTRIBUTES WHERE OBJECT_ID = ? AND ATTRN_ID = ?";

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createUser(String login, String firstName, String lastName, String email, String password, UserRole userRole) {
        throwingNullArgumentException(login, firstName, lastName, email, password, userRole);
        String obSQL = "INSERT INTO OBJECTS(NAME, OBJECT_TYPE_ID) VALUES(?, 1)";
        jdbcTemplate.update(obSQL, login);
        int object_id = jdbcTemplate.queryForObject(SELECT_OBJECT_ID,
                new Object[]{login}, Integer.class);
        jdbcTemplate.update(INSERT_ATTRIBUTE, 1, object_id, firstName);
        jdbcTemplate.update(INSERT_ATTRIBUTE, 2, object_id, lastName);
        jdbcTemplate.update(INSERT_ATTRIBUTE, 3, object_id, email);
        jdbcTemplate.update("INSERT INTO ATTRIBUTES (ATTRN_ID, OBJECT_ID, DATE_VALUE) VALUES (5, ?, SYSDATE)", object_id);
        jdbcTemplate.update(INSERT_ATTRIBUTE, 6, object_id, password);
        String roleSQL = "INSERT INTO ATTRIBUTES(ATTRN_ID, OBJECT_ID, LIST_VALUE_ID) VALUES(4, ?, ?)";
        int roleId = jdbcTemplate.queryForObject("SELECT LIST_VALUE_ID FROM LISTS WHERE VALUE = ?",
                new Object[]{userRole.getFullName()}, Integer.class);
        jdbcTemplate.update(INSERT_ATTRIBUTE, 7, object_id, 1);
        jdbcTemplate.update(roleSQL, object_id, roleId);
    }

    @Override
    public User readUserById(BigInteger id) {
        if (id.intValue() <= 0) {
            throw new IllegalArgumentException("ID cannot be 0 or less");
        }
        if (id.intValue() > jdbcTemplate.getMaxRows()){
            throw new IllegalArgumentException("ID is bigger than size of the table");
        }
        User.UserBuilder result = User.builder();
        String username = jdbcTemplate.queryForObject(SELECT_OBJECT_NAME,
                new Object[]{id}, String.class);
        result.setUserId(id);
        result.setLogin(username);
        result.setFirstName(jdbcTemplate.queryForObject(SELECT_ATTRIBUTE, new Object[]{id, 1}, String.class));
        result.setLastName(jdbcTemplate.queryForObject(SELECT_ATTRIBUTE, new Object[]{id, 2}, String.class));
        result.setEmail(jdbcTemplate.queryForObject(SELECT_ATTRIBUTE, new Object[]{id, 3}, String.class));
        result.setPassword(jdbcTemplate.queryForObject(SELECT_ATTRIBUTE, new Object[]{id, 6}, String.class));
        int userRoleId = jdbcTemplate.queryForObject(SELECT_ATTRIBUTE, new Object[]{id, 4}, Integer.class);
        String userRole = jdbcTemplate.queryForObject("SELECT VALUE FROM LISTS WHERE LIST_VALUE_ID = ?",
                new Object[]{userRoleId}, String.class);
        result.setRole(UserRole.valueOf(userRole));
        result.setHireDate(jdbcTemplate.queryForObject("SELECT DATE_VALUE FROM ATTRIBUTES" +
                " WHERE OBJECT_ID=? AND ATTRN_ID=?", new Object[]{id, 5}, Date.class));
        result.setStatus(jdbcTemplate.queryForObject(SELECT_ATTRIBUTE, new Object[]{id, 7}, Boolean.class));
        return result.build();
    }

    @Override
    public User readUserByLogin(String login) {
        throwingNullArgumentException(login);
        BigInteger userId = jdbcTemplate.queryForObject("SELECT OBJECT_ID FROM OBJECTS WHERE NAME = ?",
                new Object[]{login}, BigInteger.class);
        return readUserById(userId);
    }

    @Override
    public void updateUser(User user) {
        throwingNullArgumentException(user);
        jdbcTemplate.update(UPDATE_OBJECT,  "NAME", user.getLogin());
        jdbcTemplate.update(UPDATE_ATTRIBUTE, "VALUE", user.getFirstName(), user.getUserId(), 1);
        jdbcTemplate.update(UPDATE_ATTRIBUTE, "VALUE", user.getLastName(), user.getUserId(), 2);
        jdbcTemplate.update(UPDATE_ATTRIBUTE, "VALUE", user.getEmail(), user.getUserId(), 3);
        int userRoleId = jdbcTemplate.queryForObject(SELECT_LIST_ID, new Object[]{user.getRole().toString()},
                Integer.class);
        jdbcTemplate.update(UPDATE_ATTRIBUTE, "LIST_VALUE_ID", userRoleId, user.getUserId(), 4);
        jdbcTemplate.update(UPDATE_ATTRIBUTE, "DATE_VALUE", user.getHireDate(), user.getUserId(), 5);
        jdbcTemplate.update(UPDATE_ATTRIBUTE, "VALUE", user.getPassword(), user.getUserId(), 6);
        if(user.isStatus())
            jdbcTemplate.update(UPDATE_ATTRIBUTE, "LIST_VALUE_ID", 6, user.getUserId(), 7);
        else
            jdbcTemplate.update(UPDATE_ATTRIBUTE, "LIST_VALUE_ID", 7, user.getUserId(), 7);
    }

    @Override
    public void inactivateUser(User user) {
        jdbcTemplate.update(UPDATE_ATTRIBUTE, "LIST_VALUE_ID", 7, user.getUserId(), 7);
    }

    private void throwingNullArgumentException(Object ...args) {
        for (Object o: args) {
            if (o == null){
                throw new IllegalArgumentException("Argument cannot be null");
            }
        }
    }
}
