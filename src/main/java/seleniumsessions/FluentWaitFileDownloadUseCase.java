package seleniumsessions;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class FluentWaitFileDownloadUseCase {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://get.jenkins.io/windows-stable/2.426.3/jenkins.msi");
		
		String downloadLocation = "/Users/kvashisth/Downloads";
		String filename = "jenkins.msi";
		
		File file = new File(downloadLocation,filename);
		
		FluentWait<File> wait = new FluentWait<File>(file) //FluentWait is not specific to WebDriver generics, it can take any generic(It is <T>) like here we have <File>
								.withTimeout(Duration.ofMinutes(2))
								.pollingEvery(Duration.ofSeconds(10))
								.ignoring(Exception.class)
								.withMessage("file is not downloaded");
		
		try { //try-catch block so as to cover the negative TC as well where the timeout happens and the file is not downloaded.
		Boolean isDownloaded = wait.until(f -> f.exists() && f.canRead()); //This f will represent the File object.
		
		if(isDownloaded) {
			System.out.println("File is completely 100% downloaded");
		}
		}
		catch(TimeoutException e) {
			System.out.println("File is not completely downloaded.");
		}
		
	}

}
