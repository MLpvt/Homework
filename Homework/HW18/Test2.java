package core;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {
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
		WebElement closeCalendar = driver.findElement(By.xpath(".//i[@class=\"c2-calendar-close-button-icon\"]"));
		closeCalendar.click();
		WebElement zvezdy = driver.findElement(By.xpath(".//li[@class=\" sort_category   with_dd sort_class \"]"));
		zvezdy.click();
		WebElement topRate = driver.findElement(By.xpath(".//li[@class=\"class sort_suboption_outer \"]"));
		topRate.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement firstResult = driver.findElement(By.xpath("(.//a[@class=\"hotel_name_link url\"])[1]"));
		firstResult.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement rate = driver.findElement(By.xpath("(.//div[@class=\"bui-review-score__badge\"])[1]"));
		Assert.assertTrue(Double.parseDouble(rate.getText()) >= 9.);

		driver.close();

	}
}
