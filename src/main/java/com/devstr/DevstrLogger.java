package com.devstr;

import org.apache.commons.logging.impl.Log4JLogger;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DevstrLogger extends Log4JLogger {

    private static String INSERT_LOG = "INSERT INTO LOGGER(MSG_LEVEL, MESSAGE) VALUES(?, ?)";
    private static String CLEAR_LOG = "DELETE FROM LOGGER";
    private DataSource dataSource;

    public DevstrLogger(String name, DataSource dataSource){
        super(name);
        this.dataSource = dataSource;
    }

    @Override
    public void trace(Object message, Throwable t) {
        if(SQLException.class.isAssignableFrom(t.getClass()))
            logInDB("TRACE", message + t.getMessage());
        super.trace(message, t);
    }

    @Override
    public void debug(Object message, Throwable t) {
        if(SQLException.class.isAssignableFrom(t.getClass()))
            logInDB("DEBUG", message + t.getMessage());
        super.debug(message, t);
    }

    @Override
    public void info(Object message, Throwable t) {
        if(SQLException.class.isAssignableFrom(t.getClass()))
            logInDB("INFO", message + t.getMessage());
        super.info(message, t);
    }

    @Override
    public void warn(Object message, Throwable t) {
        if(SQLException.class.isAssignableFrom(t.getClass()))
            logInDB("WARNING",message + t.getMessage());
        super.warn(message, t);
    }

    @Override
    public void error(Object message, Throwable t) {
        if(SQLException.class.isAssignableFrom(t.getClass()))
            logInDB("ERROR", message + t.getMessage());
        super.error(message, t);
    }

    @Override
    public void fatal(Object message, Throwable t) {
        if(SQLException.class.isAssignableFrom(t.getClass()))
            logInDB("FATAL", message + t.getMessage());
        super.fatal(message, t);
    }

    public void logDB(String level, String message){
        logInDB(level, message);
    }

    public void setClearLog(){
        if (dataSource != null) {
            try {
                if (dataSource.getConnection() != null) {
                    Statement statement = dataSource.getConnection().createStatement();
                    statement.executeUpdate(CLEAR_LOG);
                }
            } catch (SQLException e) {
                this.error("Cannot delete from Logger table: ", e);
            }
        }
    }

    private void logInDB(String level, String message) {
        if (dataSource != null) {
            try {
                if (dataSource.getConnection() != null) {
                    PreparedStatement statement = dataSource.getConnection().prepareStatement(INSERT_LOG);
                    statement.setString(1, level);
                    statement.setString(2, message);
                    statement.execute();
                }
            } catch (SQLException e) {
                this.error("Cannot insert into Logger table: ", e);
            }
        }
    }
}
