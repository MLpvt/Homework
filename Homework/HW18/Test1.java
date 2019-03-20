package core;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	@Test
	public void test() {
		String exePath = "/Users/fraumarta/Desktop/автомэйшн/chromedriver";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.booking.com");
		WebElement searchField = driver.findElement(By.xpath(".//input[@type=\"search\"]"));
		searchField.sendKeys("Москва");
		WebElement checkPrice = driver.findElement(By.xpath(".//button[@data-sb-id=\"main\"]"));
		checkPrice.click();
		WebElement arrivalDate = driver.findElement(By.xpath(".//td[@data-id=\"1555286400000\"]"));
		arrivalDate.click();
		WebElement leaveDateField = driver.findElement(By.xpath("(.//div[@class=\"sb-date-field__display\"])[2]"));
		leaveDateField.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement leaveDate = driver.findElement(By.xpath("(.//td[@data-id=\"1555459200000\"])[2]"));
		leaveDate.click();
		leaveDate.submit();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> searchResult = driver.findElements(By.xpath(
				".//div[@class=\"sr_item  sr_item_new sr_item_default sr_property_block  sr_flex_layout                 \"]"));
		Assert.assertFalse(searchResult.isEmpty());
		driver.close();
	}

}
