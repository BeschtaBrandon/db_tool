/*
 * HealthCheckService.java
 *
 * Copyright 2017: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR.
 * Disclosure, Use or Reproduction without the written authorization of TRGR is prohibited.
 */

package com.thomsonreuters.cm.AutoDbService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomsonreuters.cm.AutoDbService.domain.Application;
import com.thomsonreuters.cm.AutoDbService.domain.HealthCheck;


/**
 * Allows access to the healthCheck data
 */

@Service("healthCheckService")
public class HealthCheckService
{
    @Autowired
    private Application application;


    public HealthCheck findCheck()
    {
        HealthCheck healthCheck = new HealthCheck();
        healthCheck.applications = findAll();
        return healthCheck;
    }


    private List<Application> findAll()
    {
        List<Application> apps = new ArrayList<Application>();
        apps.add(application);
        return apps;
    }
}
