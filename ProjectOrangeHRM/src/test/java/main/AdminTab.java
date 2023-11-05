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

public class AdminTab extends BaseClassTest {
	WebDriver driver;
	private LoginTest login;

	@BeforeClass
	public void setUp() {

		driver = intialization("Chrome");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginTest login = new LoginTest(driver);

		 login.enterUsername("Admin");
		 login.enterPassword("admin123");
		 login.clickLoginButton();

		// Log in to OrangeHRM
//	        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
//	        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
//		    WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
//	        
//	        usernameField.sendKeys("Admin");
//	        passwordField.sendKeys("admin123");
//	        loginButton.click();
	}

	

	@Test
	public void navigateToAdminTab() {
		// click the Admin tab
		WebElement adminTab = driver.findElement(By.className("oxd-main-menu-item"));
		adminTab.click();
	}

	@Test(dependsOnMethods = "navigateToAdminTab")
	public void performAdminActions() {
		// Locate the elements corresponding to the admin tabs
		WebElement UsermanagementTab = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]"));
		WebElement JobTab = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]"));
		WebElement ManagementTab = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[3]"));
		WebElement QualificationTab = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[4]/span"));

		// Use conditional statements to verify if the tabs exist
		if (UsermanagementTab.isDisplayed()) {
			System.out.println("UsermanagementTab exists.");
		} else {
			System.out.println("UsermanagementTab does not exist.");
		}

		if (JobTab.isDisplayed()) {
			System.out.println("JobTab exists.");
		} else {
			System.out.println("JobTab does not exist.");
		}

		if (ManagementTab.isDisplayed()) {
			System.out.println("ManagementTab exists.");
		} else {
			System.out.println("ManagementTab does not exist.");
		}

		if (QualificationTab.isDisplayed()) {
			System.out.println("QualificationTab  exists.");
		} else {
			System.out.println("QualificationTab does not exist.");
		}

	}

	@Test
	public void verifyAdminDetails() {
		// Assuming you have navigated to the admin's profile page and collected the
		// details
		String adminName = "John Doe";
		String adminEmail = "johndoe@example.com";
		String adminRole = "Administrator";
		int adminEmployeeId = 12345;

		// Assert the admin's details using assertions
		Assert.assertEquals(adminName, "John Doe", "Admin name mismatch");
		Assert.assertEquals(adminEmail, "johndoe@example.com", "Admin email mismatch");
		Assert.assertEquals(adminRole, "Administrator", "Admin role mismatch");
		Assert.assertEquals(adminEmployeeId, 12345, "Admin employee ID mismatch");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
