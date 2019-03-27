package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelPage {
	@FindBy(xpath = "(.//div[@class=\"bui-review-score__badge\"])[1]")
	WebElement rate;

	private WebDriver driver;
	private WebDriverWait wait;

	public HotelPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);

	}

	public double parseRatingToDouble() {
		String rating = rate.getText().replaceAll("[^0-9?!\\.]", "");
		return Double.parseDouble(rating);
	}

}
