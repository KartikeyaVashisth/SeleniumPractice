package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMConcept {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		Thread.sleep(5000);
		//driver.findElement(By.id("pizza")).sendKeys("veg pizza");
		
		//browser --> page --> shadowDOM --> shadow DOM ---> input element
		//If there are multiple ShadowDOM in the application, better to use some other tool like PlayWright.
		//shadowDOM should be in open state, if closed, no tool can work on it then, will need to ask developers to open the shadowDOM.
		//Shadow DOM elements don’t support xpath so we can write only cssSelector for shadow DOM elements.
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement pizza = (WebElement)js.executeScript("return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")");
		
		pizza.sendKeys("veg pizza");
		
		
		//
		driver.get("chrome://settings/");
		WebElement search  = (WebElement)js.executeScript("return document.querySelector(\"body > settings-ui\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#search\").shadowRoot.querySelector(\"#searchInput\")");
		search.sendKeys("notification");
		
		
	}

}
