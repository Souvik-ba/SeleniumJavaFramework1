package TesNGParameter;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParametersDemo {
	//testng8.xml
	
	@Test
	@Parameters({"name"})
	public void test1(@Optional("Raghav") String name){
		System.out.println("My name is : "+name);
	}
	
//	@Test
//	public void test2(){
//		System.out.println("Inside Test 2");
//	}
//	
//	@Test
//	public void test3(){
//		System.out.println("Inside Test 3");
//	}

}
