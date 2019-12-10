package TestNGPriority;

import org.testng.annotations.Test;

public class TestNGTestPriority {
	@Test(priority=1)
	public void test1(){
		System.out.println("inside test 1");
	}
	
	@Test(priority=3)
	public void test2(){
		System.out.println("inside test 2");
	}
	
	@Test
	public void test3(){
		System.out.println("inside test 3");
	}

}
