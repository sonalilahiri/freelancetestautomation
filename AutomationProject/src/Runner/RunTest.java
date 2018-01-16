package Runner;

import org.junit.runner.RunWith;

import util.sharedData;
import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(glue = "stepDef", 
                 features = "Features", format = { "html:" + sharedData.parentReportDir +  sharedData.htmlReportName, "json:" + sharedData.parentReportDir + sharedData.jsonReportName }, monochrome = true)

public class RunTest extends AbstractTestNGCucumberTests {

}
