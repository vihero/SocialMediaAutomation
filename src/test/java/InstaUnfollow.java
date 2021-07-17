import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class InstaUnfollow {

	 @Test
	  public void f() throws InterruptedException {
	 ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver;
		//provide path to chrome driver
		System.setProperty("webdriver.chrome.driver","G:\\Chrome Driver\\chromedriver.exe"); 
		driver=new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.get("http://instagram.com/");
		Thread.sleep(2000);
		//provide email or User Name
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("username/email id");
		//provide password
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");
		driver.findElement(By.xpath("//div[text()='Log In']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@data-testid='user-avatar']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='_7UhW9   xLCgt      MMzan  KV-D4              fDxYl     ']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()=' followers']")).click();
		Thread.sleep(2000);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 // This  will scroll down the page by  1000 pixel vertical		
//		 js.executeScript("arguments[0].scrollTop = arguments[1];",driver.findElement(By.xpath("//ul[@class='jSC57  _6xe7A']")), 100);
	      Thread.sleep(5000);
	      driver.findElement(By.xpath("//div[@class='PZuss']/div")).sendKeys(Keys.CONTROL, Keys.END);
//		while(true) {
//		driver.findElement(By.xpath("//div[@class='isgrP']")).click();
//		Thread.sleep(5000);
//		}
		Thread.sleep(10000);
		driver.quit();
		
}
}