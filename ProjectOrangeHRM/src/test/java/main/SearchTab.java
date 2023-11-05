package main;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.BaseClassTest;
import Base.LoginTest;
import Base.Search;


public class SearchTab extends BaseClassTest{
WebDriver driver;
private Search d;
	

	@BeforeClass
	public void setup() {
		driver = intialization("Chrome");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginTest login = new LoginTest(driver);
		Search d = new Search(driver);

		login.enterUsername("Admin");
		login.enterPassword("admin123");
		login.clickLoginButton();

	}

	@Test
	public void verifysearchbar() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "search";

		Assert.assertEquals(actualTitle, expectedTitle);

	}
	@Test

	public void searchResult() {
		
		d.enterSearchQuery("Admin");
		d.areSearchResultsDisplayed();

		
	}
	@AfterClass
	public void Teardown() {
		driver.quit();
	}

}
