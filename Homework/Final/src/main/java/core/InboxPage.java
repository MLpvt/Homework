package core;

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
	@FindBy(xpath = "(.//div[@class=\"b-checkbox__box\"])[6]")
	WebElement letterCheckboxInSpam;

	@FindBy(xpath = "(.//div[@data-name=\"spam\"])[1]")
	WebElement spamButton;

	@FindBy(xpath = "(.//div[@data-name=\"noSpam\"])[1]")
	WebElement notSpamButton;

	@FindBy(xpath = ".//button[@data-id=\"approve\"]")
	WebElement spamConfirmation;

	@FindBy(xpath = "(.//div[@data-name=\"remove\"])[1]")
	WebElement deleteButton;

	@FindBy(xpath = ".//span[@class=\"js-txt _js-title notify-message__title__text notify-message__title__text_ok\"]")
	WebElement actionIsDoneMessage;

	@FindBy(xpath = "(.//span[text()='Спам'])[3]")
	WebElement spamFolder;

	@FindBy(xpath = "(.//a[@data-name=\"compose\"])[1]")
	WebElement newLetterButton;

	@FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[2]/div/div[2]/div[5]/div/div[2]/div[1]")
	WebElement moreDropdown;

	@FindBy(xpath = ".//a[@data-text=\"Пометить флажком\"]")
	WebElement markFlag;
	@FindBy(xpath = ".//a[@data-text=\"Снять флажок\"]")
	WebElement unmarkFlag;

	@FindBy(xpath = "(.//a[@href=\"/messages/trash/\"])[1]")
	WebElement rubishBinFolder;

	@FindBy(xpath = ".//button[@data-name=\"clearFolder\"]")
	WebElement clearButton;

	@FindBy(xpath = ".//button[@class=\"btn btn_stylish confirm-ok\"]")
	WebElement clearConfirmation;
	@FindBy(xpath = "(.//span[@class=\"b-datalist__empty__text\"])[2]")
	WebElement emptyRubishBin;

	private WebDriver driver;
	private WebDriverWait wait;

	public InboxPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);

	}

	public void selectFirstMessage() {
		wait.until(ExpectedConditions.visibilityOf(letterCheckbox));
		letterCheckbox.click();
	}

	public void markAsSpam() {
		spamButton.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@class=\"b-spam-confirm\"]")));
		spamConfirmation.click();
	}

	public void markAsNotSpam() {
		letterCheckboxInSpam.click();
		notSpamButton.click();
	}

	public void openSpamFolder() {

		spamFolder.click();
	}

	public void pressNewLetterButton() {
		wait.until(ExpectedConditions.visibilityOf(newLetterButton));
		newLetterButton.click();
	}

	public void flagLetter() {
		letterCheckbox.click();
		wait.until(ExpectedConditions.visibilityOf(moreDropdown));
		moreDropdown.click();
		wait.until(ExpectedConditions.visibilityOf(markFlag));
		markFlag.click();

	}

	public void unflagLetter() {
		letterCheckbox.click();
		wait.until(ExpectedConditions.visibilityOf(moreDropdown));
		moreDropdown.click();
		wait.until(ExpectedConditions.visibilityOf(unmarkFlag));
		unmarkFlag.click();

	}

	public boolean isFlagsAreSet() {
		letterCheckbox.click();
		wait.until(ExpectedConditions.visibilityOf(moreDropdown));
		moreDropdown.click();
		wait.until(ExpectedConditions.visibilityOf(unmarkFlag));
		return unmarkFlag.isDisplayed();

	}

	public boolean isFlagsAreNotSet() {
		letterCheckbox.click();
		wait.until(ExpectedConditions.visibilityOf(moreDropdown));
		moreDropdown.click();
		wait.until(ExpectedConditions.visibilityOf(markFlag));
		return markFlag.isDisplayed();

	}

	public void pressDeleteButton() {
		wait.until(ExpectedConditions.visibilityOf(deleteButton));
		deleteButton.click();
	}

	public boolean actionIsDoneMessage() {
		wait.until(ExpectedConditions.visibilityOf(actionIsDoneMessage));
		return actionIsDoneMessage.isDisplayed();

	}

	public void clearRubishFolder() {
		rubishBinFolder.click();
		wait.until(ExpectedConditions.visibilityOf(clearButton));
		clearButton.click();
		clearConfirmation.click();
	}

	public boolean rubishFolderIsClear() {
		wait.until(ExpectedConditions.visibilityOf(emptyRubishBin));
		return emptyRubishBin.isDisplayed();
	}

}
