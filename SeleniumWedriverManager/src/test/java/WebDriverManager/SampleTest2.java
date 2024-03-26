package WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest2 {
	
	static WebDriver driver;
	
	@BeforeMethod
	@Parameters(value = {"Browser"})
	public void SetUp(String browser) {
		if(browser.toLowerCase().contains("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}else if (browser.toLowerCase().contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@AfterMethod
	public void CloseDriver() {
		driver.quit();
	}
	
	@Test
	public void getTitle() {
		System.out.println("Title:" +driver.getTitle());
		System.err.println("URL:" +driver.getCurrentUrl());
	}

}
