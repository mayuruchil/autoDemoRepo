package com.infosys.automation;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		//System.setProperty("webdriver.ie.driver","C:\\IEDriverServer.exe" );
		//WebDriver driver = new InternetExplorerDriver();
		//System.setProperty(arg0, arg1)
		//driver.get("http://www.wikipedia.org");
		driver.get("http://www.ebay.com");
		/*WebElement link;
		link = driver.findElement(By.id("js-link-box-en"));
		link.click();*/
		//Thread.sleep(5000);
		WebElement searchBox;
		searchBox = driver.findElement(By.id("gh-ac"));
		CharSequence[] s = new CharSequence[]{"sony tv"};//*[@id="ListViewInner"]
		searchBox.sendKeys(s);
		//List<WebElement> allElements = driver.findElements(By.xpath("//*[@id='ListViewInner']/div[1]/ui/li"));
		
		searchBox.submit();
		Thread.sleep(5000);
		//List<WebElement> allElements = driver.findElements(By.tagName("li"));
		//List<WebElement> allElements = driver.findElements(By.xpath("//*[@id='item5d691a8330']"));
		//List<WebElement> allElements = driver.findElements(By.xpath("//*[@id='ListViewInner']/div[1]"));shop by screen size
		List<WebElement> allElements = driver.findElements(By.xpath("//*[@id='ListViewInner']/li"));
		System.out.println(allElements.size());
		int h = 0;
		for (WebElement element: allElements) {
			String st= element.getText().toLowerCase();
			if(st.contains("tv") && st.contains("sony"))
		      h++;
		}
		System.out.println(h);//44 had sony and tv 
		
		Thread.sleep(5000);
		
		WebElement size = driver.findElement(By.xpath("//*[@id='AnswersModule']/div/div[2]/nav/ul/li[1]/a/div"));
		size.click();
		
		WebElement filterCriteraText = driver.findElement(By.xpath("//*[@id='smuys']/span/b/span"));
		if (!filterCriteraText.getText().equals("50\"-60\"")) {
			System.out.println("New  list not for size 50 - 60");
		}
		else
		{
			System.out.println("New  list for size 50 - 60");
		}
		
		
		
		WebElement searchedItemArea ;
		 searchedItemArea = driver.findElement(By.xpath("//*[@id=\"rsTabs\"]"));
	     List<WebElement> listItems = searchedItemArea.findElements(By.tagName("a")); 
	     
	     Random random = new Random();
	     int randomNumber =  random.nextInt(listItems.size());
	     listItems.get(randomNumber).click();
	     
	     Thread.sleep(1000);
		//Thread.sleep(5000);
		//driver.quit();
	}

}
