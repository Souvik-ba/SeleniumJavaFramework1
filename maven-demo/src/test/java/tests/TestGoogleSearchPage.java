package tests;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile_demo;
import pages.GoogleSearchPage;



public class TestGoogleSearchPage {
	WebDriver driver= null;
	public static String browserName=null;
	
	

	
	@BeforeTest
	public void setUp() throws IOException{
		String projectpath= System.getProperty("user.dir");
		PropertiesFile_demo.getProperties();
		if(browserName.equalsIgnoreCase("chrome")){
			
		System.setProperty("webdriver.chrome.driver", projectpath+"/drivers/chromedriver/chromedriver.exe");
		driver= new ChromeDriver();
		
		}
		
		if(browserName.equalsIgnoreCase("Firefox")){
			System.out.println("Inside Firefox condition");
			
		}
		
	
	}

	@Test
	public void testGoogleSearchPage(){

		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("Java");
//		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
//		System.out.println("baal");
		
		
	}
	
	@AfterTest
	public void tearDown() throws IOException{
		driver.quit();	
		PropertiesFile_demo.setProperties();
	}

}
