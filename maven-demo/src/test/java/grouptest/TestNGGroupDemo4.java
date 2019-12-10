package grouptest;

import org.testng.annotations.Test;

@Test(groups={"Automation"})
public class TestNGGroupDemo4 {
	//testng7.xml//
	@Test(groups={"smoke","sanity"})
	public void test1(){
		System.out.println("Inside Test 1");
	}
	
	@Test(groups={"smoke"})
	public void test2(){
		System.out.println("Inside Test 2");
	}
	
	@Test(groups={"smoke","sanity","regression"})
	public void test3(){
		System.out.println("Inside Test 3");
	}
	
	@Test
	public void test4(){
		System.out.println("Inside Test 4");
	}

}
