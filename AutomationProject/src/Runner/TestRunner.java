package Runner;

import org.junit.runner.RunWith;

import util.sharedData;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(glue = "stepDef", 
                 features = "Features/SFCreatePermission.feature", format = { "html:" + sharedData.parentReportDir +  sharedData.htmlReportName, "json:" + sharedData.parentReportDir + sharedData.jsonReportName }, 
                 tags = { "@SFCreateUser"}, monochrome = true)

public class TestRunner {

}
