package utils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCase implements IRetryAnalyzer {
	int maxCount=3;
	int retry=0;
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(!result.isSuccess() && retry<maxCount) {
			retry++;
			return true;
		}
		return false;
	}

}
