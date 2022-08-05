import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.*;

	
	public class Homework2Test {
	
	
	  public static WebDriver driver;
	  WebElement element;
	  WebDriverWait wait;

	  @BeforeSuite
	  public void instantiate()
	  {
		  driver = new SafariDriver();
			wait = new WebDriverWait(driver, 10);
	  }
	  
	  // Course Generation (1)
	  @Test(priority = 1)
	  public void empty_schedule() throws InterruptedException
	  {
		// Setup
		driver.get("https://quacs.org/spring2022/#/");
		Thread.sleep(4000);
		driver.manage().window().maximize();
		
		// Find the "Schedule" element
		element = driver.findElement(By.xpath("/html/body/div/div[1]/nav/div/ul/ul/li[4]/a"));
		element.click();
		Thread.sleep(3000);
		
		// Retrieve the h3 title tag
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/h3"));
		WebElement tag_title = driver.findElement(By.xpath("//h3[contains(text(), 'It looks like you have not selected any courses yet :(')]"));
		String original_title = tag_title.getText();
		Thread.sleep(5000);
		
		// Return to the homepage to make way for other tests
		element = driver.findElement(By.xpath("/html/body/div/div[1]/nav/a/img"));
		element.click();
		Thread.sleep(5000);
		
		// Assert
		String expected_tag_title = "It looks like you have not selected any courses yet :(";
		Assert.assertEquals(original_title, expected_tag_title, "Not viewing an empty schedule");  
	  }
	  
	  // Course Navigation (1)
	  @Test(priority = 2)
	  public void access_prerequisites_page() throws InterruptedException
	  {
		// Setup
		driver.get("https://quacs.org/spring2022/#/");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		// Find the "Prerequisites" element
		element = driver.findElement(By.xpath("/html/body/div/div[1]/nav/div/ul/ul/li[3]/a"));	
		element.click();
		
		// Retrieve the h1 title tag
		WebElement tag_title = driver.findElement(By.xpath("//h1[contains(text(), 'Prerequisites')]"));
		String original_title = tag_title.getText();
		Thread.sleep(1000);
		
		// Return to the homepage to make way for other tests
		element = driver.findElement(By.xpath("/html/body/div/div[1]/nav/a/img"));
		element.click();
		Thread.sleep(1000);
		
		// Assert
		String expected_tag_title = "Prerequisites";
		Assert.assertEquals(original_title, expected_tag_title, "Not on the prerequisite page");
	  }
	  
	  // Course Navigation (2)
	  @Test(priority = 3)
	  public void check_correct_prefixes() throws InterruptedException
	  {
		// Setup
		driver.get("https://quacs.org/spring2022/#/");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		// Access the 'COGS: Cognitive Science' courses
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div[2]/div[1]/div[2]/div[2]/a"));
		element.click();
		WebElement cog_tag = driver.findElement(By.xpath("//h1[contains(text(), 'COGS: Cognitive Science')]"));
		String cog_tag_str = cog_tag.getText();
		Thread.sleep(1000);
		
		// Return to the homepage
		element = driver.findElement(By.xpath("/html/body/div/div[1]/nav/a/img"));
		element.click();
		Thread.sleep(1000);
		
		// Access the 'CSCI: Computer Science' courses
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div[2]/div[6]/div[2]/div[5]/a"));
		element.click();
		WebElement csci_tag = driver.findElement(By.xpath("//h1[contains(text(), 'CSCI: Computer Science')]"));
		String csci_tag_str = csci_tag.getText();
		Thread.sleep(1000);
		
		// Return to the homepage to make way for other tests
		element = driver.findElement(By.xpath("/html/body/div/div[1]/nav/a/img"));
		element.click();
		Thread.sleep(1000);
		
		// Assert
		String expected_tag_title = "COGS: Cognitive Science";
		Assert.assertEquals(cog_tag_str, expected_tag_title, "Did not find the COGS: Cognitive Science page");
		expected_tag_title = "CSCI: Computer Science";
		Assert.assertEquals(csci_tag_str, expected_tag_title, "Did not find the CSCI: Computer Science page");
	  }
	  
	  // Course Navigation (3)
	  @Test(priority = 5)
	  public void check_full_course() throws InterruptedException
	  {
		// Setup
		driver.get("https://quacs.org/spring2022/#/");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		// Access the 'MATH: Mathematics' courses
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div[2]/div[6]/div[2]/div[8]/a"));
		element.click();
		
		// Access the 'MATH-4100 Linear Algebra' course
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div/div[9]"));
		element.click();
		
		// Retrieve the status of the course capacity
		WebElement capacity_tag = driver.findElement(By.xpath("//span[contains(text(), 'Full Course')]"));
		String capacity_tag_str = capacity_tag.getText();
		Thread.sleep(1000);
		
		// Return to the homepage to make way for other tests
		element = driver.findElement(By.xpath("/html/body/div/div[1]/nav/a/img"));
		element.click();
		Thread.sleep(1000);
		
		// Assert
		String expected_tag_title = "Full Course";
		Assert.assertEquals(capacity_tag_str, expected_tag_title, "Course is not full");
	  }
	  
	  // Course Search (1)
	  @Test(priority = 6)
	  public void search_courses_with_keyword() throws InterruptedException
	  {
		// Setup
		driver.get("https://quacs.org/spring2022/#/");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		// Navigate to the search bar
		element = driver.findElement(By.xpath("/html/body/div/div[1]/nav/div/div/input"));
		element.click();
		
		// Search for "comp"
		element.sendKeys("comp");
		Thread.sleep(2000);
		
		// Retrieve the title of the first course result
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div[1]"));
		element.click();
		WebElement course_title_tag = driver.findElement(By.xpath("//span[contains(text(), 'Computer Organization')]"));
		String course_title_str = course_title_tag.getText();
		Thread.sleep(1000);

		// Return to the homepage to make way for other tests
		element = driver.findElement(By.xpath("/html/body/div/div[1]/nav/a/img"));
		element.click();
		Thread.sleep(1000);
		
		// Assert
		String expected_tag_title = "CSCI-2500 Computer Organization";
		Assert.assertEquals(course_title_str, expected_tag_title, "Course does not contain \"comp\" in its title");
	  }
	 
	  // Course Search (2)
	  @Test(priority = 7)
	  public void search_courses_with_prefix() throws InterruptedException
	  {
		// Setup
		driver.get("https://quacs.org/spring2022/#/");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		// Navigate to the search bar
		element = driver.findElement(By.xpath("/html/body/div/div[1]/nav/div/div/input"));
		element.click();
		
		// Search for "csci"
		element.sendKeys("csci");
		Thread.sleep(2000);
		
		// Retrieve the title of the first course result
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div[1]"));
		element.click();
		WebElement course_title_tag = driver.findElement(By.xpath("//span[contains(text(), 'CSCI')]"));
		String course_title_str = course_title_tag.getText();
		Thread.sleep(1000);

		// Return to the homepage to make way for other tests
		element = driver.findElement(By.xpath("/html/body/div/div[1]/nav/a/img"));
		element.click();
		Thread.sleep(1000);
		
		// Assert
		String expected_tag_title = "CSCI-1100";
		Assert.assertEquals(course_title_str, expected_tag_title, "Course does not contain \"csci\" in its prefix");
	  }
	  
	  // Course Search (3)
	  @Test(priority = 8)
	  public void search_courses_with_id() throws InterruptedException 
	  {
		// Setup
		driver.get("https://quacs.org/spring2022/#/");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		// Navigate to the search bar
		element = driver.findElement(By.xpath("/html/body/div/div[1]/nav/div/div/input"));
		element.click();
		
		// Search for "4480"
		element.sendKeys("4480");
		Thread.sleep(2000);
		
		// Retrieve the title of the first course result
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div"));
		element.click();
		WebElement course_title_tag = driver.findElement(By.xpath("//span[contains(text(), '4480')]"));
		String course_title_str = course_title_tag.getText();
		Thread.sleep(1000);
		
		// Return to the homepage to make way for other tests
		element = driver.findElement(By.xpath("/html/body/div/div[1]/nav/a/img"));
		element.click();
		Thread.sleep(1000);
		
		// Assert
		String expected_tag_title = "BMED-4480";
		Assert.assertEquals(course_title_str, expected_tag_title, "Course does not contain \"csci\" in its prefix");  
	  }
	  
	  // Course Generation (2)
	  @Test(priority = 9)
	  public void generate_multiple_schedules() throws InterruptedException
	  {
		// Setup
		driver.get("https://quacs.org/spring2022/#/");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		// Access the 'CSCI: Computer Science' courses
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div[2]/div[6]/div[2]/div[5]/a"));
		element.click();
		
		// Access the 'CSCI-2300 Introduction to Algorithms' course
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div/div[4]/div[1]"));
		element.click();
		Thread.sleep(1000);
		
		// Then, select all of CSCI-2300's sections
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div/div[4]/div[2]/div/div/table/thead/tr"));
		element.click();
		Thread.sleep(1000);
		
		// Access the 'CSCI-2600 Principles of Software' course
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div/div[6]/div[1]"));
		element.click();
		Thread.sleep(1000);	
		
		// Then, select all of CSCI-2600's sections
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div/div[6]/div[2]/div/div/table/thead/tr"));
		element.click();
		Thread.sleep(1000);
		
		// Access the schedule
		element = driver.findElement(By.xpath("/html/body/div/div[1]/nav/div/ul/ul/li[4]/a"));
		element.click();
		
		// Retrieve the number of possible schedules generated
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div[1]/div/div[1]/span"));
		WebElement num_of_schedules_tag = driver.findElement(By.xpath("//span[contains(text(), 'Viewing schedule 1 out of 36 generated schedules')]"));
		String num_of_schedules_str = num_of_schedules_tag.getText();
		Thread.sleep(1000);
		
		// Assert
		String expected_num_of_schedules = "Viewing schedule 1 out of 36 generated schedules";
		Assert.assertEquals(expected_num_of_schedules, num_of_schedules_str, "Incorrect number of schedules generated");
		
		// Untoggle all sections for CSCI-2300
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/span"));
		element.click();
		Thread.sleep(1000);
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div[2]/div[1]/div[2]/div/div/table/thead/tr"));
		element.click();
		Thread.sleep(1000);
		
		// Untoggle all sections for CSCI-2600
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div[2]/div[2]"));
		element.click();
		Thread.sleep(1000);
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div[2]/div[2]/div[2]/div/div/table/thead/tr"));
		element.click();
		Thread.sleep(1000);
		
		// Retrieve the grid tag
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/h3"));
		WebElement uh_oh_tag = driver.findElement(By.xpath("//h3[contains(text(), ' Uh oh! You have deselected all sections! Please select at least one section. ')]"));
		String uh_oh_str = uh_oh_tag.getText();
		Thread.sleep(1000);
		
		// Assert
		String expected_msg = "Uh oh! You have deselected all sections! Please select at least one section.";
		Assert.assertEquals(expected_msg, uh_oh_str, "Not all sections were deselected.");
		
		// Return to the homepage to make way for other tests
		element = driver.findElement(By.xpath("/html/body/div/div[1]/nav/a/img"));
		element.click();
		Thread.sleep(1000);
	  }
	  
	  // Course Selection (1)
	  @Test(priority = 10)
	  public void select_course() throws InterruptedException
	  {
		// Setup
		driver.get("https://quacs.org/spring2022/#/");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		// Access the 'IHSS: Interdisciplinary Studies' courses
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div[2]/div[1]/div[2]/div[6]/a"));
		element.click();
		
		// Access the 'IHSS-1200 Principles of Economics' course
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div/div[3]"));
		element.click();
		Thread.sleep(1000);
		
		// Click the row of 'Section 1'
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div/div[3]/div[2]/div/div/table/tbody/tr[1]"));
		element.click();
		Thread.sleep(2000);	// Gives time for tester to check that the row is highlighted in blue
		
		// Assert
		boolean isPresent = driver.findElements(By.className("course-row")).size() > 0;
		Assert.assertEquals(isPresent, true, "Course is not selected");
		
		// Return to the homepage to make way for other tests
		element = driver.findElement(By.xpath("/html/body/div/div[1]/nav/a/img"));
		element.click();
		Thread.sleep(5000);
	  }
	  
	  // Course Selection (2)
	  @Test(priority = 11)
	  public void find_conflicting_course() throws InterruptedException
	  {
		// Setup
		driver.get("https://quacs.org/spring2022/#/");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		// Access the 'ARTS: Arts' courses
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div[2]/div[1]/div[2]/div[1]/a"));
		element.click();
		
		// Access the 'ARTS-1380 Fundamentals of Music & Sound' course
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div/div[5]"));
		element.click();
		Thread.sleep(2000);	// Gives time for tester to check that the row is highlighted in red
		
		// Assert
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div/div[5]/div[2]/div/div/table/tbody/tr"));
		boolean isPresent = driver.findElements(By.className("conflict")).size() > 0;
		Assert.assertEquals(isPresent, true, "Course does not have time conflict(s)");
		
		// Return to the homepage to make way for other tests
		element = driver.findElement(By.xpath("/html/body/div/div[1]/nav/a/img"));
		element.click();
		Thread.sleep(1000);
	  }
	  
	  // Course Selection (3)
	  @Test(priority = 12)
	  public void adjust_time_conflicts() throws InterruptedException
	  {
		// Setup
		driver.get("https://quacs.org/spring2022/#/");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		// Access the 'CSCI: Computer Science' courses
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div[2]/div[6]/div[2]/div[5]/a"));
		Thread.sleep(5000);
		element.click();
		
		
		// Access the 'CSCI-2500 Computer Organization' course
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div/div[5]/div[1]"));
		Thread.sleep(5000);
		element.click();
		
		
		// Click the row of Section 1
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div/div[5]/div[2]/div/div/table/tbody/tr[1]"));
		element.click();
		Thread.sleep(2000);	// Gives time for tester to check that the row is highlighted in blue
		
		// Access the 'CSCI-2200 Foundations Of Computer Sci' course
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div/div[3]"));
		element.click();
		Thread.sleep(2000);	// Gives time for tester to check that the row(s) is highlighted in red
		
		// Assert 
		boolean isPresent = driver.findElements(By.className("conflict")).size() > 0;
		Assert.assertEquals(isPresent, true, "Course does not have time conflict(s)");
		Thread.sleep(5000);
		
		// Deselect 'CSCI-2500 Computer Organization'
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div/div[5]"));
		element.click();
		Thread.sleep(2000);
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div/div[5]/div[2]/div/div/table/tbody/tr[1]"));
		Thread.sleep(3000);	// Gives time for tester to check that CSCI-2500 is not selected AND CSCI-2200 is no longer highlighted in red
		
		// Assert
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div/div[3]/div[2]/div/div/table/tbody/tr[1]"));
		isPresent = driver.findElements(By.className("conflict")).size() > 0;
		Assert.assertEquals(isPresent, true, "Course still has time conflict(s)");
		
		// Return to the homepage to make way for other tests
		element = driver.findElement(By.xpath("/html/body/div/div[1]/nav/a/img"));
		element.click();
		Thread.sleep(4000);	  
	  }
	  
	  // Course Generation (3)
	  @Test(priority = 13)
	  public void add_two_conflicting_courses() throws InterruptedException
	  {
		// Setup
		driver.get("https://quacs.org/spring2022/#/");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		  
		// Access the 'ARTS: Arts' courses
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div[2]/div[1]/div[2]/div[1]/a"));
		element.click();
		
		// Access the 'ARTS-1380 Fundamentals of Music & Sound' course
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div/div[5]"));
		element.click();
		Thread.sleep(5000);	// Gives time for tester to check that the row is highlighted in red
		
		// Select the first section of ARTS-1380
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div/div[5]/div[2]/div/div/table/tbody/tr"));
		element.click();
		
		// Navigate to 'Schedule'
		element = driver.findElement(By.xpath("/html/body/div/div[1]/nav/div/ul/ul/li[4]/a"));
		element.click();
		
		// Retrieve the grid tag
		element = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/h3"));
		WebElement grid_tag = driver.findElement(By.xpath("//h3[contains(text(), ' Uh oh! All possible schedules have conflicts! Try choosing more sections. ')]"));
		String grid_str = grid_tag.getText();
		Thread.sleep(5000);
		
		// Return to the homepage to make way for other tests
		element = driver.findElement(By.xpath("/html/body/div/div[1]/nav/a/img"));
		element.click();
		Thread.sleep(5000);
		
		// Assert
		String expected_grid_msg = "Uh oh! All possible schedules have conflicts! Try choosing more sections.";
		Assert.assertEquals(expected_grid_msg, grid_str, "A conflict does not exist among the two courses.");
	  }
	  
	  @DataProvider (name = "emailable-report")
	  public Object[][] dataProviderFunc()
	  {
		return new Object[][] {
			{"First"}, {"Second"}
		};
	  }
	  
	  @AfterSuite
	  public void afterMethod()
	  {
	    driver.close();
	    System.out.println("Finished Test On Chrome Browser");
	  }
	}

