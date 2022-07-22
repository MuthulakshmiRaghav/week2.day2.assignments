package week2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the url
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

		// Enter username and password
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click on login button
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click on leads button
		driver.findElement(By.linkText("Leads")).click();

		// Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();

		// Enter first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Muthulakshmi");

		// Click Find leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Capture lead ID of First Resulting lead
		String leadId = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"))
				.getText();
		System.out.println("Lead Id is " + leadId);

		// Click on first resulting lead
		driver.findElement(By.xpath(
				"//td/div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a[contains(text(),'Muthulakshmi')]"))
				.click();

		// Click Delete
		driver.findElement(By.className("subMenuButtonDangerous")).click();

		// Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Enter captured lead ID
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadId);

		// Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Verify message "No records to display" in the Lead List
		String noRecords = driver.findElement(By.xpath("//div[@class='x-panel-bbar']//div/div")).getText();
		System.out.println(noRecords);
		if (noRecords.equalsIgnoreCase("No records to display"))
			System.out.println("The Record Id " + leadId + " deleted successfully");
		else
			System.out.println("Not deleted");

		 //Close the browser
		 driver.close();

	}
}