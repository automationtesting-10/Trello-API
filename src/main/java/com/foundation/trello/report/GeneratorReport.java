package com.foundation.trello.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;


/**
 * GeneratorReport class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class GeneratorReport {
    /**
     * The method getInstance get a instance of GeneratorReport.
     *
     * @return an instance GeneratorReport
     */
    public static GeneratorReport getInstance() {
        return new GeneratorReport();
    }

    /**
     * The method generateReport is to set up and create a report.
     */
    public void generateReport() {
        final File reportOutputDirectory = new File("target");
        final List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber.json");

        final String projectName = "TRELLO";
        final boolean runWithJenkins = false;

        final Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        // additional metadata presented on main page
        configuration.addClassifications("Platform", "WINDOWS");
//        configuration.addClassifications("Browser", WebDriverConfig.getInstance().getBrowserType().toString());
        configuration.addClassifications("Branch", "RELEASE/1.0");
//        configuration.addClassifications("Layout", PageLayoutConfig.getPageLayoutName().toString());
        final ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        final Reportable result = reportBuilder.generateReports();
        // and here validate 'result' to decide what to do if report has failed
    }
}
