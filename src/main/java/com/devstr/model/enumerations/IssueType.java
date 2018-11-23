package com.devstr.model.enumerations;

public enum IssueType {

    BUG("BUG"),
    IMPROVEMENT("IMPROVEMENT"),
    TASK("TASK"),
    NEW_FEATURE("NEW_FEATURE"),
    DESIGN_BUG("DESIGN_BUG"),
    EPIC("EPIC");

    String issueType;

    private IssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getFullName() {
        return issueType;
    }

}
