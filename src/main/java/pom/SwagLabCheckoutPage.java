package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabCheckoutPage {

	@FindBy (xpath="//input[@id='first-name']") private WebElement firstname;
	@FindBy (xpath="//input[@id='last-name']") private WebElement lastname;
	@FindBy (xpath="//input[@id='postal-code']") private WebElement postalcode;
	@FindBy (xpath="//input[@type='submit']") private WebElement continuebutton;
	@FindBy (xpath="//button[@id='cancel']") private WebElement cancelbutton;
	@FindBy (xpath="//button[@id='finish']") private WebElement finishbutton;
	
	public SwagLabCheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterfirstname(String first) {
		firstname.sendKeys(first);
	}
	
	public void enterlastname(String last) {
		lastname.sendKeys(last);
	}
	public void enterpostalcode(String postal) {
		postalcode.sendKeys(postal);
	}
	
	public void clickoncontinue() {
		continuebutton.click();
	}
	public void clickoncancelbutton() {
		cancelbutton.click();
	}
	public void clickonfinishbutton() {
		finishbutton.click();
	}
}
