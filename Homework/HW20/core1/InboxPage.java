package core1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InboxPage {
	@FindBy(xpath = "(.//div[@class=\"js-item-checkbox b-datalist__item__cbx\"])[1]")
	WebElement letterCheckbox;
	@FindBy(xpath = "(.//div[@class=\"js-item-checkbox b-datalist__item__cbx\"])[2]")
	WebElement secondLetterCheckbox;
	@FindBy(xpath = "(.//div[@class=\"js-item-checkbox b-datalist__item__cbx\"])[3]")
	WebElement thirdLetterCheckbox;

	@FindBy(xpath = "(.//div[@data-name=\"spam\"])[1]")
	WebElement spamButton;

	@FindBy(xpath = ".//button[@data-id=\"approve\"]")
	WebElement spamConfirmation;

	// ????????@FindBy(linkText = "Письмо перемещено в папку \"Спам\".")
	// WebElement succeedMessage;

	@FindBy(xpath = "//*[@id=\"b-nav_folders\"]/div/div[4]/a/span")
	WebElement spamFolder;

	@FindBy(xpath = "(.//div[@class=\"b-datalist__item__addr\"])[1]")
	WebElement emailSender;

	@FindBy(xpath = "(.//a[@data-name=\"compose\"])[1]")
	WebElement newLetterButton;

	@FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[2]/div/div[2]/div[5]/div/div[2]/div[1]")
	WebElement moreDropdown;

	@FindBy(xpath = ".//a[@data-text=\"Пометить флажком\"]")
	WebElement markFlag;
	@FindBy(xpath = ".//a[@data-text=\"Снять флажок\"]")
	WebElement unmarkFlag;

	private WebDriver driver;
	private WebDriverWait wait;

	public InboxPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);

	}

	public void selectFirstMessage() {
		letterCheckbox.click();
	}

	public void markAsSpam() {
		spamButton.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@class=\"b-spam-confirm\"]")));
		spamConfirmation.click();
	}

	public void openSpamFolder() {

		wait.until(ExpectedConditions.elementToBeClickable(spamFolder));
		spamFolder.click();
	}

	public void pressNewLetterButton() {
		wait.until(ExpectedConditions.visibilityOf(newLetterButton));
		newLetterButton.click();
	}

	public String getEmailSender() {
		return emailSender.getText();
	}

	public void flagLetters() {
		letterCheckbox.click();
		secondLetterCheckbox.click();
		thirdLetterCheckbox.click();
		wait.until(ExpectedConditions.visibilityOf(moreDropdown));
		moreDropdown.click();
		wait.until(ExpectedConditions.visibilityOf(markFlag));
		markFlag.click();

	}

	public void unflagLetters() {
		letterCheckbox.click();
		secondLetterCheckbox.click();
		thirdLetterCheckbox.click();
		wait.until(ExpectedConditions.visibilityOf(moreDropdown));
		moreDropdown.click();
		wait.until(ExpectedConditions.visibilityOf(unmarkFlag));
		unmarkFlag.click();

	}

	public boolean isFlagsAreSet() {
		letterCheckbox.click();
		secondLetterCheckbox.click();
		thirdLetterCheckbox.click();
		wait.until(ExpectedConditions.visibilityOf(moreDropdown));
		moreDropdown.click();
		wait.until(ExpectedConditions.visibilityOf(unmarkFlag));
		if (unmarkFlag.isDisplayed())
			return true;
		else
			return false;

	}

	public boolean isFlagsAreNotSet() {
		letterCheckbox.click();
		secondLetterCheckbox.click();
		thirdLetterCheckbox.click();
		wait.until(ExpectedConditions.visibilityOf(moreDropdown));
		moreDropdown.click();
		wait.until(ExpectedConditions.visibilityOf(markFlag));
		if (markFlag.isDisplayed())
			return true;
		else
			return false;

	}

}
