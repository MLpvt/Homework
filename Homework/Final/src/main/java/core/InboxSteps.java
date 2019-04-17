package core;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import parser.Letter;
import parser.LetterParser;

public class InboxSteps {
	private static final String MAIN_URL = "http://mail.ru";
	private LoginPage loginPage;
	private InboxPage inboxPage;
	private NewLetterPage newLetterPage;
	private WebDriver webDriver;
	private static final String LETTER_XML = "letter.xml";

	public InboxSteps() {
		webDriver = WebDriverSingleton.getInstance();
		loginPage = new LoginPage(webDriver);
		inboxPage = new InboxPage(webDriver);
		newLetterPage = new NewLetterPage(webDriver);
	}

	@Given("^I am logged into application$")
	public void loadMainPage() {
		webDriver.get(MAIN_URL);
		loginPage.enterLoginAndPassword(loginPage.getLogin(), loginPage.getPassword());
		loginPage.clickEnterButton();
	}

	@When("^I click \"Написать Письмо\" button$")
	public void pressNewLetterButton() {
		inboxPage.pressNewLetterButton();
	}

	@And("^I fill up letter$")
	public void createLetter() throws ParserConfigurationException, SAXException, IOException, XMLStreamException {
		LetterParser letterParser = new LetterParser();
		Letter letter = letterParser.parseLetter(LETTER_XML);
		newLetterPage.fillAdresseeLine(letter.getTo());
		newLetterPage.fillSubjectLine(letter.getSubject());
		newLetterPage.fillLetterBody(letter.getBody());
	}

	@And("^I click \"Отправить\" button$")
	public void sendLetter() {
		newLetterPage.sendLetter();
	}

	@Then("^Letter is sent$")
	public void letterIsSent() {
		Assert.assertTrue(newLetterPage.isLetterSent());
	}

	@When("^I clear \"Корзина\" folder$")
	public void clearRubishFolder() {
		inboxPage.clearRubishFolder();

	}

	@Then("^Rubish bin is empty$")
	public void rubisFolderIsClear() {
		Assert.assertTrue(inboxPage.rubishFolderIsClear());
	}

	@When("^I delete letter$")
	public void deleteLetter() {
		inboxPage.selectFirstMessage();
		inboxPage.pressDeleteButton();

	}

	@When("^I add letter to spam$")
	public void addToSpam() {
		inboxPage.selectFirstMessage();
		inboxPage.markAsSpam();

	}

	@Then("^Success Message is displayed$")
	public void letterIsAddedToSpam() {
		Assert.assertTrue(inboxPage.actionIsDoneMessage());
	}

	@When("^I remove message from spam$")
	public void removeFromSpam() {
		inboxPage.openSpamFolder();
		inboxPage.markAsNotSpam();

	}

	@When("^I mark letter with flag$")
	public void flagLetter() {
		inboxPage.selectFirstMessage();
		inboxPage.flagLetter();
	}

	@Then("^Message is marked with flag$")
	public void letterIsFlagged() {
		Assert.assertTrue(inboxPage.isFlagsAreSet());
	}

	@When("^I unflag letter$")
	public void unflagLetter() {
		inboxPage.selectFirstMessage();
		inboxPage.unflagLetter();
	}

	@Then("^Message is unmarked with flag$")
	public void letterIsUnflagged() {
		Assert.assertTrue(inboxPage.isFlagsAreNotSet());
	}

	@After
	public void afterClass() {
		webDriver.quit();
	}
}
