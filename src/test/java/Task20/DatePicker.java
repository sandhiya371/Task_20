package Task20;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// if we need to access a frame we need to use switch it by using
		// --switchTo--
		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).click();
		WebElement datePicker = driver.findElement(By.xpath("//a[@title='Next']/span[text()='Next']"));
		datePicker.click();
		WebElement dateChoosen = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[4]/td[6]"));
		dateChoosen.click();
		
		System.out.println("The selected date is: " + dateChoosen.getText());
		driver.close();

	}

}

//Output:
//	The selected date is: 22
