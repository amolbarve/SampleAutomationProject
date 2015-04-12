package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleUKHome {

	private final WebDriver driver;

	public GoogleUKHome(WebDriver driver) {
		this.driver = driver;
	}
	
	private By gmail_link = By.linkText("Gmail");
	
	
	public void gotogmail(){
		driver.findElement(gmail_link).click();
		
	}
	
	

}
