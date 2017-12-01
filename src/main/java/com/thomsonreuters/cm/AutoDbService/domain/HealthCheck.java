/*
 * HealthCheck.java
 *
 * Copyright 2017: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR.
 * Disclosure, Use or Reproduction without the written authorization of TRGR is prohibited.
 */

package com.thomsonreuters.cm.AutoDbService.domain;

import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class HealthCheck
{
    public List<Application> applications;
    @SuppressWarnings("unused")
    private int numberOfApplications;


    public int getNumberOfApplications()
    {
        return applications.size();
    }
}
