package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportBasicMain {
	private static WebDriver driver=null;

	public static void main(String[] args) throws IOException {
		//Start Reporter
		ExtentHtmlReporter htmlReporter= new ExtentHtmlReporter("extentreports.html");
		//Create Extent Report and attach reporter to it
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		//Add Test Name and Description of the test
		ExtentTest tests= extent.createTest("Google Search Page Test", "This step is to perform google search operation");
		tests.log(Status.INFO, "Starting the Test Case");
		
		
		String projectpath= System.getProperty("user.dir");
		System.out.println(projectpath);
		System.setProperty("webdriver.chrome.driver", projectpath+"/drivers/chromedriver/chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("Java");
		tests.pass("Java is written in the Googke search box");
		
		driver.findElement(By.name("btnK")).click();
//		tests.fail("Search  button step failed");
		tests.pass("Search button is clicked successfully");
		
		driver.quit();
		tests.info("Test is completed");
		
		ExtentTest tests1= extent.createTest("Google Search Page Test Two", "This step is to perform google search operation");
		tests1.log(Status.INFO, "Starting the Test Case");
		
		
		String projectpath1= System.getProperty("user.dir");
		System.out.println(projectpath1);
		System.setProperty("webdriver.chrome.driver", projectpath1+"/drivers/chromedriver/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.google.com");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("Java");
		tests1.pass("Java is written in the Googke search box");
		
		driver.findElement(By.name("btnK")).click();
		tests1.fail("Search  button step failed");
	//	tests.pass("Search button is clicked successfully");
		tests1.fail("Search  button step failed", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		tests1.addScreenCaptureFromPath("screenshot.png");
		
		driver.quit();
		tests1.info("Test is completed");
		
		extent.flush();
	}

}
