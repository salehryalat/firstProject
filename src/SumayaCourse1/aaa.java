package SumayaCourse1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.fail;

import java.sql.Driver;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class aaa {

	WebDriver driver = new EdgeDriver();

	String username = "standard_user";

	String password = "secret_sauce";
	
	Random rand = new Random();
	Random rand2 = new Random();
	@BeforeTest

	public void mysetup() {

		driver.manage().window().maximize();

		// soso.manage().window().maximize();

		driver.get("https://www.saucedemo.com/");

		// soso.get("https://smartbuy-me.com/?srsltid=AfmBOooKsCoS2zLyj8-zgZWDi0uDohpuoASguupBpxt79WBagF61Cfas");

	}

	
	@Test(priority = 1)
	public void Login() {
		
		WebElement usernameInput = driver.findElement(By.id("user-name"));
		WebElement passwordInput = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));
		
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		loginButton.click();
		
		String ActuallValue = driver.getCurrentUrl();
		String ExpectedValue = "https://www.saucedemo.com/inventory.html";
		assertEquals(ActuallValue, ExpectedValue);
	}
	
	@Test(priority = 2)
	
public void AddAllItemsToCart() throws InterruptedException {
		
	
	    List<WebElement> AllAddToCartBottuns = driver.findElements(By.className("btn"));
	    for(int i = 0; i<AllAddToCartBottuns.size(); i++) {
	    	
	    AllAddToCartBottuns.get(i).click();
			
		}
	    List<WebElement> AllRemoveButtons = driver.findElements(By.className("btn_secondary"));
	    for(int i = 0; i<AllAddToCartBottuns.size(); i++) {
	    	assertEquals(AllRemoveButtons.get(i).isDisplayed(), true);
	    }
	    
	    Thread.sleep(2000);
	}
	
	@Test(priority = 3)
	public void RemoveAllItemsFromCart() throws InterruptedException {
		
		List<WebElement> AllRemoveButtons = driver.findElements(By.className("btn_secondary"));
		for(int i = 0; i<AllRemoveButtons.size(); i++) {
			AllRemoveButtons.get(i).click();
		}
		List<WebElement> AllAddToCartButtons = driver.findElements(By.className("btn_primary"));
		for(int i = 0; i<AllAddToCartButtons.size(); i++) {
			assertEquals(AllAddToCartButtons.get(i).isDisplayed(), true);
		}
		Thread.sleep(2000);
		
	}
	
	@Test(priority = 4)
	public void AddRandomItems() throws InterruptedException {
		List<WebElement> AllAddToCartButtons2 = driver.findElements(By.className("btn"));
		for(int i = 0; i<2; i++) {
		int randomIndex = rand2.nextInt(AllAddToCartButtons2.size());
			AllAddToCartButtons2.get(randomIndex).click();
		}
		WebElement CartButton = driver.findElement(By.className("shopping_cart_link"));
		String ActualValue = CartButton.getText();
		String ExpectedValue = "2";
		assertEquals(ActualValue, ExpectedValue);
		Thread.sleep(2000);
	}
	
    @Test(priority = 5)
    
    public void checkoutButton() throws InterruptedException {
    	driver.navigate().to("https://www.saucedemo.com/cart.html");
    	WebElement checkoutButton1 = driver.findElement(By.xpath("//button[@data-test='checkout']"));
    	checkoutButton1.click();
		Thread.sleep(2000);
        String ActualValue = driver.getCurrentUrl();
        String ExpectedValue = "https://www.saucedemo.com/checkout-step-one.html";
        assertEquals(ActualValue, ExpectedValue);
    }
    
    @Test(priority = 6)
    
    public void fillCheckoutInformation() throws InterruptedException {
    	
    	WebElement firstNameInput = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
    	WebElement lastNameInput = driver.findElement(By.xpath("//input[@data-test='lastName']"));
    	WebElement postalCodeInput = driver.findElement(By.xpath("//input[@placeholder='Zip/Postal Code']"));
    	WebElement ContinueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
    	firstNameInput.sendKeys("Saleh");
    	lastNameInput.sendKeys("Ryalat");
    	postalCodeInput.sendKeys("123123");
    	ContinueButton.click();
    	Thread.sleep(2000);
    	String ActualValue = driver.getCurrentUrl();
        String ExpectedValue = "https://www.saucedemo.com/checkout-step-two.html";
        assertEquals(ActualValue, ExpectedValue);
    }
    
	
    @Test(priority = 7)
    
    public void finish() {
    	
    	WebElement finishButton = driver.findElement(By.xpath("//button[@data-test='finish']"));
    	finishButton.click();
    	String ActualValue = driver.getCurrentUrl();
        String ExpectedValue = "https://www.saucedemo.com/checkout-complete.html";
        assertEquals(ActualValue, ExpectedValue);
    }
    }
	
	
	

	
	
	
	
	
	

