package core1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class MailRuTests {

	private WebDriver driver;
	private LoginPage loginPage;
	private InboxPage inboxPage;
	private SpamPage spamPage;
	private NewLetterPage newLetterPage;

	@Before
	public void before() {

		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		inboxPage = new InboxPage(driver);
		newLetterPage = new NewLetterPage(driver);
		driver.get("https://www.mail.ru");
		spamPage = new SpamPage(driver);
		loginPage.enterLoginAndPassword("cdp.selenium.test", "selenium1!");
		loginPage.clickEnterButton();
		Assert.assertTrue(loginPage.isExitLinkPresent());

	}

	@Test
	public void test1_moveToSpam() {
		inboxPage.selectFirstMessage();
		inboxPage.markAsSpam();
		Assert.assertTrue(spamPage.isLetterAddedToSpam());//  assert error message
	}

	@Test
	public void test2_moveOutOfSpam() {
		spamPage.openSpamPage();
		spamPage.selectFirstMessage();
		spamPage.markAsNotSpam();
		Assert.assertTrue(spamPage.isLetterRemovedFromSpam());//  assert error message

	}

	@Test
	public void test3_sendLetter() {

		inboxPage.pressNewLetterButton();
		newLetterPage.fillAdresseeLine("marta.lenartovich@mail.ru;");
		newLetterPage.fillAdresseeLine("cdp.selenium.test@mail.ru");
		newLetterPage.fillSubjectLine("subject");
		newLetterPage.fillLetterBody("test");
		newLetterPage.sendLetter();
		Assert.assertTrue(newLetterPage.isLetterSent());

	}

	@Test
	public void test4_setLetterFlag() {
		inboxPage.flagLetters();
		Assert.assertTrue(inboxPage.isFlagsAreSet());
	}

	@Test
	public void test5_removeLetterFlag() {
		inboxPage.unflagLetters();
		Assert.assertTrue(inboxPage.isFlagsAreNotSet());
	}

	@After
	public void tearDown() {

		driver.quit();
	}

}