package com.devstr.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Commit {

    private int commitId;
    private int userId;
    private String sha;
    private LocalDate date;
    private Set<CommitClass> commitClasses;
    private boolean buildStatus;
    private String buildSha;

    private Commit() {
    }

    public int getCommitId() {
        return commitId;
    }

    public int getUserId() {
        return userId;
    }

    public String getSha() {
        return sha;
    }

    public LocalDate getDate() {
        return date;
    }

    public Set<CommitClass> getCommitClasses() {
        return commitClasses;
    }

    public boolean isBuildStatus() {
        return buildStatus;
    }

    public String getBuildSha() {
        return buildSha;
    }

    public static CommitBuilder builder() {
        return new Commit().new CommitBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commit commit = (Commit) o;

        if (commitId != commit.commitId) return false;
        return sha.equals(commit.sha);
    }

    @Override
    public int hashCode() {
        int result = commitId;
        result = 31 * result + sha.hashCode();
        return result;
    }

    public class CommitBuilder {

        private CommitBuilder() {
        }

        public CommitBuilder setCommitId(int id) {
            Commit.this.commitId = id;
            return this;
        }

        public CommitBuilder setUserId(int id) {
            Commit.this.userId = id;
            return this;
        }

        public CommitBuilder setSha(String sha) {
            Commit.this.sha = sha;
            return this;
        }

        public CommitBuilder setDate(LocalDate date) {
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
