package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.GoogleSearchPage;



public class TestGoogleSearchPage2 {
	WebDriver driver= null;

	
	@BeforeTest
	public void setUp(){
		String projectpath= System.getProperty("user.dir");
		System.out.println(projectpath);
		System.setProperty("webdriver.chrome.driver", projectpath+"/drivers/chromedriver/chromedriver.exe");
		driver= new ChromeDriver();
		
	
	}

	@Test
	public void testGoogleSearchPage(){

		
		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		GoogleSearchPage gs = new GoogleSearchPage(driver);
		gs.GoogleSearchBox("Java");
	
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();	
	}

}
