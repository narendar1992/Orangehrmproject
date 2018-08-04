package com.hrm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrm.qa.testutil.TestUtil;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	
	
	
	public TestBase()
	{
		 prop = new Properties();
		 try {
			FileInputStream fis = new FileInputStream("/home/narendar/selenium/workspace/OrangeHRM/src"
					+ "/main/java/com/hrm/qa/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			/*System.setProperty("webdriver.chrome.driver", "/home/narendar/Downloads/chromedriver_linux64"
					+ "/chromedriver");
			driver = new ChromeDriver();*/
			
			System.setProperty("webdriver.chrome.driver", "/home/narendar/Downloads/chromedriver_linux64/chromedriver");
			driver = new ChromeDriver();
		}
		/*else 
			System.setProperty("webdriver.gecko.driver", "/home/narendar/Downloads/geckodriver-v0.15.0-linux64"
					+ "/geckodriver");
			driver = new FirefoxDriver();*/
			
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
	//driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(TestUtil.Time_Load_out, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_out, TimeUnit.SECONDS);
	
}
	
	//Taking Screenshot method on Failed Testcase
	public static void failed(String testMethodName)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("/home/narendar/selenium/workspace/OrangeHRM/screenshots/"+testMethodName+"_"+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	 
		
	}
	
	
	
	

}
