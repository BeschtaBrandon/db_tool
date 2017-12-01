/*
 * Application.java
 *
 * Copyright 2017: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR.
 * Disclosure, Use or Reproduction without the written authorization of TRGR is prohibited.
 */

package com.thomsonreuters.cm.AutoDbService.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@Component
@JsonPropertyOrder({ "application", "timestamp" })
public class Application
{
    @Value("${server.contextPath}")
    private String application;
    private String timestamp;


    public Application()
    {
        final LocalDateTime now = LocalDateTime.now();
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
        this.timestamp = now.format(formatter);
    }


    public String getApplication()
    {
        return application;
    }


    public void setApplication(String application)
    {
        this.application = application;
    }


    public String getTimestamp()
    {
        return timestamp;
    }


    public void setTimestamp(String timestamp)
    {
        this.timestamp = timestamp;
    }
}
