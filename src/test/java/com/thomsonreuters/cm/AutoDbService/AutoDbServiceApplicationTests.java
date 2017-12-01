/*
 * AutoDbServiceApplicationTests.java
 *
 * Copyright 2017: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR.
 * Disclosure, Use or Reproduction without the written authorization of TRGR is prohibited.
 */

package com.thomsonreuters.cm.AutoDbService;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * Test for the AutoDbServiceApplication class.
 */

@SpringBootTest
public class AutoDbServiceApplicationTests
{

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Test
    public void AutoDbServiceTest() throws IOException
    {
        String testPropsFile = System.getProperty("applicationProperties");
        Properties testProperties = new Properties();
        testProperties.load(new FileInputStream(testPropsFile));
        Map<String, String> testMap = (Map) testProperties;
        assertThat(testMap.get("jdbc.url")).isEqualTo("localhost");
        assertThat(testMap.get("jdbc.username")).isEqualTo("testUser");
        assertThat(testMap.get("jdbc.password")).isEqualTo("testPass");
    }


    @Before
    public void setup() throws IOException
    {
        String[] appProps = new String[3];
        appProps[0] = "jdbc.url=localhost";
        appProps[1] = "jdbc.username=testUser";
        appProps[2] = "jdbc.password=testPass";
        File appPropsFile = File.createTempFile("test", ".properties");
        BufferedWriter writer = new BufferedWriter(new FileWriter(appPropsFile));
        for (String prop : appProps)
        {
            writer.write(prop);
            writer.write("\n");
        }
        writer.close();
        System.setProperty("applicationProperties", appPropsFile.getAbsolutePath());
    }
}
