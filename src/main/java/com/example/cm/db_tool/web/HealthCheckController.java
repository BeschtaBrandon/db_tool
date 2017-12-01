/*
 * HealthCheckController.java
 *
 * Copyright 2017: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR.
 * Disclosure, Use or Reproduction without the written authorization of TRGR is prohibited.
 */

package com.thomsonreuters.cm.AutoDbService.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thomsonreuters.cm.AutoDbService.domain.HealthCheck;
import com.thomsonreuters.cm.AutoDbService.service.HealthCheckService;


@RestController
public class HealthCheckController
{
    @Autowired
    HealthCheckService healthCheckService;


    @RequestMapping(value = "/health-check", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity<HealthCheck> find()
    {
        return new ResponseEntity<HealthCheck>(healthCheckService.findCheck(), HttpStatus.OK);
    }
}
