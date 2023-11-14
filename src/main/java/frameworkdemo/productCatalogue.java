package frameworkdemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productCatalogue extends abstractComponent {
	WebDriver driver;

	public productCatalogue(WebDriver driver) {
		super(driver);
		driver = super.driver;
	}

	@FindBy(css = "button[class='btn w-10 rounded']")
	List<WebElement> addtoCartButtons;
	@FindBy(className = "card-body")
	List<WebElement> productCards;
	@FindBy(xpath = "//div/h5/b")
	List<WebElement> productNames;
	@FindBy(css = "button[routerlink='/dashboard/cart']")
	WebElement cart;
	By msgDisplay = By.cssSelector("div[id='toast-container']");

	public void addingtoCart(String firstProductName) {
		for (int i = 0; i < productCards.size(); i++) {
			String productName = productNames.get(i).getText();
			System.out.println(productName);
			System.out.println(firstProductName);
			if (productName.equalsIgnoreCase(firstProductName)) {
				System.out.println("matching");
				addtoCartButtons.get(i).click();
				super.waitForElementToAppear(msgDisplay);
				super.waitForElementToDisappear(msgDisplay);
				cart.click();

			}

		}
	}
}