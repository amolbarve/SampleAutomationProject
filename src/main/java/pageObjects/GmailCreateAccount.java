package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailCreateAccount {
	private final WebDriver driver;
	private By _firstname = By.id("FirstName");
	private By _lastname = By.id("LastName");
	private By _passwd = By.id("Passwd");
	private By _passwdagain = By.id("PasswdAgain");
	private By _birthday = By.id("BirthDay");
	private By _birthyear = By.id("BirthYear");
	private By _recoveryPhoneNumber = By.id("RecoveryPhoneNumber");
	private By _skipCaptcha = By.id("SkipCaptcha");
	private By _submitButton = By.id("submitbutton");
	private By _termsOfService = By.id("TermsOfService");
	private By _genderDropdown = By.xpath("//form/div[@id='gender-form-element']/label/div/div");
	private By _genderMale = By.xpath("//*[@id=':f']/div");
	private By _genderFemale = By.xpath("//*[@id=':e']/div");
	private By _genderOther = By.xpath("//*[@id=':g']/div");
	private By _birthMonthDropdown = By.xpath("//*[@id='BirthMonth']/div[1]");
	private By _phoneCountryDropdown = By.className("i18n-phone-flag");
	String genericBirthMonth = "//fieldset/label[@id='month-label']/span/div/div[@id=':X']";
	private By _birthMonth;

	public GmailCreateAccount(WebDriver driver) {
		this.driver = driver;
	}

	public void enterFirstName(String firstName){
		driver.findElement(_firstname).sendKeys(firstName);
	}

	public void enterLastName(String lastName){
		driver.findElement(_lastname).sendKeys(lastName);
	}

	public void enterPassword(String password){
		driver.findElement(_passwd).sendKeys(password);
	}

	public void enterPasswdAgain(String password){
		driver.findElement(_passwdagain).sendKeys(password);
	}
	public void enterBirthDay(String BirthDay){
		driver.findElement(_birthday).sendKeys(BirthDay);
	}

	public void enterBirthMonth(Integer birthMonth){
		driver.findElement(_birthMonthDropdown).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement element = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//fieldset/label[@id='month-label']/span/div/div[@id=':5']")));
		switch(birthMonth){
		case 1 : genericBirthMonth = genericBirthMonth.replace("X", "1");
				_birthMonth = By.xpath(genericBirthMonth);
				break;
		case 2 : genericBirthMonth = genericBirthMonth.replace("X", "2");
				_birthMonth = By.xpath(genericBirthMonth);
				break;
		case 3 : genericBirthMonth = genericBirthMonth.replace("X", "3");
				_birthMonth = By.xpath(genericBirthMonth);
				break;
		case 4 : genericBirthMonth = genericBirthMonth.replace("X", "4");
				_birthMonth = By.xpath(genericBirthMonth);
				break;
		case 5 : genericBirthMonth = genericBirthMonth.replace("X", "5");
				_birthMonth = By.xpath(genericBirthMonth);
				break;
		case 6 : genericBirthMonth = genericBirthMonth.replace("X", "6");
				_birthMonth = By.xpath(genericBirthMonth);
				break;
		case 7 : genericBirthMonth = genericBirthMonth.replace("X", "7");
				_birthMonth = By.xpath(genericBirthMonth);
				break;
		case 8 : genericBirthMonth = genericBirthMonth.replace("X", "8");
				_birthMonth = By.xpath(genericBirthMonth);
				break;
		case 9 : genericBirthMonth = genericBirthMonth.replace("X", "9");
				_birthMonth = By.xpath(genericBirthMonth);
				break;
		case 10 : genericBirthMonth = genericBirthMonth.replace("X", "10");
				_birthMonth = By.xpath(genericBirthMonth);
				break;
		case 11 : genericBirthMonth = genericBirthMonth.replace("X", "11");
				_birthMonth = By.xpath(genericBirthMonth);
				break;
		case 12 : genericBirthMonth = genericBirthMonth.replace("X", "12");
				_birthMonth = By.xpath(genericBirthMonth);
				break;
		default : genericBirthMonth = genericBirthMonth.replace("X", "1");
				_birthMonth = By.xpath(genericBirthMonth);
				break;
		}


		driver.findElement(_birthMonth).click();

	}


	public void enterBirthYear(String BirthYear){

		driver.findElement(_birthyear).sendKeys(BirthYear);
	}

	public void enterGender(String Gender){
		driver.findElement(_genderDropdown).click();
		if (Gender=="male"){
			driver.findElement(_genderMale).click();	
		}else if (Gender=="female"){
			driver.findElement(_genderFemale).click();
		}else{
			driver.findElement(_genderOther).click();
		}

	}
	public void enterRecoveryPhoneNumber(String recoveryPhNumber, String country){
		driver.findElement(_phoneCountryDropdown).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement element = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div/div/div/span[starts-with(text(),'"+country+"')]")));
		driver.findElement(By.xpath("//div/div/div/span[starts-with(text(),'"+country+"')]")).click();
		driver.findElement(_recoveryPhoneNumber).sendKeys(recoveryPhNumber);
	}

	public void clickSubmitButton(){
		driver.findElement(_submitButton).click();
	}

	public void clickSkipCaptch(Boolean skipCaptcha){
		if(skipCaptcha){
			driver.findElement(_skipCaptcha).click();
		}
	}

	public void clickTermsOfService(Boolean clickTermsOfService){
		if(clickTermsOfService){
			driver.findElement(_termsOfService).click();
		}
	}

}
