package com.main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.browsers.ChromeBrowser;
import com.browsers.FirefoxBrowser;
import com.functionPages.HomePage;
import com.functionPages.SearchItem;

public class MainTest {
	WebDriver driver;
	String catogery;
	@BeforeTest(alwaysRun=true)
	@Parameters("browser")
	public void setUp(String browser) {
		if(browser.equalsIgnoreCase("firefox")) {
		FirefoxBrowser b=new FirefoxBrowser();
		driver=b.getWebDriverObject();
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			ChromeBrowser b=new ChromeBrowser();
			driver=b.getWebDriverObject();
		}
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS)
		driver.get("https://www.amazon.com/");
	}
	@Test
	public void searchItem()
	{
		HomePage h=new HomePage(driver);
		catogery="Books";
		h.selectDropDownItem(catogery);
		h.searchInput("data catalog");
	}
	@Test(dependsOnMethods= {"searchItem"})
	public void searchDetails() {
		SearchItem s=new SearchItem(driver);
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.titleContains(catogery));
		String st=s.getTitle();
		System.out.println("Title of book is "+st);
		st=s.getPaperbackPrice();
		System.out.println("Paper back price is "+st);
		st=s.getKindlePrice();
		System.out.println("Kindle price is "+st);
	}
}
