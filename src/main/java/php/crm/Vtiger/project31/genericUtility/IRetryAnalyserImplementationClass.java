package php.crm.Vtiger.project31.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnalyserImplementationClass implements IRetryAnalyzer{
	int count=0;
	int limit=3;

	@Override
	public boolean retry(ITestResult result) {
		while(count<limit) {
			count++;
			return true;
		}
		return false;
	}

}
