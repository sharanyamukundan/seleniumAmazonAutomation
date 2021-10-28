package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class addressPage {
	
	static WebElement selectAdd;
	
	//object for selecting address
	public static WebElement selectAddress(WebDriver driver) {

		selectAdd = driver.findElement(By.xpath("//a[contains(text(),' to this address')]"));
		return selectAdd;

	}

}
