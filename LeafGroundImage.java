package week2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the url
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		
		//Click on this image to go home page
		driver.findElement(By.xpath("//img[@src='../images/home.png']")).click();
		driver.findElement(By.xpath("//h5[text()='Image']/parent::a")).click();
		
		//Am I Broken Image?
		
		//Click me using Keyboard or Mouse
			
	}

}
