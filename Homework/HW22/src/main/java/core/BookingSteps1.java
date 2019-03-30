package core;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookingSteps1 {

	private WebDriver driver;
	private MainPage mainPage;
	private SearchResultPage searchResultPage;
	private HotelPage hotelPage;

	public BookingSteps1() {
		driver = new ChromeDriver();
		mainPage = new MainPage(driver);
		searchResultPage = new SearchResultPage(driver);
		hotelPage = new HotelPage(driver);
	}

	@Given("^I am on main application page$")
	public void loadMainPagel() {
		driver.get("https://www.booking.com");
	}

	@When("^I fill city \"Москва\" in searchline$")
	public void fillCity() {
		mainPage.fillCity("Москва");
	}

	@And("^I click \"Проверить цены\" button$")
	public void checkPrices() {
		mainPage.pressCheckPriceButton();

	}

	@And("^I set dates$")
	public void setDates() {
		searchResultPage.setArrivalDate();
		searchResultPage.setLeaveDate();
	}

	@Then("^Page with available options is opened$")
	public void isHotelsInMoscowExist() {
		Assert.assertTrue(searchResultPage.isHotelsExist());

	}

	@When("^I search hotels in Moscow$")
	public void searchHotelsInMoscow() {
		mainPage.fillCity("Москва");
		mainPage.pressCheckPriceButton();
		searchResultPage.closeCalendar();

	}

	@And("^I filter hotels by rating$")
	public void filterHotelsByRate() {

		searchResultPage.sortByStars();

	}

	@And("^I open top-rated hotel$")
	public void openTopRatedHotel() {
		searchResultPage.openTopRatedHotel();
	}

	@Then("^Rating of hotel is higher than 9$")
	public void isRatingIsHigherThan9() {
		Assert.assertTrue(hotelPage.parseRatingToDouble() >= 9);

	}

	@After
	public void afterClass() {
		driver.quit();
	}

}
