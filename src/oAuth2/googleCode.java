package oAuth2;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class googleCode {
	static WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUp()
	{		System.setProperty("webdriver.chrome.driver","C:\\Users\\hkohli\\Previous Data\\Selenium Software\\Chromedriver83\\chromedriver.exe");
			driver=new  ChromeDriver();
	}
	@Test(groups={"group1"})
	public void test1(){
		String a="https://www.google.com/";
		driver.get(a);
	}

	@Test(groups={"group1"})
	public void test2(){
		String a="https://www.facebook.com/";
		driver.get(a);
	}
	
	@Test(groups={"group2"})
	public void test3(){
		String a="https://www.gmail.com/";
		driver.get(a);
	}
	@Test(groups={"group2"})
	public void test4(){
		String a="https://www.yahoo.com/";
		driver.get(a);
	}
	@AfterClass(alwaysRun = true)
	public void close(){

		driver.quit();
	}
}
