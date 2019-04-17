package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpamPage {
	@FindBy(xpath = "(.//span[@class=\"b-nav__item__text\"])[3]")
	WebElement spamFolder;
	@FindBy(xpath = "(.//div[@class=\"b-datalist__item__addr\"])[1]")
	WebElement emailSender;
	@FindBy(xpath = "//*[@id=\"b-letters\"]/div/div[5]/div/div[2]/div[1]/div/a/div[1]")
	WebElement letterCheckbox;
	@FindBy(xpath = "(.//div[@data-name=\"noSpam\"])[1]")
	WebElement notSpamButton;

	@FindBy(xpath = "//*[@id=\"jsHtml\"]/body/div[1]/div[1]/div/span/a")
	WebElement succeedMessage;
	@FindBy(xpath = " //*[contains(text(), 'Письмо перемещено в папку')]")
	WebElement succeedMessageNotSpam;

	private WebDriver driver;
	private WebDriverWait wait;

	public SpamPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);

	}

	public void openSpamPage() {
		wait.until(ExpectedConditions.visibilityOf(spamFolder));
		spamFolder.click();
	}

	public void selectFirstMessage() {
		wait.until(ExpectedConditions.elementToBeClickable(letterCheckbox));
		letterCheckbox.click();
	}

	public boolean isLetterAddedToSpam() {
		wait.until(ExpectedConditions.visibilityOf(succeedMessage));
		return succeedMessage.isDisplayed();
	}

	public boolean isLetterRemovedFromSpam() {
		wait.until(ExpectedConditions.visibilityOf(succeedMessageNotSpam));
		return succeedMessageNotSpam.isDisplayed();
	}

	public void markAsNotSpam() {
		wait.until(ExpectedConditions.visibilityOf(notSpamButton));
		notSpamButton.click();

	}

}
