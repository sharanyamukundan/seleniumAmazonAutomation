package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class amazonLogin {

	static WebElement email,pass,cont_button,signIn;

	public static WebElement enterUser(WebDriver driver) {

		//webelement for entering email
		email = driver.findElement(By.xpath("//input[@id='ap_email']"));

		return email;

	}

	public static WebElement contButton(WebDriver driver) {


		//continue button
		cont_button = driver.findElement(By.id("continue"));

		return cont_button;

	}
	public static WebElement enterPass(WebDriver driver) {

		//for entering password
		pass = driver.findElement(By.id("ap_password"));
		
		return pass;

	}
	
	public static WebElement signInButton(WebDriver driver) {

		//sign in button
		signIn = driver.findElement(By.xpath("//input[starts-with(@id,'sign')]"));

		return signIn;

	}

}
