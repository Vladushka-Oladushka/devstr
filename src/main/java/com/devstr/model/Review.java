package com.devstr.model;

import java.time.LocalDate;

public class Review {

    private int reviewId;
    private int authorId;
    private String authorFullName;
    private String receiverFullName;
    private int projectId;
    private String comment;
    private LocalDate creationDate;

    private Review() {
    }

    public int getReviewId() {
        return reviewId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public String getReceiverFullName() {
        return receiverFullName;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getComment() {
        return comment;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public static ReviewBuilder builder() {
        return new Review().new ReviewBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (reviewId != review.reviewId) return false;
        return authorId == review.authorId;
    }

    @Override
    public int hashCode() {
        int result = reviewId;
        result = 31 * result + authorId;
        return result;
    }

    public class ReviewBuilder {

        private ReviewBuilder() {
        }

        public ReviewBuilder setReviewId(int id) {
            Review.this.reviewId = id;
            return this;
        }

        public ReviewBuilder setAuthorId(int id) {
            Review.this.authorId = id;
            return this;
        }

        public ReviewBuilder setAuthorFullName(String fullName) {
            Review.this.authorFullName = fullName;
            return this;
        }

        public ReviewBuilder setReceiverFullName(String fullName) {
            Review.this.receiverFullName = fullName;
            return this;
        }

        public ReviewBuilder setProjectId(int id) {
            Review.this.projectId = id;
            return this;
        }

        public ReviewBuilder setComment(String comment) {
            Review.this.comment = comment;
            return this;
        }

        public ReviewBuilder setCreationDate(LocalDate creationDate) {
            Review.this.creationDate = creationDate;
            return this;
        }

        public Review build() {
            return Review.this;
        }

    }

}
