

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AutoPostFB {
  @Test
  public void f() throws InterruptedException {
//	  ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-notifications");
		WebDriver driver;
		String driverPath="G:\\Work From Home\\Chrome Driver\\geckodriver.exe"; 
		System.setProperty("webdriver.gecko.driver", driverPath);
	    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	    capabilities.setCapability("marionette", true);
	    driver = new FirefoxDriver(capabilities);
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		//pass email address
		driver.findElement(By.id("email")).sendKeys("email address");
		//pass password
		driver.findElement(By.id("pass")).sendKeys(" password");
		driver.findElement(By.xpath("//button[@data-testid='royal_login_button']")).click();
		Thread.sleep(1000);
		String[] groups= {"groups numbers"};
//		str
		for(int i=1 ;i<groups.length;i++)
		{
			try {
				String url="https://www.facebook.com/groups/"+groups[i];
				Thread.sleep(1000);		
		driver.get(url);
		String Xpath="//div[@data-pagelet='GroupInlineComposer']//input[@class='mkhogb32' and @type='file']";
		Thread.sleep(3000);
		//if you want to add image uncomment and provide path to image
//		driver.findElement(By.xpath(Xpath)).sendKeys("C:\\Users\\lenovo\\Downloads\\fsog.jpeg");
		driver.findElement(By.xpath("//span[contains(text(),'Create a public post…')]")).click();
		Thread.sleep(1000);
		String PostTextXpath="//div[@aria-label='Create a public post…' or @aria-label='Write something...' ]";
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(PostTextXpath)));
		Thread.sleep(1000);
		//content you want to post
		String content="Content to be posted";
		
		driver.findElement(By.xpath(PostTextXpath)).sendKeys(content);
		Thread.sleep(1000);
		String PostButton="//div[@aria-label='Post']";
		WebDriverWait waitPost=new WebDriverWait(driver, 10);
		waitPost.until(ExpectedConditions.elementToBeClickable(By.xpath(PostButton)));
		Thread.sleep(1000);
		driver.findElement(By.xpath(PostButton)).click();
		Thread.sleep(1000);
//		String ImageInputXpath="//*[@id=\"mount_0_0\"]/div/div[1]/div[1]/div[3]/div/div/div[1]/div[1]/div[4]/div/div/div/div/div[1]/div[1]/div/div/div/div[2]/input";
//		
//		WebDriverWait wait3 =new WebDriverWait(driver, 30);
//		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath(ImageInputXpath)));
		
			}catch(Exception e) {
				System.out.println("Problem with group no "+groups[i]+e.getMessage());
			}
  }
		
  }
}
