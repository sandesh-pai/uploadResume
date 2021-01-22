package com.uploadresume;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NaukriUpload {




	@Test
	public void uploadResume() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.naukri.com/");

		String parentwindow = driver.getWindowHandle();

		Set<String> TotalWindows = driver.getWindowHandles();
		System.out.println(TotalWindows.size());
		TotalWindows.remove(parentwindow);
		for (String child : TotalWindows)
		{
			driver.switchTo().window(child);
			
			System.out.println(driver.getTitle());
			driver.close();
		}


		driver.switchTo().window(parentwindow);

		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath("//div[.= 'For Employers']"))).build().perform();

		driver.findElement(By.xpath("//a[.='Employer Login']")).click();

		
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[contains(.,'JobSeeker')]")))).click();

		
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='usernameField']"))).sendKeys("cashsandesh@gmail.com");
		
		

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("passwordField")))).sendKeys("85531@Pai");
		
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[.='Login']")))).click();

		
	//action.moveToElement(new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@id='blobId']/parent::li/following-sibling::li/a"))))).build().perform();
		
		
		
		
		
	new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[.='Naukri on WhatsApp!']")));
	
	
	
//	new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[.='Jobs Application Status']")));
	
	action.moveToElement(new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[.='My Naukri']"))))).build().perform();
	//a[.='Search Jobs']
		
       new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[.='Edit Profile']")))).click();
       Thread.sleep(3000);

       
     //  driver.findElement(By.xpath("//span[@class='slider round']")).click();
       
       
		
		  JavascriptExecutor jsp = (JavascriptExecutor) driver;
		  
		  jsp.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(By.
		  id("attachCV")));
		  
		  
		  new WebDriverWait(driver,
		  20).until(ExpectedConditions.presenceOfElementLocated(By.
		  xpath("//div[.='Attach Resume']")));
		  
		  driver.findElement(By.id("attachCV")).sendKeys(
		  "C:\\Users\\admin\\Documents\\sandesh_automation-alpa.docx");
		  
		  
		  jsp.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(By.
		  xpath("//div[.='My Naukri']")));
		  
		  
		  action.moveToElement(new WebDriverWait(driver,
		  20).until(ExpectedConditions.visibilityOf(driver.findElement(By.
		  xpath("//div[.='My Naukri']"))))).build().perform();
		  
		  driver.findElement(By.xpath("//a[.='Logout']")).click();
		  
		  driver.quit();
		  
		 

	}

}
