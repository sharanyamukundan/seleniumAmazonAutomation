package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class amazonHome {

	static WebElement element,searchTab,searchButton,hamIcon,signOut;
	
	//object for login
	public static WebElement login_Button(WebDriver driver) {

		element = driver.findElement(By.xpath("//span[contains(text(),'Hello, ')]"));
		return element;

	}
	
	//search tab
	public static WebElement searchTab(WebDriver driver) {

		searchTab = driver.findElement(By.xpath("//input[starts-with(@id,'twotab')]"));
		return searchTab;
		

	}
	
	
	//search button
	public static WebElement searchButton(WebDriver driver) {
	
		searchButton = driver.findElement(By.xpath("//input[starts-with(@id,'nav-search')]"));
		return searchButton;
	
	}
	
	
	public static WebElement hamButton(WebDriver driver) {

		hamIcon = driver.findElement(By.cssSelector("a#nav-hamburger-menu"));
		return hamIcon;
		
	}
	
	//signout
	public static WebElement signOut(WebDriver driver) {

		signOut = driver.findElement(By.cssSelector("a#nav-item-signout"));
		return signOut;
		
	}



}
