package com.devstr.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Project {

    private BigInteger projectId;
    private String projectName;
    private BigInteger projectManagerId;
    private BigInteger technicalManagerId;
    private Set<BigInteger> developersId;
    private Set<BigInteger> issuesId;
    private String repoName;
    private String gitLogin;
    private String gitPassword;
    private String jiraLogin;
    private String jiraPassword;
    private Date fromDate;
    private Date toDate;
    private boolean status;
    private Set<BigInteger> reviewsId;

    private Project() {
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public BigInteger getProjectManagerId() {
        return projectManagerId;
    }

    public BigInteger getTechnicalManagerId() {
        return technicalManagerId;
    }

    public Set<BigInteger> getDevelopersId() {
        return developersId;
    }

    public Set<BigInteger> getIssuesId() {
        return issuesId;
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

    public Date getFromDate() {
        return fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public boolean isStatus() {
        return status;
    }

    public Set<BigInteger> getReviewsId() {
        return reviewsId;
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

    public static ProjectBuilder builder() {
        return new Project().new ProjectBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        return getProjectId().equals(project.getProjectId());
    }

    @Override
    public int hashCode() {
        return getProjectId().hashCode();
    }

    public class ProjectBuilder {

        private ProjectBuilder() {
        }

        public ProjectBuilder setProjectId(BigInteger id) {
            Project.this.projectId = id;
            return this;
        }

        public ProjectBuilder setProjectName(String name) {
            Project.this.projectName = name;
            return this;
        }

        public ProjectBuilder setProjectManagerId(BigInteger id) {
            Project.this.projectManagerId = id;
            return this;
        }

        public ProjectBuilder setTechnicalManagerId(BigInteger id) {
            Project.this.technicalManagerId = id;
            return this;
        }

        public ProjectBuilder setDeveloperId(BigInteger id) {
            if (Project.this.developersId == null) {
                Project.this.developersId = new HashSet<>();
            }
            Project.this.developersId.add(id);
            return this;
        }

        public ProjectBuilder setDevelopersId(Set<BigInteger> ids) {
            if (Project.this.developersId == null) {
                Project.this.developersId = new HashSet<>();
            }
            Project.this.developersId.addAll(ids);
            return this;
        }

        public ProjectBuilder setIssueId(BigInteger id) {
            if (Project.this.issuesId == null) {
                Project.this.issuesId = new HashSet<>();
            }
            Project.this.issuesId.add(id);
            return this;
        }

        public ProjectBuilder setIssuesId(Set<BigInteger> ids) {
            if (Project.this.issuesId == null) {
                Project.this.issuesId = new HashSet<>();
            }
            Project.this.issuesId.addAll(ids);
            return this;
        }

        public ProjectBuilder setRepoName(String repoName) {
            Project.this.repoName = repoName;
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

        public ProjectBuilder setFromDate(Date fromDate) {
            Project.this.fromDate = fromDate;
            return this;
        }

        public ProjectBuilder setToDate(Date toDate) {
            Project.this.toDate = toDate;
            return this;
        }

        public ProjectBuilder setStatus(boolean status) {
            Project.this.status = status;
            return this;
        }

        public ProjectBuilder setReviewId(BigInteger reviewId) {
            if (Project.this.reviewsId == null) {
                Project.this.reviewsId = new HashSet<>();
            }
            Project.this.reviewsId.add(reviewId);
            return this;
        }

        public ProjectBuilder setReviewsId(Set<BigInteger> reviewsId) {
            if (Project.this.reviewsId == null) {
                Project.this.reviewsId = new HashSet<>();
            }
            Project.this.reviewsId.addAll(reviewsId);
            return this;
        }

        public Project build() {
            return Project.this;
        }

    }

}
