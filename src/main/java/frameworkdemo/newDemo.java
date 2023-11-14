package frameworkdemo;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import frameworkdemo.TestComponents.BaseTest;

public class newDemo extends BaseTest {

	@Test(dataProvider= "getData")
	public void submitOrder( HashMap<String,String> input) throws IOException,InterruptedException
	{
		//String firstProductName = "ZARA COAT 3";
		System.out.print("submitOrder Test..");
		LandingPage  landingPage=launchApplication();
    	landingPage.loginApplication(input.get("email"),input.get("password") );
		productCatalogue productCatalogue = new productCatalogue(driver);
		productCatalogue.addingtoCart(input.get("product"));
		ProductCatalogue2 productCatalogue2 = new ProductCatalogue2(driver);
		productCatalogue2.itemName(input.get("product"));
		System.out.print("submitOrder Test..Completed");
	}
	@DataProvider
	public Object [ ] [ ]  getData() throws IOException
	{
		List <HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"//src//main//java//frameworkdemo//data//PurchaseOrder.json");
		return new Object [ ] [ ] {{data.get(0)},{data.get(1)}};
		
	}
	
}
