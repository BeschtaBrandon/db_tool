/*
 * AutoDbServiceApplication.java
 *
 * Copyright 2017: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR.
 * Disclosure, Use or Reproduction without the written authorization of TRGR is prohibited.
 */

package com.thomsonreuters.cm.AutoDbService;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import javax.annotation.PostConstruct;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.MissingArgumentException;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.UnrecognizedOptionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thomsonreuters.cm.AutoDbService.service.AutoDbService;


@Component
public class AutoDbServiceApplicationRunner implements ApplicationRunner
{
    @Autowired
    private AutoDbService autoDbService;
    private Options options;
    private CommandLineParser parser;
    private CommandLine cmd;
    private HelpFormatter formatter;


    @PostConstruct
    public void init()
    {
        options = new Options();
        parser = new DefaultParser();
        formatter = new HelpFormatter();

        final Option helpOption = Option.builder("h").longOpt("help").required(false).desc("Shows this message").build();
        final Option scriptPath = Option.builder("s").longOpt("schema").desc("Path to flyway scripts").build();

        options.addOption(helpOption);
        options.addOption(scriptPath);
    }


    public void run(ApplicationArguments args) throws Exception
    {
        try
        {
            cmd = parser.parse(options, args.getSourceArgs());
            if (cmd.hasOption("s"))
            {
                String flywayScriptPath = !cmd.getArgList().isEmpty() ? cmd.getArgList().get(0) : "";
                autoDbService.runDatabaseMigration(flywayScriptPath);
            }
        }
        catch (UnrecognizedOptionException | MissingArgumentException e)
        {
            formatter.printHelp("java -DapplicationProperties={path/to/dbInfo} -DdbMacro={macro} -jar AutoDbService.jar --schema {path/to/script}", options);
        }
        finally
        {
            System.exit(1);
        }
    }

}
