/*
 * AutoDbServiceController.java
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

import com.thomsonreuters.cm.AutoDbService.service.AutoDbService;


@RestController
public class AutoDbServiceController
{
    @Autowired
    AutoDbService autoDbService;


    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity<AutoDbService> index() throws Exception
    {
        return new ResponseEntity<AutoDbService>(new AutoDbService(), HttpStatus.OK);
    }

}
