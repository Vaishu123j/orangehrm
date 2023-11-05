package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Search {
	private WebDriver driver;
	private By searchInput = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/input");
	private By searchButton = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/svg");
	private By searchResults = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a']");

	public Search(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToSearch() {
		driver.findElement(searchInput);

	}

	public void enterSearchQuery(String query) {
		driver.findElement(searchInput).sendKeys(query);
	}

	public void clickSearchButton() {
		driver.findElement(searchButton).click();
	}

	public boolean areSearchResultsDisplayed() {
		return driver.findElement(searchResults).isDisplayed();
	}

	public int getSearchResultCount() {
		return driver.findElements(searchResults).size();
	}

}
