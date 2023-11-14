package frameworkdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends abstractComponent{
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userEmail")
	WebElement username;

	@FindBy(id = "userPassword")
	WebElement Password;

	@FindBy(id = "login")
	WebElement login;
	
  @FindBy(className="toast-message")
     	WebElement errormessage;
	//div[aria-label='Incorrect email or password.']
	////div[@aria-label='Incorrect email or password.']

	public void loginApplication(String email, String password) {
		username.sendKeys(email);
		Password.sendKeys(password);
		login.click();

	}
	public String getErrorMessage()
	{
		waitForElementToAppear(errormessage);
		return errormessage.getText();
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}
