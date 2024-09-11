package FrameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	 WebDriver driver;

	public LandingPage(WebDriver driver) {
		// initialisation
					this.driver = driver;
					PageFactory.initElements(driver,this);
	}

		//WebElement userEmail =  driver.findElement(By.id("userEmail"));
		
   // Page Factory 
		@FindBy(id="userEmail") 
		WebElement userEmail;
		
		@FindBy(id="userPassword") 
		WebElement passwordE;
		
		@FindBy(id="login") 
		WebElement submit;
		
		public void  loginApplication(String email,String password ) {
			
			userEmail.sendKeys(email);
			passwordE.sendKeys(password);
			submit.click();
			
			
			
		}
		public void Goto() {
			driver.get("https://rahulshettyacademy.com/client");
			
			
		}


}
