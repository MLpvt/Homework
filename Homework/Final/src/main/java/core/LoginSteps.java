package core;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	private static final String MAIN_URL = "http://mail.ru";
	private LoginPage loginPage;
	private WebDriver webDriver;

	public LoginSteps() {
		webDriver = WebDriverSingleton.getInstance();
		loginPage = new LoginPage(webDriver);
	}

	@Given("^I am on main application page$")
	public void loadMainPage() {
		webDriver.get(MAIN_URL);
	}

	@When("^I login as correct user$")
	public void loginAsCorrectUser() {
		loginPage.enterLoginAndPassword(loginPage.getLogin(), loginPage.getPassword());
		loginPage.clickEnterButton();
	}

	@When("^I login as incorrect user$")
	public void loginAsUserWithCredentials() {
		loginPage.enterLoginAndPassword(loginPage.getLogin(), "bbb");
		loginPage.enterButton.click();
	}

	@When("^I login without credentials$")
	public void loginWithoutCredentials() {
		loginPage.enterLoginAndPassword("", "");
		loginPage.enterButton.click();
	}

	@Then("^I see logout link$")
	public void seeLogoutLink() {
		Assert.assertTrue(loginPage.logoutLinkPresents());
	}

	@Then("^I see error message$")
	public void seeErrorMessage() {
		Assert.assertTrue(loginPage.logoutLinkErrorPresents());
	}

	@After
	public void afterClass() {
		webDriver.quit();
	}
}
