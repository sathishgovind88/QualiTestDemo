package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FreeNow  {
	public WebDriver driver;	
	public WebElement glbElement;
	public List<WebElement> listData;
	
	@Before
	public void browserLaunch() {
		driver = new ChromeDriver();		
		System.setProperty("webdriver.chrome.driver", "./UITestFreeNow/chromedriver.exe");
	}
	
	@Given("Open Free Now Url")
	public void addProducts() {			
				
		driver.get("https://qa-challenge.prelive.free-now.com/");			
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.manage().window().maximize();					
 	}
	
	@When("Validate Free Now Home page")
	public void verifyHomePage() {
		glbElement = driver.findElement(By.xpath("//a[@href='https://www.free-now.com']"));
		waituntil(glbElement);
		
		Assert.assertTrue(driver.getTitle().equals("Vehicles"));
		Assert.assertTrue(glbElement.isDisplayed());
		
		glbElement = driver.findElement(By.xpath("//div[@class='pigeon-overlays']"));
		Assert.assertTrue(glbElement.isDisplayed());		
	}
	
	@Then("Validate Free Now Page headers")
	public void verifyPageHeader() {
		String[] expHeaders = {"Type","Licence plate","Coordinates","Address","State","Condition"};
		List<WebElement> listHeaders = driver.findElements(By.xpath("//table//th"));

		for(int i=0;i< listHeaders.size();i++) {			
			Assert.assertTrue(listHeaders.get(i).getText().contains(expHeaders[i]));
		}		
	}
	
	@And("Validate Free Now navigate to Taxi")
	public void verifyPageValues() throws InterruptedException {
		List<WebElement> listtank;String taxi="";
		
		listData = driver.findElements(By.xpath("//table//tbody/tr"));
		
		for(int i=0;i< listData.size();i++) {
			taxi = driver.findElement(By.xpath("//table//tbody/tr[" + (i+1) + "]/td[1]")).getText().trim();
									
			if (taxi.equals("FREE NOW")){
				listtank = driver.findElements(By.xpath("//table//tbody/tr["+ (i+1) + "]/td[8]//span"));
				Assert.assertEquals(listtank.size(), 0);
				
				driver.findElement(By.xpath("//table//tbody/tr[" + (i+1) + "]/td[1]")).click();
				Thread.sleep(2000);
				
				glbElement = driver.findElement(By.xpath("//*[@aria-label='FREE NOW vehicle pin']"));
				//Assert.assertTrue(glbElement.isDisplayed());
				
			}else {
				glbElement = driver.findElement(By.xpath("//table//tbody/tr["+ (i+1) + "]/td[8]//span"));
				Assert.assertTrue(glbElement.isDisplayed());
				
				driver.findElement(By.xpath("//table//tbody/tr[" + (i+1) + "]/td[1]")).click();
				Thread.sleep(2000);
				
				glbElement = driver.findElement(By.xpath("//*[@aria-label='SHARE NOW vehicle pin']"));
				//Assert.assertTrue(glbElement.isDisplayed());
			}			
		}		
	}
	
	@And("Validate Taxi Count with Table Count")
	public void verifyTaxiCount() {
		List<WebElement> listTaxi = driver.findElements(By.xpath("//*[@class='styles_car__L9r_K']"));
		listData = driver.findElements(By.xpath("//table//tbody/tr"));
		Assert.assertEquals(listTaxi.size(), listData.size());		
	}	
	
	@When("Validate Free Now Footer Options")
	public void verifyFooter() {
		glbElement = driver.findElement(By.xpath("//button[@aria-label='First']"));
		Assert.assertTrue(glbElement.isDisplayed());
		Assert.assertFalse(glbElement.isEnabled());
				
		glbElement = driver.findElement(By.xpath("//button[@aria-label='Previous']"));
		Assert.assertTrue(glbElement.isDisplayed());
		Assert.assertFalse(glbElement.isEnabled());
		
		glbElement = driver.findElement(By.xpath("//button[@aria-label='Next']"));
		Assert.assertTrue(glbElement.isDisplayed());
		Assert.assertTrue(glbElement.isEnabled());
		
		glbElement = driver.findElement(By.xpath("//button[@aria-label='Last']"));
		Assert.assertTrue(glbElement.isDisplayed());
		Assert.assertTrue(glbElement.isEnabled());		
	}
	
	@Then("Validate Footer Navigate to Next,Last,Previous and First page")
	public void verifyFooterActions() throws InterruptedException {
		String strPage = "";String totalPage = "";String[] arrPage;
		strPage = driver.findElement(By.xpath("//span[@class='Text-sc-15p8f5j ewdosv']")).getText().trim();
			
		arrPage = strPage.split(" ");
		totalPage = arrPage[arrPage.length-1];
		
		driver.findElement(By.xpath("//button[@aria-label='Next']")).click();
		Thread.sleep(4000);
		
		strPage = driver.findElement(By.xpath("//span[@class='Text-sc-15p8f5j ewdosv']")).getText().trim();
		Assert.assertTrue(strPage.equals("Page 2 of " + totalPage));
		
		driver.findElement(By.xpath("//button[@aria-label='Last']")).click();
		Thread.sleep(4000);
		
		strPage = driver.findElement(By.xpath("//span[@class='Text-sc-15p8f5j ewdosv']")).getText().trim();
		Assert.assertTrue(strPage.equals("Page " + totalPage + " of " + totalPage));
						
		driver.findElement(By.xpath("//button[@aria-label='Previous']")).click();
		Thread.sleep(4000);
		
		strPage = driver.findElement(By.xpath("//span[@class='Text-sc-15p8f5j ewdosv']")).getText().trim();
		Assert.assertTrue(strPage.equals("Page " + (Integer.parseInt(totalPage) - 1)  + " of " + totalPage));
						
		driver.findElement(By.xpath("//button[@aria-label='First']")).click();
		Thread.sleep(4000);			
		
		strPage = driver.findElement(By.xpath("//span[@class='Text-sc-15p8f5j ewdosv']")).getText().trim();
		Assert.assertTrue(strPage.equals("Page 1 of " + totalPage));
	}
	
	public void waituntil(WebElement watiel) {
		WebDriverWait  wait = new WebDriverWait(driver, 30);		
		wait.until(ExpectedConditions.visibilityOf(watiel));
	}
	
	@After
	public void closeApplication() {
		driver.close();
	}		
}
