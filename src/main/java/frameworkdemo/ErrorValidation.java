package frameworkdemo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import frameworkdemo.TestComponents.BaseTest;

public class ErrorValidation extends BaseTest {

	@Test
	public void submitOrder() throws IOException {
	//	String firstProductName = "ZARA COAT 3";
		LandingPage landingPage = launchApplication();
		landingPage.loginApplication("rishi.gone@gmail.com", "Sacure*13");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}
}
