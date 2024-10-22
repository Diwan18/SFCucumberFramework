package sfPagePack;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberSFLogin {
	
	public ChromeDriver driver;
	public ChromeOptions option;
	
	@When("Enter the UserName as {string}")
	public void enter_the_user_name_as(String Uname) {
		option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.findElement(By.id("username")).sendKeys(Uname);
	}

	@When("Enter the Password as {string}")
	public void enter_the_password_as(String Pass) {
	    driver.findElement(By.id("password")).sendKeys(Pass);
	}

	@When("Click on Login button")
	public void click_on_login_button() {
	    driver.findElement(By.id("Login")).click();
	}
	
	@When("Click on the toggle menu button in the left corner")	
	public void click_on_the_toggle_menu_button_in_the_left_corner() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	}

	@When("Click on View All")
	public void click_on_View_All() throws InterruptedException {
			Thread.sleep(5000);
	    	driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
	    	Thread.sleep(5000);
	}

	@When("Select Sales from the App Launcher")
	public void select_from_the_app_launcher() throws InterruptedException {
	    driver.findElement(By.xpath("//p[text()='Sales']")).click();
	  Thread.sleep(5000);  
	    
	}
	
	@When("Click on Opportunity tab")
	public void click_on_opportunity_tab() {
	   WebElement opportunityTab = driver.findElement(By.xpath("//span[text()='Opportunities']"));
	   JavascriptExecutor Executer = (JavascriptExecutor) driver;
	   Executer.executeScript("arguments[0].click();",opportunityTab);
	}
	
	@When("Click on the new button")
	public void click_on_the_new_button() throws InterruptedException {
	    driver.findElement(By.xpath("//div[text()='New']")).click();
	Thread.sleep(5000);
	}
	
	

	@When("Enter the Opportunity name as {string}")
	public void enter_the_opportunity_name_as_by_your_name(String Name) {
	    driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(Name);
	}

	@When("Enter Amount as {string}")
	public void enter_amount_as(String amount) {
	    driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys(amount);
	}

	@When("Choose the close date as Today")
	public void choose_the_close_date_as_today() {
	   driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
	   driver.findElement(By.xpath("//button[@name='today']")).click();
	}

	@When("Select Stage as Need Analysis")
	public void select_as() {
	    driver.findElement(By.xpath("//button[@aria-label='Stage']")).click();
	    driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
	}

	@When("Click on save button")
	public void click_on_save_button() {
	   driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	}

	@Then("Verify the opportunity Name as {string}")
	public void verify_the_opportunity_name(String givenName) {
	    WebElement OppName = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']"));
	    String OpportunityName = OppName.getText();
	    System.out.println(OpportunityName);
	    
	    String ExpectingText = givenName;
	    driver.quit();
	    
	    Assert.assertEquals(OpportunityName, ExpectingText);
	    System.out.println("The opportunity Name is Verified");}
		



@When("Search for the Opportunity {string}")
public void search_for_the_opportunity(String OppName) throws InterruptedException {
   driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(OppName,Keys.ENTER);
   Thread.sleep(4000);
}

@When("Click on DropDown Icon")
public void click_on_drop_down_icon() throws InterruptedException {
    driver.findElement(By.xpath("//table[@role='grid']/tbody/tr[1]/td[8]/span")).click();
    Thread.sleep(4000);
}

@When("Select Edit button")
public void select_edit_button() {
    driver.findElement(By.xpath("//a[@title='Edit']")).click();
}

@When("Choose the close date as Tomorrow date")
public void choose_the_close_date_as_tomorrow_date() {		
	
//	Taking the current date 
	 LocalDate Date = LocalDate.now();
	 
//	 switching to next date
	 LocalDate NextDay = Date.plusDays(1);
//	 Setting the Dateformat
	 DateTimeFormatter Format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//	 Changing the date format
	 String tomoDate = NextDay.format(Format);
	
	driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
	driver.findElement(By.xpath("//input[@name='CloseDate']")).clear();
	driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys(tomoDate);
	 
	
//	driver.findElement(By.xpath("//table[@role='grid']/tbody/tr[4]/td[6]/span")).click();
	
	
	

}

@When("Select Stage as Perception Analysis")
public void select_stage_as_perception_analysis() throws InterruptedException {
	driver.findElement(By.xpath("//button[@aria-label='Stage']")).click();
    driver.findElement(By.xpath("//span[@title='Perception Analysis']")).click();
    Thread.sleep(4000);
}

@When("Select Delivery\\/Installation Status as In Progress")
public void select_delivery_installation_status_as_in_progress() {
//	driver.findElement(By.xpath("(//span[@class='slds-truncate'])[44]")).click();
//    driver.findElement(By.xpath("//span[@title='In progress']")).click();
	
	WebElement Delivery = driver.findElement(By.xpath("//button[@aria-label='Delivery/Installation Status']"));
	driver.executeScript("arguments[0].click();", Delivery);
	WebElement InProgress = driver.findElement(By.xpath("//span[text()='In progress']"));
	driver.executeScript("arguments[0].click();", InProgress);
}

@When("Enter Description as SalesForce")
public void enter_description_as_sales_force() {
	driver.findElement(By.xpath("//textarea[@part='textarea']")).sendKeys("SalesForce");
}

@When("Click on Save")
public void click_on_save() throws InterruptedException {
	driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
	Thread.sleep(40);
    
}

@Then("verify the Stage as Perception Analysis")
public void verify_the_stage_as_perception_analysis() throws InterruptedException {
	Thread.sleep(4000);
	WebElement Stage = driver.findElement(By.xpath("//table[@role='grid']//span[text()='Perception Analysis']"));
   String StageName = Stage.getText();
   System.out.println(StageName);
   
   if(StageName.equalsIgnoreCase("Perception Analysis")) {
	   System.out.println("The Stage Name is Verified Succesfully");
   }
   else {
	   System.out.println("The Stage Name  is not Verified");
   }
   
}}




