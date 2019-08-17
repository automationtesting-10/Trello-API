package com.foundation.trello.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

/**
 * ReportTrello class.
 *
 * @author Limbert Alvaro Vargas Laura.
 * @version 0.0.1
 */
public class ReportTrello {
    /**
     * This method gets an instance of ReportTrello from getInstance.
     *
     * @return an instance ReportTrello.
     */
    public static ReportTrello getInstance() {
        return new ReportTrello();
    }

    /**
     * This method set up and create a report.
     */
    public void generateReport() {
        final File reportOutputDirectory = new File("target");
        final List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber.json");

        final String projectName = "TRELLO";
        final boolean runWithJenkins = false;

        final Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        // additional metadata presented on main page.
        configuration.addClassifications("Platform", "WINDOWS");
        configuration.addClassifications("Branch", "RELEASE/1.0");
        final ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        // and here validate 'result' to decide what to do if report has failed.
        final Reportable result = reportBuilder.generateReports();
    }
}
