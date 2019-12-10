package grouptest;

import org.testng.annotations.Test;

public class TestNGGroupDemo2 {
	//testng5.xml//
	@Test(groups={"windows.regression"})
	public void test1(){
		System.out.println("Inside Test 1");
	}
	
	@Test(groups={"linux.regression"})
	public void test2(){
		System.out.println("Inside Test 2");
	}
	
	@Test(groups={"mac.regression"})
	public void test3(){
		System.out.println("Inside Test 3");
	}
	
	@Test
	public void test4(){
		System.out.println("Inside Test 4");
	}

}
