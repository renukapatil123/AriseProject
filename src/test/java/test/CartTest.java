package test;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.SwagLabCartPage;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;

@Listeners(test.Listeners.class)
public class CartTest extends BaseTest {
	
	@BeforeMethod
	public void LaunchApplication() {
		driver=Browser.openBrowser();
		SwagLabLoginPage SwagLabLoginPage=new SwagLabLoginPage(driver);
		SwagLabLoginPage.enterUserName("standard_user");
		SwagLabLoginPage.enterPassword("secret_sauce");
		SwagLabLoginPage.clickOnLogin();
		
	}
	
	@Test
	public void VerfiyIfUserIsAbleToAddProductToCart() {
		SwagLabHomePage SwagLabHomePage=new SwagLabHomePage(driver);
		SwagLabHomePage.clickOnAddToCart(0);
		String productname=SwagLabHomePage.getProductName(0);
		SwagLabHomePage.clickOnCart();
		SwagLabCartPage SwagLabCartPage=new SwagLabCartPage(driver);
		Assert.assertEquals(SwagLabCartPage.getCartItem(), 0);
		Assert.assertEquals(SwagLabCartPage.getProductName(0),productname);
	}
	
	@Test
	public void VerifyIsIfUserIsAbleToAddMultipleProductToCart() {
		SwagLabHomePage SwagLabHomePage=new SwagLabHomePage(driver);
		SwagLabHomePage.clickOnAddToCart(0);
		SwagLabHomePage.clickOnAddToCart(1);
		SwagLabHomePage.clickOnAddToCart(2);
		SwagLabHomePage.clickOnAddToCart(0);
		SwagLabHomePage.clickOnAddToCart(0);
		SwagLabHomePage.clickOnAddToCart(0);
	
	}
	@Test
	public void VerifyIsIfUserIsAbleToRemoveProductFromCart() throws InterruptedException {
		SwagLabHomePage SwagLabHomePage=new SwagLabHomePage(driver);
		SwagLabHomePage.clickOnAddToCart(0);
		Thread.sleep(3000);
		SwagLabCartPage SwagLabCartPage=new SwagLabCartPage(driver);
		SwagLabCartPage.clickOnRemove();
		Assert.assertTrue(SwagLabHomePage.isRemoveButtonDisplayed(0));
	}
	@Test
	public void VerifyOnClickCheckoutUserIsRedirectedToUserInformationPage() {
		SwagLabHomePage SwagLabHomePage=new SwagLabHomePage(driver);
		SwagLabHomePage.clickOnAddToCart(0);
		SwagLabHomePage.clickOnCart();
		SwagLabCartPage SwagLabCartPage=new SwagLabCartPage(driver);
		SwagLabCartPage.clickOnCheckout();
	}
	@Test
	public void demo() {
		System.out.println("demo");
	}
	
}
