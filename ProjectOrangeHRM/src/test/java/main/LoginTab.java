package main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseClassTest;
import Base.LoginTest;


public class LoginTab extends BaseClassTest {
	WebDriver driver;
	public LoginTest login;

	@BeforeMethod
	public void setup() {
		driver = intialization("Chrome");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
        @Test
	private void verifyLoginWithInavalidCredentials() {
		LoginTest login = new LoginTest(driver);

		login.enterUsername("Admin");
		login.enterPassword("23457");
		login.clickLoginButton();
		Assert.assertEquals(login.getErrorMessage(), "Invalid credentials");
		driver.close();
	}



	@Test
	public void verifyTitle() {
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "OrangeHRM";

		Assert.assertEquals(actualTitle, expectedTitle);
		driver.close();
	
	}

	@Test
	public void Verifylogo() {
		
	
		boolean flag = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[2]")).isDisplayed();

		Assert.assertTrue(flag);
		driver.close();
	

	}

	@Test
	public void testLoginWithValidCredentials() {
		LoginTest login = new LoginTest(driver);
		login.enterUsername("Admin");
		login.enterPassword("admin123");
		login.clickLoginButton();
		System.out.println("successful login");
		driver.close();
		

	}
	@AfterMethod
	public void end() {
		driver.quit();

	}

}

