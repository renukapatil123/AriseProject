package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SwagLabHomePage {
	
	@FindBy (xpath="//div[@data-test='inventory-iem-name']")private List<WebElement> productsName;
	@FindBy (xpath="//div[@data-test='inventory-iem-price']")private List<WebElement> productsPrice;
	@FindBy (xpath="//button[text()='Add to cart']")private List<WebElement> addToCart;
	@FindBy (xpath="//select[@class='product_sort_container']")private WebElement sort;
	@FindBy (xpath="//button[@id='react-burger-menu-btn']")private WebElement menu;
	@FindBy (xpath="//a[@id='about_sidebar_link']")private WebElement about;
	@FindBy (xpath="//a[@id='logout_sidebar_link']")private WebElement logout;
	@FindBy (xpath="//a[@class='shopping_cart_link']")private WebElement cart;
	@FindBy (xpath="//select[@class='product_sort_container']")private WebElement names;

	public SwagLabHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getProductName(int index) {
		return productsName.get(index).getText();
	}
	public String[] getAllProductName() {
		String [] names = new String[productsName.size()];
		for(int i=0; i<=productsName.size();i++)
		{
			names [i]=productsName.get(i).getText();
		}
		return names;
	}
	
	public String getProductsprice(int index) {
		return productsPrice.get(index).getText();
	}
	
	public void clickOnAddToCart(int indedx) {
		addToCart.get(indedx).click();
	}
	public void clickOnCart() {
		cart.click();
	}
	
	public void sortProducts(String text) {
		Select select=new Select(sort);
		select.selectByVisibleText(text);
	}
	public void clickOnMenu() {
		menu.click();
	}
	
	public void clickOnAbout() {
	about.click();
}
	public void clickOnLogout() {
		logout.click();
	}
	public boolean isRemoveButtonDisplayed(int index) {
	boolean result=addToCart.get(index).isDisplayed();
		return result;
	}
}