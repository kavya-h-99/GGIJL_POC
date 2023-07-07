package ggijl_TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Login_crm extends BaseTest_Ggijl {
	
		public static void main(String[] args) throws InterruptedException {
			
			init();// loads all files, setups configuration
			
			launchBrowser("browser");// this method instantiates a browser based on user choice
			launchURL("url");
			
			Thread.sleep(6000);
			WebElement user_name= findelem("username_id"); // username textbox is found
			
			String id= "username";
			user_name.sendKeys(p2.getProperty(id)); // capturing key value stored in properties file
			
			WebElement next_btn= findelem("nextbtn_id");
			next_btn.click(); // clciking on next button upon entering Office username
			
			// to validate that system naviagtes to Bitglass portal upon entering myGuardiangroup username
			Thread.sleep(7000);
		String openedurl=	driver.getCurrentUrl();
			if(openedurl.contains("bitglass"))
				System.out.println("bitglass portal opened");
			
			// Entering password
			WebElement pass= findelem("pass_id");
		String Pass="password";
			pass.sendKeys(p2.getProperty(Pass));
			
			// clicking on login button upon entering password on bitglass
			Thread.sleep(1000);
			WebElement loginbtn= findelem("loginbtn_id");
			loginbtn.click();
			
			// validating that user is on Signin screen
			String currentTitle= driver.getTitle();
			if(currentTitle.contains("Sign in to your account"))
				System.out.println("Stay signed in window opened");
			
			// confirming to Stay Signed in
			Thread.sleep(1000);
			WebElement yesbtn= findelem("nextbtn_id"); // reusing locator since same refernce used by Microsoft
			yesbtn.click();
			
			// Validating if Dynamics crm instance is accessed or not
			Thread.sleep(2000);
			openedurl=driver.getCurrentUrl();
			if(openedurl.contains("glocuat"))
				System.out.println("Dynamics CRM - glocuat instance accessed");
			
			// Navigating to CS hub for GGIJL app
			Thread.sleep(10000);
			driver.navigate().to("https://glocuat.crm.dynamics.com/main.aspx?appid=72b2c69c-66be-ed11-83ff-000d3a114bfa");
			
			//Static url navigation is considered than dynamic click of tile because pap tile order in dom is subject to change considering the feasibility of CRM to create custom apps
			
			/*
			 * WebElement ggijl_app= driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(5) > div:nth-child(2) > div:nth-child(2) > div:nth-child(4) > a:nth-child(1) > div:nth-child(1)"));
			 * ggijl_app.click();
			 */
			
			Thread.sleep(6000);
			WebElement ggijlapplink= driver.findElement(By.id("id-21"));
			String link_text= ggijlapplink.getText();
			System.out.println(link_text); 
			
			// App Shortcut is validated to ensure right app is open
			if(link_text.contains("GGIJL"))
				System.out.println("Cs hub for GGIJL is opened");
			
	      /*  if(ggijlapplink!=null) {
	        System.out.println(driver.getCurrentUrl());	
	        System.out.println(ggijlapplink);
	        }
	         - for validation
	        */
			quit();
			
		}

	}


