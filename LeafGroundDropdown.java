package week2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the url
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();

		// Select by Index
		WebElement dropDown1 = driver.findElement(By.id("dropdown1"));
		Select select1 = new Select(dropDown1);
		select1.selectByIndex(1);

		// Select by Text
		WebElement dropDown2 = driver.findElement(By.name("dropdown2"));
		Select select2 = new Select(dropDown2);
		select2.selectByVisibleText("Selenium");

		// Select by Value
		WebElement dropDown3 = driver.findElement(By.id("dropdown3"));
		Select select3 = new Select(dropDown3);
		select3.selectByValue("2");

		// NUmber of Dropdown Options
		int dropdownCount = driver.findElements(By.xpath("//select[@class='dropdown']/option")).size();
		System.out.println("Number of options in this dropdown "  + dropdownCount);

		// You can also use sendKeys to select

	}

}
