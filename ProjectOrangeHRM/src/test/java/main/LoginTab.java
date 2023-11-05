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
		LoginTest login = new LoginTest(driver);

		login.enterUsername("Admin");
		login.enterPassword("admin123");
		login.clickLoginButton();

	}

	@AfterMethod
	public void end() {
		driver.quit();

	}

	@Test
	private void verifyLoginWithInavalidCredentials(String usrname, String password) {

		login.enterUsername("Admin");
		login.enterPassword("admin123");
		login.clickLoginButton();
		Assert.assertEquals(login.getErrorMessage(), "Invalid credentials");
	}

//		WebElement errorMessage = driver
//				.findElement(By.xpath("///*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p"));
//		String actualErrorMessage = errorMessage.getText();
//		String expectedErrorMessage = "Invalid credentials";
//		Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
//				"Error message doesn't match for invalid credentials.");
//	}

	@Test
	public void verifyTitle() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "OrangeHRM";

		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test
	public void Verifylogo() {
		boolean flag = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[2]")).isDisplayed();

		Assert.assertTrue(flag);

	}

	@Test
	public void testLoginWithValidCredentials() {
		login.enterUsername("Admin");
		login.enterPassword("admin123");
		login.clickLoginButton();

	}

}
