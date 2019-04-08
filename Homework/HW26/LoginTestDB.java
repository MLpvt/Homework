package core1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestDB {
	private WebDriver driver;
	private LoginPage loginPage;

	@Test
	public void enterCorrectLoginAndPassword() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.mail.ru");
		loginPage = new LoginPage(driver);

		String url = "jdbc:mysql://localhost:3306/testAutomation?useSSL=false";
		String user = "root";
		String password = "5994996m";

		String query = "SELECT * FROM testAutomation.users where id=2;";
		try (Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query)) {
			if (rs.next()) {
				String loginMailRu = rs.getString(2);
				String passwordMailRu = rs.getString(3);
				loginPage.enterLoginAndPassword(loginMailRu, passwordMailRu);
				loginPage.clickEnterButton();
				WebElement newLetterButton = driver.findElement(By.xpath("(.//a[@data-name=\"compose\"])[1]"));
				Assert.assertTrue(newLetterButton.isDisplayed());
				driver.close();

			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();

		}

	}

	@Test
	public void enterIncorrectLoginAndPassword() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.mail.ru");
		loginPage = new LoginPage(driver);

		String url = "jdbc:mysql://localhost:3306/testAutomation?useSSL=false";
		String user = "root";
		String password = "5994996m";

		String query = "SELECT * FROM testAutomation.users where id=1;";
		try (Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query)) {
			if (rs.next()) {
				String loginMailRu = rs.getString(2);
				String passwordMailRu = rs.getString(3);
				loginPage.enterLoginAndPassword(loginMailRu, passwordMailRu);
				Assert.assertTrue(loginPage.submitToError());
				driver.close();

			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();

		}

	}

}
