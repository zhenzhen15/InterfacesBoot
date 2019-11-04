package cn.springmvc.apitest;

import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import cn.springmvc.model.TestResult;
import cn.springmvc.service.ITestResultService;

/**
 *检查结果入库
 */
public class ApiTestReport implements IReporter {

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		System.out.println(" generateReport-------------- ");
		System.out.println("Passed Case: " + ApiTest.testPassed);
		System.out.println("testFailed Case: " + ApiTest.testFailed);
		System.out.println("testFailed skip: " + ApiTest.testSkip);
		TestResult result = new TestResult();
		result.setResultId(ApiTest.resultId);
		result.setRuntime(ApiTest.runtime);
		result.setSucess(ApiTest.testPassed);
		result.setFail(ApiTest.testFailed);
		result.setSkip(ApiTest.testSkip);
		ITestResultService testResultService = SpringContextUtils.getBean(ITestResultService.class);
		testResultService.addResult(result, ApiTest.alldetailResult);
		reset();
	}
	
	
	//全局变量重置
	private void reset() {
		ApiTest.alldetailResult.clear();
		ApiTest.testFailed=0;
		ApiTest.testPassed=0;
		ApiTest.testSkip=0;
	}

	
}
