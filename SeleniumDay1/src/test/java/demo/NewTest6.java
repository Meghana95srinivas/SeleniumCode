package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest6 {
	WebDriver driver;
	@BeforeTest
	public void beforeTest()
	{
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Training_b3a.00.39\\Drivers\\chromedriver_win32\\chromedriver.exe");
		   driver=new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/login");
		driver.manage().window().maximize();
	}
	@AfterTest
	public void afterTest()
	{
		//driver.close();
	}
  @Test(dataProvider="dp1")
  public void testValidUserDemoWorkshop(String Username,String Password) {
	driver.findElement(By.id("Email")).sendKeys(Username);
	driver.findElement(By.id("Password")).sendKeys(Password);
	driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();
	driver.findElement(By.linkText("Log out")).click();
	driver.findElement(By.linkText("Log in")).click();
	
  }
@DataProvider(name="dp1")
public Object[][] providedata()
{
	return NewTest5.testExtractDataExcel();
	
}
}

