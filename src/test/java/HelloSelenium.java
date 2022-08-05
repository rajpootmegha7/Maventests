

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class HelloSelenium {

	public static void main(String[] args) {
		// To run on chrome driver
		//WebDriver driver = new ChromeDriver();
		
		//To run on Safari browser
		WebDriver driver = new SafariDriver();
		
        driver.get("https://selenium.dev");

        //driver.quit();

	}

}
