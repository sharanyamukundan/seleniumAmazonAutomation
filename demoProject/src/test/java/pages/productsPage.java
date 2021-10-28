package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class productsPage {
	
	
	static WebElement sort,min,minProduct;


	public static WebElement sortButton(WebDriver driver) {
		
		//sort button
		sort = driver.findElement(By.xpath("//span[contains(@id,'0-announce')]"));
		return sort;

	}

	public static WebElement sortMin(WebDriver driver) {
		
		//low to high
		min = driver.findElement(By.xpath("//a[contains(@id,'sort-select_1')]"));
		return min;

	}
	
	public static WebElement Products(WebDriver driver) {
		
		//select product
		minProduct =  driver.findElement(By.xpath("//span[text()='boAt Bassheads 105 in-Ear Wired Headset(Black)']"));
		return minProduct;
		
	}

}
