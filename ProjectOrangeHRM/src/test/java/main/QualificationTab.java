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
		Qualification qt = new Qualification(driver);

		login.enterUsername("Admin");
		login.enterPassword("admin123");
		login.clickLoginButton();
		login.clickAdminTab();
		login.clickQualificationTable();

	}

	@Test
	public void testQualificationList() {

		List<WebElement> qualifications = qt.getQualifications();

		for (WebElement qualification : qualifications) {
			System.out.println(qualification.getText());

		}
		driver.close();
	}

	@Test
	public void SkillsTab() {

		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[4]/span")).click();

		qt.ClickSkillTab();
		driver.close();

	}

	@Test(dataProvider = "skillData")
	public void testAddSkill(String skillName) {
		qt.ClickSkillTab();
		qt.clickAddSkill();
		qt.enterSkillName(skillName);
		driver.close();

	}

	@Test
	public void testEditSkill() {

		qt.ClickSkillTab();
		qt.clickAddSkill();
		qt.enterSkillName("java");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")).click();
		driver.close();

	}

	@Test
	public void testDeleteSkill() {
		qt.ClickSkillTab();
		qt.clickDeleteSkill();
		driver.close();

	}

	@DataProvider(name = "skillData")
	public Object[][] getSkillData() {
		return new Object[][] { { "Java Programming" }, { "Web Development" }, { "Data Analysis" }, };
	}

	@AfterMethod

	public void Teardown() {
		driver.quit();

	}
}

