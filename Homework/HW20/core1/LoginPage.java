package core1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	@FindBy(xpath = ".//input[@id=\"mailbox:login\"]")
	WebElement loginField;

	@FindBy(xpath = ".//input[@id=\"mailbox:password\"]")
	WebElement passwordField;

	@FindBy(xpath = ".//input[@class=\"o-control\"]")
	WebElement enterButton;

	@FindBy(xpath = ".//a[@id=\"PH_logoutLink\"]")
	WebElement exitLink;

	private WebDriver driver;
	private WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);

	}

	public void enterLoginAndPassword(String login, String password) {

		loginField.clear();
		loginField.sendKeys(login);
		passwordField.clear();
		passwordField.sendKeys(password);

	}

	public void clickEnterButton() {
		enterButton.click();
		// WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.titleContains("Входящие"));

	}

	public boolean isExitLinkPresent() {

		return exitLink.isDisplayed();
	}

}