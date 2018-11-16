package com.devstr.model;

import com.devstr.model.enumerations.IssuePriority;
import com.devstr.model.enumerations.IssueStatus;
import com.devstr.model.enumerations.IssueType;

import java.time.LocalDate;

public class Issue {

    private int issueId;
    private String issueKey;
    private int projectId;
    private IssueType type;
    private IssueStatus status;
    private IssuePriority priority;
    private LocalDate startDate;
    private LocalDate dueDate;
    private int userId;
    private String reporter;
    private Commit commit;

    private Issue(){
    }

    public int getIssueId() {
        return issueId;
    }

    public String getIssueKey() {
        return issueKey;
    }

    public int getProjectId() {
        return projectId;
    }

    public IssueType getType() {
        return type;
    }

    public IssueStatus getStatus() {
        return status;
    }

    public IssuePriority getPriority() {
        return priority;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public int getUserId() {
        return userId;
    }

    public String getReporter() {
        return reporter;
    }

    public Commit getCommit() {
        return commit;
    }

    public static IssueBuilder builder() {
        return new Issue().new IssueBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Issue issue = (Issue) o;

        if (issueId != issue.issueId) return false;
        return issueKey.equals(issue.issueKey);
    }

    @Override
    public int hashCode() {
        int result = issueId;
        result = 31 * result + issueKey.hashCode();
        return result;
    }

    public class IssueBuilder {

        private IssueBuilder() {
        }

        public IssueBuilder setIssueId(int id) {
            Issue.this.issueId = id;
            return this;
        }

        public IssueBuilder setIssueKey(String key) {
            Issue.this.issueKey = key;
            return this;
        }

        public IssueBuilder setProjectId(int id) {
            Issue.this.projectId = id;
            return this;
        }

        public IssueBuilder setIssueType(IssueType type) {
            Issue.this.type = type;
            return this;
        }

        public IssueBuilder setIssueStatus(IssueStatus status) {
            Issue.this.status = status;
            return this;
        }

        public IssueBuilder setIssuePriority(IssuePriority priority) {
            Issue.this.priority = priority;
            return this;
        }

        public IssueBuilder setStartDate(LocalDate startDate) {
            Issue.this.startDate = startDate;
            return this;
        }

        public IssueBuilder setDueDate(LocalDate dueDate) {
            Issue.this.dueDate = dueDate;
            return this;
        }

        public IssueBuilder setUserId(int id) {
            Issue.this.userId = id;
            return this;
        }

        public IssueBuilder setReporter(String reporter) {
            Issue.this.reporter = reporter;
            return this;
        }

        public IssueBuilder setCommit(Commit commit) {
            Issue.this.commit = commit;
            return this;
        }

        public Issue build() {
            return Issue.this;
        }

    }

}
