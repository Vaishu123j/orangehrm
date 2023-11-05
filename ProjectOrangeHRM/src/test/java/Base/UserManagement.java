package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserManagement {
	private WebDriver driver;
	private By addUserButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
	private By userTable = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]");

	public UserManagement(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAddUserButton() {

		driver.findElement(addUserButton).click();
	}

	public boolean isUserTableDisplayed() {
		return driver.findElement(userTable).isDisplayed();
	}

	public void deleteUser(String username) {
		// Find and click the delete button for the specified user
		String deleteButtonLocator = String
				.format("///*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div/button/i", username);
		driver.findElement(By.xpath(deleteButtonLocator)).click();
	}

}
