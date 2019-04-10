package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class NewTest3 {
  @Test
  public void testKeys() throws InterruptedException {
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Training_b3a.00.39\\Drivers\\chromedriver_win32\\chromedriver.exe");
	 WebDriver driver=new ChromeDriver();
	 driver.get("https://www.cleartrip.com/");
	 driver.manage().window().maximize();
	 WebElement from=driver.findElement(By.id("FromTag"));
	 Actions act1=new Actions(driver);
	 act1.sendKeys(from,"h").perform();
	 Thread.sleep(5000);
	 act1.sendKeys("y").perform();
	 Thread.sleep(5000);
	 act1.sendKeys("d").perform();
	 Thread.sleep(5000);
	 act1.sendKeys(Keys.ENTER).perform();
			 
	  
  }
}
