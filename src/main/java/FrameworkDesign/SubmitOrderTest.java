package FrameworkDesign;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;

public class SubmitOrderTest {

	public static void main(String[] args) {
		// WebDriverManager.chromedriver().setup(); // chromedriver.exe will be downloaded based on the Version of my chrome ... 
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\SeliniumFrameworkDesign\\src\\main\\java\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String productName="ZARA COAT 3";
		// Object creation 
		LandingPage landingPage = new LandingPage(driver);
		
		landingPage.Goto(); 
		 
		landingPage.loginApplication("dhiadjebbi1@gmail.com", "Djebbi.123456"); 
		
	
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
		
		

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ng-animating")));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName)); 
		
		//Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click(); 
		
		Actions a = new Actions(driver);
		
		a.sendKeys(driver.findElement(By.cssSelector("")));
		 

		

	}

}
