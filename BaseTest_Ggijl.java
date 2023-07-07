package ggijl_TestScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;

public class BaseTest_Ggijl{
	

		public static WebDriver driver;
		public static Properties p = new Properties();
		public static Properties p2 = new Properties();
		
	public static String projectpath=System.getProperty("user.dir");
		
		public static void init() {	
			
			try {	
			FileInputStream fis= new FileInputStream(projectpath+"\\config.properties");
			p.load(fis);
			String environment= p.getProperty("env");
			
			FileInputStream fis2= new FileInputStream(projectpath+"\\"+environment+".properties");
			p2.load(fis2);
			
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			} 
			catch (IOException ie) {
		        ie.printStackTrace();
		    }
		}
		public static void launchBrowser(String browser) {
			if(p.getProperty(browser).equals("chrome")) {
				
				// this is profiling which states what defualt profile to open i.e profile6(Integ user account)
				ChromeOptions option = new ChromeOptions();
				option.addArguments("user-data-dir=C:\\Users\\Kavya.h\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 6");
				
				// opened chrome profile doesnt come up with profile pic and default Tech 
				
				driver= new ChromeDriver(option);
				// this creates chrome driver with options configured
				
				System.setProperty("webdriver.chrome.driver",projectpath+"\\drivers\\chromedriver.exe");	

				/*
				if(p.getProperty(browser).equals("edge")) {
					driver= new EdgeDriver();
					System.setProperty("webdriver.edge.driver","C:\\Users\\Kavya.h\\OneDrive - Technovert\\Desktop\\Selenium JARs\\chromedriver_win32 (3)");
				}
				if(p.getProperty(browser).equals("firefox")) {
					driver= new FirefoxDriver();
					System.setProperty("webdriver.gecko.driver","C:\\Users\\Kavya.h\\OneDrive - Technovert\\Desktop\\Selenium JARs\\chromedriver_win32 (3)");
				}*/
		}

		}
			public static void launchURL(String url){
				
				driver.get(p2.getProperty(url));
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				System.out.println("block executed");
				
				}
			
public static WebElement findelem(String locatorKey){
				
	WebElement element=null;// initialised to null so that escape compilation error
				if(locatorKey.endsWith("id")) {
	
					 element= driver.findElement(By.id(p2.getProperty(locatorKey)));
					 System.out.println(element+" found");
				}
				
				return element;
}
			
public static void quit() {
	driver.quit();
}
				}
		

