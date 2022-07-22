package week2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundLink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the url
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();

		// Go to Home Page
		driver.findElement(By.linkText("Go to Home Page")).click();
		driver.findElement(By.xpath("//h5[text()='HyperLink']/parent::a")).click();

		// Find where am supposed to go without clicking me?
		String href = driver.findElement(By.linkText("Find where am supposed to go without clicking me?"))
				.getAttribute("href");
		System.out.println(href);

		// Go to Home Page (Interact with same link name)
		driver.findElement(By.xpath("(//a[@link='blue'])[3]")).click();
		driver.findElement(By.xpath("//h5[text()='HyperLink']/parent::a")).click();

		// How many links are available in this page?
		System.out.println(driver.findElement(By.linkText("How many links are available in this page?")).isDisplayed());
		int links = driver.findElements(By.tagName("a")).size();
		System.out.println("Number of links in this page:  " + links);

		// Verify am I broken?
		driver.findElement(By.linkText("Verify am I broken?")).click();
		String title = driver.getTitle();
		System.out.println(title);
		String currentUrl = driver.getCurrentUrl();
		if ((currentUrl.contains("error")) && (title.contains("404"))) {
			System.out.println("Its broken");
		} else
			System.out.println("Link is not broken" + title);

	}

}
