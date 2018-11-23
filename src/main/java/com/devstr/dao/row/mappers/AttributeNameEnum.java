package com.devstr.dao.row.mappers;

/**
 * Created by Robert in 18.11.2018
 */
public enum AttributeNameEnum {

    FIRST_NAME(1),
    LAST_NAME(2),
    EMAIL(3),
    ROLE(4),
    CREATION_DATE(5),
    PASSWORD(6),
    STATUS(7),
    TO_DATE(8),
    GIT_LOGIN(9),
    GIT_PASSWORD(10),
    JIRA_LOGIN(11),
    JIRA_PASSWORD(12),
    REPOSITORY_NAME(13),
    REVIEW_TEXT(14),
    JOB_QUALITY(15),
    JOB_AMOUNT(16),
    COMMUNICATION(17),
    XP_QUALITY(18),
    TEAM_SPIRIT(19),
    ORGANIZATION(20),
    TIME_MANAGMENT(21),
    SERVICE_NAME(22),
    TOKEN(23),
    TOKEN_CODE(24),
    REVIEWS(25),
    PROJECT_USERS(26),
    REVIEW_AUTHOR(27),
    PROJECT(28);

    private int id;

    AttributeNameEnum(int id) {
        this.id = id;
    }

    int getId() {
        return id;
    }

}
