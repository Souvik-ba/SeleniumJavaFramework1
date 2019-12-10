package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPage;

public class TestNGGoogleSearchPage {
	static WebDriver driver= null;
	public static void main(String[] args) {
		try {
			testGoogleSearchPage();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
	public static void testGoogleSearchPage() throws InterruptedException {
		
		String projectpath= System.getProperty("user.dir");
		System.out.println(projectpath);
		System.setProperty("webdriver.chrome.driver", projectpath+"/drivers/chromedriver/chromedriver.exe");
		
		driver= new ChromeDriver();
		GoogleSearchPage googlesearchpage = new GoogleSearchPage(driver);
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		googlesearchpage.GoogleSearchBox("JAVA");
		googlesearchpage.ClickSearchButton();
		
		Thread.sleep(3000);
		driver.close();
		
		
	}

}
