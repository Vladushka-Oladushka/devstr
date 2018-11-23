package com.devstr.model;

import com.devstr.model.enumerations.IssuePriority;
import com.devstr.model.enumerations.IssueStatus;
import com.devstr.model.enumerations.IssueType;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Issue {

    private BigInteger issueId;
    private String issueKey;
    private IssueType type;
    private IssueStatus status;
    private IssuePriority priority;
    private Date startDate;
    private Date dueDate;
    private BigInteger projectId;
    private BigInteger userId;
    private String reporter;
    private Set<Commit> commits;

    private Issue(){
    }

    public BigInteger getIssueId() {
        return issueId;
    }

    public String getIssueKey() {
        return issueKey;
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

    public Date getStartDate() {
        return startDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public String getReporter() {
        return reporter;
    }

    public Set<Commit> getCommits() {
        return commits;
    }

    public void setCommit(Commit commit) {
        if (this.commits == null) {
            this.commits = new HashSet<>();
        }
        this.commits.add(commit);
    }

    public void setCommits(Set<Commit> commits) {
        if (this.commits == null) {
            this.commits = new HashSet<>();
        }
        this.commits.addAll(commits);
    }

    public static IssueBuilder builder() {
        return new Issue().new IssueBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Issue issue = (Issue) o;

        return getIssueId().equals(issue.getIssueId());
    }

    @Override
    public int hashCode() {
        return getIssueId().hashCode();
    }

    public class IssueBuilder {

        private IssueBuilder() {
        }

        public IssueBuilder setIssueId(BigInteger id) {
            Issue.this.issueId = id;
            return this;
        }

        public IssueBuilder setIssueKey(String key) {
            Issue.this.issueKey = key;
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

        public IssueBuilder setStartDate(Date startDate) {
            Issue.this.startDate = startDate;
            return this;
        }

        public IssueBuilder setDueDate(Date dueDate) {
            Issue.this.dueDate = dueDate;
            return this;
        }

        public IssueBuilder setProjectId(BigInteger id) {
            Issue.this.projectId = id;
            return this;
        }

        public IssueBuilder setUserId(BigInteger id) {
            Issue.this.userId = id;
            return this;
        }

        public IssueBuilder setReporter(String reporter) {
            Issue.this.reporter = reporter;
            return this;
        }

        public IssueBuilder setCommit(Commit commit) {
            if (Issue.this.commits == null) {
                Issue.this.commits = new HashSet<>();
            }
            Issue.this.commits.add(commit);
            return this;
        }

        public IssueBuilder setCommits(Set<Commit> commits) {
            if (Issue.this.commits == null) {
                Issue.this.commits = new HashSet<>();
            }
            Issue.this.commits.addAll(commits);
            return this;
        }

        public Issue build() {
            return Issue.this;
        }

    }

}
