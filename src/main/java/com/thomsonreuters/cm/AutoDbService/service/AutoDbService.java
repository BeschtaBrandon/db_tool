/*
 * AutoDbService.java
 *
 * Copyright 2017: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR.
 * Disclosure, Use or Reproduction without the written authorization of TRGR is prohibited.
 */

package com.thomsonreuters.cm.AutoDbService.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomsonreuters.cm.AutoDbService.domain.Application;
import com.thomsonreuters.cm.AutoDbService.domain.Database;

import constants.PropertyPrefix;
import oracle.jdbc.pool.OracleDataSource;


/**
 * Allows access to the database connection information
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
@Service("autoDbService")
public class AutoDbService implements InitializingBean
{
    @Autowired
    private Application application;
    private Properties appProperties;
    private String dbMacro;
    private Database db = new Database();
    private Flyway flyway;
    private final Logger LOGGER = LoggerFactory.getLogger(AutoDbService.class);


    public AutoDbService() throws FileNotFoundException, IOException
    {
        String appPropsFile = System.getProperty("applicationProperties");
        dbMacro = System.getProperty("dbMacro");
        appProperties = new Properties();
        appProperties.load(new FileInputStream(appPropsFile));
        Map<String, String> dbConnectionInfo = (Map) appProperties;
        db = getDatabase(dbConnectionInfo);
        flyway = buildFlywayInstance();
    }


    public Application find() throws Exception
    {
        afterPropertiesSet();
        return application;
    }


    public void runDatabaseMigration(String flywayScriptPath) throws Exception
    {
        LOGGER.info("Location from where to read scripts: " + flywayScriptPath);
        flyway.setLocations("filesystem:" + flywayScriptPath);
        flyway.migrate();
    }


    private Database getDatabase(Map<String, String> dbConnectionInfo)
    {

        db.setUrl(dbConnectionInfo.get(String.format("%s.%s", dbMacro, PropertyPrefix.URL.getPrefix())));
        db.setUser(dbConnectionInfo.get(String.format("%s.%s", dbMacro, PropertyPrefix.USERNAME.getPrefix())));
        db.setPass(dbConnectionInfo.get(String.format("%s.%s", dbMacro, PropertyPrefix.PASSWORD.getPrefix())));
        return db;
    }


    @Override
    public void afterPropertiesSet() throws Exception
    {
        String name = application.getApplication();
        application.setApplication(name.replace("/", ""));
    }


    private static DataSource getDatasource(final String url, final String username, final String password)
    {
        OracleDataSource dataSource;
        try
        {
            dataSource = new OracleDataSource();
            dataSource.setUser(username);
            dataSource.setPassword(password);
            dataSource.setURL(url);

            // this tests the connection
            dataSource.getConnection().close();
        }
        catch (SQLException exception)
        {
            throw new IllegalStateException("Incorrect connection information!");
        }
        return dataSource;
    }


    private Flyway buildFlywayInstance()
    {
        flyway = new Flyway();
        flyway.setBaselineOnMigrate(true);
        flyway.setPlaceholderReplacement(false);
        flyway.setDataSource(getDatasource(db.getUrl(), db.getUser(), db.getPass()));
        flyway.setCleanDisabled(true);
        return flyway;
    }
}
