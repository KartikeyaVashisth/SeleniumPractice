package seleniumsessions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationConcepts {

	public static void main(String[] args) throws MalformedURLException {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		System.out.println(driver.getTitle());
		
		//driver.navigate().to(new URL("https://www.amazon.com/"));
		
		driver.navigate().to("https://www.amazon.com/");
		//Diff between get() and naviaget.to() method is:
		//1. .get("") will wait until the page gets loaded completely whereas navigate().to("") it will redirect to the page and then return immediately.
		//2. .get("") will not retain browser history whereas navigate.to("") will remember the browser history and therefore we can navigate back and forth.
		
		System.out.println(driver.getTitle());

		driver.navigate().back();
		System.out.println(driver.getTitle());

		driver.navigate().forward();
		System.out.println(driver.getTitle());

		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().refresh();//refresh the page
		
		
//		int a = driver.findElements(By.xpath("//input[@type='email']")).size();
//		int b = driver.findElements(By.xpath("//input[@type='text']")).size();
//		int c = driver.findElements(By.xpath("//input[@type='tel']")).size();
//		int d = driver.findElements(By.xpath("//input[@type='password']")).size();
//		System.out.println(a+b+c+d); //6
//		
//		//form//input[@placeholder] --- 6
				
	}

}
