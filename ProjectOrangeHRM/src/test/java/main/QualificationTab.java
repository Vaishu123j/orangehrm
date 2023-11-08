package main;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseClassTest;
import Base.LoginTest;
import Base.Qualification;


public class QualificationTab extends BaseClassTest {
	private WebDriver driver;

	private Qualification QualificationTest;

	@BeforeClass
	public void setp() {
		driver = intialization("Chrome");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginTest login = new LoginTest(driver);
		Qualification QualificationTest = new Qualification(driver);

		login.enterUsername("Admin");
		login.enterPassword("admin123");
		login.clickLoginButton();

	}
	@AfterMethod

	public void Teardown() {
		driver.quit();

	}

	@Test(priority=1)
	public void openAdminTab() {
		WebElement adminTab = driver.findElement(By.className("oxd-main-menu-item"));
		adminTab.click();

	}

	@Test(priority=2)
	public void testQualificationList() {
		List<WebElement> qualifications = QualificationTest.getQualifications();

		for (WebElement qualification : qualifications) {
			System.out.println(qualification.getText());

		}
	}
@Test(priority=3)
	public void SkillsTab() {
		driver.findElement(By.xpath("//*[@id=\\\"app\\\"]/div[1]/div[1]/header/div[2]/nav/ul/li[4]/span/i")).click();

		QualificationTest.ClickSkillTab();
		
		
	}

	@Test(dataProvider = "skillData",priority=4)
	public void testAddSkill(String skillName) {
		driver.findElement(By.xpath("//*[@id=\\\"app\\\"]/div[1]/div[1]/header/div[2]/nav/ul/li[4]/span/i")).click();

		QualificationTest.clickAddSkill();
		QualificationTest.enterSkillName(skillName);

	}

	@Test(priority=5)
	public void testEditSkill() {
		QualificationTest.clickEditSkill();

	}

	@Test(priority=6)
	public void testDeleteSkill() {
		QualificationTest.clickDeleteSkill();
		
	}
	 @DataProvider(name = "skillData")
	    public Object[][] getSkillData() {
	        return new Object[][] {
	            {"Java Programming"},
	            {"Web Development"},
	            {"Data Analysis"},
	        };
	 }

	


}
