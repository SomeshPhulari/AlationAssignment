package com.browsers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeBrowser implements IBrowserThreads {
	
	/*Function:getWebDriverObject
	 * Description: This function will return the chromedriver of diffrent architecture based driver
	 * Developed on: 4 Aug 2018
	 * Develop By: Alok Kumar
	 * Change on:
	 * Changed By:
	 * */ 
	    @Override
	    public WebDriver getWebDriverObject() {
	    	String path=System.getProperty("user.dir");
	        String win64 = path+"/driver/chromedriver.exe";
	        System.out.println("exevutable path:"+win64);
	        String win32 = path+"/driver/chromedriver.exe";
	   

	        if (System.getProperty("os.name").contains("Windows")
	                && System.getProperty("os.arch").contains("64"))
	            System.setProperty("webdriver.chrome.driver", win64);
	        else if (System.getProperty("os.name").contains("Windows")
	                && System.getProperty("os.arch").contains("32"))
	            System.setProperty("webdriver.chrome.driver", win32);

	        return new ChromeDriver();
	    }
	    
	   


}
