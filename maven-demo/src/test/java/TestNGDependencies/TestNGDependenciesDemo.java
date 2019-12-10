package TestNGDependencies;

import org.testng.annotations.Test;

public class TestNGDependenciesDemo {
	//testng9.xml
//	@Test(dependsOnMethods={"test2"}, priority=1)
//	@Test(dependsOnGroups={"sanity1"})
	@Test(dependsOnGroups={"car.*"})
	public void test1(){
		System.out.println("Inside Test 1");
	}
	
//	@Test(priority=2)
//	@Test(groups={"sanity1","smoke1"})
	@Test(groups={"car.regression"})
	public void test2(){
		System.out.println("Inside Test 2");
	}
	
//	@Test(groups={"regression1"})
	@Test(groups={"auto.regression"})
	public void test3(){
		System.out.println("Inside Test 3");
	}
	
	

}
