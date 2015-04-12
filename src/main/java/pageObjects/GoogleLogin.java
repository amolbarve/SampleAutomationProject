package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleLogin {
	private final WebDriver driver;

	public GoogleLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	private By gmail_signup = By.id("link-signup");
	
	public void click_signup(){
		driver.findElement(gmail_signup).click();
	}
}
