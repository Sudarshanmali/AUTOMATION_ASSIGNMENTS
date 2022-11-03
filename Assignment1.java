package com.seleniumprograms;

import java.security.PublicKey;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment1{

	public WebDriver driver;
	
	@BeforeMethod
	public void LoginToApplication()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\karti\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//Navigate to Flipkart Home page
		driver.get("https://www.flipkart.com/");
//		driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("sudarshanmali703@gmail.com");
//		driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys("Pass@1999",Keys.ENTER);
		driver.findElement(By.xpath("//button[text()='✕']")).click();
	}
	
	@Test
	public void Test1() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("shoes",Keys.ENTER);
		Thread.sleep(5000);
		//Sort price Low to High
		driver.findElement(By.xpath("//div[text()='Price -- Low to High']")).click();
		Thread.sleep(5000);
		
		//To store all product prices in List
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='_30jeq3']"));
		System.out.println(price.size());
		//For getting prices of all products available on page 1
		for (WebElement i : price)
		{
			System.out.println(i.getText());
		}
			
		Thread.sleep(5000);  
		//Navigate to page 2
		driver.findElement(By.xpath("//a[text()='2']")).click();
		Thread.sleep(5000);
		//To store all product prices in List
		List<WebElement> price1 = driver.findElements(By.xpath("//div[@class='_30jeq3']"));
		System.out.println(price1.size());
		      
		//For getting prices of all products available on page 2
		for (WebElement j : price1)
		{
			System.out.println(j.getText());
		}
		
//		@AfterMethod
//		public void LogoutTheApplication()
//		{
//			driver.close();
//		}	
	}
}
