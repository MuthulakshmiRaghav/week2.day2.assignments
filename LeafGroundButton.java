package week2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the url
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();

		// Click button to travel home page
		driver.findElement(By.xpath("//button[@id='home']")).click();
		driver.findElement(By.xpath("//h5[text()='Button']/parent::a")).click();

		// Find position of button (x,y)
		System.out.println("Position os the button " + driver.findElement(By.id("position")).getLocation());

		// Find button color
		// String buttonColor = driver.findElement(By.id("color")).getAttribute("style");
		String buttonColor = driver.findElement(By.id("color")).getCssValue("background-color");
		System.out.println("Color of the Button " + buttonColor);

		// Find the height and width
		System.out.println("Height and Width " + driver.findElement(By.id("size")).getSize());
	}

}
