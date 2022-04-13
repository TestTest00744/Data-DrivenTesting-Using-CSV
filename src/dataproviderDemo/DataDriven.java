package dataproviderDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriven {
	String baseUrl = "http://localhost:8888/";
	WebDriver driver;
	@Test(dataProvider = "VtigerLoginApp")
	
	public void TestLogin(String User, String Pswd) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Selenium Browsers Jars\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
		driver.findElement(By.id("username")).sendKeys(User);
		driver.findElement(By.id("password")).sendKeys(Pswd);
		driver.findElement(By.xpath("//button[@class='btn btn-primary sbutton']")).click();
		Thread.sleep(5000);
		
		//Assert.assertTrue(driver.getTitle().contains("Home"),"User Not able to Login - Invalid Credentials");
		//System.out.println("Browser Title Verified - User Can Login Successfully");
		driver.quit();
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
	@DataProvider(name = "VtigerLoginApp")
	public Object[][] passdata()
	{
		Object[][] data = new Object[3][2];
		
		data[0][0]="admin";
		data[0][1]="raghu";
		
		data[1][0]="admin112";
		data[1][1]="raghu";
		
		data[2][0]="admin";
		data[2][1]="raghu11";
		
		return data;
	}
}

