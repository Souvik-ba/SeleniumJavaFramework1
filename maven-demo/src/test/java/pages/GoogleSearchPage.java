package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {
	WebDriver driver= null;
	By searchbox= By.name("q");
	By searchbutton= By.name("btnK");
	
	//Creating a Constructor for Web Driver//
	public GoogleSearchPage(WebDriver driver){
		this.driver=driver;
	}
	
	//TS 1//
	public void GoogleSearchBox(String text){
		driver.findElement(searchbox).sendKeys(text);
	}
	
	//TS 2//
	public void ClickSearchButton(){
		driver.findElement(searchbutton).sendKeys(Keys.RETURN);
	}

}
