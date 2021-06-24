package utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LearnExtentReports {

	public static void main(String[] args) throws IOException {
//		To create a physical report
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./reports/result.html");
		
//		To get the previous execution of the reports or get the previous execution history
		reporter.setAppendExisting(true);
//		To create actual data
		ExtentReports extent=new ExtentReports();
//		Attach the data to physical report
		extent.attachReporter(reporter);
		
		ExtentTest testcase = extent.createTest("Files", "File to upload");
		
		testcase.assignAuthor("Saran");
		testcase.assignCategory("Functional Testing");
		testcase.pass("Successfully Uploaded",MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/SolutionArchitect.png").build());
		extent.flush();
		

	}

}
