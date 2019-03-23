package homework;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test19_2 {

	@Test
	public void test() {
		String exePath = "/Users/fraumarta/Desktop/автомэйшн/chromedriver";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.booking.com");
		WebElement searchField = driver.findElement(By.xpath(".//input[@type=\"search\"]"));
		searchField.sendKeys("Paris");
		WebElement dateField = driver.findElement(By.xpath(".//div[@class=\"xp__dates xp__group\"]"));
		dateField.click();
		WebElement startDate = driver.findElement(By.xpath(".//td[@data-date=\"2019-03-25\"]"));
		startDate.click();
		WebElement endDate = driver.findElement(By.xpath(".//td[@data-date=\"2019-03-31\"]"));
		endDate.click();
		endDate.submit();
		WebElement adults = driver.findElement(By.xpath(".//select[@name=\"group_adults\"]"));
		Select adultsDropdown = new Select(adults);
		adultsDropdown.selectByVisibleText("4 взрослых");
		WebElement rooms = driver.findElement(By.xpath(".//select[@name=\"no_rooms\"]"));
		Select roomsDropdown = new Select(rooms);
		roomsDropdown.selectByVisibleText("2 номера");
		WebElement priceLimits = driver.findElement(By.partialLinkText("BYN 470 + за ночь"));
		priceLimits.click();
		WebElement availableOnly = driver.findElement(By.partialLinkText("Показать только доступные варианты"));
		availableOnly.click();
		WebElement priceFilter = driver.findElement(By.xpath(".//li[@class=\" sort_category   sort_price \"]"));
		priceFilter.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement cheapHotel = driver.findElement(By.xpath("(.//img[@class=\"hotel_image\"])[1]"));
		cheapHotel.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		WebElement price = driver.findElement(By.xpath("(.//div[@class=\"hprt-price-price \"])[1]"));
		String priceNum = price.getText().replaceAll("[^0-9?!\\.]", "");
		double priceLimit = 470 * 6;
		Assert.assertTrue(Double.parseDouble(priceNum) > priceLimit);
//task3
		WebElement appartments = driver.findElement(By.xpath("(.//select[@class=\"hprt-nos-select\"])[1]"));
		Select appartmentsDropdown = new Select(appartments);
		appartmentsDropdown.selectByIndex(1);
		WebElement bookNutton = driver.findElement(By.xpath(".//div[@class=\"hprt-reservation-cta\"]"));
		bookNutton.click();
		WebElement lastName = driver.findElement(By.xpath(".//input[@name=\"lastname\"]"));
		lastName.sendKeys("Lenartovich");
		WebElement email = driver.findElement(By.xpath(".//input[@id=\"email\"]"));
		email.sendKeys("marta.lenartovich@mail.ru");
		WebElement emailConfirm = driver.findElement(By.xpath(".//input[@id=\"email_confirm\"]"));
		emailConfirm.sendKeys("marta.lenartovich@mail.ru");
		WebElement continueBooking = driver.findElement(By.xpath(".//i[@class=\"submit-button__arrow\"]"));
		continueBooking.click();
		WebElement phone = driver.findElement(By.xpath(".//input[@id=\"phone\"]"));
		phone.sendKeys("295994996");
		WebElement cardTypes = driver.findElement(By.xpath(".//select[@id=\"cc_type\"]"));
		Select cardType = new Select(cardTypes);
		cardType.selectByIndex(2);
		WebElement cardNumber = driver.findElement(By.xpath(".//input[@name=\"cc_number\"]"));
		cardNumber.sendKeys("4242 4242 4242 4242");
		WebElement cardMonths = driver.findElement(By.xpath(".//select[@name=\"cc_month\"]"));
		Select cardMonth = new Select(cardMonths);
		cardMonth.selectByIndex(11);
		WebElement cvc = driver.findElement(By.xpath(".//input[@name=\"cc_cvc\"]"));
		cvc.sendKeys("123");
		WebElement error = driver.findElement(By.xpath(".//p[@id=\"bp_form_cc_number_msg\"] "));
		Assert.assertTrue(error.isDisplayed());
		driver.quit();

	}

}
