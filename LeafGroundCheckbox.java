package week2.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundCheckbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the url
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();

		// Select the languages that you know?
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();

		// Confirm Selenium is checked
		System.out.println(driver.findElement(By.xpath("(//input[@type='checkbox'])[6]")).isSelected());

		// DeSelect only checked
		if (driver.findElement(By.xpath("(//input[@type='checkbox'])[8]")).isSelected()) {
			driver.findElement(By.xpath("(//input[@type='checkbox'])[8]")).click();
		}

		// Select all below checkboxes
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (int i = 9; i <= checkbox.size(); i++) {
			driver.findElement(By.xpath("(//input[@type='checkbox'])[" + i + "]")).click();
		}

	}

}
