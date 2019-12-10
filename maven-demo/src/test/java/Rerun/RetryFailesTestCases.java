package Rerun;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryFailesTestCases {
	
	@Test
	public void test1(){
		System.out.println("Inside Test 1");
	}
	
	@Test(retryAnalyzer = listeners.RetryTest.class)
	public void test2(){
		System.out.println("Inside Test 2");
		int i=1/0;
	}
	
	@Test
	public void test3(){
		System.out.println("Inside Test 3");
		Assert.fail();
	}

}
