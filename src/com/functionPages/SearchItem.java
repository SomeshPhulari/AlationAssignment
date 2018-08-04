package com.functionPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.objectRepo.ObjectMap;

public class SearchItem {
	WebDriver driver;
	ObjectMap objMap=new ObjectMap("objectmap.properties");
	
	
	public SearchItem(WebDriver driver) {
		this.driver=driver;
	}
	
	/*Function:getTitle
	 * Description:- This function will return Title of the first searched element
	 * Developed By: Alok Kumar
	 * Develop Date: 4 Aug 2018 
	 * Changes on:
	 * Changed By:*/
	public String getTitle() {
		String st=null;
		WebDriverWait w=new WebDriverWait(driver,10);
		try {
		WebElement we=w.until(ExpectedConditions.presenceOfElementLocated(objMap.getLocator("amazon.books.title")));
		st=we.getText();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return st;
	}
	
	/*Function:getPaperbackPrice
	 * Description: This function will return Paperback price of first element
	 * Developed By: Alok Kumar
	 * Develop Date: 4 Aug 2018 
	 * Changes on:
	 * Changed By:*/
	public String getPaperbackPrice() {
		String st=null;
		WebDriverWait w=new WebDriverWait(driver,10);
		try {
		WebElement we=w.until(ExpectedConditions.presenceOfElementLocated(objMap.getLocator("amazon.books.paperbackprice")));
		st=we.getText();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return st;
	}
	
	
	/*Function:getPaperbackPrice
	 * Description: This function will return Kindle price of first element
	 * Developed By: Alok Kumar
	 * Develop Date: 4 Aug 2018 
	 * Changes on:
	 * Changed By:*/
	public String getKindlePrice() {
		String st=null;
		WebDriverWait w=new WebDriverWait(driver,10);
		try {
		WebElement we=w.until(ExpectedConditions.presenceOfElementLocated(objMap.getLocator("amazon.books.kindleeditionprice")));
		st=we.getText();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return st;
	}
	
}
