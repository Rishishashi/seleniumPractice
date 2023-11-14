package frameworkdemo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class standAloneTest {

	public static void main(String args[]) {
		String product1 = "ZARA COAT 3";

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("rishi.gone@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Secure*13");
		driver.findElement(By.id("login")).click();
		List<WebElement> addtocart = driver.findElements(By.cssSelector("button[class='btn w-10 rounded']"));
		List<WebElement> productname = driver.findElements(By.className("card-body"));
		for (int i = 0; i < productname.size(); i++) {
			String product = driver.findElements(By.xpath("//div/h5/b")).get(i).getText();
			if (product.equalsIgnoreCase(product1)) {
				addtocart.get(i).click();
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		//WebElement cartElement = driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']"));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[id='toast-container']")))); 
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("div[id='toast-container']")))); 
		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
		
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		WebElement selected = driver.findElement(By.cssSelector("div[class='cartSection']"));
		
		String selectedItem = selected.findElement(By.xpath("h3")).getText();
		System.out.println(selectedItem);
		if (selectedItem.equalsIgnoreCase(product1)) {
			WebElement checkout = driver.findElement(By.cssSelector("div[class='subtotal cf ng-star-inserted']"));
			checkout.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
		}

	}

}
