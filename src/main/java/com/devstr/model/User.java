package com.devstr.model;

import com.devstr.model.enumerations.UserRole;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class User {

    private int userId;
    private String login;
    private String firstName;
    private String lastName;
    private Set<Review> reviews;
    private String password;
    private String email;
    private UserRole role;
    private int projectId;
    private LocalDate hireDate;
    private boolean status;

    private User() {
    }

    public int getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public UserRole getRole() {
        return role;
    }

    public int getProjectId() {
        return projectId;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public boolean isStatus() {
        return status;
    }

    public static UserBuilder builder() {
        return new User().new UserBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        return login.equals(user.login);
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + login.hashCode();
        return result;
    }

    public class UserBuilder {

        private UserBuilder() {
        }

        public UserBuilder setUserId(int userId) {
            User.this.userId = userId;
            return this;
        }

        public UserBuilder setLogin(String login) {
            User.this.login = login;
            return this;
        }

        public UserBuilder setFirstName(String firstName) {
            User.this.firstName = firstName;
            return this;
        }

        public UserBuilder setLastName(String lastName) {
            User.this.lastName = lastName;
            return this;
        }

        public UserBuilder setReview(Review review) {
            if (User.this.reviews == null) {
                User.this.reviews = new HashSet<>();
            }
            User.this.reviews.add(review);
            return this;
        }

        public UserBuilder setReviews(Set<Review> reviews) {
            if (User.this.reviews == null) {
                User.this.reviews = new HashSet<>();
            }
            User.this.reviews.addAll(reviews);
            return this;
        }

        public UserBuilder setPassword(String password) {
            User.this.password = password;
            return this;
        }

        public UserBuilder setEmail(String email) {
            User.this.email = email;
            return this;
        }

        public UserBuilder setRole(UserRole role) {
            User.this.role = role;
            return this;
        }

        public UserBuilder setProjectId(int projectId) {
            User.this.projectId = projectId;
            return this;
        }

        public UserBuilder setHireDate(LocalDate hireDate) {
            User.this.hireDate = hireDate;
            return this;
        }

        public UserBuilder setStatus(boolean status) {
            User.this.status = status;
            return this;
        }

        public User build() {
            return User.this;
        }

    }

}
