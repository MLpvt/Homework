package core;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	private WebDriver driver;
	private MainPage mainPage;
	private SearchResultPage searchResultPage;
	private HotelPage hotelPage;

	@Before
	public void before() {

		driver = new ChromeDriver();
		mainPage = new MainPage(driver);
		searchResultPage = new SearchResultPage(driver);
		hotelPage = new HotelPage(driver);
		driver.get("https://www.booking.com");
	}

	@Test
	public void hotelsInMoscowPresent() {
		mainPage.fillCity("Москва");
		mainPage.pressCheckPriceButton();
		searchResultPage.setArrivalDate();
		searchResultPage.setLeaveDate();

		Assert.assertTrue(searchResultPage.isHotelsExist());
	}

	@Test
	public void ratingIsHigherThan9() {
		mainPage.fillCity("Москва");
		mainPage.pressCheckPriceButton();
		searchResultPage.closeCalendar();
		searchResultPage.sortByStars();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		searchResultPage.openTopRatedHotel();
		Assert.assertTrue(hotelPage.parseRatingToDouble() >= 9);

	}

	@After
	public void tearDown() {

		driver.quit();
	}

}
