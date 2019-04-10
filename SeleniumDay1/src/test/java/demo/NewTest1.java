package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest1 {
  @Test
  public void test() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Training_b3a.00.39\\Drivers\\chromedriver_win32\\chromedriver.exe");
	  WebDriver driver=new ChromeDriver();  
	  driver.get("https://www.hdfcbank.com/");
	  driver.manage().window().maximize();
	  Thread.sleep(5000);
	  Actions act1=new Actions(driver);
	  act1.moveToElement(driver.findElement(By.linkText("Products"))).perform();
	  Thread.sleep(3000);
	  act1.moveToElement(driver.findElement(By.linkText("Cards"))).perform();
	  Thread.sleep(3000);
	  act1.moveToElement(driver.findElement(By.linkText("Credit Cards"))).click().perform();
	  Assert.assertTrue(driver.getCurrentUrl().contains("credit_cards"));
  }
}

