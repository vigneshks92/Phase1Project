package phase1;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");    
		
		//Maximize window
		driver.manage().window().maximize();
		
		//wait for browser to load - implicit
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement SearchBox = driver.findElement(By.id("twotabsearchtextbox"));
		SearchBox.sendKeys("iphone 12");
		
		WebElement SearchButton = driver.findElement(By.id("nav-search-submit-button"));
		SearchButton.click();
		
		List<WebElement> ProductName = driver.findElements(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> ProductPrice = driver.findElements(By.xpath("//*[@class='a-price-whole']"));
		
		System.out.println("Search Result " + ProductName.size());
		
		for(int i=0 ;i<ProductName.size();i++)
		{
			System.out.println("Product Name = " +ProductName.get(i).getText()+ "price is "+ProductPrice.get(i).getText());
		}
			
			driver.close();
		}

	}
