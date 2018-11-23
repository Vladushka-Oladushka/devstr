package com.devstr.model;

import java.math.BigInteger;

public class UserReview extends Review {

    private int codeQuality;
    private int codeAmount;
    private int communication;
    private BigInteger projectId;

    private UserReview(){
        super();
    }

    public int getCodeQuality() {
        return codeQuality;
    }

    public int getCodeAmount() {
        return codeAmount;
    }

    public int getCommunication() {
        return communication;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public static UserReviewBuilder builder() {
        return new UserReview().new UserReviewBuilder();
    }

    public class UserReviewBuilder extends ReviewBuilder{

        private UserReviewBuilder(){
            super();
        }

        public UserReviewBuilder setCodeQuality(int value) {
            UserReview.this.codeQuality = value;
            return this;
        }

        public UserReviewBuilder setCodeAmount(int value) {
            UserReview.this.codeAmount = value;
            return this;
        }

        public UserReviewBuilder setCommunication(int value) {
            UserReview.this.communication = value;
            return this;
        }

        public UserReviewBuilder setProjectId(BigInteger id) {
            UserReview.this.projectId = id;
            return this;
        }

        public UserReview build() {
            return UserReview.this;
        }

    }

}
