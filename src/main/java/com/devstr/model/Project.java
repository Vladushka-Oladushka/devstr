package com.devstr.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Project {

    private int projectId;
    private String projectName;
    private int projectManagerId;
    private int technicalManagerId;
    private Set<Integer> developersId;
    private Set<Review> reviews;
    private Set<Integer> issuesId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private boolean status;
    private String repoName;
    private String gitLogin;
    private String gitPassword;
    private String jiraLogin;
    private String jiraPassword;

    private Project() {
    }

    public int getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public int getProjectManagerId() {
        return projectManagerId;
    }

    public int getTechnicalManagerId() {
        return technicalManagerId;
    }

    public Set<Integer> getDevelopersId() {
        return developersId;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public Set<Integer> getIssuesId() {
        return issuesId;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public boolean isStatus() {
        return status;
    }

    public String getRepoName() {
        return repoName;
    }

    public String getGitLogin() {
        return gitLogin;
    }

    public String getGitPassword() {
        return gitPassword;
    }

    public String getJiraLogin() {
        return jiraLogin;
    }

    public String getJiraPassword() {
        return jiraPassword;
    }

    public static ProjectBuilder builder() {
        return new Project().new ProjectBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (projectId != project.projectId) return false;
        return projectManagerId == project.projectManagerId;
    }

    @Override
    public int hashCode() {
        int result = projectId;
        result = 31 * result + projectManagerId;
        return result;
    }

    public class ProjectBuilder {

        private ProjectBuilder() {
        }

        public ProjectBuilder setProjectId(int id) {
            Project.this.projectId = id;
            return this;
        }

        public ProjectBuilder setProjectName(String name) {
            Project.this.projectName = name;
            return this;
        }

        public ProjectBuilder setProjectManagerId(int id) {
            Project.this.projectManagerId = id;
            return this;
        }

        public ProjectBuilder setTechnicalManagerId(int id) {
            Project.this.technicalManagerId = id;
            return this;
        }

        public ProjectBuilder setDeveloperId(int id) {
            if (Project.this.developersId == null) {
                Project.this.developersId = new HashSet<>();
            }
            Project.this.developersId.add(id);
            return this;
        }

        public ProjectBuilder setDevelopersId(Set<Integer> ids) {
            if (Project.this.developersId == null) {
                Project.this.developersId = new HashSet<>();
            }
            Project.this.developersId.addAll(ids);
            return this;
        }

        public ProjectBuilder setReview(Review review) {
            if (Project.this.reviews == null) {
                Project.this.reviews = new HashSet<>();
            }
            Project.this.reviews.add(review);
            return this;
        }

        public ProjectBuilder setReviews(Set<Review> reviews) {
            if (Project.this.reviews == null) {
                Project.this.reviews = new HashSet<>();
            }
            Project.this.reviews.addAll(reviews);
            return this;
        }

        public ProjectBuilder setIssueId(int id) {
            if (Project.this.issuesId == null) {
                Project.this.issuesId = new HashSet<>();
            }
            Project.this.issuesId.add(id);
            return this;
        }

        public ProjectBuilder setIssuesId(Set<Integer> ids) {
            if (Project.this.issuesId == null) {
                Project.this.issuesId = new HashSet<>();
            }
            Project.this.issuesId.addAll(ids);
            return this;
        }

        public ProjectBuilder setFromDate(LocalDate fromDate) {
            Project.this.fromDate = fromDate;
            return this;
        }

        public ProjectBuilder setToDate(LocalDate toDate) {
            Project.this.toDate = toDate;
            return this;
        }

        public ProjectBuilder setStatus(boolean status) {
            Project.this.status = status;
            return this;
        }

        public ProjectBuilder setGitLogin(String login) {
            Project.this.gitLogin = login;
            return this;
        }

        public ProjectBuilder setGitPassword(String password) {
            Project.this.gitPassword = password;
            return this;
        }

        public ProjectBuilder setJiraLogin(String login) {
            Project.this.jiraLogin = login;
            return this;
        }

        public ProjectBuilder setJiraPassword(String password) {
            Project.this.jiraPassword = password;
            return this;
        }

        public ProjectBuilder setRepoName(String repoName) {
            Project.this.repoName = repoName;
            return this;
        }

        public Project build() {
            return Project.this;
        }

    }

}
