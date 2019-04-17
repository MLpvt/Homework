package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

	@FindBy(xpath = "//*[@id='PH_logoutLink']")
	private WebElement logoutLink;

	@FindBy(xpath = ".//div[@id=\"mailbox:error\"]")
	public WebElement logoutLinkError;

	private static final int LINK_PRESENSE_TIMEOUT = 10;

	private WebDriver driver;
	private WebDriverWait wait;

	private String login;
	private String passwordUser;

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
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("Входящие"));

	}

	public boolean islogoutLinkPresent() {

		return logoutLink.isDisplayed();
	}

	public boolean logoutLinkPresents() {
		return (new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT)).until(ExpectedConditions.visibilityOf(logoutLink))
				.isDisplayed();
	}

	public boolean logoutLinkErrorPresents() {
		return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(logoutLinkError)).isDisplayed();
	}

	public String getLogin() {
		String url = "jdbc:mysql://localhost:3306/testAutomation?useSSL=false";
		String user = "root";
		String password = "5994996m";
		String query = "SELECT * FROM testAutomation.users where id=2;";
		try (Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query)) {
			if (rs.next()) {
				login = rs.getString(2);

			}

			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();

		}
		return login;
	}

	public String getPassword() {
		String url = "jdbc:mysql://localhost:3306/testAutomation?useSSL=false";
		String user = "root";
		String password = "5994996m";
		String query = "SELECT * FROM testAutomation.users where id=2;";
		try (Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query)) {
			if (rs.next()) {
				passwordUser = rs.getString(3);

			}

			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();

		}
		return passwordUser;
	}

}