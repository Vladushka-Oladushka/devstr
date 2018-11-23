package com.devstr.model;

import com.devstr.model.enumerations.UserRole;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User {

    private BigInteger userId;
    private String login;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private UserRole role;
    private Date hireDate;
    private boolean status;
    private Set<BigInteger> reviewsId;
    private BigInteger projectId;

    private User() {
    }

    public BigInteger getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRole getRole() {
        return role;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public boolean isStatus() {
        return status;
    }

    public Set<BigInteger> getReviewsId() {
        return reviewsId;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setReviewId(BigInteger reviewId) {
        if (this.reviewsId == null) {
            this.reviewsId = new HashSet<>();
        }
        this.reviewsId.add(reviewId);
    }

    public void setReviewsId(Set<BigInteger> reviewsId) {
        if (this.reviewsId == null) {
            this.reviewsId = new HashSet<>();
        }
        this.reviewsId.addAll(reviewsId);
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public static UserBuilder builder() {
        return new User().new UserBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return getUserId().equals(user.getUserId());
    }

    @Override
    public int hashCode() {
        return getUserId().hashCode();
    }

    public class UserBuilder {

        private UserBuilder() {
        }

        public UserBuilder setUserId(BigInteger userId) {
            User.this.userId = userId;
            return this;
        }

        public UserBuilder setLogin(String login) {
            User.this.login = login;
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

        public UserBuilder setFirstName(String firstName) {
            User.this.firstName = firstName;
            return this;
        }

        public UserBuilder setLastName(String lastName) {
            User.this.lastName = lastName;
            return this;
        }

        public UserBuilder setRole(UserRole role) {
            User.this.role = role;
            return this;
        }

        public UserBuilder setHireDate(Date hireDate) {
            User.this.hireDate = hireDate;
            return this;
        }

        public UserBuilder setStatus(boolean status) {
            User.this.status = status;
            return this;
        }

        public UserBuilder setReviewId(BigInteger reviewId) {
            if (User.this.reviewsId == null) {
                User.this.reviewsId = new HashSet<>();
            }
            User.this.reviewsId.add(reviewId);
            return this;
        }

        public UserBuilder setReviewsId(Set<BigInteger> reviewsId) {
            if (User.this.reviewsId == null) {
                User.this.reviewsId = new HashSet<>();
            }
            User.this.reviewsId.addAll(reviewsId);
            return this;
        }

        public UserBuilder setProjectId(BigInteger projectId) {
            User.this.projectId = projectId;
            return this;
        }

        public User build() {
            return User.this;
        }

    }

}
