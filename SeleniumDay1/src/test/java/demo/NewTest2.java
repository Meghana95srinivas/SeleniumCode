package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class NewTest2 {
  @Test
  public void testDragAndDrop() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Training_b3a.00.39\\Drivers\\chromedriver_win32\\chromedriver.exe");
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
	  driver.manage().window().maximize();
	  WebElement from=driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceholder1_RadTreeView1']/ul/li/ul/li[3]/ul/li[2]/div/div/span"));
	  WebElement to=driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1"));
	  Actions act1=new Actions(driver);
	  act1.clickAndHold(from).release(to).perform();
	  
	  
	  
	  
	  
	  
			  
			  
  }
}
