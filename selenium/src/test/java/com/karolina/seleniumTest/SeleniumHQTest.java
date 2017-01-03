package com.karolina.seleniumTest;

import org.junit.Test;
import io.ddavison.conductor.Browser;
import io.ddavison.conductor.Config;
import io.ddavison.conductor.Locomotive;

@Config(
		browser = Browser.CHROME, 
		url = "http://www.seleniumhq.org"
		)

public class SeleniumHQTest extends Locomotive
{
	// Test case 1
	@Test
	public void testDownloadLinkExists()
	{ 
		validatePresent(HomePage.LOC_LNK_DOWNLOAD_SELENIUM);
	}


	@Test
	public void testTabsExist()
	{
		        validatePresent(HomePage.LOC_LNK_PROJECTS_TAB)
		        .validatePresent(HomePage.LOC_LOC_LNK_DOWNLOAD_TAB)
		        .validatePresent(HomePage.LOC_LNK_DOCUMENTATION_TAB)
		        .validatePresent(HomePage.LOC_LNK_SUPPORT_TAB)
		        .validatePresent(HomePage.LOC_LNK_ABOUT_TAB)
		        ;   

	}

}
