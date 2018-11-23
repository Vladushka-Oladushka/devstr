package com.devstr.model;

public class ProjectReview extends Review {

    private int experienceQuality;
    private int organisationLevel;
    private int timeManagement;
    private int teamSpirit;

    private ProjectReview(){
        super();
    }

    public int getExperienceQuality() {
        return experienceQuality;
    }

    public int getOrganisationLevel() {
        return organisationLevel;
    }

    public int getTimeManagement() {
        return timeManagement;
    }

    public int getTeamSpirit() {
        return teamSpirit;
    }

    public static ProjectReviewBuilder builder() {
        return new ProjectReview().new ProjectReviewBuilder();
    }

    public class ProjectReviewBuilder extends ReviewBuilder{

        private ProjectReviewBuilder(){
            super();
        }

        public ProjectReviewBuilder setExperienceQuality(int value) {
            ProjectReview.this.experienceQuality = value;
            return this;
        }

        public ProjectReviewBuilder setOrganisationLevel(int value) {
            ProjectReview.this.organisationLevel = value;
            return this;
        }

        public ProjectReviewBuilder setTimeManagement(int value) {
            ProjectReview.this.timeManagement = value;
            return this;
        }

        public ProjectReviewBuilder setTeamSpirit(int value) {
            ProjectReview.this.teamSpirit = value;
            return this;
        }

        public ProjectReview build() {
            return ProjectReview.this;
        }

    }

}
