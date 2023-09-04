package marathon1aug3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		//add  implicitlyWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		//Type "Bags" in the Search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags");
		//Choose the   item in the result (bags for girls)
		driver.findElement(By.xpath("//div[@class='s-suggestion-container']/div[@aria-label='bags for girls']")).click();
		//Print the total number of results (like 50000)
	    //1-48 of over 100,000 for "bags for girls"
		String total=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[contains(text(),'100,000 ')]")).getText();
		System.out.println(total);
		//06) Select the first 2 brands in the left menu(like American Tourister, Generic)
		driver.findElement(By.xpath("//a[@class='a-link-normal s-navigation-item']/span[contains(text(),'Genie')]")).click();
		driver.findElement(By.xpath("//a[@class='a-link-normal s-navigation-item']/span[contains(text(),'ADISA')]")).click();
		//07) Choose New Arrivals (Sort)
		driver.findElement(By.xpath("//span[@class='a-dropdown-label']")).click();
		driver.findElement(By.xpath("//a[@id='s-result-sort-select_4']")).click();
		//08) Print the first resulting bag info (name, discounted price)
		String bname=driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']")).getText();
		System.out.println("Bag name:"+bname);
		String price=driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println("Bag price:"+price);
		//09) Get the page title and close the browser(driver.close()) 
		driver.close();


		
		


	}

}
