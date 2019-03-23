package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Test19_1 {

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
		WebElement priceFilter = driver.findElement(By.xpath(".//li[@class=\" sort_category   sort_price \"]"));
		priceFilter.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement priceLimits = driver.findElement(By.partialLinkText("BYN 110 - BYN 230 за ночь"));
		priceLimits.click();
		WebElement availableOnly = driver.findElement(By.partialLinkText("Показать только доступные варианты"));
		availableOnly.click();
		List<WebElement> searchResult = driver.findElements(By.xpath(
				".//div[@class=\"sr_item txp-pmc-prop sr_item_new sr_item_default sr_property_block  sr_flex_layout                 \"]"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertFalse(searchResult.isEmpty());
		List<WebElement> ratings = driver.findElements(By.xpath(".//div[@class=\"bui-review-score__badge\"]"));
		WebElement maxRate = driver.findElement(By.partialLinkText(maxRatingString(ratings)));
		maxRate.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement price = driver.findElement(By.xpath("(.//div[@class=\"hprt-price-price \"])[1]"));
		String priceNum = price.getText().replaceAll("[^0-9?!\\.]", "");
		double priceLimit = 230 * 6; // задали фильтром priceLimits
		Assert.assertTrue(Double.parseDouble(priceNum) < priceLimit);
		driver.quit();
	}

	public List<Double> parseDouble(List<WebElement> values) {
		List<Double> doubles = new ArrayList<Double>();
		for (WebElement value : values) {
			String valueText = value.getText().replace(',', '.');
			doubles.add(Double.parseDouble(valueText));

		}
		return doubles;
	}

	public String maxRatingString(List<WebElement> values) {
		List<Double> doubles = parseDouble(values);
		Double maxDouble = Collections.max(doubles);
		String maxString = Double.toString(maxDouble).replace('.', ',');
		return maxString;
	}

}
