package marathon1aug3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Abhibusseatbooking {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.abhibus.com/");
			driver.manage().window().maximize();
			//WebElement source = driver.findElement(By.id("source"));
			driver.findElement(By.id("source")).sendKeys("Chennai");
			driver.findElement(By.xpath("//li[@class='ui-menu-item ui-state-focus']")).click();
			driver.findElement(By.id("destination")).sendKeys("Bangalore");
			driver.findElement(By.xpath("//li[@class='ui-menu-item ui-state-focus']")).click();
			driver.findElement(By.id("datepicker1")).click();
			driver.findElement(By.xpath("//a[@class='ui-state-default']")).click();
			driver.findElement(By.xpath("//a[@class='btn btn-main px-5 py-2 border-right-radius']")).click();
			String Busname = driver.findElement(By.xpath("//h2[@class='TravelAgntNm ng-binding']")).getText();
			System.out.println("Busname :"+Busname);
			//Choose SLEEPER in the left menu from Bus Type 
			WebElement findElement = driver.findElement(By.xpath("//p[text()='SLEEPER']"));
			driver.executeScript("arguments[0].click();",findElement );
			//Print the first resulting bus seat count(Example:35 Seats Available)(use .getText()) 
			String busfare= driver.findElement(By.xpath("//strong[@class='TickRate ng-binding']")).getText();
			System.out.println("Busfare:"+busfare);
			//Busfare
			String Seatsvailable= driver.findElement(By.xpath("//p[@class='noseats AvailSts ng-binding']")).getText();
			System.out.println("Seatcount:"+Seatsvailable);
			//Click SelectSeat
			driver.findElement(By.xpath("//span[@class='book']")).click();
			//Choose any one Available seat 
			driver.findElement(By.xpath("//li[contains(@class,'sleeper available')]/a")).click();
			//Print Seats Selected ,Total Fare 
			String Seatno= driver.findElement(By.id("seatnos")).getText();
			System.out.println("Booked Seatno:"+Seatno);			
			
			//Select Boarding Point  and Dropping Point
			WebElement Boarding=driver.findElement(By.id("boardingpoint_id"));
			Select BoardingSelect= new Select(Boarding);
			BoardingSelect.selectByIndex(2);
			
			WebElement drop=driver.findElement(By.id("droppingpoint_id"));
			Select dropSelect= new Select(drop);
			dropSelect.selectByIndex(2);
		
			//Get the Title of the page(use .getTitle()) 
			System.out.println("Title of the page:"+driver.getTitle());
			driver.close();
			
			// Close the browser
			
			
			
			
			
			
			
			

	}

}
