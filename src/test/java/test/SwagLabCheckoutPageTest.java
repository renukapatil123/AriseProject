package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.SwagLabCartPage;
import pom.SwagLabCheckoutPage;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;

public class SwagLabCheckoutPageTest extends BaseTest {
	@BeforeMethod
	public void LaunchApplication() {
		driver=Browser.openBrowser();
		SwagLabLoginPage SwagLabLoginPage=new SwagLabLoginPage(driver);
		SwagLabLoginPage.enterUserName("standard_user");
		SwagLabLoginPage.enterPassword("secret_sauce");
		SwagLabLoginPage.clickOnLogin();
	}
	
	@Test
	public void enteryourinfomationoncheckoutpage() {
		SwagLabHomePage SwagLabHomePage=new SwagLabHomePage(driver);
		SwagLabHomePage.clickOnAddToCart(0);
		SwagLabHomePage.clickOnCart();
		SwagLabCartPage SwagLabCartPage=new SwagLabCartPage(driver);
		SwagLabCartPage.clickOnCheckout();
		SwagLabCheckoutPage SwagLabCheckoutPage=new SwagLabCheckoutPage(driver);
		SwagLabCheckoutPage.enterfirstname("renuka");
		SwagLabCheckoutPage.enterlastname("patil");
		SwagLabCheckoutPage.enterpostalcode("413517");
		SwagLabCheckoutPage.clickoncontinue();
		SwagLabCheckoutPage.clickonfinishbutton();
	}
}
