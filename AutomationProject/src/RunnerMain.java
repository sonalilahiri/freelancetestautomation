

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import util.sharedData;
import util.general.tools;
import Runner.TestRunner;

public class RunnerMain {

	public static void main(String[] args) {
			//System.out.println("browserUnderTest :" + util.sharedData.browserUnderTest + ":");
			//System.out.println("util.sharedData.URLUnderTest : " + util.sharedData.URLUnderTest);
			//System.out.println("pomSheetInstance : " + sharedData.pomSheetInstance);
		    //System.out.println("autPosition : " + sharedData.autPosition);
			//util.general.MailUtil.getTable("H:\\Java_Things\\GoAsULike\\SeleniumCucks\\Reports\\GeneratdReports\\Test Env1\\2017-01-16\\feature-overview.html", "stats-table table-hover tablesorter tablesorter-default");
		try {
			Result result = JUnitCore.runClasses(TestRunner.class);
			for (Failure failure : result.getFailures()) {
				System.out.println(failure.toString());
			}
			System.out.println(result.wasSuccessful());

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		//System.out.println("From Main : " + util.general.tools.copyFile(sharedData.parentReportDir + sharedData.jsonReportName, sharedData.backupReportDir, true));
		List<String> reportFiles = new ArrayList<String>();
		//reportFiles.add(util.general.tools.copyFile(sharedData.parentReportDir + sharedData.jsonReportName, sharedData.backupReportDir, true));
		reportFiles.add(sharedData.parentReportDir + sharedData.jsonReportName);
		String message = util.general.ReportUtil.generateJSONReport( reportFiles );
		System.out.println("message : " + message );
		try {
			System.out.println("message : " + message );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
