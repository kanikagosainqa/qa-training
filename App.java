package tatoc.tatocMaven;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class App 
{
	
	WebDriver driver ;
	//System.setProperty("webdriver.firefox.driver", "/home/qainfotech");
	//driver.navigate().to("http://10.0.1.86/tatoc");
	//driver.get("http://10.0.1.86/tatoc");
	
	public void basicCourse(){
		driver.findElement(By.linkText("Basic Course")).click();
		
	}
	public void greenBox(){
		driver.findElement(By.className("greenbox")).click();
	}
}

