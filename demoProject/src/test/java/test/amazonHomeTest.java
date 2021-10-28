package test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.sun.tools.sjavac.Log;

import config.configDemo;
import pages.amazonHome;
import pages.amazonLogin;
import pages.productsPage;
import pages.productDesc;
import pages.paymentsPage;
import pages.cartPage;
import pages.addressPage;
import utils.excelUtils;

public class amazonHomeTest {

	public static String browserName,webName,username,pass,search;
	public  static WebElement searchtab;
	static WebDriver driver;
	static ExtentReports extent;
	ExtentHtmlReporter htmlReporter;
	ExtentTest test;
	Logger logger = LogManager.getLogger(amazonHomeTest.class.getName());

	@BeforeSuite
	public void beforeSuite() {
		htmlReporter = new ExtentHtmlReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);



	}

	@BeforeSuite
	public void setUpDriver() throws IOException {


		//launching chrome
		String project = System.getProperty("user.dir");

		configDemo.getProperties();

		//gettting input from excel
		excelUtils.getData();

		if(browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", project+"\\drivers\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
			logger.debug("Chrome Launched");

		}



	}

	@Test(priority = 1)
	public void login() throws IOException {

		try {


			// creates a toggle for the given test, adds all log events under it    
			test = extent.createTest("MyFirstTest", "Sample description");


			//go to amazon
			driver.get(webName);

			//maximize
			driver.manage().window().maximize();

			//click for login
			amazonHome.login_Button(driver).click();


			//logging
			logger.debug("Amazon launched and button clicked");

			//click for email input
			amazonLogin.enterUser(driver).click();

			//entering username
			amazonLogin.enterUser(driver).sendKeys(username);

			//Click continue
			amazonLogin.contButton(driver).click();

			//logging
			logger.debug("Username entered");

			//click for entering password
			amazonLogin.enterPass(driver).click();

			//enter password
			amazonLogin.enterPass(driver).sendKeys(pass);

			//click signIn
			amazonLogin.signInButton(driver).click();

			//logging
			logger.debug("Signin successfull");



			// log(Status, details)
			test.log(Status.INFO, "This step shows usage of log(status, details)");

			// info(details)
			test.info("This step shows usage of info(details)");

			// log with snapshot
			test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

			// test with snapshot
			test.addScreenCaptureFromPath("screenshot.png");

		}catch(Exception exp) {

			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}



	}


	@Test(priority = 2)
	public void search() throws IOException {


		try {

			// creates a toggle for the given test, adds all log events under it    
			test = extent.createTest("search", "Sample description"); 

			//clicking search
			amazonHome.searchTab(driver).click();

			//enter search data
			amazonHome.searchTab(driver).sendKeys(search);

			//click search
			amazonHome.searchButton(driver).click();

			//logging
			logger.debug("Search successfull");


			// log with snapshot
			test.pass("Username and password entered successfully", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

			// test with snapshot
			test.addScreenCaptureFromPath("screenshot.png");

		}catch(Exception exp) {

			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}


	}

	@Test(priority = 3)
	public void findMin() throws IOException {
		
		try {
			
			// creates a toggle for the given test, adds all log events under it    
			test = extent.createTest("search for minimum price", "Sample description"); 
			
			
			//click sort 
			productsPage.sortButton(driver).click();
			
			//click low to high
			productsPage.sortMin(driver).click();
			

			//logging
			logger.debug("Searched for product with minimum price");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//click on product with minimum price
			productsPage.Products(driver).click();
			
			logger.info("Product with minimum price selected");


			// log with snapshot
			test.pass("Search for product with minimum price done successfully", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

			// test with snapshot
			test.addScreenCaptureFromPath("screenshot.png");

			
		}catch(Exception exp) {
			
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
			
		}

		
	}
	
	@Test(priority = 4)
	public void addToCart() throws IOException {
		
		try {
			
			// creates a toggle for the given test, adds all log events under it    
			test = extent.createTest("buying a product", "Sample description"); 
			
			String originalHandle = driver.getWindowHandle();
			for(String handle1:driver.getWindowHandles()) {
				
				driver.switchTo().window(handle1);
				
			}
			//click buy now 
			productDesc.addToCart(driver).click();
			
			

			//logging
			logger.debug("Added to cart");
			
			
			//click cart
			cartPage.clickCart(driver).click();
			
			//click proceed to buy
			cartPage.proceedToBuy(driver).click();
			
			//logging
			logger.debug("Clicked proceed to buy");
			
			
			//select address
			addressPage.selectAddress(driver).click();
			
			//logging
			logger.info("Selected address");
			
			
			//select payment method
			paymentsPage.COD(driver).click();
			
			//logging
			logger.info("Selected pay on delivery");

			// log with snapshot
			test.pass("Started placing order", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

			// test with snapshot
			test.addScreenCaptureFromPath("screenshot.png");

			
		}catch(Exception exp) {
			
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
			
		}

		
	}
	
	@Test(priority = 5)
	public void logout() throws IOException {
		
		try {
			
			// creates a toggle for the given test, adds all log events under it    
			test = extent.createTest("signout", "Sample description"); 
			
			//go to home page
			driver.get(webName);
			
			//logging
			logger.info("Reached home page");
			
			//hover on login element
			Actions action = new Actions(driver);
			action.moveToElement(amazonHome.login_Button(driver)).build().perform();
			
			amazonHome.signOut(driver).click();
			
			//logging
			logger.info("Sign Out Successful");

			// log with snapshot
			test.pass("Successfully signed out", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

			// test with snapshot
			test.addScreenCaptureFromPath("screenshot.png");

			
		}catch(Exception exp) {
			
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
			
		}

		
	}



	@AfterTest
	public void tearDown() {
		driver.close();
		
		driver.quit();

		// calling flush writes everything to the log file
		extent.flush();
	}

}
