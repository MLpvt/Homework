package core;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {

	@FindBy(xpath = ".//td[@data-id=\"1555286400000\"]")
	WebElement arivalDate;
	@FindBy(xpath = "(.//div[@class=\"sb-date-field__display\"])[2]")
	WebElement leaveDateField;
	@FindBy(xpath = "(.//td[@data-id=\"1555459200000\"])[2]")
	WebElement leaveDate;
	@FindBy(xpath = ".//div[@class=\"sr_item  sr_item_new sr_item_default sr_property_block  sr_flex_layout                 \"]")
	List<WebElement> searchResult;
	@FindBy(xpath = ".//i[@class=\"c2-calendar-close-button-icon\"]")
	WebElement closeCalendar;
	@FindBy(xpath = ".//li[@class=\" sort_category   with_dd sort_class \"]")
	WebElement stars;
	@FindBy(xpath = ".//li[@class=\"class sort_suboption_outer \"]")
	WebElement starsDescending;
	@FindBy(xpath = "(.//img[@class=\"hotel_image\"])[1]")
	WebElement topRatedHotel;
	@FindBy(xpath = "//div[@ class=\"sr-usp-overlay sr-usp-overlay--wide\"]")
	WebElement message;

	private WebDriver driver;
	private WebDriverWait wait;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);

	}

	public void setArrivalDate() {
		arivalDate.click();
	}

	public void setLeaveDate() {
		wait.until(ExpectedConditions.visibilityOf(leaveDateField));
		leaveDateField.click();
		wait.until(ExpectedConditions.visibilityOf(leaveDate));
		leaveDate.click();
		leaveDate.submit();
	}

	public boolean isHotelsExist() {
		return !searchResult.isEmpty();

	}

	public void closeCalendar() {
		closeCalendar.click();
	}

	public void sortByStars() {

		stars.click();
		wait.until(ExpectedConditions.visibilityOf(starsDescending));
		starsDescending.click();
	}

	public boolean isMessageVisible() {
		return message.isDisplayed();
	}

	public void openTopRatedHotel() {
		if (isMessageVisible() == true) {
			isMessageVisible();
		} else

			topRatedHotel.click();

	}
}
