package com.functionPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.objectRepo.ObjectMap;

public class HomePage {
	WebDriver driver;
	
	ObjectMap objMap=new ObjectMap("objectmap.properties");
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	/*Function: selectDropDownItem 
	 * Parameter accept item name you want to select from drop down menu
	 * Example: Book
	 * Developer: Alok Kumar
	 * Developed Date: 04 Aug 2018
	 * Last Change made: 
	 * change date: */
	public void selectDropDownItem(String st) {
		WebDriverWait w=new WebDriverWait(driver,20);
		try {
		WebElement we=w.until(ExpectedConditions.presenceOfElementLocated(objMap.getLocator("amazon.home.searchdropdown")));
			//WebElement we=driver.findElement(objMap.getLocator("amazon.home.searchdropdown"));
			//we.click();
			Select se=new Select(we);
			se.selectByVisibleText(st);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*Function: searchInput 
	 * Parameter accept product you want to search in amazon
	 * Example: Book
	 * Developer: Alok Kumar
	 * Developed Date: 04 Aug 2018
	 * Last Change made: 
	 * change date: */
	public void searchInput(String st) {
		WebDriverWait w=new WebDriverWait(driver,10);
		try {
		WebElement we=w.until(ExpectedConditions.presenceOfElementLocated(objMap.getLocator("amazon.home.searchtextbox")));
		we.clear();
		we.sendKeys(st);
		we=w.until(ExpectedConditions.presenceOfElementLocated(objMap.getLocator("amazon.home.searchbutton")));
		we.click();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
