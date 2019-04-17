package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewLetterPage {

	@FindBy(xpath = ".//textarea[@tabindex=\"4\"]")
	private WebElement addressee;

	@FindBy(xpath = "//input[@class='b-input']")
	private WebElement subjectField;

	@FindBy(xpath = "//body[@id='tinymce']")
	private WebElement letterBody;

	@FindBy(xpath = "(.//div[@data-name=\"send\"])[1]")
	private WebElement sendButton;

	@FindBy(xpath = "//iframe[contains(@id, 'composeEditor_ifr')]")
	private WebElement emailBodyFrame;

	@FindBy(xpath = ".//div[@class=\"message-sent__title\"]")
	private WebElement letterSendMessage;

	private WebDriver driver;
	private WebDriverWait wait;
	private static final String LETTER_XML = "letter.xml";

	public NewLetterPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);

	}

	public void fillAdresseeLine(String emailAdress) {
		wait.until(ExpectedConditions.visibilityOf(addressee));
		addressee.sendKeys(emailAdress);

	}

	public void fillSubjectLine(String subject) {
		subjectField.sendKeys(subject);
	}

	public void fillLetterBody(String text) {
		driver.switchTo().frame(emailBodyFrame);
		letterBody.sendKeys(text);
		driver.switchTo().defaultContent();
	}

	public void sendLetter() {
		sendButton.click();
	}

	public boolean isLetterSent() {
		wait.until(ExpectedConditions.visibilityOf(letterSendMessage));
		return letterSendMessage.isDisplayed();
	}

}
