package com.karolina.seleniumTest;

import org.openqa.selenium.By;

// Preparing library:
// HomePage - it's going to map out the objects we need for Selenium HQ
public class HomePage
{
	// LOC = locator
	// LNK = link - Hungarian notation
	// LOC_TXT_  for a text box
	// LOC_BTN_ for a button
	// sth^ = Starting with
	// sth$ = Ending with
	// sth* = Containing
	
	// Tabs on the website
	public static final String LOC_LNK_PROJECTS_TAB = "li#menu_projects a[href$='projects/']";
	public static final String LOC_LOC_LNK_DOWNLOAD_TAB = "li#menu_download a[href$='download/']";
	public static final By LOC_LNK_DOCUMENTATION_TAB = By.xpath("//*[@id='menu_documentation']/a[contains(@href, 'docs/')]");
	public static final String LOC_LNK_SUPPORT_TAB = "li#menu_support a[href$='support/']";
    public static final String LOC_LNK_ABOUT_TAB = "li#menu_about a[href$='about/']";
    
    // Download link
    
    public static final By LOC_LNK_DOWNLOAD_SELENIUM = By.linkText("Download Selenium");
	
}
