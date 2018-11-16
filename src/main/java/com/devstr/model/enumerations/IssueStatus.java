package com.devstr.model.enumerations;

public enum IssueStatus {

    OPEN("OPEN"),
    IN_PROGRESS("IN_PROGRESS"),
    READY_FOR_TESTING("READY_FOR_TESTING"),
    CLOSED("CLOSED"),
    REOPEN("REOPEN");

    String issueStatus;

    private IssueStatus(String issueStatus) {
        this.issueStatus = issueStatus;
    }

    public String getIssueStatus() {
        return issueStatus;
    }

}
