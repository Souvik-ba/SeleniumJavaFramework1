package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportBasicTestNG {
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest tests;
	
	@BeforeSuite
	public void setUp(){
		System.out.println("Setup Executed");
		htmlReporter= new ExtentHtmlReporter("extentreports.html");
		extent= new ExtentReports();
		extent.attachReporter(htmlReporter);
		
	}
	
	@BeforeTest
	public void setUpTest(){
		
		System.out.println("Setup Test Executed");
 
		String project_path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", project_path+"/drivers/chromedriver/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
	}
	
	@Test
	public void test() throws Exception{
		System.out.println("Test executed");
		tests= extent.createTest("Amazon Website", "Automating Amazon Website");
		driver.get("https://www.amazon.in");
		tests.log(Status.INFO, "Opening Amazon Website");
	
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("mobile");
		tests.pass("In the search bar typing Mobile");
		driver.findElement(By.xpath("//input[@type='submit' and @value='Go']")).click();
		tests.pass("After writing Mobile, Clicking the Search button");
		tests.pass("List Of Mobile is displayed", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		tests.addScreenCaptureFromPath("screenshot.png");
	}
	
	@AfterTest
	public void tearDownTest() throws InterruptedException {
		System.out.println("Tear Down Test executed");
		Thread.sleep(2000);
		
		driver.quit();
		tests.info("Amazon Website Testing is successful");
		
	}
	@AfterSuite
	private void tearDown() {
		System.out.println("Tear Down executed");
		extent.flush();
	}

}
