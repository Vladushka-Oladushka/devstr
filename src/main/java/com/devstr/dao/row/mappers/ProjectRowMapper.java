package com.devstr.dao.row.mappers;

import com.devstr.model.Project;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Robert in 18.11.2018
 */
public class ProjectRowMapper implements RowMapper<Project> {

    @Override
    public Project mapRow(ResultSet resultSet, int i) throws SQLException {
        return Project.builder()
                .setProjectId(resultSet.getBigDecimal("OBJECT_ID").toBigInteger())
                .setProjectName(resultSet.getString(AttributeNameEnum.PROJECT.getId()))
                .setProjectManagerId(resultSet.getBigDecimal("OBJECT_TYPE_ID").toBigInteger())
                .setTechnicalManagerId(resultSet.getBigDecimal("OBJECT_TYPE_ID").toBigInteger())
                .setFromDate(resultSet.getDate(AttributeNameEnum.CREATION_DATE.getId()))
                .setToDate(resultSet.getDate(AttributeNameEnum.TO_DATE.getId()))
                .setStatus(resultSet.getBoolean(AttributeNameEnum.STATUS.getId()))
                .setRepoName(resultSet.getString(AttributeNameEnum.REPOSITORY_NAME.getId()))
                .setGitLogin(resultSet.getString(AttributeNameEnum.GIT_LOGIN.getId()))
                .setGitPassword(resultSet.getString(AttributeNameEnum.GIT_PASSWORD.getId()))
                .setJiraLogin(resultSet.getString(AttributeNameEnum.JIRA_LOGIN.getId()))
                .setJiraPassword(resultSet.getString(AttributeNameEnum.JIRA_PASSWORD.getId()))
                .build();

    }
}
