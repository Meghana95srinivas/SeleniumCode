package demo;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class NewTest8 {
	ExtentHtmlReporter htmlreporter;
	ExtentReports reports;
	ExtentTest logger;
	WebDriver driver;
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Training_b3a.00.39\\Drivers\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("http://demowebshop.tricentis.com/login");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss-ms");
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/extent-reports/"+sdf.format(new Date())+".html");
		reports=new ExtentReports();
		reports.attachReporter(htmlreporter);
		reports.setSystemInfo("host","LocalHost Training LKM");
		reports.setSystemInfo("username","meghana.srinivas");
		htmlreporter.config().setTheme(Theme.DARK);
		htmlreporter.config().setReportName("Report for Demo Web Shop");
		
	}
  @Test
  public void testPass() {
	  logger=reports.createTest("Test pass");
	  logger.log(Status.PASS,MarkupHelper.createLabel("This test is padded", ExtentColor.GREEN));
  
  }
  @Test
  public void testFail() {
	  logger=reports.createTest("Test fail");
	 
	  driver.findElement(By.id("Email")).sendKeys("abc@gmail.com");
	  driver.findElement(By.id("pass")).sendKeys("abc@gmail.com");
	  //Assert.assertTrue(false);
	  
	  
  }
  @Test
  public void testSkip() {
	  logger=reports.createTest("Test skip");
	  throw new SkipException("This test is skipped");
  }
  @AfterMethod
  public void afterMethod(ITestResult result)
  {
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
		  logger.log(Status.FAIL,MarkupHelper.createLabel("This test " +result.getMethod().getMethodName()+"is failed",ExtentColor.RED));
		TakesScreenshot capture=(TakesScreenshot) driver;
		  File src=capture.getScreenshotAs(OutputType.FILE);
		  String capturePath=System.getProperty("user.dir")+"/extent-reports/capture/"+result.getMethod().getMethodName()+".png";
		  try
		  {
			  FileUtils.copyFile(src,new File(capturePath));
			  logger.addScreenCaptureFromPath(capturePath,"Demo Web Shop Screen");
			  logger.log(Status.FAIL, result.getThrowable().getMessage());
		  }
	  catch(IOException e)
	  {
		  e.printStackTrace();
	  }
	  }
	  else if(result.getStatus()==ITestResult.SKIP)
	  {
		  logger.log(Status.SKIP,MarkupHelper.createLabel("This test "+result.getMethod().getMethodName()+"is skipped",ExtentColor.INDIGO));
	  }
  }
  @AfterTest
  public void afterTest() {
	  reports.flush();
	  driver.close();
  }
}
