package browser_Testsuite_GoogleServices;

import org.sikuli.script.Key;

import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class GoogleNews extends BrowserCommon {
    
	public void GoogleServices_GoogleNews_01 ()
	{
		TestLogger.info("Verify that user can access to Google News page after login on Gmail page without relogin ");
		startCocCoc();
		openLink("https://news.google.com/news/?ned=us&hl=eni");
		TestLogger.info("Expect :show logo Google News and avatar of user");
		if (waitForObjectPresent("pictures\\Website_GoogleNews_logo_News.png", 5) && (waitForObjectPresent("pictures\\Website_GoogleNews_menu_ForYou", 5)))
		{
			setTestcaseStatus("PASSED", " user can access to Google News page after login on Gmail page without relogin ");
		}
		else
		{
			setTestcaseStatus("FAILED", " user can NOT access to Google News page after login on Gmail page without relogin ");
		}
		
		//exit browser
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep (2);
		s.type(Key.F4, Key.ALT);
	}
	
	public void GoogleServices_GoogleNews_02()
	{
		TestLogger.info("Verify that user will be redirect to correct pages after clicking on options on the left menu");
		startCocCoc();
		TestLogger.info("1. Open Google News page (https://news.google.com/news/?ned=us&hl=eni) ");
		openLink("https://news.google.com/news/");
		TestLogger.info("2. Click on Options on the left menu. "); 
		clickOn("pictures\\Website_GoogleNews_Menu_World.png"); 
		if (waitForObjectPresent("pictures\\Website_GoogleNews_Title_World.png", 5))
		{
		   setTestcaseStatus("PASSED", "User is redirected to correct pages after clicking on World option on the left menu");	
		}
		else
		{
			setTestcaseStatus("FAILED", "User is NOT redirected to correct pages after clicking on World option on the left menu");
		}
		
		clickOn("pictures\\Website_GoogleNews_Menu_Bussiness.png"); 
		if (waitForObjectPresent("pictures\\Website_GoogleNews_Title_Bussniess.png", 5))
		{
			setTestcaseStatus("PASSED", "User is redirected to correct pages after clicking on Business option on the left menu");
		}
		else
		{
			setTestcaseStatus("FAILED", "User is NOT redirected to correct pages after clicking on Business option on the left menu");
		
		}
		
		clickOn("pictures\\Website_GoogleNews_Menu_Sport.png");
		if (waitForObjectPresent("pictures\\Website_GoogleNews_Title_Sport.png", 5))
		{
			setTestcaseStatus("PASSED", "User is redirected to correct pages after clicking on Sport option on the left menu");
		}
		else
		{
			setTestcaseStatus("FAILED", "User is NOT redirected to correct pages after clicking on Sport option on the left menu");
		}
		
		clickOn("pictures\\Website_GoogleNews_Menu_Health.png");
		if (waitForObjectPresent("pictures\\Website_GoogleNews_Title_Health.png", 5))
		{
			setTestcaseStatus("PASSED", "User is redirected to correct pages after clicking on Health option on the left menu");
		}
		else
		{
			setTestcaseStatus("FAILED", "User is NOT redirected to correct pages after clicking on Health option on the left menu");
		}
		
		
		
		//exit browser
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
				sleep (2);
				s.type(Key.F4, Key.ALT);
		
		
	}
}
