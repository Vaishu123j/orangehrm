package main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Base.BaseClassTest;
import Base.LoginTest;
import Base.UserManagement;



public class UserManagementTab extends BaseClassTest{
	WebDriver driver;
	private LoginTest login;

	@BeforeClass
	public void SetUp() {
		driver = intialization("Chrome");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Log in to OrangeHRM
		LoginTest login = new LoginTest(driver);
		
		
		login.enterUsername("Admin");
		 login.enterPassword("admin123");
		 login.clickLoginButton();



		
	}

	@Test

	public void verifytheTab() {
		WebElement adminTab = driver.findElement(By.className("oxd-main-menu-item"));
		adminTab.click();
		WebElement UsermanagementTab = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]/span"));
		UsermanagementTab.click();

	}

	@Test
	public void Verifyaddbutton() {
		WebElement addUserButton = driver
				.findElement(By.xpath("//*[@id=\\\"app\\\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button"));

		if (addUserButton.isEnabled()) {
			// Placeholder for the functionality to be added
			// You can add your code to perform an action here
			System.out.println("Add User functionality is enabled. Proceed with your functionality.");
		} else {
			// Placeholder for the functionality if the "Add User" button is disabled
			// You can add alternative actions or assertions here
			System.out.println("Add User functionality is disabled. Handle this scenario.");
		}
	}

	@Test(dependsOnMethods = "verifytheTab")
	public void Addfunctionality() {

		try {
			// Navigate to the Admin tab
			WebElement AddButton = driver
					.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button"));
			AddButton.click();

			// Click on the 'userole' button to add a new user
			WebElement UserRole = driver.findElement(By.xpath(
					"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]/i"));
			UserRole.click();
			driver.findElement(By.className("oxd-select-text-input")).click();

			// Fill in user details 
			WebElement EmployeeName = driver.findElement(By.xpath(
					"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input"));
			EmployeeName.sendKeys("John");

			WebElement Username = driver.findElement(
					By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input"));
			Username.sendKeys("Doe");

			WebElement Status = driver.findElement(By.xpath(
					"///*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]/i"));
			Status.click();
			driver.findElement(By.xpath(
					"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]"))
					.click();

			WebElement passwordField = driver.findElement(
					By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input"));
			passwordField.sendKeys("securepassword");

			WebElement confirmPasswordField = driver.findElement(
					By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input"));
			confirmPasswordField.sendKeys("securepassword");

			WebElement saveButton = driver
					.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]"));
			saveButton.click();

			
			Assert.assertTrue(driver.findElement(By.id("systemUser_userType")).isDisplayed(), "User was not added.");

		} catch (Exception e) {
			// Handle any exceptions that may occur during the process
			e.printStackTrace();
			Assert.fail("Exception occurred: " + e.getMessage());

		}}
	

	
	    @Test
		public void deletefunctionality() {
	    	UserManagement user =new UserManagement(driver);

			user.deleteUser("Admin");
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[1]/div/label/span/i")).click();
			 
			

	}

	@AfterClass
	public void end() {
		driver.quit();
	}




}
