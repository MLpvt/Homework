package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
	@FindBy(xpath = ".//input[@type=\"search\"]")
	WebElement searchField;

	@FindBy(xpath = ".//button[@data-sb-id=\"main\"]")
	WebElement checkPriceButton;

	private WebDriver driver;
	private WebDriverWait wait;

	public MainPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);

	}

	public void fillCity(String city) {
		searchField.sendKeys(city);
	}

	public void pressCheckPriceButton() {
		checkPriceButton.click();
	}
}
