package qaTraining;

import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tatoc {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		//T.A.T.O.C. - Test Automation Training Obstacle Course
		driver.findElement(By.linkText("Basic Course")).click();	
		//Grid Gate
		driver.findElement(By.className("greenbox")).click();
				
		//Frame Dungeon
		driver.switchTo().frame(0);
		WebElement box1 = driver.findElement(By.id("answer"));
		String colorBox1 = box1.getAttribute("class");
		String colorBox2 = "";
	    while(!colorBox1.equals(colorBox2)){
		    driver.switchTo().defaultContent();
		    driver.switchTo().frame(0);
		    driver.findElement(By.cssSelector("a")).click();
		    driver.switchTo().frame(0);
		    colorBox2 = driver.findElement(By.id("answer")).getAttribute("class");
		     }
	   driver.switchTo().defaultContent();
	   driver.switchTo().frame(0).findElement(By.linkText("Proceed")).click();   
	   //Drag Around
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   WebElement dragbox = driver.findElement(By.id("dragbox"));
	   js.executeScript("arguments[0].setAttribute('style','position: relative; left: 30px; top: -71px;')",
			   dragbox);	   
	    driver.findElement(By.linkText("Proceed")).click();
		//Pop up Windows
	    driver.findElement(By.linkText("Launch Popup Window")).click();
        String parentwindow = driver.getWindowHandle();
	    String subWindow = null;
	    Set<String> windows = driver.getWindowHandles();
	    Iterator itr = windows.iterator();
	    while(itr.hasNext()){
	    	subWindow = (String) itr.next();
	    }
	    driver.switchTo().window(subWindow);
	    driver.findElement(By.id("name")).sendKeys("Kanika");
	    driver.findElement(By.id("submit")).click();
	    driver.switchTo().window(parentwindow);
	    driver.findElement(By.linkText("Proceed")).click();    
	    //Cookie Handling
	    driver.findElement(By.linkText("Generate Token")).click();
	    String token_text = driver.findElement(By.id("token")).getText();
	    String token = token_text.substring(token_text.indexOf(":")+2);
	    Cookie cookie = new Cookie("Token",token);
	    driver.manage().addCookie(cookie);
	    driver.findElement(By.linkText("Proceed")).click();
	    	
	}

}