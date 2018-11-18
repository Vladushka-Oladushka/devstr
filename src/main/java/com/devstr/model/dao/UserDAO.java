package com.devstr.model.dao;

import com.devstr.model.User;
import com.devstr.model.enumerations.UserRole;

public interface UserDAO {
    /**
     * Method writes User to database
     *
     * @param login user's login(stores in db as object.name)
     * @param firstName user's first name
     * @param lastName user's last name
     * @param email user's email
     * @param password user's password(encrypted)
     * @param userRole user's role
     */
    void createUser(String login, String firstName, String lastName, String email, String password, UserRole userRole);

    /**
     * Get user by id from the DB
     *
     * @param id object_id of user in table "Objects" of the DB
     * @return User with certain id
     */
    User readUserById(int id);

    /**
     * Get user with a certain login from the DB
     *
     * @param login login of a user in the system(objects.name attribute in the DB)
     * @return User with certain login
     */
    User readUserByLogin(String login);

    /**
     * Update user in the database, when id got no changes
     *
     * @param user updated User instance with the old id
     */
    void updateUser(User user);

    /**
     * Sets user into inactive mode
     *
     * @param user User instance that must be deactivated
     */
    void inactivateUser(User user);
}
