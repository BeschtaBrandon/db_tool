/*
 * AutoDbServiceApplication.java
 *
 * Copyright 2017: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR.
 * Disclosure, Use or Reproduction without the written authorization of TRGR is prohibited.
 */

package com.thomsonreuters.cm.AutoDbService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AutoDbServiceApplication
{

    /**
     * Main method for Spring Boot and Jetty
     *
     * @param args Passed as arguments to the Spring Application
     * @throws Exception
     */
    public static void main(String[] args)
    {
        SpringApplication application = new SpringApplication(AutoDbServiceApplication.class);
        application.setWebEnvironment(false);
        application.run(args);
    }
}
