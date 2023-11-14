package frameworkdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalogue2 {

	WebDriver driver;

	public ProductCatalogue2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "div[class='cartSection']")
	WebElement selectedItem;
	@FindBy(css = "div[class='subtotal cf ng-star-inserted']")
	WebElement checkOut;
	

	public void itemName(String firstProductName) {
		String selectedItem1 = selectedItem.findElement(By.xpath("h3")).getText();
		if (selectedItem1.equalsIgnoreCase(firstProductName)) {
			checkOut.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
		}
	}

}
