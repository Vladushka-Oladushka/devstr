package com.devstr.dao.impl;

import com.devstr.dao.ProjectDAO;
import com.devstr.model.Project;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Set;

/**
 * Created by Robert in 18.11.2018
 */
public class ProjectDAOImpl implements ProjectDAO {

    JdbcTemplate jdbcTemplate;

    @Override
    public void createProject(String name, int managerId, int techId, Set<Integer> devs, String repoName, String gitLogin, String gitPass, String jiraLogin, String jiraPass) {

    }

    @Override
    public Project readProjectById(int projectID) {
        return null;
    }

    @Override
    public Project readProjectByName(String projectName) {
        return null;
    }

    @Override
    public void updateProject(Project project) {

    }
}
