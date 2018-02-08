package browser_Testsuite_GoogleServices;

import org.sikuli.script.Key;
import org.testng.annotations.Test;

import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class Googleplus extends BrowserCommon {
  
	
	   
	@Test
	public void GoogleServices_Googleplus_01()
	   {
		   TestLogger.info("Verify that user can access to Google plus page after login on Gmail page without relogin ");
		   startCocCocInEnglish();
		   SigninToCocCoc(userNameGmail4, passwordGmail4); 
		   closeBrowser();
		   startCocCoc();
		   
		   openLink("https://plus.google.com/?hl=vi");
		   if (waitForObjectPresent("pictures\\website_googleplus_image_logo.png", 5) || (waitForObjectPresent("pictures\\Website_Googleplus_menu_profile.png", 5)))
		   {
			  setTestcaseStatus("PASSED", "showed logo Google + and avatar of user");   
		   }
		   else
		   {
			   setTestcaseStatus("FAILED", "DO NOT show logo Google + and avatar of user ");
		   }
		   
		   
		   //exit browser
			closeBrowser();
	   }
	
	@Test
	public void GoogleServices_Googleplus_02()
	{
		TestLogger.info("Verify that user will be redirected to correct pages after clicking on menus on the left");
		startCocCoc();
		openLink("https://plus.google.com/?hl=vi");
		TestLogger.info("2. Click on menus on the left");
		TestLogger.info("User must be redirected to correct pages after click on menus"); 
		TestLogger.info("Click on explore menu ");
		clickOn("pictures\\website_googleplus_menu_explore.png");
		if (waitForObjectPresent("pictures\\Website_GooglePlus_Popup_turnon.png", 5))
		{
			clickOn("Website_GooglePlus_Popup_turnon");
		}
		
		if (waitForObjectPresent("pictures\\Website_youtube_button_Allow.png", 3))
		{
			clickOn("pictures\\Website_youtube_button_Allow.png");
		}
		
		if (waitForObjectPresent("pictures\\specificEnviroment\\win10\\website_googleplus_text_explore.png", 5))
		{
			setTestcaseStatus("PASSED", "User is redirected to correct pages after clicking on Explore menu ");
		}
		else
		{
			setTestcaseStatus("FAILED", "User is NOT redirected to correct pages after clicking on Explore menu");
		}
		
		TestLogger.info("click on Community menu");
		clickOn("pictures\\website_googleplus_menu_community.png");
		if (waitForObjectPresent("pictures\\website_googleplus_text_community.png", 5))
		{
			setTestcaseStatus("PASSED", "User is redirected to correct pages after clicking on Community menu");
		}
		else
		{
			setTestcaseStatus("FAILED", "User is NOT redirected to correct pages after clicking on Community menu");
		}
		
		        //exit browser
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
				sleep (2);
				s.type(Key.F4, Key.ALT);
	}
	
	
	
	@Test 
	public void GoogleServices_Googleplus_03()
	{ 
		TestLogger.info("Verify that user can post status successfully on Google Plus");
		startCocCoc();
		openLink("https://plus.google.com/?hl=vi");
		sleep (12);
		TestLogger.info(" Post a status on page");
		clickOn("pictures\\Website_Googleplus_TextFiled_postStatus.png");
		sleep (3);
		s.type("Today is 23/8/2017") ;
		clickOn("pictures\\Website_GooglePlus_button_Post.png");
		if (waitForObjectPresent("pictures\\Website_Googleplus_text_post.png", 6))
		{
			setTestcaseStatus("PASSED",  "user can post status successfully on Google Plus");
		}
		else
		{
			setTestcaseStatus("FAILED",  "user can NOT post status successfully on Google Plus");
		}
		
		 //exit browser
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep (2);
		s.type(Key.F4, Key.ALT);
	
		
	} 
	
	
	@Test 
	public void GoogleServices_Googleplus_04()
	{ 
		TestLogger.info("Verify that user can Edit status successfully on Google Plus");
		startCocCoc();
		openLink("https://plus.google.com/?hl=vi");
		TestLogger.info(" Edit a status on page");
		if (waitForObjectPresent("pictures\\Website_Googleplus_text_post.png", 5))
		{
			clickOn("pictures\\Website_Googleplus_text_post.png");
			clickOn("pictures\\Website_Googleplus_token_3dot.png");
			clickOn("pictures\\Website_Googleplus_menu_Editpost.png");
			s.type("Editted"); 
			clickOn("pictures\\Website_Googleplus_menu_Save.png");
			if (waitForObjectPresent("pictures\\Website_Googleplus_text_Editted.png", 5))
			{
				setTestcaseStatus("PASSED", "User can Edit status successfully on Google Plus");
			}
			else
			{
				setTestcaseStatus("FAILED", "User can NOT Edit status successfully on Google Plus");
			}
			
		}
		
		 //exit browser
		closeBrowser();
		s.type(Key.F4, Key.ALT);
	}
	
	@Test 
	public void GoogleServices_Googleplus_05()
	{
		TestLogger.info("Verify that user can Delete status successfully on Google Plus");
		startCocCoc();
		openLink("https://plus.google.com/?hl=vi");
		TestLogger.info("2. Choose a post to delete. ");
		if (waitForObjectPresent("pictures\\Website_Googleplus_text_post.png", 5))
		{
			clickOn("pictures\\Website_Googleplus_text_post.png");
			clickOn("pictures\\Website_Googleplus_token_3dot.png");
			clickOn("pictures\\Website_Googleplus_menu_DeletePost.png");
			clickOn("pictures\\Website_Googleplus_menu_Delete.png");
			if (waitForObjectPresent("pictures\\Website_Googleplus_text_Editted.png", 5))
			{
				setTestcaseStatus("FAILED", "User can NOT delelte status successfully on Google Plus");
			}
			else
			{
				setTestcaseStatus("PASSED", "User can delete status successfully on Google Plus");
			}
			
			
		}
		
		 //exit browser
		closeBrowser();
		s.type(Key.F4, Key.ALT);
	}
}
