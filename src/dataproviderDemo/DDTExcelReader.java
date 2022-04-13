package dataproviderDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import library.ExcelConfigReader;

public class DDTExcelReader {
	
	WebDriver driver;
	@Test(dataProvider = "VtigerLoginApp")
	
	public void TestLogin(String UserName, String Password) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Selenium Browsers Jars\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.id("username")).sendKeys(UserName);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.xpath("//button[@class='btn btn-primary sbutton']")).click();
		Thread.sleep(5000);
		
		Assert.assertTrue(driver.getTitle().contains("Home"),"User Not able to Login - Invalid Credentails");
		System.out.println("Broser Title Varified - User Can Login Sucessfully");
		driver.quit();
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
	@DataProvider(name = "VtigerLoginApp")
	public Object[][] passdata()
	{
	ExcelConfigReader config = new ExcelConfigReader("D:\\DataSheets\\Data.xlsx");	
	
		int rows = config.getRowCount(0);
		
		Object[][] data = new Object[rows][2];
		
		for(int i=0;i<rows;i++){
			data[i][0]= config.getData(0, i, 0);
			data[i][1]= config.getData(0, i, 1);
		}
		return data;
	}
}

