package com.objectRepo;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class ObjectMap {
	Properties prop;
	public ObjectMap(String strpath)
	{
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream(strpath);
			prop.load(fis);
			fis.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*
	 * Function:getLocator
	 * Description: This function will read locator from objectmap properties file and return the acceptable locator for selenium
	 * Developed By: Alok Kumar
	 * Developed On: 3 Aug 2018
	 * Changed On:
	 * Changed By:
	 * */
	
	public By getLocator(String strElement) throws Exception {
         
        // retrieve the specified object from the object list
        String locator = prop.getProperty(strElement);
         
        // extract the locator type and value from the object
        String locatorType = locator.split(":")[0];
        String locatorValue = locator.split(":")[1];
         
        // for testing and debugging purposes
        //System.out.println("Retrieving object of type '" + locatorType + "' and value '" + locatorValue + "' from the object map");
         
        // return a instance of the By class based on the type of the locator
        // this By can be used by the browser object in the actual test
        if(locatorType.toLowerCase().equals("id"))
            return By.id(locatorValue);
        else if(locatorType.toLowerCase().equals("name"))
            return By.name(locatorValue);
        else if((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
            return By.className(locatorValue);
        else if((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
            return By.className(locatorValue);
        else if((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
            return By.linkText(locatorValue);
        else if(locatorType.toLowerCase().equals("partiallinktext"))
            return By.partialLinkText(locatorValue);
        else if((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
            return By.cssSelector(locatorValue);
        else if(locatorType.toLowerCase().equals("xpath"))
            return By.xpath(locatorValue);
        else
            throw new Exception("Unknown locator type '" + locatorType + "'");
    }
}
