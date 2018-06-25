package tatoc.tatocMaven;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AppTest extends App{
	WebDriver driver;
	
	@BeforeClass
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "/home/qainfotech/Desktop/chrome.exe");
		driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	
	//1st page-choosing "basic course" linkText
	@Test
	public void page1()
	{
		basicCourse();
		//driver.findElement(By.linkText("Basic Course")).click();
		Assert.assertEquals("Test Automation Training Obstacle Course", driver.getTitle());
	}
	//2nd page-choose green box in grid gate 
	@Test
	public void page2()
	{
		greenBox();
		Assert.assertEquals("Grid Gate", driver.getTitle());
	}
	
	//3rd page- "Repaint Box-2" in Frame Dungeon
	@Test
	public void page3()
	{
		driver.switchTo().frame(0);
		WebElement box1 = driver.findElement(By.id("answer"));
		String colorOfBox1 = box1.getAttribute("class");
		String colorOfBox2 = "";
		while(!colorOfBox2.equals(colorOfBox1))
		{
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.findElement(By.cssSelector("a")).click();
	    driver.switchTo().frame(0);
	    colorOfBox2 = driver.findElement(By.id("answer")).getAttribute("class");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0).findElement(By.linkText("Proceed")).click();   
	}

}
