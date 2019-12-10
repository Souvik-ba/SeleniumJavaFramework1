package browsertest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelBrowserTest {
	WebDriver driver=null;
	String projectpath= System.getProperty("user.dir");
	
	@Parameters("browsername")
	//String browsername="ie";
	@BeforeTest
	public void setUp(String browsername){
		System.out.println("Number of thread is : "+Thread.currentThread().getId());
		
		
		if(browsername.equalsIgnoreCase("chrome")){
			System.out.println("Inside chrome");
			System.setProperty("webdriver.chrome.driver", projectpath+"/drivers/chromedriver/chromedriver.exe");
			driver= new ChromeDriver();
		}
		
		else if (browsername.equalsIgnoreCase("firefox")) {
			System.out.println("Inside firefox");
			System.setProperty("webdriver.gecko.driver", projectpath+"/drivers/geckodriver/geckodriver.exe");
			driver= new FirefoxDriver();
		} 
		
		else if (browsername.equalsIgnoreCase("ie")) {
			System.out.println("Inside IE");
			System.setProperty("webdriver.ie.driver", projectpath+"/drivers/iedriver/IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		} 
		
	}
	
	@Test
	public void test() throws Exception{
		
		driver.get("https://www.google.com");
		Thread.sleep(2000);
		
	}
	
	@AfterTest
	public void tearDown(){
		driver.close();
		driver.quit();
		
	}

}
