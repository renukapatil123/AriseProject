package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SwagLabCartPage {

	@FindBy (xpath="//div[@class='cart_item']") private List<WebElement>cartitem;
	@FindBy (xpath="//div[@class='inventory_cart_item']")private List<WebElement> productname;
    @FindBy (xpath="//button[@id='remove-sauce-labs-backpack']")private WebElement remove;
	@FindBy (xpath="//button[@data-test='checkout']")private WebElement checkout;
public SwagLabCartPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}

public int getCartItem()
{
	return cartitem.size();
}
public String getProductName(int index) {
	return productname.get(index).getText();
}
public void clickOnRemove() {
	remove.click();
}
public void clickOnCheckout() {
	checkout.click();
}
}
