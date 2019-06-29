package com.orangehrm.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features"
,glue={"com/orangehrm/steps"}
//,dryRun=true
,monochrome=true
,plugin= {"pretty","html:target/cucumber-reports","junit:target/cucumber-result.xml","json:target/cucumber.json"}
,tags= {"@temp"}
)
public class TestRunner {

}
