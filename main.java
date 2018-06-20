package test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class main {


    public static void main(String[] args) {
       System.setProperty("webdriver.chrome.driver","C:\\Users\\rahulgumber\\Downloads\\chromedriver.exe");
	   WebDriver driver = new ChromeDriver();
    	Object color;
        String baseUrl = "http://10.0.1.86/tatoc";
        driver.get(baseUrl);
       driver.findElement(By.linkText("Basic Course")).click();
       driver.findElement(By.className("greenbox")).click();
     color= driver.findElement(By.className("green")).getClass();       
     System.out.println("color"); 
     //driver.close();
       
    }

}