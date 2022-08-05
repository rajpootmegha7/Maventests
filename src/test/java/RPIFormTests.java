import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class RPIFormTests {
	public static WebDriver driver;
	WebElement element;
	WebDriverWait wait;

	@BeforeClass 
	public void instantiate() {
		driver = new SafariDriver();
		wait = new WebDriverWait(driver, 10);
	}
	

	@Test(priority= 1, description = "Verify that application management navigation is correct.")
	public void navigateTestManagement() throws InterruptedException {
		driver.get("https://apply.rpi.edu/apply/");
		// Implicit wait command
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		element = driver.findElement(By.xpath("//div[@class='c_container cr']/div[@id='content']/h1"));
		wait.until(ExpectedConditions.visibilityOf(element));
		
		String actual_name = element.getText();
		String expected_name = "Application Management			";
		
		Assert.assertEquals(actual_name, expected_name, "Name doesn't match.");

	}
	
	
	@AfterClass
	public void afterMethod() {
		driver.close();
		System.out.println("Finished Test On Safari Browser");
	}
	


}
