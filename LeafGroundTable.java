package week2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the url
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();

		// Get the count of number of columns
		int columnCount = driver.findElements(By.xpath("(//tr)[2]/td")).size();
		System.out.println("Number of Columns " + columnCount);

		// Get the count of number of rows
		int rowCount = driver.findElements(By.tagName("tr")).size();
		System.out.println("Number of Rows  " + rowCount);

		// Get the progress value of 'Learn to interact with Elements'
		int learnToInteractElements = driver
				.findElements(By.xpath("(//td[1]/font[contains(text(),'Learn to interact')])")).size();
		for (int i = 1; i <= learnToInteractElements; i++) {
			System.out.println(driver
					.findElement(By.xpath(
							"(//td[1]/font[contains(text(),'Learn to interact')])[" + i + "]/following::font[1]"))
					.getText());
		}

		// Check the vital task for the least completed progress.
		WebElement checkBox = driver.findElement(By.xpath("((//td[1]/font)/following::font[1])[5]/following::input"));
		checkBox.click();
		System.out.println(checkBox.isSelected());

	}
}
