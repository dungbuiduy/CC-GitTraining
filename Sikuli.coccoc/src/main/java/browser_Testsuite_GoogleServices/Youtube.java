package browser_Testsuite_GoogleServices;

import org.sikuli.script.Key;
import org.testng.annotations.Test;

import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class Youtube extends BrowserCommon {
	
	@Test
	public void GoogleServices_Youtube_01()
	{
		
		TestLogger.info("Verify that user can access to Youtube page after login on Gmail page without relogin ");
		 startCocCocInEnglish();
		 SigninToCocCoc(userNameGmail3, passwordGmail3);
	     closeBrowser();
		 startCocCoc();
		
		TestLogger.info("1. Open Youtube page (https://www.youtube.com/?gl=VN)");
		openLink("https://www.youtube.com/?gl=VN");
		if (waitForObjectPresent("pictures\\Website_youtube_button_Allow.png", 5))
		{
		   clickOn("pictures\\Website_youtube_button_Allow.png");	
		}
		
		clickOn("pictures\\Browser_GooglePlus_Avatar_Account3.png");
		
		if (waitForObjectPresent("pictures\\Website_youtube_menu_MyChannel.png", 5) || (waitForObjectPresent("pictures\\Website_youtube_image_logo.png", 5)))
		{
			setTestcaseStatus("PASSED", " - Logo Youtube appear and user can access youtube after login on Gmail page without relogin after that  ");
		}
		else
		{
			setTestcaseStatus("FAILED", " - Logo Youtube DO NOT appear and user can NOT access youtube after login on Gmail page without relogin after that  ");
		}
		
	}
	
	@Test
	public void GoogleServices_Youtube_02()
	{
		TestLogger.info("Verify that user can access Correct pages after clicking on options on the left menu");
		TestLogger.info("1.Open page Youtube ");
		openLink("https://www.youtube.com/?gl=VN");
		TestLogger.info("2.Click on options on the left menu");
		if (waitForObjectPresent("pictures\\Website_youtube_button_Allow.png", 5))
		{
		   clickOn("pictures\\Website_youtube_button_Allow.png");	
		}
		
		clickOn("pictures\\Browser_GooglePlus_Avatar_Account3.png");
		
		clickOn("pictures\\Website_youtube_menu_myChannel.png");
	
		TestLogger.info("click on menu popular menu ");
		openLink("https://www.youtube.com/channel/UCF0pVplsI8R5kcAqgtoRqoA");
	    if (waitForObjectPresent("pictures\\Website_youtube_Text_popular.png", 3))
	    {
	    	setTestcaseStatus("PASSED", "Accessed correct page after clicking on Popular option");
	    }
	    else
	    {
	    	setTestcaseStatus("FAILED", "DO NOT Access correct page after clicking on Popular option");
	    }
		
	  //exit browser
		closeBrowser();
	    	
	}
	
	
	@Test
	public void GoogleServices_Youtube_03()
	{
		
		TestLogger.info("Verify that user can upload video on youtube");
		//startCocCoc();
		TestLogger.info("1. Open page Youtube.");
		openLink("https://www.youtube.com/?gl=VN");
		TestLogger.info("2.Click on My Channel"); 
		sleep(10);
		clickOn("pictures\\Browser_GooglePlus_Avatar_Account3.png");
		if(waitForObjectPresent("pictures\\Website_youtube_menu_myChannel.png", 5))
		{
		   clickOn("pictures\\Website_youtube_menu_myChannel.png");
		}
		TestLogger.info("Click on Choose upload video"); 
		openLink("https://www.youtube.com/channel/UCeM92tYJCSKYl3fpir2nG3Q?view_as=subscriber");
		sleep(15);
		if (waitForObjectPresent("pictures\\Browser_AddressBar_icon_SaviorDisabled.png", 5))
		{
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
		}
		
		clickOn("pictures\\website_youtube_textlink_uploadAVideo.png");
		sleep (15);
		waitForObjectPresent("pictures\\Website_Youtube_Button_UploadVideo.png", 25);
		clickOn("pictures\\Website_Youtube_Button_UploadVideo.png");
		sleep(5);
		s.type("[All album] Ost. It's okay, That's love."); 
		s.type(Key.ENTER); 
		
		TestLogger.info("Expect : Video must be uploaded successfully and can play video after that .");
		sleep (100);
		if (waitForObjectPresent("pictures\\Website_youtube_button_publish.png", 30))
		{
			clickOn("pictures\\Website_youtube_button_publish.png");
			setTestcaseStatus("PASSED", "Video must be uploaded successfully");
		}
		else
		{
			clickOn("pictures\\Website_youtube_button_publish.png");
			setTestcaseStatus("FAILED", "Video NOT be uploaded successfully");
		}
		
		  //exit browser
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
				sleep (2);
				s.type(Key.F4, Key.ALT);
		
	}
	
	
	@Test
	public void GoogleServices_Youtube_04()
	{
		TestLogger.info("Verify that user can delete video on youtube");
		TestLogger.info("1.Open page youtube.");
		startCocCoc();
		openLink("https://www.youtube.com/?gl=VN");
		TestLogger.info("2. Click on My Channel");
		
		if(waitForObjectPresent("pictures\\Website_youtube_menu_myChannel.png", 5))
		{
		   clickOn("pictures\\Website_youtube_menu_myChannel.png");
		}
		
		TestLogger.info("3.Choose a video to delete"); 
		openLink("https://www.youtube.com/channel/UCeM92tYJCSKYl3fpir2nG3Q/videos");
		clickOn("pictures\\website_youtube_button_ArrowManageVideo.png");
		clickOn("pictures\\website_youtube_button_deleteVideo.png"); 
		if (waitForObjectPresent("pictures\\website_youtube_button_delete.png", 5))
		{
			clickOn("pictures\\website_youtube_button_delete.png");
			if (waitForObjectPresent("pictures\\Website_youtube_text_deteledVideo.png", 5))
			{
				setTestcaseStatus("PASSED", " Video is deleted successfully ");
			}
			else
			{
				setTestcaseStatus("PASSED", "Video is NOT deleted successfully");
			}
		 }
		
		  //exit browser
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep (2);
		s.type(Key.F4, Key.ALT);
		
	}

	
	@Test
	public void GoogleServices_Youtube_05()
	{
		TestLogger.info("Verify that user can view live video on youtube");
		TestLogger.info("1.Open page youtube with channel live videos : ");
		//startCocCoc();
		openLink("https://www.youtube.com/channel/UC4R8DWoMoI7CAwX8_LjQHig ");
		TestLogger.info("Expect : User must be redirected to Live Videos page "); 
		if (waitForObjectPresent("pictures\\Website_youtube_text_live.png", 5))
		{
			setTestcaseStatus("PASSED", "User is redirected to Live Videos page");
		}
		else
		{
			setTestcaseStatus("FAILED", "User is NOT redirected to Live Videos page");
		}
		
		TestLogger.info("2.Open a live video on this channel ");
		moveMouseDownFromLogo("pictures\\Website_youtube_text_live.png", 240);
		s.click();
		if (waitForObjectPresent("pictures\\Website_youtube_text_liveChat.png", 12))
		{
			setTestcaseStatus("PASSED", "User viewed live video. (showed live chat which is next to video");
		}
		else
		{
			setTestcaseStatus("FAILED", "User DID NOT view live video. (DID NOT show live chat which is next to video");
		}
		
		  //exit browser
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep (2);
		s.type(Key.F4, Key.ALT);
		
	}
		
	
}
