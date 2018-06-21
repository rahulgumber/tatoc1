package test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.Cookie;
public class main 
{


    public static void main(String[] args) throws InterruptedException
    	{
    		System.setProperty("webdriver.chrome.driver","C:\\Users\\rahulgumber\\Downloads\\chromedriver.exe");
    		WebDriver driver = new ChromeDriver();
    		//Object color;
    		String baseUrl = "http://10.0.1.86/tatoc";
    		driver.get(baseUrl);
    		driver.findElement(By.linkText("Basic Course")).click();
    		driver.findElement(By.className("greenbox")).click();
    		//color= driver.findElement(By.className("green")).getClass();       
    		System.out.println("color"); 
    		boolean b = true;
    		driver.switchTo().frame("main");
    		String box1= driver.findElement(By.id("answer")).getAttribute("class");
    		{
    			// System.out.println(box1);
    			while(b)
    			{
    				driver.switchTo().frame("child");
    				String  box2= driver.findElement(By.id("answer")).getAttribute("class");
    				//System.out.println(box2);
    				if(box1.equals(box2))
    				{
    					b=false;
    					driver.switchTo().parentFrame();
    					driver.findElement(By.linkText("Proceed")).click();
    			    }
    			   else
    			   	{
    				   driver.switchTo().parentFrame();
    				   driver.findElement(By.linkText("Repaint Box 2")).click();
    		
    			   }
    			}
    					WebElement drag=driver.findElement(By.id("dragbox"));
    					WebElement drop=driver.findElement(By.id("dropbox"));
    					Actions act = new Actions(driver);
    					act.dragAndDrop(drag,drop).build().perform();
    					driver.findElement(By.linkText("Proceed")).click();
 	
    					driver.findElement(By.linkText("Launch Popup Window")).click();
    					String winHandleBefore = driver.getWindowHandle();
    					for (String winHandle : driver.getWindowHandles())
    					{
    						driver.switchTo().window(winHandle); 
    					}
    					driver.findElement(By.id("name")).click();
    					driver.findElement(By.id("name")).sendKeys("Rahul");	
    					driver.findElement(By.id("submit")).click();
    					driver.switchTo().window(winHandleBefore);
    					driver.findElement(By.linkText("Proceed")).click();
    	    	
    					driver.findElement(By.linkText("Generate Token")).click();
    					Thread.sleep(1000);
    					String token=driver.findElement(By.id("token")).getText();
    					System.out.println(token);
    					String Cookie= token.substring(7);
    					Cookie name = new Cookie("Token",Cookie);
    					driver.manage().addCookie(name);
    			
    					driver.findElement(By.linkText("Proceed")).click();
    					driver.close();
    	    	
    	    	
        
    	 } 		

    	 
     }
}

      
    

