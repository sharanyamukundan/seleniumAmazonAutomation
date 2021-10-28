package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class paymentsPage {
	
	static WebElement pay;

	public static WebElement COD(WebDriver driver) {

		//cod 
		pay = driver.findElement(By.xpath("//input[contains(@value,'COD')]"));
		return pay;

	}

}
