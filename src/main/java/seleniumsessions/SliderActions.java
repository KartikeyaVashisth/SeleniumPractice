package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderActions {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://jqueryui.com/resources/demos/slider/default.html");
		WebElement slider = driver.findElement(By.id("slider"));

		slider.click(); //With Selenium 3.4.0 and above, it will click at the centre of the slider bar.
		
		int width = slider.getSize().getWidth();
		System.out.println(width);//1264
//		
		Actions act = new Actions(driver);
		//act.moveToElement(slider, -((width/2)-30), 0).click().build().perform(); //-((width/2)-30) negative means move to the left from centre of slider, positive > Right side.
		act.clickAndHold(slider).moveByOffset((width/2-40), 0).build().perform();
	

}
}
