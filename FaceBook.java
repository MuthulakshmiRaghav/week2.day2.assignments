package week2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Download and set the path
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");

		// Maximize the window
		driver.manage().window().maximize();

		// Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on Create New Account button
		driver.findElement(By.linkText("Create New Account")).click();

		// Enter firstName, lastName, mobileNum and password
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Muthu");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Lakshmi");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("1234567891");
		driver.findElement(By.id("password_step_input")).sendKeys("mahiya");

		// Handle all the three drop downs
		// Date of birth
		WebElement day = driver.findElement(By.id("day"));
		Select selectDay = new Select(day);
		selectDay.selectByVisibleText("12");

		WebElement month = driver.findElement(By.id("month"));
		Select selectMonth = new Select(month);
		selectMonth.selectByValue("10");

		WebElement year = driver.findElement(By.id("year"));
		Select selectyear = new Select(year);
		selectyear.selectByVisibleText("1988");

		// Select the radio button "Female"
		driver.findElement(By.xpath("//label[text()='Female']")).click();

	}

}
