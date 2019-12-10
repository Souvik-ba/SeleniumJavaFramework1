package tests;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class HeadlessBrowsers {
	public static void main(String[] args) throws Exception {
		test();
	}
	
	public static WebDriver driver;
	public static void test() throws Exception{
		String projectpath= System.getProperty("user.dir");
		System.out.println(projectpath);
		System.setProperty("webdriver.chrome.driver", projectpath+"/drivers/chromedriver/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		
		driver= new ChromeDriver(options);
		
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("q")).sendKeys("abcd");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		Thread.sleep(2000);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(30))
			       .pollingEvery(Duration.ofSeconds(2))
			       .ignoring(NoSuchElementException.class);

			   WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			    	 
			    	 WebElement ele= driver.findElement(By.xpath("//a[@class='Q6Pnse']/span[text()='Shop on Google']"));
			    	 /*if(ele.isSelected()){
			    		 System.out.println("Congrats");
			    	 }*/
			    	 System.out.println("Congrats");
			       return ele;
			     }
			   });
			   
			   
			
			   element.click();
			   System.out.println("Test is success");
		
		
//		Thread.sleep(4000);
		
		driver.quit();
		
	}

}
