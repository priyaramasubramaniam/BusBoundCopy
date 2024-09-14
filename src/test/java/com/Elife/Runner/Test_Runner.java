package com.Elife.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/RideCreation.feature",
        glue = "com.Elife.StepDefinitions",
        dryRun = false,
        tags = "@1",
        monochrome = true,
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class Test_Runner {

}
