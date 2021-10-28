package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class productDesc {

	static WebElement addCart;

	public static WebElement addToCart(WebDriver driver) {

		//add to cart
		addCart = driver.findElement(By.id("add-to-cart-button"));
		return addCart;

	}

}
