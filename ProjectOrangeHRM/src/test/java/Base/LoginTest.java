package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTest {
	private WebDriver driver;
	private By usernameInput = By
			.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input");
	private By passwordInput = By
			.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input");
	private By loginButton = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
	private By errorMessage = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]");

	
	public LoginTest(WebDriver driver) {
		this.driver =driver;
		// TODO Auto-generated constructor stub
	}


	public void enterUsername(String username) {
		driver.findElement(usernameInput).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordInput).sendKeys(password);
	}

	public void clickLoginButton() {
		driver.findElement(loginButton).click();

	}

	public String getErrorMessage() {
		return driver.findElement(errorMessage).getText();
	}

}
