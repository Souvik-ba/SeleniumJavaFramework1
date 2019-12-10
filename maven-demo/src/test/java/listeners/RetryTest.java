package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer{
	private int retryTestCount=0;
	private static final int maxRetryTestCount=3;

	public boolean retry(ITestResult result) {
		if(retryTestCount<maxRetryTestCount){
			retryTestCount++;
			return true;
		}
		
		return false;
	}

}
