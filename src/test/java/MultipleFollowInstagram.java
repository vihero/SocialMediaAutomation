import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MultipleFollowInstagram {
	WebDriver driver;
	public void scrollTillElementFound() {
//		WebElement element=driver.findElement(By.xpath("(//button[text()='Following' or text()='Requested'] )[9]"));
//		new Actions(driver).moveToElement(new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(element))).build().perform();
	
		WebElement scroll = driver.findElement(By.className("isgrP"));
		scroll.sendKeys(Keys.PAGE_DOWN);
	}
	
	
	@Test
	  public void f() throws Exception {
		
		String driverPath="G:\\Work From Home\\Chrome Driver\\geckodriver.exe"; 
		System.setProperty("webdriver.gecko.driver", driverPath);
	    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	    capabilities.setCapability("marionette", true);
	    driver = new FirefoxDriver(capabilities);
		driver.get("https://www.instagram.com/");
		Thread.sleep(2000);
		//Provide User Name
		driver.findElement(By.xpath("(//input)[1]")).sendKeys("Username");
		//Provide Password
		driver.findElement(By.xpath("(//input)[2]")).sendKeys("Password");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button/div[text()='Log In']")).click();
		Thread.sleep(3000);
		//provide page name
		driver.get("https://www.instagram.com/PageName");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a)[1]")).click();
		Thread.sleep(1000);
		while(true) {
			try {
			WebElement element=driver.findElement(By.xpath("(//button[text()='Follow'])[2]"));
			 new Actions(driver).moveToElement(new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(element))).build().perform();
			driver.findElement(By.xpath("(//button[text()='Follow'])[2]")).click();
			Thread.sleep(1000);
			}
			catch(Exception e) {
				scrollTillElementFound();
			}
			
		}
	}

}
