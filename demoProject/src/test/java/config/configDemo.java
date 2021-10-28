package config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import test.amazonHomeTest;

public class configDemo {
	
	static Properties prop = new Properties();
	
	public static void main(String args[]) {
		
		getProperties();
	}
	
	
	public static void getProperties() {
		
		try {
			
			
			String project = System.getProperty("user.dir");
			InputStream input = new FileInputStream(project+"\\src\\test\\java\\config\\config.properties");
			prop.load(input);
			String browser = prop.getProperty("browser");
			String web = prop.getProperty("web");
			System.out.println(browser);
			amazonHomeTest.browserName = browser;
			amazonHomeTest.webName = web;
		
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}

}
