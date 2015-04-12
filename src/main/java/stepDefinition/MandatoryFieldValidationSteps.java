package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.GmailCreateAccount;
import pageObjects.GoogleLogin;
import pageObjects.GoogleUKHome;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MandatoryFieldValidationSteps {

	WebDriver driver;

	@Before
	public void beforescenario(){
		System.setProperty("webdriver.chrome.driver", "C://ChromeDriver.exe");
		driver = new ChromeDriver();
	}

	@Given("^User is on google UK home page as \"(.*?)\"$")
	public void user_is_on_google_UK_home_page_as(String URL) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.get(URL);
	}

	@When("^User navigates to gmail link$")
	public void user_navigates_to_gmail_link() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		GoogleUKHome homepage = new GoogleUKHome(driver);
		homepage.gotogmail();
	}


	@When("^User enters \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void user_enters(String firstName, String lastName, String password, String birthday, String birthyear, String recoveryPhoneNumber, String skipCaptcha, String checkTermsOfService, String gender, String birthMonth, String country) throws Throwable {

		GoogleLogin loginpage = new GoogleLogin(driver);
		loginpage.click_signup();

		GmailCreateAccount accountcreation = new GmailCreateAccount(driver);
		accountcreation.enterFirstName(firstName);
		accountcreation.enterLastName(lastName);
		accountcreation.enterPassword(password);
		accountcreation.enterPasswdAgain(password);
		accountcreation.enterBirthDay(birthday);
		accountcreation.enterBirthYear(birthyear);
		accountcreation.enterGender(gender);
		accountcreation.enterBirthMonth(Integer.parseInt(birthMonth));
		accountcreation.enterRecoveryPhoneNumber(recoveryPhoneNumber,country);
		accountcreation.clickSkipCaptch(Boolean.parseBoolean(skipCaptcha));
		accountcreation.clickTermsOfService(Boolean.parseBoolean(checkTermsOfService));
	}

	@When("^user clicks on create account button$")
	public void user_clicks_on_create_account_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		GmailCreateAccount accountcreation = new GmailCreateAccount(driver);
		accountcreation.clickSubmitButton();
	}

	@Then("^Username Mandatory Message shoudl be displayed to the user\\.$")
	public void username_Mandatory_Message_shoudl_be_displayed_to_the_user() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals("Message is not diapleyed", "You can't leave this empty.", driver.findElement(By.id("errormsg_0_GmailAddress")).getText());
	}	
	@After
	public void afterscenario(){
		driver.close();
		driver.quit();
	}

}
