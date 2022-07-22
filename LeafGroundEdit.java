package week2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundEdit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the url
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();

		// Enter email
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sai@gmail.com");

		// Append
		driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys("Text added");
		driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys(Keys.TAB);

		// Get default text entered
		String value = driver.findElement(By.xpath("//input[@value='TestLeaf']")).getAttribute("value");
		System.out.println("Default text entered is :  " + value);

		// Clear the text
		driver.findElement(By.xpath("(//input[@name='username'])[2]")).clear();

		// Confirm that edit field is disabled
		System.out.println(driver.findElement(By.xpath("//input[@disabled='true']")).isEnabled());

	}

}
