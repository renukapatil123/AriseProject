package test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.SwagLabLoginPage;

@Listeners(test.Listeners.class)
public class SwagLabLoginTest extends BaseTest {

	
	@BeforeMethod
	public void launchApplication() {
		driver=Browser.openBrowser();
	}
	
	@Test
	public void verifyUserIsAbleToLoginWithValidCredentials() {
		test=reports.createTest("verifyUserIsAbleToLoginWithValidCredentials");
		SwagLabLoginPage SwagLabLoginPage=new SwagLabLoginPage(driver);
		SwagLabLoginPage.enterUserName("standard_user");
		SwagLabLoginPage.enterPassword("secret_sauce");
		SwagLabLoginPage.clickOnLogin();
	}
	
	@Test
	public void verifyIfWarningMessageIsDisplayeddForLockedUser() {
		test=reports.createTest("verifyIfWarningMessageIsDisplayeddForLockedUser");
		SwagLabLoginPage SwagLabLoginPage = new SwagLabLoginPage(driver);
		SwagLabLoginPage.enterUserName("locked_out_user");
		SwagLabLoginPage.enterPassword("secret_sauce");
		SwagLabLoginPage.clickOnLogin();
	}
	

}
