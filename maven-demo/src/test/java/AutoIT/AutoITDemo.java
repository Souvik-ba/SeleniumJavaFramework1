package AutoIT;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutoITDemo {
	
	public static void main(String[] args) throws Exception {
		test();
	}
	
	public static void test() throws Exception{
		
		String projectpath= System.getProperty("user.dir");
		System.out.println(projectpath);
		System.setProperty("webdriver.chrome.driver", projectpath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("http://www.tinyupload.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement ele= driver.findElement(By.name("uploaded_file"));
		Actions actions= new Actions(driver);
		actions.moveToElement(ele).click(ele).build().perform();
		//Using AutoIT to upload the .exe script//
		Runtime.getRuntime().exec("D://FileUploadScript.exe");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//img[@src='images/button_upload.gif']")).click();
		Thread.sleep(7000);
		driver.close();
		driver.quit();
	}

}
