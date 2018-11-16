package com.devstr.model.enumerations;

public enum IssuePriority {

    BLOCKER("BLOCKER"),
    CRITICAL("CRITICAL"),
    HIGH("HIGH"),
    MEDIUM("MEDIUM"),
    LOW("LOW"),
    LOWEST("LOWEST");

    String issuePriority;

    private IssuePriority(String issuePriority) {
        this.issuePriority = issuePriority;
    }

    public String getIssuePriority() {
        return issuePriority;
    }

}
