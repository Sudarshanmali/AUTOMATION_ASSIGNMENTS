package com.seleniumprograms;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assignment2 {
public WebDriver driver;
	
	@BeforeMethod
	public void LoginToApplication() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\karti\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//Navigate to Flipkart Home page
		driver.get("https://www.flipkart.com/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("sudarshanmali703@gmail.com");
		driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys("Pass@1999",Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("shoes",Keys.ENTER);
		Thread.sleep(5000);
		//Sort price Low to High
		driver.findElement(By.xpath("//div[text()='Price -- Low to High']")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority=1)
	public void Test1() throws InterruptedException
	{
		//Select second product from the page
		driver.findElement(By.xpath("(//a[@target='_blank'])[4]//child::div/div/div/div/img")).click();
		//For handling windows
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		
		Iterator<String> iterator =windowHandles.iterator();
		String parentWindow = iterator.next();
		String childWindow = iterator.next();
	
		driver .switchTo().window(childWindow);	
		//Select shoe size
		driver.findElement(By.xpath("//a[text()='6']")).click();
		//Add product in to cart
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
	}
	
	
	@Test(priority=2)
	public void Test2() throws InterruptedException
	{
		//Select third product from the page
		driver.findElement(By.xpath("(//a[@target='_blank'])[7]//child::div/div/div/div/img")).click();
		//For handling windows
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		
		Iterator<String> iterator =windowHandles.iterator();
		String parentWindow = iterator.next();
		String childWindow = iterator.next();
		driver.switchTo().window(childWindow);
		//Select shoe size
		driver.findElement(By.xpath("//a[text()='7']")).click();
		//Add product in to cart
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		//driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		//Open Cart
		driver.findElement(By.xpath("//a[@class='_3SkBxJ']")).click();
		
		//For getting actual total amount of both products
		String actualtotal = driver.findElement(By.xpath("//div[@class='Ob17DV _3X7Jj1']")).getText();
		System.out.println(actualtotal);
		String product1= driver.findElement(By.xpath("(//span[@class='_2-ut7f _1WpvJ7'])[1]")).getText();
		System.out.println(product1);
		String product2= driver.findElement(By.xpath("(//span[@class='_2-ut7f _1WpvJ7'])[2]")).getText();
		System.out.println(product2);
		
		String Expetedtotal ="?568";
		//To validate actual vs expected prices of the product
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(Expetedtotal,actualtotal );
	}
	
	@AfterMethod
	public void LogoutTheApplication()
	{
		driver.quit();
	}
}