package test;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;

@Listeners(test.Listeners.class)

public class SwagLabHomeTest extends BaseTest {

@BeforeMethod
public void LaunchApplication() {
	driver=Browser.openBrowser();
	SwagLabLoginPage SwagLabLoginPage=new SwagLabLoginPage(driver);
	SwagLabLoginPage.enterUserName("standard_user");
	SwagLabLoginPage.enterPassword("secret_sauce");
	SwagLabLoginPage.clickOnLogin();
}

@Test
public void VerifyOnClickingOnMenuAllTheMenuOptionsAreDisplayed() {
	SwagLabHomePage SwagLabHomePage=new SwagLabHomePage(driver);
	SwagLabHomePage.clickOnMenu();
}
@Test
public void VerifyOnClickAboutUserIsRedirectedToSwaglabExternalPage() {
	SwagLabHomePage SwagLabHomePage=new SwagLabHomePage(driver);
	SwagLabHomePage.clickOnMenu();
	SwagLabHomePage.clickOnAbout();
	Assert.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/");
}

@Test
public void VerifyOnClickingLogoutUserIsSuccessfullyLoggedOutFromApplication() {
	SwagLabHomePage SwagLabHomePage=new SwagLabHomePage(driver);
	SwagLabHomePage.clickOnMenu();
	SwagLabHomePage.clickOnLogout();
	Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/" );
}

}