package Task20;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class guviSignupAndLoginProcess {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.guvi.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	
		WebElement signin = driver.findElement(By.xpath("//li[@class='nav-item python-signup-btn']/a"));
		signin.click();
		driver.findElement(By.xpath("//*[@id='name']")).sendKeys("Sandhiya N");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("davidufc18@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Guvi@123");
		driver.findElement(By.xpath("//input[@id='mobileNumber']")).sendKeys("9874563210");
		driver.findElement(By.id("signup-btn")).click();

		System.out.println("Current profile: ");

		// To select the 1st dropdown:
		WebElement dropdown1 = driver.findElement(By.id("profileDrpDwn"));
		Select slt1 = new Select(dropdown1);
		slt1.selectByIndex(4);

		System.out.println("Select who you are: " + dropdown1.getAttribute("value"));

		WebElement degree = driver.findElement(By.id("degreeDrpDwn"));
		Select slt2 = new Select(degree);
		slt2.selectByVisibleText("B.Com. / M.Com.");
		System.out.println("Your degree : " + degree.getAttribute("value"));

		WebElement passedoutyear = driver.findElement(By.id("year"));
		passedoutyear.sendKeys("2015");
		System.out.println("Passed out year: " + passedoutyear.getAttribute("value"));

		driver.findElement(By.id("details-btn")).click();

		WebElement verification = driver.findElement(By.xpath("//*[contains(text(),'Almost Done')]"));
		String loginsuccess = verification.getText();
		System.out.println(loginsuccess);

		String title = driver.getTitle();
		System.out.println(title);

		driver.findElement(By.xpath("//*[@class='navbar-guvilogo-black']")).click();

		driver.findElement(By.xpath("//div[@id='accountGroup']/ul/li/a[text()='Login']")).click();
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("davidufc18@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Guvi@123");
		driver.findElement(By.id("login-btn")).click();
		
		Wait<WebDriver> wait1 = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(60)).pollingEvery(Duration.ofMillis(300))
		            .ignoring(ElementNotInteractableException.class);
	 
		driver.switchTo().frame("preview-notification-frame");
	 
		System.out.println("Successfully frame 0 passed");
	 
		driver.findElement(By.xpath("//html//body//div[@id='NC_background_color']//a[text()='X']")).click();
	
		driver.findElement(By.xpath("//div[@id='accountGroup']/button")).click();
	
		WebElement profileName = driver.findElement(By.xpath("//*[text()='Sandhiya R ']"));
	
		System.out.println("Successfuly logged in to the profile: " + profileName.getText());
	
		System.out.println(driver.getTitle());
	
		driver.close();

	}

}

//Output:
//	Current profile: 
//		Select who you are: Looking for a career
//		Your degree : B.Com. / M.Com.
//		Passed out year: 2015
//		Almost Done! Check Your Inbox!
//		GUVI | Sign Up
//		Successfully frame 0 passed
//		Successfuly logged in to the profile: Sandhiya R
//		GUVI | courses
