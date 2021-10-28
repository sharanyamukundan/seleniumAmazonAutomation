package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cartPage {
	
	static WebElement proceedBuy,cart;
	
	
	public static WebElement clickCart(WebDriver driver) {
		
		//cart button
		cart = driver.findElement(By.cssSelector("a#nav-cart"));
		return cart;

	}
	
	public static WebElement proceedToBuy(WebDriver driver) {
		
		
		//proceed to buy button
		proceedBuy = driver.findElement(By.cssSelector("input[name='proceedToRetailCheckout']"));
		return proceedBuy;

	}

}
