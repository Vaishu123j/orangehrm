package Base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Qualification {
	private WebDriver driver;
	private By qualificationTable = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[4]/span/i");
	private By skillsTab = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[4]/ul/li[1]");
	private By addSkillButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/div/button");
	private By editSkillButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[4]/div/button[2]/i");
	private By skillNameInput = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input");
	private By deleteSkillButton = By
			.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[4]/div/button[1]");

	public Qualification(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> getQualifications() {
		return driver.findElements(qualificationTable);
	}

	public void ClickSkillTab() {
		driver.findElement(skillsTab).click();

	}

	public void clickAddSkill() {
		driver.findElement(addSkillButton).click();

	}

	public void enterSkillName(String skillName) {
		driver.findElement(skillNameInput).sendKeys(skillName);
	}

	public void clickEditSkill() {
		driver.findElement(editSkillButton).click();
	}

	public void clickDeleteSkill() {
		driver.findElement(deleteSkillButton).click();
	}

}
