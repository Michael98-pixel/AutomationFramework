package com.itstep.aliexpress;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"de.monochromata.cucumber.report.PrettyReports:target/cucumber"},
        stepNotifications = true,
        tags = "@Scenario2",
        features = "src/test/resources/",
        glue = {"MyScenarios","hooks"}

)

public class CucumberTest {

}
