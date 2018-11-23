package com.devstr.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Commit {

    private BigInteger commitId;
    private BigInteger userId;
    private String sha;
    private Date date;
    private Set<CommitClass> commitClasses;
    private boolean buildStatus;
    private String buildSha;

    private Commit() {
    }

    public BigInteger getCommitId() {
        return commitId;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public String getSha() {
        return sha;
    }

    public Date getDate() {
        return date;
    }

    public Set<CommitClass> getCommitClasses() {
        return commitClasses;
    }

    public boolean getBuildStatus() {
        return buildStatus;
    }

    public String getBuildSha() {
        return buildSha;
    }

    public void setCommitClass(CommitClass commitClass) {
        if (this.commitClasses == null) {
            this.commitClasses = new HashSet<>();
        }
        this.commitClasses.add(commitClass);
    }

    public void setCommitClasses(Set<CommitClass> commitClasses) {
        if (this.commitClasses == null) {
            this.commitClasses = new HashSet<>();
        }
        this.commitClasses.addAll(commitClasses);
    }

    public static CommitBuilder builder() {
        return new Commit().new CommitBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commit commit = (Commit) o;

        return getCommitId().equals(commit.getCommitId());
    }

    @Override
    public int hashCode() {
        return getCommitId().hashCode();
    }

    public class CommitBuilder {

        private CommitBuilder() {
        }

        public CommitBuilder setCommitId(BigInteger id) {
            Commit.this.commitId = id;
            return this;
        }

        public CommitBuilder setUserId(BigInteger id) {
            Commit.this.userId = id;
            return this;
        }

        public CommitBuilder setSha(String sha) {
            Commit.this.sha = sha;
            return this;
        }

        public CommitBuilder setDate(Date date) {
            Commit.this.date = date;
            return this;
        }

        public CommitBuilder setCommitClass(CommitClass commitClass) {
            if (Commit.this.commitClasses == null) {
                Commit.this.commitClasses = new HashSet<>();
            }
            Commit.this.commitClasses.add(commitClass);
            return this;
        }

        public CommitBuilder setCommitClasses(Set<CommitClass> commitClasses) {
            if (Commit.this.commitClasses == null) {
                Commit.this.commitClasses = new HashSet<>();
            }
            Commit.this.commitClasses.addAll(commitClasses);
            return this;
        }

        public CommitBuilder setBuildStatus(boolean status) {
            Commit.this.buildStatus = status;
            return this;
        }

        public CommitBuilder setBuildSha(String buildSha) {
            Commit.this.buildSha = buildSha;
            return this;
        }

        public Commit build() {
            return Commit.this;
        }

    }

}
